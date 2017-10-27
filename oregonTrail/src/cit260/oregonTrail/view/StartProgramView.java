/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.GameControl;
import cit260.oregonTrail.model.Player;
import java.util.Scanner;

/**
 *
 * @author erinsmith
 */
public class StartProgramView {
    
    private String promptMessage;
    
    public StartProgramView() {
        // promptMessage = "Please enter your name"
        this.promptMessage = "\nPlease enter your name: ";
        
        // display the banner when view is created
        this.displayBanner();
    }

    private void displayBanner() {
        System.out.println(
                  "\n*******************************************"
                + "\n*                                         *"
                + "\n*            THE OREGON TRAIL             *"
                + "\n*                                         *"
                + "\n* Journey by covered wagon across 2000    *"
                + "\n* miles of plains, rivers and mountains.  *"
                + "\n* On the plains, will you slosh your      *"
                + "\n* wagons through mud and water filled     *"
                + "\n* ruts or will you plod through dust six  *"
                + "\n* inches deep?                            *"
                + "\n*                                         *"
                + "\n* Pick a profession, gather your supplies *"
                + "\n* and hope your party makes it to Oregon  *"
                + "\n* alive. Good luck on your adventure!     *"
                + "\n*                                         *"
                + "\n*******************************************"
        
        );
    }

    public void displayStartProgramView() {
        
        boolean done = false; // set flag to not done
        do {
            // prompt for and get players name
            String playersName = this.getPlayersName();
            if (playersName.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
        
            // do requested action and display next view
            done = this.doAction(playersName);
                    
        } while (!done);
    }

    private String getPlayersName() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is entered
            System.out.println("\n" + this.promptMessage);
            
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

    private boolean doAction(String playersName) {
        if (playersName.length() <2) {
            System.out.println("\nInvalid players name: "
                + "The name must be greater than one character in length");
            return false;
        }
        
        // call createPlayer() control function
        Player player = GameControl.createPlayer(playersName);
        
        if (player == null) { // if unsuccessful
            System.out.println("\nError creating the player.");
            return false;
        }
        
        // display next view
        this.displayNextView(player);
        
        return true; // success !
    }

    private void displayNextView(Player player) {
        
        // display a custom welcome message
        System.out.println("\n====================================="
                          + "\n Welcome to the game " + player.getName()
                          + "\n We hope you make it to Oregon alive!"
                          + "\n====================================="
                          );
        
        // Create MainMenuView object
        MainMenuView mainMenuView = new MainMenuView();
                
        // Display the main menu view
        mainMenuView.displayMainMenuView();
    }
    
    
}
