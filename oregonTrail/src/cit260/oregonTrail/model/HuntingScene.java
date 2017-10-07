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
 * @author Stoddard
 */
public class HuntingScene implements Serializable {
    
    //class instance variables
    private double timer;
    private String currentAnimal;
    private int totalMeat;
    private double distanceToAnimal;
    private RegularSceneType regularScene;
    
    //constructor
    public HuntingScene() {
    }

    //setter and getter functions
    public double getTimer() {
        return timer;
    }

    public void setTimer(double timer) {
        this.timer = timer;
    }

    public String getCurrentAnimal() {
        return currentAnimal;
    }

    public void setCurrentAnimal(String currentAnimal) {
        this.currentAnimal = currentAnimal;
    }

    public int getTotalMeat() {
        return totalMeat;
    }

    public void setTotalMeat(int totalMeat) {
        this.totalMeat = totalMeat;
    }

    public double getDistanceToAnimal() {
        return distanceToAnimal;
    }

    public void setDistanceToAnimal(double distanceToAnimal) {
        this.distanceToAnimal = distanceToAnimal;
    }

    //class getter and setter
    public RegularSceneType getPlayer() {
        return regularScene;
    }

    public void setRegularScene(RegularSceneType regularScene) {
        this.regularScene = regularScene;
    }
    
    //hashcode functions
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.timer) ^ (Double.doubleToLongBits(this.timer) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.currentAnimal);
        hash = 29 * hash + this.totalMeat;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.distanceToAnimal) ^ (Double.doubleToLongBits(this.distanceToAnimal) >>> 32));
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
        final HuntingScene other = (HuntingScene) obj;
        if (Double.doubleToLongBits(this.timer) != Double.doubleToLongBits(other.timer)) {
            return false;
        }
        if (this.totalMeat != other.totalMeat) {
            return false;
        }
        if (Double.doubleToLongBits(this.distanceToAnimal) != Double.doubleToLongBits(other.distanceToAnimal)) {
            return false;
        }
        if (!Objects.equals(this.currentAnimal, other.currentAnimal)) {
            return false;
        }
        return true;
    }
    
    //toString function
    @Override
    public String toString() {
        return "HuntingScene{" + "timer=" + timer + ", currentAnimal=" + currentAnimal + ", totalMeat=" + totalMeat + ", distanceToAnimal=" + distanceToAnimal + '}';
    }
    
}
