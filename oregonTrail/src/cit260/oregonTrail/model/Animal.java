/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.model;

/**
 *
 * @author Stoddard
 */
public enum Animal {
    
    Buffalo("Buffalo",1.0,150,90),
    Bear("Bear",1.2,90,65),
    Deer("Deer",2.0,75,35),
    Elk("Elk",2.0,75,35),
    Rabbit("Rabbit",4.0,10,7),
    Squirrel("Suqirrel",6.0,5,2);
    
    private final String type;
    private final double speed;
    private final int maxMeat;
    private final int minMeat;
    
    //constructor
    Animal(String type, double speed, int maxMeat, int minMeat) {
        this.type = type;
        this.speed = speed;
        this.maxMeat = maxMeat;
        this.minMeat = minMeat;
    }
    
    //getter functions
    public String getType() {
        return type;
    }

    public double getSpeed() {
        return speed;
    }

    public int getMaxMeat() {
        return maxMeat;
    }

    public int getMinMeat() {
        return minMeat;
    }
    
    //toString
    @Override
    public String toString() {
        return "Animal{" + "type=" + type + ", speed=" + speed + ", maxMeat=" + maxMeat + ", minMeat=" + minMeat + '}';
    }
    
}