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
public class InventoryControl {
    public static int foodConsumed(int rations, int numPartyMembers) {
        // checks for inputs too low
        if (rations < 1 || numPartyMembers < 1) {
            return -1;
        }
        
        // checks for inputs too high
        if (rations > 3 || numPartyMembers > 5) {
            return -1;
        }
        
        // declares var rawFoodConsumed
        double rawFoodConsumed = 0;
        
        // generates random number 0-1
        double randomNumber = Math.random();
        
        // rations level 1
        if (rations == 1) {
            rawFoodConsumed = (randomNumber * numPartyMembers);
        }
        
        // rations level 2
        if (rations == 2) {
            rawFoodConsumed = (randomNumber * numPartyMembers * 2);
        }
        
         // rations level 3
        if (rations == 3) {
            rawFoodConsumed = (randomNumber * numPartyMembers * 3);
        }
        
        // rounds to nearest integer
        int foodConsumed = (int) Math.round(rawFoodConsumed);
        
        // ensures at least one pound of food is consumed each day at lowest rations
        if (foodConsumed < 1 && rations == 1) {
            foodConsumed = 1;
        }
        
        // ensures at least two pounds of food is consumed each day at middle rations
        if (foodConsumed < 2 && rations == 2) {
            foodConsumed = 2;
        }
        
        // ensures at least three pounds of food is consumed each day at highest rations
        if (foodConsumed < 3 && rations == 3) {
            foodConsumed = 3;
        }
        
        return foodConsumed;
    }
}
