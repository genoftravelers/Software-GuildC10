/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import vm.dto.VmItem;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public interface VmDao {

    /**
     * Returns a list of all items in the collection.
     *
     * @return List containing all items in the collection.
     * @throws vm.dao.VmPersistenceException
     */
    List<VmItem> getAllItems() throws VmPersistenceException;

    
    //String itemName
    VmItem addItem(String itemName, VmItem anItem) throws VmPersistenceException;
//    1. added to Dao ->Item("Twix", $1.00, qty 12)
//    2. made purchase of "Twix"
//    3. now add this-> Item("Twix", $1.00, qty 11) (As a way of updating)
//            SAME NAME!!!
//    4. get dao item "Twix" -> Item("Twix", $1.00, qty 11)
            
            
    VmItem getSelectedItem(String itemName) throws VmPersistenceException;

}
