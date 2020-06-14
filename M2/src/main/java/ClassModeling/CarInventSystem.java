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
public class CarInventSystem {
    private boolean usedCar;
    private String model;
    private double maxPrice;
    private double milesTraveled;
    private String color;
    private boolean transmissionManual;
    
    public CarInventSystem (boolean usedC, boolean transManual) {
        this.usedCar = usedC;
        this.transmissionManual = transManual;
    }
    
    public CarInventSystem (String mod, String col) {
        this.color = col;
        this.model = mod;
    }
    
    public CarInventSystem(double maxP, double mTraveled,boolean usedC, boolean transManual,String mod, String col ) {
        this.usedCar = usedC;
        this.transmissionManual = transManual;
        this.color = col;
        this.model = mod;
        this.maxPrice = maxP;
        this.milesTraveled = mTraveled;
    }

    public boolean isUsedCar() {
        return usedCar;
    }

    public void setUsedCar(boolean usedCar) {
        this.usedCar = usedCar;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getMilesTraveled() {
        return milesTraveled;
    }

    public void setMilesTraveled(double milesTraveled) {
        this.milesTraveled = milesTraveled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isTransmissionManual() {
        return transmissionManual;
    }

    public void setTransmissionManual(boolean transmissionManual) {
        this.transmissionManual = transmissionManual;
    }
    public void addToMaxPrice( double newMaxPrice) {
        this.maxPrice = this.maxPrice + newMaxPrice;
    }
}
