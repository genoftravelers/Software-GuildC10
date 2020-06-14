/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassModeling;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class IceCreamSSystem {

    private String section;
    private String aisle;
    private String brand;
    private double price;
    private double size;
    private double totalQuantity;

    public IceCreamSSystem(String s, String a, String b) {
        this.aisle = a;
        this.brand = b;
        this.section = s;
    }

    public IceCreamSSystem(double p, double size, double tQuan) {
        this.price = p;
        this.size = size;
        this.totalQuantity = tQuan;
    }

    public IceCreamSSystem(String s, String a, String b, double p, double size, double tQuan) {
        this.aisle = a;
        this.brand = b;
        this.section = s;
        this.price = p;
        this.size = size;
        this.totalQuantity = tQuan;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public void addToTotalQuantity(double newTotalQuantity) {
        this.totalQuantity = this.totalQuantity + newTotalQuantity;
    }
}
