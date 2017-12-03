/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import oregontrail.OregonTrail;

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
        
        protected final BufferedReader keyboard = OregonTrail.getInFile();
        protected final PrintWriter console = OregonTrail.getOutFile();
        
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
            
            String value = null; // value to be returned
            boolean valid = false; // initialize to not valid
        
            try {
                while (!valid) { // loop while an invalid value is entered
                    this.console.println("\n" + this.displayMessage);

                    
                    value = this.keyboard.readLine(); // get next line typed on keyboard
                    
                    value = value.trim(); // trim off leading and trailing blanks

                    if (value.length() <1) { // value is blank
                        ErrorView.display(this.getClass().getName(), "\nInvalid value: value can not be blank");
                        continue;
                    }

                    break; // end the loop
                }
            } catch (Exception e) {
                ErrorView.display(this.getClass().getName(), "Error reading input: " + e.getMessage());
            }
        
            return value; // return the value entered
        }
    }
}
