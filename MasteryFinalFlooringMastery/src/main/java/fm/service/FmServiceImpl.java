/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.service;

import fm.dao.FmAuditDao;
import fm.dao.FmExportFileDao;
import fm.dao.FmInvalidOrderDateException;
import fm.dao.FmInvalidOrderNumException;
import fm.dao.FmInvalidProductException;
import fm.dao.FmInvalidTaxException;
import fm.dao.FmOrderDao;
import fm.dao.FmPersistenceException;
import fm.dao.FmProductDao;
import fm.dao.FmTaxDao;
import fm.dto.FmOrder;
import fm.dto.FmProduct;
import fm.dto.FmTax;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class FmServiceImpl implements FmService {

    FmOrderDao orderDao;
    FmProductDao productDao;
    FmTaxDao taxDao;
    FmAuditDao auditDao;
    FmExportFileDao exportDao;

    public FmServiceImpl(FmOrderDao orderDao, FmProductDao productDao, FmTaxDao taxDao, FmExportFileDao exportDao) {
        //this.audit = audit;
        this.orderDao = orderDao;
        this.productDao = productDao;
        this.taxDao = taxDao;
        this.exportDao = exportDao;
    }

    @Override
    public FmOrder addAnOrder(FmOrder newOrder) throws FmPersistenceException, FmInvalidOrderDateException, FmInvalidOrderNumException {
        return orderDao.addOrder(newOrder);
    }

    @Override
    public FmOrder editAnOrder(FmOrder editedOrder) throws FmPersistenceException {
        return orderDao.editOrder(editedOrder);
    }

    @Override
    public FmOrder removeAnOrder(LocalDate date, int orderNum) throws FmPersistenceException, FmInvalidOrderDateException, FmInvalidOrderNumException {
        // return orderDao.removeOrder(date, orderNum);
        // get teh order by date and number from dao
        //then delete.
        return orderDao.removeOrder(date, orderNum);
    }

    @Override
    public FmOrder getOrder(LocalDate date, int orderNum) throws FmPersistenceException, FmPersistenceException, FmInvalidOrderDateException {
        FmOrder theOrder = orderDao.getOrderByDateandId(date, orderNum);
        if (theOrder == null) {
            return null;
        } else {
            return theOrder;
        }
    }

    @Override
    public List<FmOrder> getOrdersByDate(LocalDate date) throws FmPersistenceException {
        List<FmOrder> fmOrderList = orderDao.getAllOrdersForDate(date);
        return fmOrderList;

    }

    @Override
    public List<FmProduct> getAllProducts() throws FmPersistenceException {
        List<FmProduct> listOfProduct = productDao.getAllProduct();
        return listOfProduct;

    }

    @Override
    public FmOrder validateOrder(FmOrder newOrder) throws OrderDataInvalidException, FmPersistenceException, FmInvalidTaxException, FmInvalidProductException {
        if (newOrder.getOrderDate() == null || newOrder.getCustomerName() == null
                || newOrder.getOrderArea() == null || newOrder.getOrderProduct().getProductType() == null
                || newOrder.getOrderStateName().getStateAbbreviation() == null) {
            throw new OrderDataInvalidException("ERROR: All fields[Customer Name, Date, State, ProductType, Area] required");
        }
        String customerName = newOrder.getCustomerName();

        if (!Pattern.matches("[a-zA-Z0-9\\,\\.\\s]*", customerName)) {
            throw new OrderDataInvalidException("Error: Name should only contain [a-z][0-9][periods and comma]");
        }

        FmTax newTax = taxDao.getTax(newOrder.getOrderStateName().getStateAbbreviation());
        if (newTax == null) {
            throw new FmInvalidTaxException("ERROR: Invalid State");
        }
        newOrder.setOrderStateName(newTax);

        FmProduct newProduct = productDao.getProduct(newOrder.getOrderProduct().getProductType());
        if (newProduct == null) {
            throw new FmInvalidProductException("ERROR: Invalid Product");
        }
        newOrder.setOrderProduct(newProduct);

        //generate and set order number
//       if we are adding (we can tell if the order number is zero), then we generate and set the order number
//       if(the orderNumber is zero), then genrate and set
//       if we are not adding, i.e. editing, (we can tell if the order number is not zero), then we do not do anything with the order number
        if (newOrder.getOrderNumber() == 0) {
            int orderNumber = generateOrderNumber();
            newOrder.setOrderNumber(orderNumber);
        }

        //calculate remaining fields
        calculateOrder(newOrder);

        return newOrder;
    }

    @Override
    public int generateOrderNumber() throws FmPersistenceException {
        int max = orderDao.getOrderNumber();
        return max + 1;
    }

    @Override
    public void validateOrderNumber(LocalDate date, int orderNumber) throws FmPersistenceException, FmInvalidOrderDateException, FmInvalidOrderNumException {
        if (!orderDao.exportAllData().get(date).keySet().contains(orderNumber)) {
            throw new FmInvalidOrderDateException("ERROR: NO ORDER FOUND.");
        }
    }

    @Override
    public List<FmTax> getAllTaxes() throws FmPersistenceException {

        List<FmTax> listOfTaxes = taxDao.getAllTaxs();
        return listOfTaxes;
    }

    @Override
    public void calculateOrder(FmOrder newOrder) {
        BigDecimal matCosts = newOrder.getOrderProduct().getCostPerSquareFt().multiply(newOrder.getOrderArea());
        BigDecimal matCostsScaled = matCosts.setScale(2, RoundingMode.HALF_UP);
        BigDecimal laborCosts = newOrder.getOrderArea().multiply(newOrder.getOrderProduct().getlaborCostPerSquareFt());
        BigDecimal laborCostsScaled = laborCosts.setScale(2, RoundingMode.HALF_UP);
        BigDecimal taxCosts = matCosts.add(laborCosts).multiply(newOrder.getOrderStateName().getTaxRate().divide(new BigDecimal("100").setScale(2, RoundingMode.HALF_UP)));
        BigDecimal taxCostsScaled = taxCosts.setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalCosts = matCosts.add(laborCosts).add(taxCosts);
        BigDecimal totalCostsScaled = totalCosts.setScale(2, RoundingMode.HALF_UP);

        newOrder.setOrderMaterialCost(matCostsScaled);
        newOrder.setLaborCost(laborCostsScaled);
        newOrder.setTotalTax(taxCostsScaled);
        newOrder.setOrderTotal(totalCostsScaled);

    }

    @Override
    public void exportAllData() throws FmPersistenceException {
        try {
            List<FmOrder> allActiveOrders = orderDao.getAllOrders();
            exportDao.exportOrders(allActiveOrders);

        } catch (FmPersistenceException e) {
            throw new FmPersistenceException("Unable to export.", e);
        }
    }

}
