/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.HuntingControl;
import cit260.oregonTrail.exception.HuntingControlException;
import cit260.oregonTrail.view.ViewInterface.View;

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
                } catch (Throwable te) {
                   System.out.println(te.getMessage());
                }
                break;
            case "2": // Invalid distance
                try {
                    hit = HuntingControl.calcHuntingControl(4.0, 0.0, 3.0);
                } catch (HuntingControlException me) {
                   System.out.println(me.getMessage());
                } catch (Throwable te) {
                   System.out.println(te.getMessage());
                }
               break;
            case "3": // Set the money and profession to farmer
                try {
                    hit = HuntingControl.calcHuntingControl(1.2, 125.0, -1.0);
                } catch (HuntingControlException me) {
                   System.out.println(me.getMessage());
                } catch (Throwable te) {
                   System.out.println(te.getMessage());
                }
               break;
            case "4": // View a help screen
                try {
                    hit = HuntingControl.calcHuntingControl(1.2, 100.0, 2.0);
                } catch (HuntingControlException me) {
                   System.out.println(me.getMessage());
                } catch (Throwable te) {
                   System.out.println(te.getMessage());
                }
               break;
            default:
               System.out.println("\n*** Invalid selection *** Try again");
               break;
        }
        
        if (hit) {
            System.out.println("You have hit the animal and are collecting meat!");
        }
        
        //Return if a valid choice was picked
        return valid;
    }
}
