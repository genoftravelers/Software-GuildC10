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
public class House3DSystem {

    private String houseType;
    private int numOfFloors;
    private int numOfCapacity;
    private int numOfBath;
    private int numOfEntrances;
   

    public House3DSystem(String houseT) {
        this.houseType = houseT;
    }
    public House3DSystem(String houseT, int numOfFl, int numOfCap, int numOfBa, int numOfEn){
        this.houseType = houseT;
        this.numOfFloors = numOfFl;
        this.numOfBath = numOfBa;
        this.numOfEntrances = numOfEn;
        this.numOfCapacity = numOfCap;
    }
    

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public void setNumOfFloors(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }

    public int getNumOfCapacity() {
        return numOfCapacity;
    }

    public void setNumOfCapacity(int numOfCapacity) {
        this.numOfCapacity = numOfCapacity;
    }

    public int getNumOfBath() {
        return numOfBath;
    }

    public void setNumOfBath(int numOfBath) {
        this.numOfBath = numOfBath;
    }

    public int getNumOfEntrances() {
        return numOfEntrances;
    }

    public void setNumOfEntrances(int numOfEntrances) {
        this.numOfEntrances = numOfEntrances;
    }

    public void addTonumOfFloors(int newNumOfFloors) {
        this.numOfFloors = this.numOfFloors + newNumOfFloors;
    }
    
}
