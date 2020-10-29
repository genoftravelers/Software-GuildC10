/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.dao;

import fm.dto.FmOrder;
import fm.dto.FmProduct;
import fm.dto.FmTax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class FmOrderDaoImplTest {

    FmOrderDao testOrderDao;

    public FmOrderDaoImplTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        //create order and reuse them.
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws Exception {
//        String testFile = "Test/";
//        new File(testFile);
//        for (File file : folder.listFiles()) {
//            file.delete();
//        }
        //  new FileWriter(testFile);
        //  testOrderDao = new FmOrderDaoImpl(testFile);
//       
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        testOrderDao
                = ctx.getBean("FmOrderDao", FmOrderDaoImpl.class);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddGetOrder() throws Exception {
        //ARRANGE
        String date = "02142023";
        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 9;
        FmOrder newOrder = new FmOrder();
        newOrder.setOrderDate(localdate);
        newOrder.setOrderNumber(orderNumber);
        newOrder.setCustomerName("Karma");
        FmTax newTax = new FmTax();
        newTax.setStateAbbreviation("CA");
        BigDecimal taxRate = new BigDecimal("25.00");
        newTax.setTaxRate(taxRate);
        FmProduct newProduct = new FmProduct();
        newProduct.setProductType("Tile");
        BigDecimal orderArea = new BigDecimal("342");
        newOrder.setOrderArea(orderArea);
        BigDecimal costPerSqFt = new BigDecimal("3.50");
        BigDecimal laborCostPerSqFt = new BigDecimal("4.15");
        newProduct.setCostPerSquareFt(costPerSqFt);
        newProduct.setLaborCostPerSquareFt(laborCostPerSqFt);
        newOrder.setOrderProduct(newProduct);
        newOrder.setOrderStateName(newTax);
        BigDecimal materialCost = new BigDecimal("1197.00");
        BigDecimal laborCost = new BigDecimal("1419.30");
        BigDecimal tax = new BigDecimal("654.08");
        BigDecimal total = new BigDecimal("3270.38");
        newOrder.setProductCost(materialCost);
        newOrder.setLaborCost(laborCost);
        newOrder.setOrderMaterialCost(materialCost);
        newOrder.setTotalTax(tax);
        newOrder.setOrderTotal(total);

        testOrderDao.addOrder(newOrder);

        FmOrder testNewOrder = testOrderDao.getOrderByDateandId(localdate, orderNumber);
//        assertEquals(testNewOrder, newOrder, "Orders should be the same");//OBJECTS NOT TAKING IN, ONLY INDIVIDUAL DETAILS.
        assertEquals(newOrder.getCustomerName(), testNewOrder.getCustomerName(), "Order should be equal");
        assertEquals(newOrder.getLaborCost(), testNewOrder.getLaborCost(), "labor cost should be same.");
        assertEquals(newOrder.getOrderDate(), testNewOrder.getOrderDate(), "Date should be the same.");

        assertNotNull(testNewOrder, "it must be not null");
//        //9,Karma,CA,25.00,Tile,342,3.50,4.15,1197.00,1419.30,654.08,3270.38
    }

    @Test
    public void testRemoveOrder() throws Exception {
        String date = "02152025";
        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 1;
        FmOrder newOrder = new FmOrder();
        newOrder.setOrderDate(localdate);
        newOrder.setOrderNumber(orderNumber);
        newOrder.setCustomerName("Karma");
        FmTax newTax = new FmTax();
        newTax.setStateAbbreviation("CA");
        BigDecimal taxRate = new BigDecimal("25.00");
        newTax.setTaxRate(taxRate);
        FmProduct newProduct = new FmProduct();
        newProduct.setProductType("Tile");
        BigDecimal orderArea = new BigDecimal("342");
        newOrder.setOrderArea(orderArea);
        BigDecimal costPerSqFt = new BigDecimal("3.50");
        BigDecimal laborCostPerSqFt = new BigDecimal("4.15");
        newProduct.setCostPerSquareFt(costPerSqFt);
        newProduct.setLaborCostPerSquareFt(laborCostPerSqFt);
        newOrder.setOrderProduct(newProduct);
        newOrder.setOrderStateName(newTax);
        BigDecimal materialCost = new BigDecimal("1197.00");
        BigDecimal laborCost = new BigDecimal("1419.30");
        BigDecimal tax = new BigDecimal("654.08");
        BigDecimal total = new BigDecimal("3270.38");
        newOrder.setProductCost(materialCost);
        newOrder.setLaborCost(laborCost);
        newOrder.setOrderMaterialCost(materialCost);
        newOrder.setTotalTax(tax);
        newOrder.setOrderTotal(total);

        //SECOND ORDER IS HERE FOR DEBUG PURPOSE TO SEE IF THE FIRST ORDER IS BELING DELETED CORRECTLY,
        String secondDate = "02152025";
        LocalDate secondLocaldate = LocalDate.parse(secondDate, DateTimeFormatter.ofPattern("MMddyyyy"));
        int newOrderNumber = 2;
        FmOrder testSecondOrder = new FmOrder();
        testSecondOrder.setOrderDate(secondLocaldate);
        testSecondOrder.setOrderNumber(newOrderNumber);
        testSecondOrder.setCustomerName("MEENY");
        FmTax secondTax = new FmTax();
        secondTax.setStateAbbreviation("CA");
        BigDecimal secondtaxRate = new BigDecimal("25.00");
        secondTax.setTaxRate(secondtaxRate);
        FmProduct newEditedProduct = new FmProduct();
        newEditedProduct.setProductType("Laminate");
        BigDecimal secondOrderArea = new BigDecimal("342");
        testSecondOrder.setOrderArea(secondOrderArea);
        BigDecimal costPerSqFt1 = new BigDecimal("3.50");
        BigDecimal laborCostPerSqFt1 = new BigDecimal("4.15");
        newEditedProduct.setCostPerSquareFt(costPerSqFt1);
        newEditedProduct.setLaborCostPerSquareFt(laborCostPerSqFt1);
        testSecondOrder.setOrderProduct(newEditedProduct);
        testSecondOrder.setOrderStateName(secondTax);
        BigDecimal materialCost1 = new BigDecimal("1197.00");
        BigDecimal laborCost1 = new BigDecimal("1419.30");
        BigDecimal tax1 = new BigDecimal("654.08");
        BigDecimal total1 = new BigDecimal("3270.38");
        testSecondOrder.setProductCost(materialCost1);
        testSecondOrder.setLaborCost(laborCost1);
        testSecondOrder.setOrderMaterialCost(materialCost1);
        testSecondOrder.setTotalTax(tax1);
        testSecondOrder.setOrderTotal(total1);
        FmOrder addOrder = testOrderDao.addOrder(testSecondOrder);

        FmOrder addedOrder = testOrderDao.addOrder(newOrder);
        assertEquals(newOrder, addedOrder, "Orders should be the same");
        String testDate = "02152025";
        LocalDate testlocaldate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int testOrderNum = 1;
        FmOrder testOrder1 = testOrderDao.getOrderByDateandId(testlocaldate, testOrderNum);
        FmOrder removedOrder = testOrderDao.removeOrder(testlocaldate, testOrderNum);
        assertNotNull(removedOrder, "Removed order cannot be null.");
        List<FmOrder> allOrders = testOrderDao.getAllOrdersForDate(localdate);
        assertEquals(removedOrder.getCustomerName(), newOrder.getCustomerName(), "Customer names should be the same");

//        assertEquals(removedOrder, newOrder, "Removed order is same as the newOrder ");
        assertEquals(1, allOrders.size(), "All orders should be ONE");//THERE SHOULD ONLY BE ONE ORDER OUT OF TWO.
        assertFalse(allOrders.isEmpty(), "List is empty.");//SHOULD NOT BE EMPTY.
    }

    @Test
    public void testExportAllData() throws OrderPersistenceException, FmPersistenceException {
        Map<LocalDate, Map<Integer, FmOrder>> testMap = testOrderDao.exportAllData();
        assertNotNull(testMap, "Map shouldn't be null");
    }

    @Test
    public void testEditOrder() throws Exception {

        String date = "02152021";
        LocalDate localdate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
        int orderNumber = 2;
        FmOrder newOrder = new FmOrder();
        newOrder.setOrderDate(localdate);
        newOrder.setOrderNumber(orderNumber);
        newOrder.setCustomerName("Karma");
        FmTax newTax = new FmTax();
        newTax.setStateAbbreviation("CA");
        BigDecimal taxRate = new BigDecimal("25.00");
        newTax.setTaxRate(taxRate);
        FmProduct newProduct = new FmProduct();
        newProduct.setProductType("Tile");
        BigDecimal orderArea = new BigDecimal("342");
        newOrder.setOrderArea(orderArea);
        BigDecimal costPerSqFt = new BigDecimal("3.50");
        BigDecimal laborCostPerSqFt = new BigDecimal("4.15");
        newProduct.setCostPerSquareFt(costPerSqFt);
        newProduct.setLaborCostPerSquareFt(laborCostPerSqFt);
        newOrder.setOrderProduct(newProduct);
        newOrder.setOrderStateName(newTax);
        BigDecimal materialCost = new BigDecimal("1197.00");
        BigDecimal laborCost = new BigDecimal("1419.30");
        BigDecimal tax = new BigDecimal("654.08");
        BigDecimal total = new BigDecimal("3270.38");
        newOrder.setProductCost(materialCost);
        newOrder.setLaborCost(laborCost);
        newOrder.setOrderMaterialCost(materialCost);
        newOrder.setTotalTax(tax);
        newOrder.setOrderTotal(total);

        FmOrder addedOrder = testOrderDao.addOrder(newOrder);

        FmOrder retrievedOrder = testOrderDao.getOrderByDateandId(localdate, orderNumber);
        assertEquals(retrievedOrder.getCustomerName(), newOrder.getCustomerName(), "Should be same");

        String editedDate = "02152021";
        LocalDate editedLocaldate = LocalDate.parse(editedDate, DateTimeFormatter.ofPattern("MMddyyyy"));
        int newOrderNumber = 2;
        FmOrder newEditedOrder = new FmOrder();
        newEditedOrder.setOrderDate(editedLocaldate);
        newEditedOrder.setOrderNumber(newOrderNumber);
        newEditedOrder.setCustomerName("FUNKY");
        FmTax newEditedTax = new FmTax();
        newEditedTax.setStateAbbreviation("WA");
        BigDecimal editedtaxRate = new BigDecimal("25.00");
        newEditedTax.setTaxRate(editedtaxRate);
        FmProduct newEditedProduct = new FmProduct();
        newEditedProduct.setProductType("Laminate");
        BigDecimal editedOrderArea = new BigDecimal("342");
        newEditedOrder.setOrderArea(editedOrderArea);
        BigDecimal costPerSqFt1 = new BigDecimal("3.50");
        BigDecimal laborCostPerSqFt1 = new BigDecimal("4.15");
        newEditedProduct.setCostPerSquareFt(costPerSqFt1);
        newEditedProduct.setLaborCostPerSquareFt(laborCostPerSqFt1);
        newEditedOrder.setOrderProduct(newEditedProduct);
        newEditedOrder.setOrderStateName(newEditedTax);
        BigDecimal materialCost1 = new BigDecimal("1197.00");
        BigDecimal laborCost1 = new BigDecimal("1419.30");
        BigDecimal tax1 = new BigDecimal("654.08");
        BigDecimal total1 = new BigDecimal("3270.38");
        newEditedOrder.setProductCost(materialCost1);
        newEditedOrder.setLaborCost(laborCost1);
        newEditedOrder.setOrderMaterialCost(materialCost1);
        newEditedOrder.setTotalTax(tax1);
        newEditedOrder.setOrderTotal(total1);

        FmOrder editedOrder = testOrderDao.editOrder(newEditedOrder);
        retrievedOrder = testOrderDao.getOrderByDateandId(editedOrder.getOrderDate(), editedOrder.getOrderNumber());

        assertEquals(retrievedOrder.getCustomerName(), newEditedOrder.getCustomerName(), "Orders should be the same");
        assertNotEquals(retrievedOrder.getCustomerName(), newOrder.getCustomerName());
        assertNotNull(retrievedOrder, "This order should not be null");

    }

    ///Process for testing edit method
//make an order
//add it to the dao
//get it and make sure it's the same
//make an edited order with the same order date and order number
//use the editOrder function and use the edited order as the parameter
//get the order from the dao using the same orderDate and OrderID.
//make sure the order you get now is the same as the edited order 
//make sure the order is not the first order you added. 
//finish making completely edited order
}
