/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.model;

import java.io.Serializable;

/**
 *
 * @author dglinzey
 */
public class StoreScene implements Serializable {
    
    //class instance variables
    private float costMultiplier;
    
    //constructor
    public StoreScene() {
    }
    
    //getter and setter
    public float getCostMultiplier() {
        return costMultiplier;
    }

    public void setCostMultiplier(float costMultiplier) {
        this.costMultiplier = costMultiplier;
    }
    
    //hashcode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Float.floatToIntBits(this.costMultiplier);
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
        return true;
    }
    
    //toString
    @Override
    public String toString() {
        return "StoreScene{" + "costMultiplier=" + costMultiplier + '}';
    }
    
    
    
}
