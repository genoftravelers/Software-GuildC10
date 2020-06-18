/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm.service;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import vm.dao.VmAuditDao;
import vm.dao.VmDao;
import vm.dto.VmItem;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class VmServiceImplTest {

    private VmService service;

    public VmServiceImplTest() {
        VmDao dao = new VmDaoStubImpl();
        VmAuditDao auditDao = new VmAudiDaoStubImpl();

        service = new VmServiceImpl(dao, auditDao);
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetAllItem() throws Exception {

        //ARRANGE
        VmItem anItem = new VmItem("Yogurt with Granola", new BigDecimal("4.99"), 10);

        List<VmItem> list = service.getAllItems();
        //ACT & ASSERT
        assertEquals(1, list.size(), "Should only have 1 item.");
        assertTrue(list.contains(anItem));

    }

    @Test
    public void testPurchaseItem() throws Exception {
        //ARRANGE 
        VmItem anItem = new VmItem("Yogurt with Granola", new BigDecimal("4.99"), 10);

        //ACT& ASSERT
        VmItem purchasedItem = service.purchaseItem(anItem.getItemName(), new BigDecimal("6.99"));
        
                        //expected          //actual
       assertEquals(anItem.getItemName(), purchasedItem.getItemName(), "Item name should same");
       assertTrue(anItem.getItemCost().equals(purchasedItem.getItemCost()));

    }

}
