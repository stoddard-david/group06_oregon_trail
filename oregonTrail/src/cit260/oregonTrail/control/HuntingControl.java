/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.control;

import cit260.oregonTrail.exception.HuntingControlException;

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
}
