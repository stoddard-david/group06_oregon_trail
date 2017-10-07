/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author dglinzey
 */
public class StoreScene implements Serializable {
    
    //class instance variables
    private String description;
    private float costMultiplier;
    
    //constructor
    public StoreScene() {
    }
    
    //getter and setter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getCostMultiplier() {
        return costMultiplier;
    }

    public void setCostMultiplier(float costMultiplier) {
        this.costMultiplier = costMultiplier;
    }

    //hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.description);
        hash = 13 * hash + Float.floatToIntBits(this.costMultiplier);
        return hash;
    }

    //equals
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
        final StoreScene other = (StoreScene) obj;
        if (Float.floatToIntBits(this.costMultiplier) != Float.floatToIntBits(other.costMultiplier)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    //toString
    @Override
    public String toString() {
        return "StoreScene{" + "description=" + description + ", costMultiplier=" + costMultiplier + '}';
    }
    
    
    
    
}
