/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import vm.dto.VmItem;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class VmDaoFileImpl implements VmDao {


    public final String INVENTORY_FILE;
    public static final String DELIMITER = "::";

    public VmDaoFileImpl() { //production constructor
        INVENTORY_FILE = "inventory.txt";
    }

    public VmDaoFileImpl(String inventoryTextFile) {//testing constructor
        INVENTORY_FILE = inventoryTextFile;
    }

    private Map<String, VmItem> VmItems = new HashMap<>();

    private VmItem unmarshallVmItem(String VmItemAsText) {
        String[] VmItemTokens = VmItemAsText.split(DELIMITER);

        String itemName = VmItemTokens[0];
        BigDecimal itemCost = new BigDecimal(VmItemTokens[1]);
        int numOfItems = Integer.parseInt(VmItemTokens[2]);

        VmItem itemFromFile = new VmItem(itemName, itemCost, numOfItems);

        return itemFromFile;

    }

    private void loadInventory() throws VmPersistenceException {
        Scanner sc;

        try {
            sc = new Scanner(
                    new BufferedReader(
                            new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new VmPersistenceException(
                    "-_- could not load roster data in memory", e);
        }
        String currentLine;
        VmItem currentVmItem;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentVmItem = unmarshallVmItem(currentLine);

            VmItems.put(currentVmItem.getItemName(), currentVmItem);
        }
        sc.close();
    }

    private String marshallVmItem(VmItem anItem) {
        String VmItemAsText = anItem.getItemName() + DELIMITER;
        VmItemAsText += anItem.getItemCost() + DELIMITER;
        VmItemAsText += anItem.getNumOfItems();

        return VmItemAsText;
    }

    private void writeInventory() throws VmPersistenceException {
        PrintWriter out;
        //String itemAsText;
        List<VmItem> itemList = new ArrayList(VmItems.values());

        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
            itemList.stream()
                    .forEach((item) -> {
                        String itemAsText = marshallVmItem(item);
                        out.println(itemAsText);
                        out.flush();
                    });

            out.close(); //clean up

        } catch (IOException e) {
            throw new VmPersistenceException("COULD NOT SAVE ITEM DATA", e);
        }
    }

//    private void writeInventory() throws VmPersistenceException {
//        PrintWriter out;
//        try {
//            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
//
//        } catch (IOException e) {
//            throw new VmPersistenceException("COUNLD NOT SAVE ITEM DATA", e);
//        }
//
//        String itemAsText;
//        List<VmItem> itemList = new ArrayList(VmItems.values());
//        //itemList.forEach((currentItem) -> out.println(currentItem));
//        for (VmItem currentItem : itemList) {
//            itemAsText = marshallVmItem(currentItem);
//            out.println(itemAsText);
//            out.flush();// force PrintWriter to write line to the file.
//        }
//        out.close(); //clean up
//    }
    @Override
    public List<VmItem> getAllItems() throws VmPersistenceException {
        loadInventory();
        return new ArrayList(VmItems.values());
    }

    @Override
    public VmItem addItem(String itemName, VmItem anItem) throws VmPersistenceException {
        loadInventory();
        VmItem newVmItem = VmItems.put(itemName, anItem);
        writeInventory();
        return newVmItem;

    }

    @Override
    public VmItem getSelectedItem(String ItemName) throws VmPersistenceException {
        loadInventory();
        return VmItems.get(ItemName);

    }

}
