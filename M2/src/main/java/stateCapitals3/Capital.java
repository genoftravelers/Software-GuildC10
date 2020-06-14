/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateCapitals3;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class Capital {
    protected String name;
    protected int population;
    protected double mileage;
    
    public Capital(String name, int population, double mileage){
        this.mileage= mileage;
        this.name= name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    
    @Override
    public String toString(){
        return name + ", pupulation = "+ population + ",square mile = " + mileage;
    }
}
