/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.GameControl;
import java.util.Scanner;

/**
 *
 * @author erinsmith
 */
public class ChangePaceView {
    
    private String menu;
    
    public ChangePaceView() {
        this.menu = "\n"
                  + "\n-------------------------------------------"
                  + "\n| Change your pace of travel                |"
                  + "\n-------------------------------------------"
                  + "\n1 - Steady --You travel 8 hours a day. You take many rests and rarely get very tired."
                  + "\n2 - Strenuous --You travel 12 hours a day, starting at sunrise and stopping at"
                  + "\nsunset. You stop to rest only when you must. You finish each day very tired."
                  + "\n3 - Grueling --You travel 16 hours a day, starting before sunrise and continuing"
                  + "\nuntil dark. You rarely rest and you don't get enough sleep. You finish each"
                  + "\nday exhausted and your health suffers."
                  + "\nQ - Quit"
                  + "\n-------------------------------------------"; 
    }

    void displayChangePaceMenuView() {
        
     boolean done = false; // set flag to not done
        do {
            // prompt for and get players input
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the view
            
            // do the requested action and display the next view
            done = this.doAction(menuOption);
            
        } while (!done);      
    }
    
    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is entered
            System.out.println("\n" + this.menu);
            
            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim off leading and trailing blanks
            
            if (value.length() <1) { // value is blank
                System.out.println("\nInvalid value: value can not be blank");
            } else {            
                valid = true; // end the loop
            }
        }
        
        return value; // return the value entered
    }
    
    private boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // convert choice to upper case
        
        switch (choice) {
            case "1": // set pace to "Steady"
               GameControl.changePace(1);
               break;
            case "2": // set pace to "Strenuous"
               GameControl.changePace(2);
               break;
            case "3": // set pace to "Grueling"
               GameControl.changePace(3);
               break;
            default:
               System.out.println("\n*** Invalid selection *** Try again");
               break;
        }
        
        return false;
    }

}
