/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.model;

/**
 *
 * @author dglinzey
 */
public class Map {
    
    private int height;
    private int width;

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
