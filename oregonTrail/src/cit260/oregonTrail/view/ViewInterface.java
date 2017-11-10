/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import java.util.Scanner;

/**
 *
 * @author dglinzey
 */
public interface ViewInterface {
    
    public void display();
    public String getInput();
    public boolean doAction(String value);
    
    public abstract class View implements ViewInterface {
        
        protected String displayMessage;
        
        public View() {
        }
        
        public View(String message) {
            this.displayMessage = message;
        }
        
        @Override
        public void display() {
        
            boolean done = false;
            do {
                // prompt for and get players name
                String value = this.getInput();
                if (value.toUpperCase().equals("Q")) // user wants to quit
                    return; // exit the game
            
            
                // do the requested action and display the next view
                done = this.doAction(value);
            
            } while (!done);
        }
        
        @Override
        public String getInput() {
            
            Scanner keyboard = new Scanner(System.in); //get infile for keyboard
            String value = null; // value to be returned
            boolean valid = false; // initialize to not valid
        
            while (!valid) { // loop while an invalid value is entered
                System.out.println("\n" + this.displayMessage);
            
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
    }
}
