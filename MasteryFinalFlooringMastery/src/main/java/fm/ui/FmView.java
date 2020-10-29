/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.ui;

import fm.dao.FmInvalidProductException;
import fm.dao.FmInvalidTaxException;
import fm.dto.FmOrder;
import fm.dto.FmProduct;
import fm.dto.FmTax;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class FmView {

    private UserIO io;
    //  private UserIO io = new UserIOConsoleImpl();

    public FmView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndSelection() {
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print(" \n* 1 => Display Orders");
        io.print(" \n* 2 => Add an Order");
        io.print(" \n* 3 => Edit an Order");
        io.print(" \n* 4 => Remove an Order");
        io.print(" \n* 5 => Export All Data");
        io.print(" \n* 6 => Quit");
        io.print("\n* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");

        boolean isIncorrect;
        int choice = 0;

        do {
            try {
                choice = io.readInt("\nPlease select from the above choices, Thank You.", 0, 6);
                isIncorrect = false;
            } catch (NumberFormatException e) {
                isIncorrect = true;
                displayErrorMessage(e.getMessage());
            }
        } while (isIncorrect);

        return choice;
    }

    public void displayDisplayFmBanner() {
        io.print("VIEW ORDERS");

    }

    public void displayAddAnOrderBanner() {
        io.print("ADD AN ORDER");

    }

//    public String confirmChanges() {
//        
//    }
    public void displayOrderSuccessfulBanner() {
        io.print("Order Success ^^!");
        io.readString("Press Enter to continue");
    }

    public void displayOrderUnSuccessfulBanner() {
        io.print("Your order has not been added.");
        io.readString("Press Enter to continue");

    }

    public void displayEditAnOrderBanner() {
        io.print("EDIT ORDER");

    }

    public void displayEditSuccessfulBanner() {
        io.print("Edit was Successful!");
        io.readString("Press Enter to continue");

    }

    public void displayEditUnSuccessfulBanner() {
        io.print("Edit was not Successful!");
        io.readString("Press Enter to continue");

    }

    public void displayRemoveAnOrderBanner() {
        io.print("REMOVE AN ORDER");

    }

    public void displayRemoveSuccessfulBanner() {
        io.print("Removed Successfuly!");
        io.readString("Press Enter to continue");

    }

    public void displayOrderNotFound() {
        io.print("No orders found.");
    }

    public void displayRemoveUnSuccessfulBanner() {
        io.print("Not Removed!");
        io.readString("Press Enter to continue");

    }

    public void displayExportDataBanner() {
        io.print("EXPORT ORDERS!");

    }

    public void displayExportDataSuccessful() {
        io.print("Exported Successfully");
        io.readString("Press Enter to continue");

    }

    public void displayExportDataUnSuccessful() {
        io.print("Export Unsuccessful!");

    }

    public void displayExitBanner() {
        io.print("Have a good day!");

    }

    public void quit() {
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown command");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print(errorMsg);
    }

    public LocalDate getOrderDate() {
        LocalDate userDate = io.readLocalDate("Please Enter the Date.");
        return userDate;
    }

    public int getOrderNumber() {
        int orderNum = io.readInt("Please Enter the Order Number");
        return orderNum;

    }

    public FmOrder getNewOrderInfo(List<FmProduct> listOfProduct, List<FmTax> listOfState) throws FmInvalidTaxException, FmInvalidProductException {

        LocalDate orderDate = io.readLocalDate("Please Enter an Order Date in the future", LocalDate.now());

        String customerName = io.readStringLoop("Please Enter Customer Name");

        //state
        for (FmTax currentState : listOfState) {
            io.print("StateAbbreviation " + currentState.getStateAbbreviation());
            io.print("Tax Rate " + currentState.getTaxRate());
            io.print("State Name " + currentState.getStateName());

        }
        String state = io.readStringLoop("Enter state abbreviation");

        //product
        for (FmProduct currentProduct : listOfProduct) {
            io.print("ProductType " + currentProduct.getProductType());
            io.print("CostPerSquareFoot $" + currentProduct.getCostPerSquareFt());
            io.print("LaborCostPerSquareFoot $" + currentProduct.getCostPerSquareFt());
        }
        String productType = io.readStringLoop("Enter the product type");

        BigDecimal area = io.readBigDecimal("Enter the area.");

        FmOrder newOrder = new FmOrder(orderDate, customerName, area);

        FmTax userTax = new FmTax();
        userTax.setStateAbbreviation(state);

        newOrder.setOrderStateName(userTax);

        FmProduct userProduct = new FmProduct();
        userProduct.setProductType(productType);

        newOrder.setOrderProduct(userProduct);

        return newOrder;
    }

    public void displayFmList(List<FmOrder> listOfOrders) {
        for (FmOrder currentOrder : listOfOrders) {
            //%s prints out the string written by user.
            io.print("OrderNumber " + currentOrder.getOrderNumber());
            io.print("CustomerName " + currentOrder.getCustomerName());
            io.print("State " + currentOrder.getOrderStateName().getStateAbbreviation());
            io.print("TaxRate " + currentOrder.getOrderStateName().getTaxRate());
            io.print("ProductType " + currentOrder.getOrderProduct().getProductType());
            io.print("Area " + currentOrder.getOrderArea());
            io.print("CostPerSquareFoot " + currentOrder.getOrderProduct().getCostPerSquareFt());
            io.print("MaterialCost " + currentOrder.getOrderMaterialCost());
            io.print("LaborCost " + currentOrder.getLaborCost());
            io.print("Tax " + currentOrder.getTotalTax());
            io.print("Total " + currentOrder.getOrderTotal());

        }
    }

    public boolean confirmNewOrder(FmOrder confirmedOrder) {
        //display the order
        io.print("Here is your Order details.");
        io.print("Date: " + confirmedOrder.getOrderDate().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
        io.print("ID: " + confirmedOrder.getOrderNumber());
        io.print("Customer Name: " + confirmedOrder.getCustomerName());
        io.print("State: " + confirmedOrder.getOrderStateName().getStateAbbreviation());
        io.print("Product: " + confirmedOrder.getOrderProduct().getProductType());
        io.print("Area in sq.ft.: " + confirmedOrder.getOrderArea());
        io.print("Material Cost: $" + confirmedOrder.getOrderMaterialCost());
        io.print("Labor Cost: $" + confirmedOrder.getLaborCost());
        io.print("Tax: $" + confirmedOrder.getTotalTax());
        io.print("Total Cost: $" + confirmedOrder.getOrderTotal());
        //get user string for confirmation
        String userConfirmation = io.readString("Please press Y to save and N to discard.");
        if (userConfirmation.equalsIgnoreCase("Y")) {
            return true;
        } else {
            return false;
        }

        //  return boolean;
    }

    public FmOrder getEditedOrderInfo(FmOrder orderToEdit) {

        String newCustomerName = io.readString("Enter customer name (" + orderToEdit.getCustomerName() + "):");
        String newState = io.readString("Enter State (" + orderToEdit.getOrderStateName().getStateAbbreviation() + "):");
        String newProduct = io.readString("Enter ProductType (" + orderToEdit.getOrderProduct().getProductType() + "):");
        BigDecimal newArea = io.readBigDecimal("Enter Area (" + orderToEdit.getOrderArea() + "):");

        if (!newCustomerName.isBlank()) {
            orderToEdit.setCustomerName(newCustomerName);
            //new customer name should be original name in the order.
        }
        if (!newState.isBlank()) {
            orderToEdit.getOrderStateName().setStateAbbreviation(newState);
        }
        if (!newProduct.isBlank()) {
            orderToEdit.getOrderProduct().setProductType(newProduct);
        }
        if (!newArea.equals(null)) {
            orderToEdit.setOrderArea(newArea);
        }
        return orderToEdit;

    }
}
