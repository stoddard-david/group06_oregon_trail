/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.HuntingControl;
import cit260.oregonTrail.exception.HuntingControlException;
import cit260.oregonTrail.model.Animal;
import cit260.oregonTrail.model.Game;
import cit260.oregonTrail.model.InventoryItem;
import cit260.oregonTrail.view.ViewInterface.View;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.MILLIS;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import oregontrail.OregonTrail;

/**
 *
 * @author Stoddard
 */
public class HuntingView  extends View{

    private double distance;
    private int choosenAnimal;
    private String fireWord;
    private int pounds;
    private int totalPounds;
    
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private double time;
    
    public HuntingView() {
        super("\n"
                  + "\n-------------------------------------------"
                  + "\n| Hunting                                 |"
                  + "\n-------------------------------------------"
                  + "\nYou will type BANG, POW, or WHAM to shoot. "
                  + "\nJust hit ENTER to not shoot the animal.    "
                  + "\n\nNow you must wait for an animal.         "
                  + "\n-------------------------------------------");
    }
    
    @Override
     public void display() {

        boolean done = false;
        this.totalPounds = 0;
        
        Game game = OregonTrail.getCurrentGame();
        InventoryItem meat = game.getInventoryItem(1);
        InventoryItem bullets = game.getInventoryItem(5);
        
        NumberFormat formatter = new DecimalFormat("#0.00");
        
        this.console.println("\n" + this.displayMessage);
        
        for(int i=0; i<4; i++) {
            // prompt for and get players name
            
            this.choosenAnimal = HuntingControl.pickAnimal();
            this.distance = HuntingControl.getDistance();                  
            this.fireWord = HuntingControl.chooseFireWord();

            this.displayMessage = Animal.values()[choosenAnimal].getType().toUpperCase() + " " + formatter.format(distance) + " yards away."
                    + "\nEnter " + fireWord + " to shoot.";
            
            try {
                HuntingControl.waitForAnimal();
            } catch (InterruptedException ex) {
                ErrorView.display(this.getClass().getName(), "Wait for animal error: " + ex.getMessage());
            }
            
            timeStart = LocalDateTime.now();
            String value = this.getInput();
            timeEnd = LocalDateTime.now();
            
            // do the requested action and display the next view
            if (value.length() > 0) {
                if (bullets.getQuantityOwned() > 0) {
                    done = this.doAction(value);
                    bullets.setQuantityOwned(bullets.getQuantityOwned()-1);
                } else {
                    this.console.println("You have no bullets.");
                }
            }
        }
        
        this.console.println("\nYou collect " + totalPounds + " pounds of meat.");
        if (totalPounds>100) {
            this.console.println("You can only carry of 100 pounds of meat back.");
            totalPounds = 100;
        }
       
        meat.setQuantityOwned(meat.getQuantityOwned()+totalPounds);
        
        this.console.println("\nPress any key to continue"); //Print the help
        try {
            this.keyboard.readLine(); // get next line typed on keyboard, used to pause
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "You must enter a value.");        
        }
     }
     
    @Override
    public String getInput() {

        String value = null; // value to be returned
        boolean valid = false; // initialize to not valid

        try {
            while (!valid) { // loop while an invalid value is entered
                this.console.println("\n" + this.displayMessage);

                value = this.keyboard.readLine(); // get next line typed on keyboard

                value = value.trim(); // trim off leading and trailing blanks

                break; // end the loop
            }
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
        }

        return value; // return the value entered
    }

    @Override
    public boolean doAction(String choice) {
        
        boolean valid = false; 
        boolean hit = false; //Determine if hit
        choice = choice.toUpperCase(); // convert choice to upper case
        
        String missText = "Sorry, you have missed.";    
        time =  (double)MILLIS.between(timeStart, timeEnd)/1000.0;
       
        try {
            if (choice.equals(fireWord)) {
              hit = HuntingControl.calcHuntingControl(Animal.values()[choosenAnimal].getSpeed(), distance, time);
            } else {
              missText = "Sorry, you mistyped and missed.";
            }
        } catch (HuntingControlException ex) {
            ErrorView.display(this.getClass().getName(), "Error calculating hit: " + ex.getMessage());
        }
        
        if (hit) {
            pounds = HuntingControl.getPoundsOfMeat(Animal.values()[choosenAnimal].getMinMeat(),Animal.values()[choosenAnimal].getMaxMeat());
            this.console.println("You have hit the " + Animal.values()[choosenAnimal].getType() + " and are collected " + pounds + " pounds of meat!");
            totalPounds = totalPounds + pounds;
        } else {
            this.console.println(missText);
        }
        
        //Return if a valid choice was picked
        return valid;
    }
    
}
