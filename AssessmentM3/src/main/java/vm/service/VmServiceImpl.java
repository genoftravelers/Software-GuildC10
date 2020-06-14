/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vm.dao.VmAuditDao;
import vm.dao.VmDao;
import vm.dao.VmPersistenceException;
import vm.dto.Coins;
import vm.dto.VmItem;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class VmServiceImpl implements VmService {

    VmDao dao;
    VmAuditDao auditDao;

    public VmServiceImpl(VmDao dao, VmAuditDao auditDao) {
        this.auditDao = auditDao;
        this.dao = dao;
    }

    @Override
    public List<VmItem> getAllItems() throws VmPersistenceException {
        //1. Sweets (10) 2. Drinks(0) 3. Tiger Biscuit(11)

        List<VmItem> listItem = dao.getAllItems();

        List<VmItem> newList = new ArrayList<>();

        for (VmItem newItem : listItem) {
            if (newItem.getNumOfItems() > 0) {
                newList.add(newItem);
            }

        }
        return newList;
    }

//    @Override
//    public VmItem addItem(VmItem anItem) throws ItemValidationException, VmPersistenceException, VmDuplicateNameException {
//            if(dao.getSelectedItem(anItem.getItemName()) != null) {
//                throw new VmDuplicateNameException("Error: " + "item already exists.");
//            }
//               
//        
//    }
    @Override
    public VmItem getSelectedItem(String itemName) throws ItemDoesNotExistException, VmPersistenceException, ItemValidationException {

        return dao.getSelectedItem(itemName);

    }

    @Override
    public VmItem purchaseItem(String itemName, BigDecimal money) throws VmPersistenceException, ItemDoesNotExistException, InsufficientMoneyException, ItemValidationException {

        //1. Water, 2, 20 2. Snacks ,1, 0
        VmItem buyItem = dao.getSelectedItem(itemName);
        if (buyItem == null) {
            throw new ItemDoesNotExistException("Item Does not exist, please try from Menu above.");
        }
        //validateVmData(buyItem);

        if (buyItem.getNumOfItems() == 0) {
            throw new ItemDoesNotExistException("OUT OF STOCK!");
        }

        if (money.compareTo(buyItem.getItemCost()) == 0 || money.compareTo(buyItem.getItemCost()) > 0) {
            buyItem.setNumOfItems(buyItem.getNumOfItems() - 1);
            dao.addItem(itemName, buyItem);
            auditDao.writeAuditEntry(itemName + " successfully purchased.");
            return buyItem;

        } else {
            throw new InsufficientMoneyException("You have only entered " + money + " dollars, please enter more $$ to purchase.");
        }

    }

    @Override
    public Map returnChange(BigDecimal cost, BigDecimal money) {
        Change change = new Change();
        BigDecimal leftAmount = money.subtract(cost);
        leftAmount = leftAmount.multiply(new BigDecimal("100"));//returning change in cents.
        int changeBreak = leftAmount.intValue();//intValue is inbuult for BigDecimal.
        change.changeCalc(changeBreak);

        int amtOfQuarters = change.getNumOfQuarters();
        int amtOfDime = change.getNumOfDimes();
        int amtOfNickel = change.getNumOfNickels();
        int amtOfPenny = change.getNumOfCents();

        Map<Coins, Integer> newMap = new HashMap<>();

        newMap.put(Coins.PENNY, amtOfPenny);
        newMap.put(Coins.DIME, amtOfDime);
        newMap.put(Coins.NICKEL, amtOfNickel);
        newMap.put(Coins.QUARTER, amtOfQuarters);

        return newMap;

    }

    private void validateVmData(VmItem anItem) throws ItemValidationException {
        if (anItem == null
                || anItem.getItemName().trim().length() == 0
                || anItem.getItemCost() == null
                || anItem.getItemCost().compareTo(new BigDecimal("0.01")) <= 0) {
            throw new ItemValidationException(
                    "ERROR: All fields [Item Name and Cost] are required.");
        }
    }

}
