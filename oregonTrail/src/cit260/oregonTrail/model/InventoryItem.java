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
 * @author erinsmith
 */
public class InventoryItem implements Serializable{
 
    
    // class instance variables
    private String inventoryType;
    private int maxAmount;
    private float baseCost;
    private int quantityOwned;
    private Player player;
    
    // constructor
    public InventoryItem() {
    }
    
    
    // getters and setters
    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public float getBaseCost() {
        return baseCost;
    }

    public void setBaseCost(float baseCost) {
        this.baseCost = baseCost;
    }

    public int getQuantityOwned() {
        return quantityOwned;
    }

    public void setQuantityOwned(int quantityOwned) {
        this.quantityOwned = quantityOwned;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    

    // equals() and hashCode()
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.inventoryType);
        hash = 31 * hash + this.maxAmount;
        hash = 31 * hash + Float.floatToIntBits(this.baseCost);
        hash = 31 * hash + this.quantityOwned;
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
        final InventoryItem other = (InventoryItem) obj;
        if (this.maxAmount != other.maxAmount) {
            return false;
        }
        if (Float.floatToIntBits(this.baseCost) != Float.floatToIntBits(other.baseCost)) {
            return false;
        }
        if (this.quantityOwned != other.quantityOwned) {
            return false;
        }
        if (!Objects.equals(this.inventoryType, other.inventoryType)) {
            return false;
        }
        return true;
    }
    
    // toString()

    @Override
    public String toString() {
        return "InventoryItem{" + "inventoryType=" + inventoryType + ", maxAmount=" + maxAmount + ", baseCost=" + baseCost + ", quantityOwned=" + quantityOwned + '}';
    }
    
    
}
