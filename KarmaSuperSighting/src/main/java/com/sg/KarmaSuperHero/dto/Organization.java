/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.KarmaSuperHero.dto;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class Organization {
    private int organizationId;
    private Location location;
    private List <Hero> heroes;
    private String orgnizationName;
    private String organizationDescription;
    private String organizationPhoneNum;

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public String getOrgnizationName() {
        return orgnizationName;
    }

    public void setOrgnizationName(String orgnizationName) {
        this.orgnizationName = orgnizationName;
    }

    public String getOrganizationDescription() {
        return organizationDescription;
    }

    public void setOrganizationDescription(String organizationDescription) {
        this.organizationDescription = organizationDescription;
    }

    public String getOrganizationPhoneNum() {
        return organizationPhoneNum;
    }

    public void setOrganizationPhoneNum(String organizationPhoneNum) {
        this.organizationPhoneNum = organizationPhoneNum;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.organizationId;
        hash = 37 * hash + Objects.hashCode(this.location);
        hash = 37 * hash + Objects.hashCode(this.heroes);
        hash = 37 * hash + Objects.hashCode(this.orgnizationName);
        hash = 37 * hash + Objects.hashCode(this.organizationDescription);
        hash = 37 * hash + Objects.hashCode(this.organizationPhoneNum);
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
        final Organization other = (Organization) obj;
        if (this.organizationId != other.organizationId) {
            return false;
        }
        if (!Objects.equals(this.orgnizationName, other.orgnizationName)) {
            return false;
        }
        if (!Objects.equals(this.organizationDescription, other.organizationDescription)) {
            return false;
        }
        if (!Objects.equals(this.organizationPhoneNum, other.organizationPhoneNum)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.heroes, other.heroes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Organization{" + "organizationId=" + organizationId + ", location=" + location + ", heroes=" + heroes + ", orgnizationName=" + orgnizationName + ", organizationDescription=" + organizationDescription + ", organizationPhoneNum=" + organizationPhoneNum + '}';
    }

  
    
}
