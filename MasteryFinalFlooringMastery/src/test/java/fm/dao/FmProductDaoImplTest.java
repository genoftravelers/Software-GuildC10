/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.dao;

import fm.dto.FmProduct;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class FmProductDaoImplTest {

    FmProductDao testProductDao;

    public FmProductDaoImplTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testProduct.txt";
        //  new FileWriter(testFile);
        //new FmProductDaoImpl(testFile);

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        testProductDao
                = ctx.getBean("FmProductDao", FmProductDaoImpl.class);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddGetProduct() throws FmPersistenceException {
        //ARRANGE

        String productType = "Carpet";
        BigDecimal productCost = new BigDecimal("2.25");
        BigDecimal laborCost = new BigDecimal("2.10");

        FmProduct product = new FmProduct(productType, productCost, laborCost);

        //ACT
        FmProduct retrievedProduct1 = testProductDao.getProduct("Carpet");
        //ASSERT
        assertEquals(product.getProductType(), retrievedProduct1.getProductType(), "Checking product type");
        assertEquals(product.getCostPerSquareFt(), retrievedProduct1.getCostPerSquareFt(), "Checking product cost / Sqft.");
        assertEquals(product.getlaborCostPerSquareFt(), retrievedProduct1.getlaborCostPerSquareFt(), "Checking labor cost / sqft.");
        //       assertEquals(product, retrievedProduct1, "check the object itself.");
    }

    @Test
    public void testAddGeAllProducts() throws FmPersistenceException {
        // ARRANGE -> FIRST PRODUCT

        FmProduct firstProduct = new FmProduct();
        firstProduct.setProductType("Carpet");
        BigDecimal productCost1 = new BigDecimal("2.25");
        firstProduct.setCostPerSquareFt(productCost1);
        BigDecimal laborCost1 = new BigDecimal("2.10");
        firstProduct.setLaborCostPerSquareFt(laborCost1);

        //SECOND PRODUCT
        FmProduct secondProduct = new FmProduct();
        secondProduct.setProductType("Laminate");
        BigDecimal productCost2 = new BigDecimal("1.75");
        secondProduct.setCostPerSquareFt(productCost2);
        BigDecimal laborCost2 = new BigDecimal("2.10");
        secondProduct.setLaborCostPerSquareFt(laborCost2);

//        //ADD BOTH PRODUCTS TO DAO
//        testProductDao.addProduct(firstProduct.getProductType(), firstProduct);
//        testProductDao.addProduct(secondProduct.getProductType(), secondProduct);
        //RETRIEVE THE LIST OF ALL PROUCTS IN THE DAO
        List<FmProduct> allProducts = testProductDao.getAllProduct();

        //CHECK GENERAL CONTENT OF LIST
        assertNotNull(allProducts, "The list of products must not be null");
        assertEquals(2, allProducts.size(), "List of product should have 2.");

        //ASSERT
        assertTrue(testProductDao.getAllProduct().contains(firstProduct),
                "The list of product should include Laminate ");
        assertTrue(testProductDao.getAllProduct().contains(secondProduct),
                "The list of product should include Tile");

    }

//    @Test
//    public void testRemoveProduct() throws Exception {
//        //FIRST PRODCUT
//        FmProduct firstProduct = new FmProduct();
//        firstProduct.setProductType("Carpet");
//        BigDecimal productCost1 = new BigDecimal("2.25");
//        firstProduct.setCostPerSquareFt(productCost1);
//        BigDecimal laborCost1 = new BigDecimal("2.10");
//        firstProduct.setLaborCostPerSquareFt(laborCost1);
//
//        //SECOND PRODUCT
//        FmProduct secondProduct = new FmProduct();
//        secondProduct.setProductType("Laminate");
//        BigDecimal productCost2 = new BigDecimal("1.75");
//        secondProduct.setCostPerSquareFt(productCost2);
//        BigDecimal laborCost2 = new BigDecimal("2.10");
//        secondProduct.setLaborCostPerSquareFt(laborCost2);
//
//        //ADD TWO TO THE DAO
//        testProductDao.addProduct(firstProduct.getProductType(), firstProduct);
//        testProductDao.addProduct(secondProduct.getProductType(), secondProduct);
//
//        //REMOVE THE FIRST PRODUCT
//        FmProduct removedProduct = testProductDao.removeProduct(firstProduct.getProductType());
//
//        //CHECK THAT TEH CORRECT PRODCUT WAS REMOVED
//        assertEquals(removedProduct, firstProduct, "The removed product should be Carpet");
//
//        //GET ALL PRODUCT
//        List<FmProduct> allProducts = testProductDao.getAllProduct();
//        
//        //FIRST CHECK THE GENERAL CONTENTS OF TEH LIST
//        assertNotNull(allProducts, "All product list should not be null");
//                assertEquals(1, allProducts.size(), "There should be 1 dvd");
//
//      //  assertTrue(allProducts.contains(firstProduct), "All Product should include Carpet");
//      //  assertTrue(allProducts.contains(secondProduct), "ALL Product should include Laminate");
//        
//        
//        //RETRIEVE ALL OF THE PRODUCT AGAIN AND CHECK TEH LIST
////        allProducts = testProductDao.getAllProduct();
////        assertNotNull(allProducts, "All product lost should not be null");
////        assertEquals(1, allProducts.size(), "There should be 1 dvd");
////        
//        //THEN THE SPECIFIES
//        assertFalse(allProducts.contains(firstProduct), "All product should not include Carpet");
//        assertTrue(allProducts.contains(secondProduct), "aLL Products should include Laminate");
//        
//        //REMOVE THE SECOND DVD = LAMINATE
//        removedProduct = testProductDao.removeProduct(secondProduct.getProductType());
//        //CHECK THE CORRECT ONE AS REMOVED
//        assertEquals(removedProduct, secondProduct, "The removed product was Laminate");
//        
//        //RETREIVE ALL OF TEH PRODUCT AGAIN AND CHECK THE LIST
//        allProducts = testProductDao.getAllProduct();
//        
//        //CHECK THE CONTENT OF THE LIST, IT SHOULD BE ZERO
//        assertNull(allProducts, "All products should be null");
//        assertEquals(0, allProducts.size(), "All products should be 0.");
//        
//        //THEN THE SPECIFIES
//        assertFalse(allProducts.contains(firstProduct), " All product should not include Carpet");
//        assertFalse(allProducts.contains(secondProduct), "All product should not include Laminate");
//        
//        //CHECK TEH CONTENT OF THE LIST , SHOULD BE EMPTY
//        assertTrue(allProducts.isEmpty(), "The retrieved of Products should be empty");
//        
//        //TRY TO "GET" ALL PRODUCTS BY THEIR TYPE = THEY SHOULD BE NULL;
//        FmProduct retrievedProduct = testProductDao.getProduct(firstProduct.getProductType());
//        assertNull(retrievedProduct, "Carpet was removed, should be null");
//        retrievedProduct = testProductDao.getProduct(secondProduct.getProductType());
//        assertNull(retrievedProduct, "Lamimate was removed, should be null");
//    }
}
