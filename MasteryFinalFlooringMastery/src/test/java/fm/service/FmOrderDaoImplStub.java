/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.service;

import fm.dao.FmInvalidOrderDateException;
import fm.dao.FmInvalidOrderNumException;
import fm.dao.FmOrderDao;
import fm.dao.FmPersistenceException;
import fm.dto.FmOrder;
import fm.dto.FmProduct;
import fm.dto.FmTax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class FmOrderDaoImplStub implements FmOrderDao {

    public FmOrder onlyOrder;

    public FmOrderDaoImplStub(FmOrder onlyOrder) {
        this.onlyOrder = onlyOrder;
    }

    public FmOrderDaoImplStub() {
        String date = "02142023";
        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 9;

        onlyOrder = new FmOrder();
        onlyOrder.setOrderDate(localdate);
        onlyOrder.setOrderNumber(orderNumber);
        onlyOrder.setCustomerName("Karma");
        FmTax newTax = new FmTax();
        newTax.setStateAbbreviation("CA");
        BigDecimal taxRate = new BigDecimal("25.00");
        newTax.setTaxRate(taxRate);
        FmProduct newProduct = new FmProduct();
        newProduct.setProductType("Tile");
        BigDecimal orderArea = new BigDecimal("342");
        onlyOrder.setOrderArea(orderArea);
        BigDecimal costPerSqFt = new BigDecimal("3.50");
        BigDecimal laborCostPerSqFt = new BigDecimal("4.15");
        newProduct.setCostPerSquareFt(costPerSqFt);
        newProduct.setLaborCostPerSquareFt(laborCostPerSqFt);
        onlyOrder.setOrderProduct(newProduct);
        onlyOrder.setOrderStateName(newTax);
        BigDecimal materialCost = new BigDecimal("1197.00");
        BigDecimal laborCost = new BigDecimal("1419.30");
        BigDecimal tax = new BigDecimal("654.08");
        BigDecimal total = new BigDecimal("3270.38");
        onlyOrder.setProductCost(materialCost);
        onlyOrder.setLaborCost(laborCost);
        onlyOrder.setOrderMaterialCost(materialCost);
        onlyOrder.setTotalTax(tax);
        onlyOrder.setOrderTotal(total);
    }

    @Override
    public FmOrder addOrder(FmOrder newOrder) throws FmPersistenceException {
        if(newOrder.equals(onlyOrder)){
            return onlyOrder;
        } else {
            return null;
        }
    }

    @Override
    public FmOrder editOrder(FmOrder order) throws FmPersistenceException{
        if(onlyOrder.getOrderNumber() == order.getOrderNumber()){
            return onlyOrder;
        }else{
            return null;
        }
    }

    @Override
    public FmOrder removeOrder(LocalDate date, int orderNum) throws FmPersistenceException, FmInvalidOrderDateException, FmInvalidOrderNumException {
        if(onlyOrder.getOrderNumber() == orderNum && onlyOrder.getOrderDate().equals(date)){
            return onlyOrder;
        }else {
            return null;
        }
    }

    @Override
    public FmOrder getOrderByDateandId(LocalDate orderDate, int orderNumber) throws FmPersistenceException {
        if(onlyOrder.getOrderNumber() == orderNumber && orderDate.equals(onlyOrder.getOrderDate())){
            return onlyOrder;
        }else{
            return null;
        }
    }

    @Override
    public List<FmOrder> getAllOrdersForDate(LocalDate orderDate) throws FmPersistenceException {
        List<FmOrder> orderList = new ArrayList<>();
        orderList.add(onlyOrder);
        return orderList;
    }

    @Override
    public int getOrderNumber() throws FmPersistenceException {
        return onlyOrder.getOrderNumber();
    }

    @Override
    public List<LocalDate> orderDate() throws FmPersistenceException {
        List<LocalDate> orderDate = new ArrayList<>();
        orderDate.add(onlyOrder.getOrderDate());
        return orderDate; 
    }

    @Override
    public List<FmOrder> getAllOrders() throws FmPersistenceException {
        List<FmOrder> orders = new ArrayList<>();
        if(orders.isEmpty()){
            throw new FmPersistenceException("No orders.");
        } else{
            return (List<FmOrder>) orders;
        }
    }

    @Override
    public Map<LocalDate, Map<Integer, FmOrder>> exportAllData() throws FmPersistenceException {
        Map<LocalDate, Map<Integer, FmOrder>> exportMap = new HashMap<>();
        Map<Integer, FmOrder> innerMap = new HashMap<>();
        innerMap.put(onlyOrder.getOrderNumber(), onlyOrder);
        exportMap.put(onlyOrder.getOrderDate(), innerMap);
        return exportMap;
        }

}
