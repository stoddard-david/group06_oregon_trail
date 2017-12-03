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
public class Map implements Serializable {


    
    private int height;
    private int width;
    private Location[][] locations;
    private Location[] path;
    private int miles;

    //constructor
    public Map() {
    }
 
    //setter and getter functions
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
    public Location[][] getLocation() {
        return locations;
    }

    public void setLocation(Location[][] locations) {
        this.locations = locations;
    }
    
    public Location[] getPath() {
        return path;
    }

    public void setPath(Location[] path) {
        this.path = path;
    }
    
    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    //hashcode functions
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.height;
        hash = 37 * hash + this.width;
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
        final Map other = (Map) obj;
        if (this.height != other.height) {
            return false;
        }
        if (this.width != other.width) {
            return false;
        }
        return true;
    }

    //toString function
    @Override
    public String toString() {
        return "Map{" + "height=" + height + ", width=" + width + '}';
    }
    
}
