/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.HuntingControl;
import cit260.oregonTrail.exception.HuntingControlException;
import cit260.oregonTrail.view.ViewInterface.View;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stoddard
 */
public class HuntingView  extends View{
    
    public HuntingView() {
        super("\n"
                  + "\n-------------------------------------------"
                  + "\n| Testing the hunting exceptions          |"
                  + "\n-------------------------------------------"
                  + "\n1 - Invalid speed"
                  + "\n2 - Invalid distance"
                  + "\n3 - Invalid time"
                  + "\n4 - A valid respone is entered"
                  + "\nQ - Quit"
                  + "\n-------------------------------------------");
    }

    @Override
    public boolean doAction(String choice) {
        
        boolean valid = false; 
        boolean hit = false; //Determine if hit
        choice = choice.toUpperCase(); // convert choice to upper case
        
        switch (choice) {
            case "1": // Invalid speed
                try {
                   hit = HuntingControl.calcHuntingControl(0.0, 75.0, 0.5);
                } catch (HuntingControlException me) {
                   System.out.println(me.getMessage());
                   return valid;
                } catch (Throwable te) {
                   System.out.println(te.getMessage());
                   return valid;
                }
                break;
            case "2": // Invalid distance
                try {
                   hit = HuntingControl.calcHuntingControl(4.0, 0.0, 3.0);
                } catch (HuntingControlException me) {
                   System.out.println(me.getMessage());
                   return valid;
                } catch (Throwable te) {
                   System.out.println(te.getMessage());
                   return valid;
                }
               break;
            case "3": // Invalid timer
                try {
                   hit = HuntingControl.calcHuntingControl(1.2, 125.0, -1.0);
                } catch (HuntingControlException me) {
                   System.out.println(me.getMessage());
                   return valid;
                } catch (Throwable te) {
                   System.out.println(te.getMessage());
                   return valid;
                }
               break;
            case "4": // View a help screen
                try {
                   double timer = getTimer();
                   hit = HuntingControl.calcHuntingControl(1.2, 100.0, timer);
                } catch (HuntingControlException me) {
                   System.out.println(me.getMessage());
                   return valid;
                } catch (Throwable te) {
                   System.out.println(te.getMessage());
                   return valid;
                }
               break;
            default:
               System.out.println("\n*** Invalid selection *** Try again");
               break;
        }
        
        if (hit) {
            System.out.println("You have hit the animal and are collecting meat!");
        } else {
            System.out.println("Sorry, you have missed.");
        }
        
        //Return if a valid choice was picked
        return valid;
    }
    
        private double getTimer() {
        
        String valueString = "";
        double value = -9999;
        
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is entered
            System.out.println("\nEnter the time it took for you to fire.");
            try {
                valueString = this.keyboard.readLine(); // value to be returned
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "You must enter a value.");
            }
            try {
                value = Double.parseDouble(valueString);
            } catch (NumberFormatException nf) {
                System.out.println("\nYou must enter a valid number.");
            }
            if (value != -9999) {
                valid = true;
            }
        }
        
        return value; // return the value entered
    }
}
