/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.dao;

import fm.dto.FmOrder;
import fm.dto.FmProduct;
import fm.dto.FmTax;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class FmOrderDaoImpl implements FmOrderDao {

    private Map<LocalDate, Map<Integer, FmOrder>> outerMap = new HashMap<>();
    public String ORDERS_FILE;
    public String DELIMITER = ",";
    public String REPLACEMENT = "::";

    public FmOrderDaoImpl() {

//production constructor
        ORDERS_FILE = "Datafolder/Order";
    }

    public FmOrderDaoImpl(String FmOrdersTextFile) {

//testing constructor
        ORDERS_FILE = FmOrdersTextFile;
    }

//    public FmOrderDaoImpl(String testFile) {
//        //testing constructor
//        ORDERS_FILE=testFile;
//    }
    @Override
    public FmOrder addOrder(FmOrder newOrder) throws FmPersistenceException {
        loadFmOrders();
        FmOrder newAddedOrder;
        if (outerMap.containsKey(newOrder.getOrderDate())) {
            Map<Integer, FmOrder> innerMap = outerMap.get(newOrder.getOrderDate()); //loading the inner for new additions

            innerMap.put(newOrder.getOrderNumber(), newOrder); //add new order to inner map

            outerMap.put(newOrder.getOrderDate(), innerMap);
            newAddedOrder = outerMap.get(newOrder.getOrderDate()).get(newOrder.getOrderNumber());
        } else {
            Map<Integer, FmOrder> innerMap = new HashMap<>(); //initialize new innermap
            innerMap.put(newOrder.getOrderNumber(), newOrder); //add new order
            outerMap.put(newOrder.getOrderDate(), innerMap); //put innermap to outer
            newAddedOrder = outerMap.get(newOrder.getOrderDate()).get(newOrder.getOrderNumber());
        }

        writeOrderInventory();

        return newAddedOrder;

    }

    @Override
    public FmOrder editOrder(FmOrder order) throws FmPersistenceException{

        loadFmOrders();
//        if (order.getOrderNumber() == 0){
//            throw new FmInvalidOrderNumException(" cannot edit order with order number 0.");
//        }
//        if (order.getOrderDate().isBefore(LocalDate.now())){
//            throw new FmInvalidOrderDateException("cannot order past order.");
//        }
        Map<Integer, FmOrder> innerMap = outerMap.get(order.getOrderDate());
        FmOrder editedOrder = innerMap.put(order.getOrderNumber(), order);
        outerMap.put(order.getOrderDate(), innerMap);

        writeOrderInventory();
//note to self = this returns the order that was previously there, not the newly edited order
        return editedOrder;

    }

    @Override
    public FmOrder removeOrder(LocalDate date, int orderNum) throws FmPersistenceException, FmInvalidOrderDateException, FmInvalidOrderNumException {

        loadFmOrders();

        Map<Integer, FmOrder> innerMap = outerMap.get(date);
        FmOrder removedOrder = innerMap.remove(orderNum);
        if (removedOrder == null) {
            throw new FmInvalidOrderDateException("\nThis order Date does not exits.");

        }
//        FmOrder deletedOrder = removedOrder.
        if (removedOrder == null) {
            throw new FmInvalidOrderNumException("This order Does not exist");
        }

        outerMap.put(date, innerMap);
        writeOrderInventory();

        return removedOrder;

//        
    }

    @Override
    public FmOrder getOrderByDateandId(LocalDate orderDate, int orderNumber) throws FmPersistenceException {
        loadFmOrders();
        Map<Integer, FmOrder> innerMap = outerMap.get(orderDate);
        if (innerMap == null) {
            return null;
        } else {
            FmOrder theOrder = innerMap.get(orderNumber);
            return theOrder;
        }
    }

    @Override
    public List<FmOrder> getAllOrdersForDate(LocalDate orderDate) throws FmPersistenceException {
        loadFmOrders();
        try {
            return new ArrayList<>(outerMap.get(orderDate).values());
        } catch (NullPointerException e) {
            throw new FmPersistenceException("Nothing to retrieve");
        }
    }

    @Override
    public List<LocalDate> orderDate() throws FmPersistenceException {
        loadFmOrders();
        return new ArrayList<>(outerMap.keySet());
    }

    private FmOrder unmarshallFmOrder(String FmOrdersAsText, LocalDate date) {

        String[] FmOrderTokens = FmOrdersAsText.split(DELIMITER);

        int orderNumber = Integer.parseInt(FmOrderTokens[0]);

        String customerName = FmOrderTokens[1].replace(REPLACEMENT, DELIMITER);//REPLACING "::" WITH ",".

        FmTax orderStateName = new FmTax(FmOrderTokens[2], new BigDecimal(FmOrderTokens[3]));
        FmProduct orderProduct = new FmProduct(FmOrderTokens[4], new BigDecimal(FmOrderTokens[6]), new BigDecimal(FmOrderTokens[7]));
        BigDecimal orderArea = new BigDecimal(FmOrderTokens[5]);
        BigDecimal orderMaterialCost = new BigDecimal(FmOrderTokens[8]);
        BigDecimal laborCost = new BigDecimal(FmOrderTokens[9]);
        BigDecimal totalTax = new BigDecimal(FmOrderTokens[10]);
        BigDecimal orderTotal = new BigDecimal(FmOrderTokens[11]);

        return new FmOrder(date, orderNumber, customerName, orderStateName, orderProduct, orderArea, orderMaterialCost, laborCost, totalTax, orderTotal);
    }

    private String marshallFmOrder(FmOrder newOrder) {//AS TEXT

        String orderAsText = newOrder.getOrderNumber() + DELIMITER
                + newOrder.getCustomerName().replace(DELIMITER, REPLACEMENT) + DELIMITER
                + newOrder.getOrderStateName().getStateAbbreviation() + DELIMITER
                + newOrder.getOrderStateName().getTaxRate() + DELIMITER
                + newOrder.getOrderProduct().getProductType() + DELIMITER
                + newOrder.getOrderArea() + DELIMITER
                + newOrder.getOrderProduct().getCostPerSquareFt() + DELIMITER
                + newOrder.getOrderProduct().getlaborCostPerSquareFt() + DELIMITER
                + newOrder.getOrderMaterialCost() + DELIMITER
                + newOrder.getLaborCost() + DELIMITER
                + newOrder.getTotalTax() + DELIMITER
                + newOrder.getOrderTotal();
        return orderAsText;
    }

    private void writeOrderInventory() throws FmPersistenceException {
        PrintWriter out;
        String OrderAsText;

        for (Map.Entry<LocalDate, Map<Integer, FmOrder>> orderEntry : outerMap.entrySet()) {

            LocalDate localDate = orderEntry.getKey();
            String date = localDate.format(DateTimeFormatter.ofPattern("MMddyyyy"));

            if (orderEntry.getValue().isEmpty()) {
                File file = new File(ORDERS_FILE + "/Orders_" + date + ".txt");
                file.delete();//DELETE ONCE ORDER IS EMPTY
            } else {
                try {
                    out = new PrintWriter(new FileWriter(ORDERS_FILE + "/Orders_" + date + ".txt"));
                } catch (IOException ex) {
                    throw new FmPersistenceException("Cannot save the data");
                }

                out.println("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total");
                for (Map.Entry<Integer, FmOrder> currentOrder : orderEntry.getValue().entrySet()) {
                    OrderAsText = marshallFmOrder(currentOrder.getValue());
                    out.println(OrderAsText);
                    out.flush();
                }
                out.close();
            }

        }

    }

    private void loadFmOrders() throws FmPersistenceException {
        Scanner sc;
        File folder = new File(ORDERS_FILE);
        File[] files = folder.listFiles();

        for (File currentFile : files) {
            String date = currentFile.getName().substring(7, 15);
            LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MMddyyyy"));
            try {
                sc = new Scanner(
                        new BufferedReader(
                                new FileReader(currentFile)));
            } catch (FileNotFoundException e) {
                throw new FmPersistenceException(
                        "-_- could not load product data in memory", e);
            }

            String currentLine;
            sc.nextLine();

            FmOrder currentOrder;
            Map<Integer, FmOrder> innerMap = new HashMap<>();

            while (sc.hasNextLine()) {
                currentLine = sc.nextLine();
                currentOrder = unmarshallFmOrder(currentLine, localDate);
                // currentOrder.setDate(localDate);
                innerMap.put(currentOrder.getOrderNumber(), currentOrder);
            }
            sc.close();
            outerMap.put(localDate, innerMap);//adding the inner map  the outer map for the local date.
        }

    }

    @Override
    public int getOrderNumber() throws FmPersistenceException {
        loadFmOrders();

        //dump all to global map
        TreeMap<Integer, FmOrder> allOrders = new TreeMap<>();

        outerMap.forEach((date, innerMap) -> {
            allOrders.putAll(innerMap);
        });

        //sort keys lowest to highest
        return allOrders.lastKey();//will return the highest ordernumber in the map
    }

    @Override
    public Map<LocalDate, Map<Integer, FmOrder>> exportAllData() throws FmPersistenceException {
        loadFmOrders();
        return outerMap;
    }

    @Override
    public List<FmOrder> getAllOrders() throws FmPersistenceException {
        Set<LocalDate> dates = outerMap.keySet();

        loadFmOrders();
        ArrayList<FmOrder> everySingleOrder = new ArrayList<>();
        for (LocalDate date : dates) {
            everySingleOrder.addAll(outerMap.get(date).values());
        }
        return everySingleOrder;

    }
    //make a blank arrayList //giant container
    //get a set of all dates from the map //
    //for each date, get a list of orders //when you have a date,  new ArrayList<>(outerMap.get(orderDate).values());
    //now add these orders to the array List - giant container
    //repeat for every date
    //return the arraylist with everythingggg in it.
}
