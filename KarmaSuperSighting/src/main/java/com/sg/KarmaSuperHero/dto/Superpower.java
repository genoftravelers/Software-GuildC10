/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.KarmaSuperHero.dto;

import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class Superpower {

    private int superpowerId;

    @NotBlank(message = "Superpower name must not be blank")
    @Size(max = 45, message = "Superpower name must be fewer than 45 characters")
    private String superpowerName;

    public int getSuperpowerId() {
        return superpowerId;
    }

    public void setSuperpowerId(int superpowerId) {
        this.superpowerId = superpowerId;
    }

    public String getSuperpowerName() {
        return superpowerName;
    }

    public void setSuperpowerName(String superpowerName) {
        this.superpowerName = superpowerName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.superpowerId;
        hash = 37 * hash + Objects.hashCode(this.superpowerName);
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
        final Superpower other = (Superpower) obj;
        if (this.superpowerId != other.superpowerId) {
            return false;
        }
        if (!Objects.equals(this.superpowerName, other.superpowerName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Superpower{" + "superpowerId=" + superpowerId + ", superpowerName=" + superpowerName + '}';
    }

}
