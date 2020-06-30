/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vm.dto.VmItem;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class VmDaoFileImplTest {

    VmDao testDao;

    private Map<String, VmItem> vm = new HashMap<>();

    public VmDaoFileImplTest() {
    }

    @BeforeEach
    public void setUp() throws Exception {
       // String testFile = "testInventory.txt";
        //new FileWriter(testFile);
     //   testDao = new VmDaoFileImpl(testFile);
        
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        testDao
                = ctx.getBean("vmDao", VmDaoFileImpl.class);
    }

    @Test
    public void testAddGetAllItems() throws VmPersistenceException, IOException {
        //Arange
        String itemName = "Yogurt with Granola";
        String itemName1 = "Avacado crisps";
        String itemName2 = "Beef Jerkey";
        VmItem item = new VmItem(itemName, new BigDecimal("4.99"), 10);
        VmItem item1 = new VmItem(itemName1, new BigDecimal("3.99"), 10);
        VmItem item2 = new VmItem(itemName2, new BigDecimal("2.99"), 10);
        //Act
        testDao.addItem(itemName, item);
        testDao.addItem(itemName1, item1);
        testDao.addItem(itemName2, item2);

        List<VmItem> allItems = testDao.getAllItems();
        //Assert
        assertNotNull(allItems);
        assertEquals(3, allItems.size(), "3 items");
        assertTrue(allItems.contains(item), "List should have Yogurt with Granola.");
        assertTrue(allItems.contains(item1), "List should have Avacado crisps.");
        assertTrue(allItems.contains(item2), "List should have Beef Jerkey.");

    }

    @Test
    public void testGetSelectedItem() throws VmPersistenceException, IOException {
        //Arrange

        String itemName = "Yogurt with Granola";
        String itemName1 = "Avacado crisps";
        String itemName2 = "Beef Jerkey";
        VmItem item = new VmItem(itemName, new BigDecimal("4.99"), 10);
        VmItem item1 = new VmItem(itemName1, new BigDecimal("3.99"), 10);
        VmItem item2 = new VmItem(itemName2, new BigDecimal("2.99"), 10);

        //Act
        testDao.addItem(itemName, item);
        testDao.addItem(itemName1, item1);
        testDao.addItem(itemName2, item2);

        VmItem retrievedItem = testDao.getSelectedItem(itemName);
        VmItem retrievedItem1 = testDao.getSelectedItem(itemName1);
        VmItem retrievedItem2 = testDao.getSelectedItem(itemName2);
        //Assert
        assertEquals(item.getItemName(), retrievedItem.getItemName(), "Name should be Yogurt");
        assertEquals(item.getItemCost(), retrievedItem.getItemCost(), "Cost should be $4.99");
        assertEquals(item.getNumOfItems(), retrievedItem.getNumOfItems(), "Amount should be 10.");

        assertEquals(item1.getItemName(), retrievedItem1.getItemName(), "Avacado crisps");
        assertEquals(item1.getItemCost(), retrievedItem1.getItemCost(), "Cost should be $3.99");
        assertEquals(item1.getNumOfItems(), retrievedItem1.getNumOfItems(), "Amount should be 10.");

        assertEquals(item2.getItemName(), retrievedItem2.getItemName(), "Name should be Beef Jerkey");
        assertEquals(item2.getItemCost(), retrievedItem2.getItemCost(), "Cost should be $2.99");
        assertEquals(item2.getNumOfItems(), retrievedItem2.getNumOfItems(), "Amount should be 10.");

    }
}
