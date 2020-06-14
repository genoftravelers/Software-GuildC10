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
public class HouseMappingSystem {

    private String typeOfCommunity;
    private String description;
    private String typeOfTransportation;
    private double latitude;
    private double longitude;
    private int houseNumber;
    private String streetName;
    private String cityName;
    private String stateName;
    private int zipCode;

    public HouseMappingSystem() {

    }

    public HouseMappingSystem(double lati, double longi) {
        this.latitude = lati;
        this.longitude = longi;
    }

    public HouseMappingSystem(double lati, double longi, String typeOfCom, String descrip, String transport, int houseNum, String stName, String cName, String staName, int zip) {
        this.latitude = lati;
        this.longitude = longi;
        this.typeOfCommunity = typeOfCom;
        this.description = descrip;
        this.typeOfTransportation = transport;
        this.houseNumber = houseNum;
        this.streetName = stName;
        this.cityName = cName;
        this.stateName = staName;
        this.zipCode = zip;

    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getZip() {
        return zipCode;
    }

    public void setZip(int zip) {
        this.zipCode = zip;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTypeOfCommunity() {
        return typeOfCommunity;
    }

    public void setTypeOfCommunity(String typeOfCommunity) {
        this.typeOfCommunity = typeOfCommunity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeOfTransportation() {
        return typeOfTransportation;
    }

    public void setTypeOfTransportation(String typeOfTransportation) {
        this.typeOfTransportation = typeOfTransportation;
    }

    public void addToDescription(String newDescription) {
        this.description = this.description + newDescription;
    }
}
