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
public class RiverScene implements Serializable {
    
    //class instance variables
    private int currentDepth;
    private int currentWidth;
    private int minDepth;
    private int maxDepth;
    private int minWidth;
    private int maxWidth;

    //constructor
    public RiverScene() {
    }

    //getter and setter
    public int getCurrentDepth() {
        return currentDepth;
    }

    public void setCurrentDepth(int currentDepth) {
        this.currentDepth = currentDepth;
    }

    public int getCurrentWidth() {
        return currentWidth;
    }

    public void setCurrentWidth(int currentWidth) {
        this.currentWidth = currentWidth;
    }

    public int getMinDepth() {
        return minDepth;
    }

    public void setMinDepth(int minDepth) {
        this.minDepth = minDepth;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public int getMinWidth() {
        return minWidth;
    }

    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    //hashcode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.currentDepth;
        hash = 29 * hash + this.currentWidth;
        hash = 29 * hash + this.minDepth;
        hash = 29 * hash + this.maxDepth;
        hash = 29 * hash + this.minWidth;
        hash = 29 * hash + this.maxWidth;
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
        final RiverScene other = (RiverScene) obj;
        if (this.currentDepth != other.currentDepth) {
            return false;
        }
        if (this.currentWidth != other.currentWidth) {
            return false;
        }
        if (this.minDepth != other.minDepth) {
            return false;
        }
        if (this.maxDepth != other.maxDepth) {
            return false;
        }
        if (this.minWidth != other.minWidth) {
            return false;
        }
        if (this.maxWidth != other.maxWidth) {
            return false;
        }
        return true;
    }

    //toString
    @Override
    public String toString() {
        return "RiverScene{" + "currentDepth=" + currentDepth + ", currentWidth=" + currentWidth + ", minDepth=" + minDepth + ", maxDepth=" + maxDepth + ", minWidth=" + minWidth + ", maxWidth=" + maxWidth + '}';
    }
    
    
    
}
