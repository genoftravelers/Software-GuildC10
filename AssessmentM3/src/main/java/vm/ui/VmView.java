/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import vm.service.ItemDoesNotExistException;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class VmView {
    
    private UserIO io;
    //  private UserIO io = new UserIOConsoleImpl();

    public VmView(UserIO io) {
        this.io = io;
    }
    //What the user will see.
    public int printMenuSelection() {
        io.print("Welcome to Karma's Healthy Vending Machine.");
        io.print("\nBelow are the yummy snacks we offer to indulge.");
        
        io.print("\nYogurt with Granola -> $4.99");
        io.print("Avocado crisps -> $5.49");
        io.print("Beef Jerky -> $2.99");
        io.print("Edamame -> $3.99");
        io.print("Aloe Juice -> $3.99");
        io.print("Nutritional Bar -> $4.49");
        io.print("Fruit Salad -> $6.99");
        io.print("Seltzer water -> $1.99");
        io.print("Natural stream water -> $.99");
        io.print("Veggie Straws -> $3.99");
        
        io.print("\n1. Insert $$ / Purchase Snack.");
        io.print("\n2. No thanks, I'm just browsing.");
        
        return io.readInt("\nPlease select from the above choices 1 and 2, Thank You.", 1, 2);
    }
    
    public BigDecimal insertAmount() {
        BigDecimal cash = new BigDecimal(io.readString("Enter the amount: ".trim()));
        cash.setScale(2, RoundingMode.HALF_UP);
        return cash;
    }
    
    public String getItemName() {
        return io.readString("What is the name of the item you want to purchase? ").trim();
    }
    
    public void displayPurchaseSuccessful() {
        io.readString("Purchase was successful. Please hit enter to continue.");
    }
    
    public void displayExitMessage() {
        io.readString("You may keep browsing, have a good day.");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    
    public void purchase(String itemName, Map newMap) throws ItemDoesNotExistException {
        
        if (itemName != null) {
            io.print(itemName + " successfully purchased");
            io.print("Your change is " + newMap);
        } else {
            throw new ItemDoesNotExistException("Item Does not exist, please try from Menu above.");
        }
        
    }
}
