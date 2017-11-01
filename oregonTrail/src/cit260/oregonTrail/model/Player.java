/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.ArrayList;

/**
 *
 * @author Stoddard
 */
public class Player implements Serializable {
    
    //class instance variables
    private String name;
    private ArrayList<Game> games = new ArrayList<>();
    private ArrayList<InventoryItem> inventoryItem = new ArrayList<>();
    
    //constructor
    public Player() {
    }
        
    //setter functions
    public void setName(String name) {
        this.name = name;
    }

    //getter functions
    public String getName() {
        return name;
    }

    //class getter and setter
    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public ArrayList<InventoryItem> getInventoryItem() {
        return inventoryItem;
    }

    public void setInventoryItem(ArrayList<InventoryItem> inventoryItem) {
        this.inventoryItem = inventoryItem;
    }
        
    //hashcode functions
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.name);
        return hash;
    }

    //equals function
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
        final Player other = (Player) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    //toString function
    @Override
    public String toString() {
        return "Player{" + "name=" + name + "}";
    }  
    
}
