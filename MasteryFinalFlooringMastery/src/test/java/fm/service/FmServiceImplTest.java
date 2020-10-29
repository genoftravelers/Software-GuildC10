/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.service;

import fm.dao.FmInvalidOrderDateException;
import fm.dao.FmInvalidOrderNumException;
import fm.dao.FmInvalidProductException;
import fm.dao.FmInvalidTaxException;
import fm.dao.FmPersistenceException;
import fm.dto.FmOrder;
import fm.dto.FmProduct;
import fm.dto.FmTax;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class FmServiceImplTest {

    private FmService service;

    public FmServiceImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = ctx.getBean("serviceTest", FmServiceImpl.class);
    }

    @Test
    public void testGetOrderInvalidOrderDate() throws Exception {
        String date = "02142030";
        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 9;

        FmOrder onlyOrder = new FmOrder();
        onlyOrder.setOrderDate(localdate);
        onlyOrder.setOrderNumber(orderNumber);

        FmOrder order = service.getOrder(localdate, orderNumber);
        assertNull(order);

    }

    @Test
    public void testGetOrderInvalidOrderNumber() throws FmPersistenceException, FmInvalidOrderDateException, FmInvalidOrderNumException {
        //ARRANGE
        String date = "02142024";
        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 15;

        FmOrder onlyOrder = new FmOrder();
        onlyOrder.setOrderDate(localdate);
        onlyOrder.setOrderNumber(orderNumber);

        //ACT
        FmOrder order = service.getOrder(localdate, onlyOrder.getOrderNumber());

        assertNull(order); //ASSERT

    }

    @Test
    public void testAddAnOrder() throws FmPersistenceException, FmInvalidOrderDateException, FmInvalidOrderNumException {
        //ARRANGE
        String date = "02142023";
        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 9;

        FmOrder onlyOrder = new FmOrder();
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
        //ACT
        FmOrder addedOrder = service.addAnOrder(onlyOrder);
        //ASSERT
        assertNotNull(addedOrder, "It should not be null");
        assertEquals(addedOrder, onlyOrder, "Both orders should be same.");
    }

    @Test
    public void testRemoveOrder() throws FmPersistenceException, FmInvalidOrderDateException, FmInvalidOrderNumException {
        String date = "02142023";
        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 9;
        //ACT AND ASSERT
        FmOrder orderRemove = service.removeAnOrder(localdate, orderNumber);

        assertNotNull(orderRemove, "Removing by this date and order number should not be null");
        assertEquals(orderNumber, orderRemove.getOrderNumber(), "Order number must be equal");
        assertEquals(localdate, orderRemove.getOrderDate(), "Order date must be equal");
    }

    @Test//It's a pass through method and it is only testing that(edit) not calculations and validations. validation happens before editing the order.
    public void testEditAnOrder() throws FmPersistenceException, FmPersistenceException, FmInvalidOrderDateException, FmInvalidOrderNumException {
        String date = "02142023";
        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 9;

        FmOrder editedOrder = new FmOrder();
        editedOrder.setOrderDate(localdate);
        editedOrder.setOrderNumber(orderNumber);
        editedOrder.setCustomerName("Yolanda");
        FmTax newTax = new FmTax();
        newTax.setStateAbbreviation("TX");
        BigDecimal taxRate = new BigDecimal("25.00");
        newTax.setTaxRate(taxRate);
        editedOrder.setOrderStateName(newTax);
        FmProduct newProduct = new FmProduct("Carpet", new BigDecimal("2.25"), new BigDecimal("2.10"));
        editedOrder.setOrderProduct(newProduct);
        BigDecimal orderArea = new BigDecimal("342");
        editedOrder.setOrderArea(orderArea);

        BigDecimal matCosts = editedOrder.getOrderProduct().getCostPerSquareFt().multiply(editedOrder.getOrderArea());
        BigDecimal matCostsScaled = matCosts.setScale(2, RoundingMode.HALF_UP);
        editedOrder.setOrderMaterialCost(matCostsScaled);

        BigDecimal laborCosts = editedOrder.getOrderArea().multiply(editedOrder.getOrderProduct().getlaborCostPerSquareFt());
        BigDecimal laborCostsScaled = laborCosts.setScale(2, RoundingMode.HALF_UP);
        editedOrder.setLaborCost(laborCostsScaled);
        BigDecimal taxCosts = matCosts.add(laborCosts).multiply(editedOrder.getOrderStateName().getTaxRate().divide(new BigDecimal("100").setScale(2, RoundingMode.HALF_UP)));
        BigDecimal taxCostsScaled = taxCosts.setScale(2, RoundingMode.HALF_UP);
        editedOrder.setTotalTax(taxCostsScaled);
        BigDecimal totalCosts = matCosts.add(laborCosts).add(taxCosts);
        BigDecimal totalCostsScaled = totalCosts.setScale(2, RoundingMode.HALF_UP);
        editedOrder.setOrderTotal(totalCostsScaled);

        //copy of stub order
        FmOrder retrievedOrder = service.getOrder(localdate, orderNumber);
        assertNotEquals(retrievedOrder.getCustomerName(), editedOrder.getCustomerName(), "Names should be same");
        //ACT AND ASSERT

        FmOrder orderEdit = service.editAnOrder(editedOrder);//TESTING JUST HTIS METHOD.
        assertEquals(retrievedOrder, orderEdit, "These orders should be the same");
        assertNotEquals(editedOrder, orderEdit, "These orders should not be the same");

    }

    @Test
    public void testGetOrdersByDate() throws Exception {//dont need an order to test this method just need a date 
        String date = "02142023";
        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));

        List<FmOrder> orderByDate = service.getOrdersByDate(localdate);

        assertNotNull(orderByDate, "the list should not be null");
        assertEquals(orderByDate.size(), 1, "List should contain one item.");

    }

    @Test
    public void testGetAllProducts() throws Exception {//typically make it a list.
        //dont need to make an order just test if value is not null and correct number of products.
        assertEquals(1, service.getAllProducts().size(), "Should only have one product");
        assertNotNull(service.getAllProducts(), "Shouldn't be null");

    }

    @Test
    public void testGetAllTaxes() throws Exception {
        FmTax onlyTax = new FmTax();
        onlyTax.setStateAbbreviation("TX");
        onlyTax.setStateName("Texas");
        onlyTax.setTaxRate(new BigDecimal("4.45"));

        assertEquals(1, service.getAllTaxes().size(), "Should have one tax");
        assertTrue(service.getAllTaxes().contains(onlyTax), "The one Tax should be Texas");

    }

    @Test
    public void testCalculateOrder() throws Exception {

        String date = "02142023";
        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));

        FmOrder onlyOrder = new FmOrder();
        onlyOrder.setOrderDate(localdate);
        onlyOrder.setCustomerName("Karma");
        FmTax tax = new FmTax();
        tax.setStateAbbreviation("TX");
        FmProduct product = new FmProduct();
        product.setProductType("Tile");
        BigDecimal orderArea = new BigDecimal("153");
        onlyOrder.setOrderArea(orderArea);
        onlyOrder.setOrderProduct(product);
        onlyOrder.setOrderStateName(tax);

        FmOrder testOrder = service.validateOrder(onlyOrder);

        assertEquals(testOrder.getOrderNumber(), 10);
        assertEquals(testOrder.getOrderMaterialCost(), new BigDecimal("535.50"));
        assertEquals(testOrder.getLaborCost(), new BigDecimal("634.95"));
        assertEquals(testOrder.getTotalTax(), new BigDecimal("52.09"));
        assertEquals(testOrder.getOrderTotal(), new BigDecimal("1222.54"));

    }

    @Test
    public void testValidateOrderInvalidName() throws Exception {//pass in bad data not just null.
        //created a new order
        String date = "12142027";

        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        FmOrder validOrder = new FmOrder();
        validOrder.setOrderDate(localdate);
        validOrder.setCustomerName("$Karma%");

        try {
            service.validateOrder(validOrder);
            fail("if failed, should throw the exception");//should fail if these characters were passed in.
        } catch (OrderDataInvalidException e) {
            System.out.println("Name is incorrect. Test Passed.");
        }

    }

    @Test
    public void testValidateOrderNullArea() throws Exception {//pass in bad data not just null.
        //created a new order
        String date = "12142027";

        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        FmOrder validOrder = new FmOrder();
        validOrder.setOrderDate(localdate);
        validOrder.setCustomerName("Karma");//set a proper name
        validOrder.setOrderStateName(new FmTax("TX", new BigDecimal("4.45")));
        FmProduct validProduct = new FmProduct();
        validOrder.setOrderProduct(validProduct);
        validOrder.setOrderArea(null);//set order Area to null

        try {
            service.validateOrder(validOrder);
            fail("This should fail if no exception is thrown");
        } catch (OrderDataInvalidException e) {
            System.out.println("Null OrderArea exception is thrown.");
        }

    }
   

    @Test
    public void testValidateOrderInvalidProduct() throws Exception {

        String date = "02142023";
        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
//        int orderNumber = 9;

        FmOrder validOrder = new FmOrder();
        validOrder.setOrderDate(localdate);
//        validOrder.setOrderNumber(orderNumber);
        validOrder.setCustomerName("Karma");
        FmTax newTax = new FmTax();
        newTax.setStateAbbreviation("TX");
        FmProduct newProduct = new FmProduct();
        newProduct.setProductType("Gold");
        BigDecimal orderArea = new BigDecimal("342");
        validOrder.setOrderArea(orderArea);
        validOrder.setOrderProduct(newProduct);
        validOrder.setOrderStateName(newTax);

        try {
            service.validateOrder(validOrder);
            fail("Invalid product exception should be thrown.");
        } catch (FmInvalidProductException e) {
            System.out.println("Product should not be gold");
        }
    }

    @Test
    public void testValidateOrderInvalidState() throws Exception {
        String date = "02142023";
        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
//        int orderNumber = 9;

        FmOrder validOrder = new FmOrder();
        validOrder.setOrderDate(localdate);
//        validOrder.setOrderNumber(orderNumber);
        validOrder.setCustomerName("Karma");
        FmTax newTax = new FmTax();
        newTax.setStateAbbreviation("NY");
        FmProduct newProduct = new FmProduct();
        newProduct.setProductType("Tile");
        BigDecimal orderArea = new BigDecimal("342");
        validOrder.setOrderArea(orderArea);
        validOrder.setOrderProduct(newProduct);
        validOrder.setOrderStateName(newTax);

        try {
            service.validateOrder(validOrder);
            fail("Invalid Tax exception should be thrown");
        } catch (FmInvalidTaxException e) {
            System.out.println("State/Tax should not be NewYork");
        }
    }

    @Test
    public void testValidateOrderAddOrderOrderNumber() throws Exception {

        String date = "02142023";
        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));

        FmOrder validOrder = new FmOrder();
        validOrder.setOrderDate(localdate);
        validOrder.setCustomerName("Karma");
        FmTax newTax = new FmTax();
        newTax.setStateAbbreviation("TX");
        FmProduct newProduct = new FmProduct();
        newProduct.setProductType("Tile");
        BigDecimal orderArea = new BigDecimal("342");
        validOrder.setOrderArea(orderArea);
        validOrder.setOrderProduct(newProduct);
        validOrder.setOrderStateName(newTax);

        assertEquals(validOrder.getOrderNumber(), 0, "Order Number should be 0 before validation.");

        FmOrder validatedOrder = service.validateOrder(validOrder);

        assertEquals(validatedOrder.getOrderNumber(), 10, "Order Number should be 10 after validation.");

    }

    @Test
    public void testValidateOrderEditOrderNumber() throws Exception {
        String date = "02142023";
        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 9;

        FmOrder editedOrder = new FmOrder();
        editedOrder.setOrderDate(localdate);
        editedOrder.setOrderNumber(orderNumber);

        final String orderName = "Karma";
        editedOrder.setCustomerName(orderName);

        FmTax newTax = new FmTax();
        final String testState = "TX";
        newTax.setStateAbbreviation(testState);
        final String taxrateString = "4.45";
        BigDecimal taxRate = new BigDecimal(taxrateString);
        newTax.setTaxRate(taxRate);
        editedOrder.setOrderStateName(newTax);

        FmProduct newProduct = new FmProduct("Tile", new BigDecimal("3.50"), new BigDecimal("4.15"));
        newProduct.setProductType(newProduct.getProductType());
        editedOrder.setOrderProduct(newProduct);

        final String testArea = "150";
        BigDecimal orderArea = new BigDecimal(testArea);
        editedOrder.setOrderArea(orderArea);
//
//        BigDecimal matCosts = editedOrder.getOrderProduct().getCostPerSquareFt().multiply(editedOrder.getOrderArea());
//        BigDecimal matCostsScaled = matCosts.setScale(2, RoundingMode.HALF_UP);
//        editedOrder.setOrderMaterialCost(matCostsScaled);
//
//        BigDecimal laborCosts = editedOrder.getOrderArea().multiply(editedOrder.getOrderProduct().getlaborCostPerSquareFt());
//        BigDecimal laborCostsScaled = laborCosts.setScale(2, RoundingMode.HALF_UP);
//        editedOrder.setLaborCost(laborCostsScaled);
//        BigDecimal taxCosts = matCosts.add(laborCosts).multiply(editedOrder.getOrderStateName().getTaxRate().divide(new BigDecimal("100").setScale(2, RoundingMode.HALF_UP)));
//        BigDecimal taxCostsScaled = taxCosts.setScale(2, RoundingMode.HALF_UP);
//        editedOrder.setTotalTax(taxCostsScaled);
//        BigDecimal totalCosts = matCosts.add(laborCosts).add(taxCosts);
//        BigDecimal totalCostsScaled = totalCosts.setScale(2, RoundingMode.HALF_UP);
//        editedOrder.setOrderTotal(totalCostsScaled);

        //ACT AND ASSERT
        FmOrder orderAfterEdits = service.validateOrder(editedOrder);
        assertEquals(editedOrder.getOrderNumber(), orderAfterEdits.getOrderNumber(), "Order Numbers should be the same");

    }

}
