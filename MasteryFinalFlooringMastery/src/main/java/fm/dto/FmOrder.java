/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class FmOrder {

    private LocalDate orderDate;
    private FmProduct orderProduct;
    private FmTax orderStateName;
    private int orderNumber;
    private String customerName;
    private BigDecimal orderArea;
    private BigDecimal orderMaterialCost;
    private BigDecimal laborCost;
    private BigDecimal productCost;
    private BigDecimal totalTax;
    private BigDecimal orderTotal;

    public FmOrder() {

    }

    public FmOrder(LocalDate orderDate, String customerName, BigDecimal orderArea) {
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.orderArea = orderArea;
    }

    public FmOrder(LocalDate orderDate, FmProduct orderProduct, FmTax orderStateName, String customerName, BigDecimal orderArea) {
        this.orderDate = orderDate;
        this.orderProduct = orderProduct;
        this.orderStateName = orderStateName;
        this.customerName = customerName;
        this.orderArea = orderArea;
    }

    public FmOrder(LocalDate orderDate, int orderNumber, String customerName, 
            FmTax orderStateName, FmProduct orderProduct, BigDecimal area, 
            BigDecimal materialCost, BigDecimal laborCost, BigDecimal totalTax, BigDecimal total) {
        this.orderDate = orderDate;
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.orderStateName = orderStateName;
        this.orderProduct = orderProduct;
        this.orderArea = area;
        this.orderMaterialCost = materialCost;
        this.laborCost = laborCost;
        this.totalTax = totalTax;
        this.orderTotal = total;
    }

    public FmOrder(int orderNumber, String customerName, FmTax orderStateName, FmProduct orderProduct, BigDecimal orderArea, BigDecimal orderMaterialCost, BigDecimal laborCost, BigDecimal totalTax, BigDecimal orderTotal) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.orderStateName = orderStateName;
        this.orderProduct = orderProduct;
        this.orderArea = orderArea;
        this.orderMaterialCost = orderMaterialCost;
        this.laborCost = laborCost;
        this.totalTax = totalTax;
        this.orderTotal = laborCost;

    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public FmProduct getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(FmProduct orderProduct) {
        this.orderProduct = orderProduct;
    }

    public FmTax getOrderStateName() {
        return orderStateName;
    }

    public void setOrderStateName(FmTax orderStateName) {
        this.orderStateName = orderStateName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getOrderArea() {
        return orderArea;
    }

    public void setOrderArea(BigDecimal orderArea) {
        this.orderArea = orderArea;
    }

    public BigDecimal getOrderMaterialCost() {
        return orderMaterialCost;
    }

    public void setOrderMaterialCost(BigDecimal orderMaterialCost) {
        this.orderMaterialCost = orderMaterialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getProductCost() {
        return productCost;
    }

    public void setProductCost(BigDecimal productCost) {
        this.productCost = productCost;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.orderDate);
        hash = 29 * hash + Objects.hashCode(this.orderProduct);
        hash = 29 * hash + Objects.hashCode(this.orderStateName);
        hash = 29 * hash + this.orderNumber;
        hash = 29 * hash + Objects.hashCode(this.customerName);
        hash = 29 * hash + Objects.hashCode(this.orderArea);
        hash = 29 * hash + Objects.hashCode(this.orderMaterialCost);
        hash = 29 * hash + Objects.hashCode(this.laborCost);
        hash = 29 * hash + Objects.hashCode(this.productCost);
        hash = 29 * hash + Objects.hashCode(this.totalTax);
        hash = 29 * hash + Objects.hashCode(this.orderTotal);
        return hash;
    }

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
        final FmOrder other = (FmOrder) obj;
        if (this.orderNumber != other.orderNumber) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        if (!Objects.equals(this.orderProduct, other.orderProduct)) {
            return false;
        }
        if (!Objects.equals(this.orderStateName, other.orderStateName)) {
            return false;
        }
        if (!Objects.equals(this.orderArea, other.orderArea)) {
            return false;
        }
        if (!Objects.equals(this.orderMaterialCost, other.orderMaterialCost)) {
            return false;
        }
        if (!Objects.equals(this.laborCost, other.laborCost)) {
            return false;
        }
        if (!Objects.equals(this.productCost, other.productCost)) {
            return false;
        }
        if (!Objects.equals(this.totalTax, other.totalTax)) {
            return false;
        }
        if (!Objects.equals(this.orderTotal, other.orderTotal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FmOrder{" + "orderDate=" + orderDate + ", orderProduct=" + orderProduct + ", orderStateName=" + orderStateName + ", orderNumber=" + orderNumber + ", customerName=" + customerName + ", orderArea=" + orderArea + ", orderMaterialCost=" + orderMaterialCost + ", laborCost=" + laborCost + ", productCost=" + productCost + ", totalTax=" + totalTax + ", orderTotal=" + orderTotal + '}';
    }
    /*
    This toString method is added mostly for convenience. Often in error messages, JUnit will print out information about the object that failed a test. 
    Overriding this method can allow us to printout all of the objects property values instead, which can allow for much faster insight into issues when reading test logs!
    */

}
