/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import vm.dto.Coins;
//import vm.dao.VmPersistenceException;
import vm.dto.VmItem;
import vm.dao.VmPersistenceException;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public interface VmService {

    List<VmItem> getAllItems() throws VmPersistenceException;

    // VmItem addItem(VmItem anItem) throws ItemValidationException, VmPersistenceException;
//    1. added to Dao ->Item("Twix", $1.00, qty 12)
//    2. made purchase of "Twix"
//    3. now add this-> Item("Twix", $1.00, qty 11) (As a way of updating)
//            SAME NAME!!!
//    4. get dao item "Twix" -> Item("Twix", $1.00, qty 11)
    VmItem getSelectedItem(String itemName) throws ItemDoesNotExistException, VmPersistenceException, ItemValidationException, ItemDoesNotExistException;

    VmItem purchaseItem(String itemName, BigDecimal money) throws VmPersistenceException, InsufficientMoneyException, ItemDoesNotExistException, ItemValidationException;

    Map returnChange(BigDecimal cost, BigDecimal money);
}
