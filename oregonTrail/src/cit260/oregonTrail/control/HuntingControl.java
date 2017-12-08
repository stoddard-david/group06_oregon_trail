/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.control;

import cit260.oregonTrail.exception.HuntingControlException;
import cit260.oregonTrail.model.Animal;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author dglinzey
 */
public class HuntingControl{
    
    public static boolean calcHuntingControl(double speed, double distanceToAnimal, double timer) throws HuntingControlException {
    
        //time to beat in seconds
        double timeToBeat = 8;
        
        //check if valid
        if (speed <= 0) {
            throw new HuntingControlException("The speed of the animal can not be negative.Value entered is " + speed);
        }
        if (distanceToAnimal < 50) {
            throw new HuntingControlException("The animal can not be closer than 50. Value entered is " + distanceToAnimal);
        }
        if (timer < 0) {
            throw new HuntingControlException("Time can not be less than 0. Value entered is " + timer);
        }
        
        //do math
        timeToBeat = (timeToBeat/speed)/(distanceToAnimal/50);
        
        if (timer <= timeToBeat){
            return true;
        } else {
            return false;
        }
    }
    
    public static int pickAnimal() {
        int numberAnimals = Animal.values().length;
        
        Random rand = new Random();
        return rand.nextInt(numberAnimals);
    }
    
    public static double getDistance() {
        Random rand = new Random();
        double distance;
        distance = (rand.nextDouble()*150) + 50.0;
        return distance;
    }

    public static void waitForAnimal() throws InterruptedException {
        Random rand = new Random();
        int seconds = rand.nextInt(7) + 2;
        
        TimeUnit.SECONDS.sleep(seconds);
    }
    
    public static String chooseFireWord() {
        Random rand = new Random();
        
        int randChoice = rand.nextInt(3);
        
        switch (randChoice) {
            case 0: // BANG
                return "BANG";
            case 1: // POW
                return "POW";
            case 2: // WHAM
                return "WHAM";
            default:
                return "BANG";
        }
    }
    
    public static int getPoundsOfMeat(int min, int max) {
        Random rand = new Random();
        int pounds = rand.nextInt((max-min)+1) + min;
        return pounds;
    }
}
