/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.KarmaSuperHero.dto;

import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class Location {

    private int locationId;

    @NotBlank(message = "Name must not be blank")
    @Size(max = 45, message = "Name must be fewer than 45 characters")
    private String locationName;

    @NotBlank(message = "Description must not be blank")
    @Size(max = 250, message = "Description must be fewer than 250 characters")
    private String locationDescription;

    @NotBlank(message = "Address must not be blank")
    @Size(max = 45, message = "Address must be fewer than 45 characters")
    private String locationAddress;

    @NotBlank(message = "City must not be blank")
    @Size(max = 45, message = "City must be fewer than 45 characters")
    private String locationCity;

    @Size(max = 2, message = "State must be 2 characters")
    private String locationState;

    @Size(min = 5, max = 5, message = "Zip Code must be 5 characters")
    private String zipCode;

    @DecimalMax(value = "90.0", inclusive = true, message = "Latitude must be between -90 and 90")
    @DecimalMin(value = "-90.0", inclusive = true, message = "Latitude must be between -90 and 90")
    @Digits(integer = 3, fraction = 6, message = "Latitude must only have 6 numbers max after the decimal")
    @NotNull(message = "Please Input a valid Latitude")
    private BigDecimal latitude;

    @DecimalMax(value = "180.0", inclusive = true, message = "Longitude must be between -180 and 180")
    @DecimalMin(value = "-180.0", inclusive = true, message = "Longitude must be between -180 and 180")
    @Digits(integer = 3, fraction = 6, message = "Longitude must only have 6 numbers max after the decimal")
    @NotNull(message = "Please Input a valid Longitude")
    private BigDecimal longitude;

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationState() {
        return locationState;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.locationId;
        hash = 59 * hash + Objects.hashCode(this.locationName);
        hash = 59 * hash + Objects.hashCode(this.locationDescription);
        hash = 59 * hash + Objects.hashCode(this.locationAddress);
        hash = 59 * hash + Objects.hashCode(this.locationCity);
        hash = 59 * hash + Objects.hashCode(this.locationState);
        hash = 59 * hash + Objects.hashCode(this.zipCode);
        hash = 59 * hash + Objects.hashCode(this.latitude);
        hash = 59 * hash + Objects.hashCode(this.longitude);
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
        final Location other = (Location) obj;
        if (this.locationId != other.locationId) {
            return false;
        }
        if (!Objects.equals(this.locationName, other.locationName)) {
            return false;
        }
        if (!Objects.equals(this.locationDescription, other.locationDescription)) {
            return false;
        }
        if (!Objects.equals(this.locationAddress, other.locationAddress)) {
            return false;
        }
        if (!Objects.equals(this.locationCity, other.locationCity)) {
            return false;
        }
        if (!Objects.equals(this.locationState, other.locationState)) {
            return false;
        }
        if (!Objects.equals(this.zipCode, other.zipCode)) {
            return false;
        }
        if (!Objects.equals(this.latitude, other.latitude)) {
            return false;
        }
        if (!Objects.equals(this.longitude, other.longitude)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Location{" + "locationId=" + locationId + ", locationName=" + locationName + ", locationDescription=" + locationDescription + ", locationAddress=" + locationAddress + ", locationCity=" + locationCity + ", locationState=" + locationState + ", zipCode=" + zipCode + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }

}
