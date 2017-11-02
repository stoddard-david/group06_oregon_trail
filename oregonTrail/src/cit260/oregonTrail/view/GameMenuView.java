/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author erinsmith
 */
public class GameMenuView {

    private String menu;
    
    public GameMenuView() {
        this.menu = "\n"
                  + "\n-------------------------------------------"
                  + "\n| Game Controls                               |"
                  + "\n-------------------------------------------"
                  + "\n1 - Turn sound on/off"
                  + "\n2 - Change pace"
                  + "\n3 - Change rations"
                  + "\nQ - Quit game controls"
                  + "\n-------------------------------------------"; 
    }
    
    public void displayGameMenu() {
        
//        // gets class name of calling function in order to dynamically return to origin point in game
//        String path = Thread.currentThread().getStackTrace()[3].getClassName(); //gets whole path of calling class
//        String segments[] = path.split("\\."); // splits path into sub paths
//        String className = segments[segments.length-1]; // isolates the view that called this function
//        System.out.println(className);
        
    
        
        boolean done = false; // set flag to not done
        do {
            // prompt for and get player's input
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the menu
            
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
                continue;
            }
            
            break; // end the loop
        }
        
        return value; // return the value entered
    }
    
    private boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // convert choice to upper case
        
        switch (choice) {
            case "1": // turn sound on and off
                this.toggleSound();
                break;
            case "2": // change travel pace
                this.changePace();
                break;
            case "3": // change food rations
                this.changeRations();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }
    
  
    private void toggleSound() {
        System.out.println("*** toggleSound function called ***");
    }

    private void changePace() {
        //display change pace menu
        ChangePaceView changePaceView = new ChangePaceView();
        changePaceView.displayChangePaceMenuView();
    }
    
    private void changeRations() {
        System.out.println("*** changeRations function called ***");
    }
    

}
