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
 * @author Stoddard
 */
public class ProfessionMenuView {
    private String menu;
    
    public ProfessionMenuView() {
        this.menu = "\n"
                  + "\n-------------------------------------------"
                  + "\n| Many kinds of peopel made the trip to   |"
                  + "\n| Oregon. Who will you be?                |"
                  + "\n-------------------------------------------"
                  + "\n1 - Be a banker from Boston"
                  + "\n2 - Be a carpenter from Ohio"
                  + "\n3 - Be a farmer from Illinois"
                  + "\n4 - Find out the differences between the choices"
                  + "\nQ - Quit"
                  + "\n-------------------------------------------";
    }
    
    public void displayProfessionMenuView() {
        
        boolean done = false; // set flag to not done
        do {
            // prompt for and get players name
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
            
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
            case "1": // create and start a new game
               GameControl.setGameProfession(1);
               displayNextView();
               break;
            case "2": // get and start an existing game
               GameControl.setGameProfession(2);
               displayNextView();
               break;
            case "3": // display the help menu
               GameControl.setGameProfession(3);
               displayNextView();
               break;
            case "4": // save the current game
               GameControl.setGameProfession(4);
               break;
            default:
               System.out.println("\n*** Invalid selection *** Try again");
               break;
        }
        
        return false;
    }
    
    private void viewProfessionHelp() {
        String helpProfession = "\n"
            + "\n-------------------------------------------"
            + "\nTraveling to Oregon isn't easy."
            + "\nThe banker has the most money for supplies"
            + "\nmaking the journey easier, but receives"
            + "\nfewer points. The farmer has the least"
            + "\namount of money making the journey harder,"
            + "\nbut provides the most points. The carpenter"
            + "\nis between the banker and farmer in money"
            + "\nand points."                
            + "\n-------------------------------------------"
            + "\n"
            + "\nPress any key to continue";
        String value = ""; // value to be returned. Just to make sure a key is pressed
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        System.out.println(helpProfession);
        value = keyboard.nextLine(); // get next line typed on keyboard
    }
    
    private void displayNextView() {
        
        // Create MainMenuView object
        PartyCreationMenuView partyCreationMenuView = new PartyCreationMenuView();
                
        // Display the main menu view
        partyCreationMenuView.displayPartyCreationMenuView();
    }
}
