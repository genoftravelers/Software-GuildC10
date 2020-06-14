/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class VmItem {
//Fields

    private String itemName;
    private BigDecimal itemCost;
    private int numOfItems;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.itemName);
        hash = 47 * hash + Objects.hashCode(this.itemCost);
        hash = 47 * hash + this.numOfItems;
        return hash;
    }

//    public VmItem(String itemName) {
//        this.itemName = itemName;
//    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final VmItem other = (VmItem) obj;
        if (this.numOfItems != other.numOfItems) {
            return false;
        }
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        if (!Objects.equals(this.itemCost, other.itemCost)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "VmItem{" + "itemName=" + itemName + ", itemCost=" + itemCost + ", numOfItems=" + numOfItems + '}';
    }
//CONSTRUCTOR

    public VmItem(String itemName, BigDecimal itemCost, int numOfItems) {
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.numOfItems = numOfItems;
    }

//    public VmItem(String itemName, BigDecimal itemCost) {
//        this.itemName= itemName;
//        this.itemCost = itemCost;
//    }
    //GETTERS AND SETTERS.
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemCost() {
        return itemCost;
    }

    public void setItemCost(BigDecimal itemCost) {
        this.itemCost = itemCost;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }
}
