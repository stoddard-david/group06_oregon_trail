/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.control;

/**
 *
 * @author dglinzey
 */
public class HuntingControl{
    
    public static boolean calcHuntingControl(double speed, double distanceToAnimal, double timer) {
    
        //time to beat in seconds
        double timeToBeat = 8;
        
        //check if valid
        if (speed <= 0) {
            return false;
        }
        if (distanceToAnimal < 50) {
            return false;
        }
        if (timer < 0) {
            return false;
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
