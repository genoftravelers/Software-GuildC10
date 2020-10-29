/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.dao;

import fm.dto.FmTax;
import java.io.FileWriter;
import java.io.IOException;
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
public class FmTaxDaoImplTest {

    FmTaxDao testTaxDao;

    public FmTaxDaoImplTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws IOException {
        String testFile = "testTax.txt";
        //   new FileWriter(testFile);
//        testTaxDao = new FmTaxDaoImpl(testFile);

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        testTaxDao
                = ctx.getBean("FmTaxDao", FmTaxDaoImpl.class);

    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
    }

    @Test
    public void testAddGetTax() throws FmPersistenceException {

//        FmTax tax = new FmTax();
//        tax.setStateAbbreviation("TX");
//        tax.setStateName("Texas");
//        BigDecimal taxRate = new BigDecimal("4.45");
//        tax.setTaxRate(taxRate);
//        
//        FmTax tax1 = testTaxDao.getTax("TX");
//        assertEquals(tax1, tax, "tax must be same");
//        assertNotNull(tax1, "It should not be null");
//        
//        //ARRANGE
        String stateAbbreviation = "TX";
        String stateName = "Texas";
        BigDecimal taxRate = new BigDecimal("4.45");

        FmTax tax = new FmTax(stateAbbreviation, stateName, taxRate);

        //ACT
        FmTax retrievedTax1 = testTaxDao.getTax("TX");
        //ASSERT
        assertEquals(tax.getStateAbbreviation(), retrievedTax1.getStateAbbreviation(), "Checking state Abbre");
        assertEquals(tax.getStateName(), retrievedTax1.getStateName(), "Check state name");
        assertEquals(tax.getTaxRate(), retrievedTax1.getTaxRate(), "check state tax rate");

    }

//    @Test
//    public void testAddGetAllTaxs() throws FmPersistenceException {
//        //ARRANGE-> FIRST TAX
//        FmTax firstTax = new FmTax();
//        firstTax.setStateAbbreviation("TX");
//        firstTax.setStateName("Texas");
//        BigDecimal taxRate1 = new BigDecimal("4.45");
//        firstTax.setTaxRate(taxRate1);
//        
//        //SECOND TAX
//        FmTax secondTax = new FmTax();
//        secondTax.setStateAbbreviation("WA");
//        secondTax.setStateName("Washington");
//        BigDecimal taxRate2 = new BigDecimal("9.25");
//        firstTax.setTaxRate(taxRate2);
//        
//        //RETRIEVE THE LIST OF ALL PROUCTS IN THE DAO
//        List<FmTax> allTaxs = testTaxDao.getAllTaxs();
//        
//        //CHECK GENERAL CONTENT OF LIST
//        assertNotNull(allTaxs, "The list of taxes must not be null");
//        assertEquals(2, allTaxs.size(), "List of taxes should have 2.");
//
//        //ASSERT
//        assertFalse(testTaxDao.getAllTaxs().contains(firstTax),
//                "The list of tax should include TX ");
//        assertFalse(testTaxDao.getAllTaxs().contains(secondTax),
//                "The list of tax should include WA");
//    }
}
