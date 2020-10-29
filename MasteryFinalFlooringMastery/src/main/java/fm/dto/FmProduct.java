/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class FmProduct {

    private String productType;
    private BigDecimal costPerSquareFt;
    private BigDecimal laborCostPerSquareFt;

    public FmProduct() {

    }

    public FmProduct(String productType, BigDecimal costPerSquareFt, BigDecimal laborCostPerSquareFt) {
        this.productType = productType;
        this.costPerSquareFt = costPerSquareFt;
        this.laborCostPerSquareFt = laborCostPerSquareFt;
    }


    public String getProductType() {
        return productType;
    }

    public void setCostPerSquareFt(BigDecimal costPerSquareFt) {
        this.costPerSquareFt = costPerSquareFt;
    }

    public void setLaborCostPerSquareFt(BigDecimal laborCostPerSquareFt) {
        this.laborCostPerSquareFt = laborCostPerSquareFt;
    }

    public BigDecimal getCostPerSquareFt() {
        return costPerSquareFt;
    }

    public BigDecimal getlaborCostPerSquareFt() {
        return laborCostPerSquareFt;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.productType);
        hash = 37 * hash + Objects.hashCode(this.costPerSquareFt);
        hash = 37 * hash + Objects.hashCode(this.laborCostPerSquareFt);
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
        final FmProduct other = (FmProduct) obj;
        if (!Objects.equals(this.productType, other.productType)) {
            return false;
        }
        if (!Objects.equals(this.costPerSquareFt, other.costPerSquareFt)) {
            return false;
        }
        if (!Objects.equals(this.laborCostPerSquareFt, other.laborCostPerSquareFt)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        // return  +  + productType +  + costPerSquareFt +  + laborCostPerSquareFt +;

        return "FmProduct{" + "productType=" + productType + ", costPerSquareFt=" + costPerSquareFt + ", laborCostPerSquareFt=" + laborCostPerSquareFt + '}';
    }

}
