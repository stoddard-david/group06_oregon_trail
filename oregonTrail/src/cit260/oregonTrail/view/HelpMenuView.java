/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import java.util.Scanner;

/**
 *
 * @author erinsmith
 */
public class HelpMenuView {
    
    private String menu;

    public HelpMenuView() {
        this.menu = "\n"
                  + "\n-------------------------------------------"
                  + "\n| Help Menu                               |"
                  + "\n-------------------------------------------"
                  + "\n1 - How to move"
                  + "\n2 - How to hunt"
                  + "\n3 - How do I increase health"
                  + "\n4 - How do I cross a river"
                  + "\nQ - Quit help menu"
                  + "\n-------------------------------------------";
    }
    
    public void displayHelpMenu() {
        
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
                continue;
            }
            
            break; // end the loop
        }
        
        return value; // return the value entered
    }
    
    private boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // convert choice to upper case
        
        switch (choice) {
            case "1": // how to move
               this.howMove();
               break;
            case "2": // how to hunt
                this.howHunt();
                break;
            case "3": // increase health
                this.howHealth();
                break;
            case "4": // crossing a river
                this.howRiver();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }

    private void howMove() {
        System.out.println("*** howMove function called ***");
    }

    private void howHunt() {
        System.out.println("*** howHunt function called ***");
    }

    private void howHealth() {
        System.out.println("*** howHealth function called ***");
    }

    private void howRiver() {
        System.out.println("*** howRiver function called ***");
    }

}
    
