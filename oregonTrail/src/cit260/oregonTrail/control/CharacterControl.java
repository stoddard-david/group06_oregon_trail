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
public class CharacterControl {
    
    public static String setProfession(String profession){
        String professionName = profession;
        return professionName;
    }
        
    public static double restHealing(double health){
        
        double newHealth = health + 1;
        return newHealth;
    }
    
}

