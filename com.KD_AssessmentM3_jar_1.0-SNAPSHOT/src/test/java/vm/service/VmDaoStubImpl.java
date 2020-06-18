/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import vm.dao.VmDao;
import vm.dao.VmPersistenceException;
import vm.dto.VmItem;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class VmDaoStubImpl implements VmDao {

    public VmItem onlyItem;

    public VmDaoStubImpl() {
        onlyItem = new VmItem("Yogurt with Granola", new BigDecimal("4.99"), 10);
    }

    public VmDaoStubImpl(VmItem testItem) {
        this.onlyItem = testItem;
    }

    @Override
    public List<VmItem> getAllItems() throws VmPersistenceException {
        List<VmItem> itemList = new ArrayList<>();
        itemList.add(onlyItem);
        return itemList;
    }

    @Override
    public VmItem addItem(String itemName, VmItem anItem) throws VmPersistenceException {
        if (itemName.equals(onlyItem.getItemName())) {
            return onlyItem; //indicates failure/updates
        } else {
            return null;//indicates successfull adding
        }
    }

    @Override
    public VmItem getSelectedItem(String itemName) throws VmPersistenceException {
        if (itemName.equals(onlyItem.getItemName())) {
            return onlyItem;
        } else {
            return null;
        }
    }

}
