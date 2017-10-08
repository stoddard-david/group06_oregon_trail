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
public class AdviceScene implements Serializable{
    
    //class instance variables
    private String description;
    
    //Constructor
    public AdviceScene() {
    }

    //getter and setter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //hashcode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.description);
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
        final AdviceScene other = (AdviceScene) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    //toString
    @Override
    public String toString() {
        return "AdviceScene{" + "description=" + description + '}';
    }
    
    
    
}
