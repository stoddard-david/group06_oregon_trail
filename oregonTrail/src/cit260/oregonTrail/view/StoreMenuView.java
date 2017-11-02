/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.InventoryControl;
import java.util.Scanner;
/**
 *
 * @author dglinzey
 */
public class StoreMenuView {
    
    private String menu;
    
    public StoreMenuView(){
    
        this.menu = "\n"
                  + "\n-------------------------------------------"
                  + "\n| Welcome to the General Store             |"
                  + "\n| Take a look around. Want to buy anything?|"
                  + "\n-------------------------------------------"
                  + "\n1 - Flour - - - - $1.0 /lb"
                  + "\n2 - Meat  - - - - $5.0 /lb"
                  + "\n3 - Water - - - - $0.5 /gallon"
                  + "\n4 - Oxen  - - - - $100 /pair"
                  + "\n5 - Wagon Parts - $25  /part"
                  + "\n6 - Bullets - - - $10  /box"
                  + "\nQ - Quit"
                  + "\n-------------------------------------------";
    }
    public void displayStoreMenuView() {
        
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
        
        String itemName;
        String itemNumber;
        switch (choice) {
            case "1": // purchase flour
                itemNumber = "1";
                itemName = "flour";
               displayNextView();
               break;
            case "2": // purchase meat
               itemNumber = "2";
               itemName = "meat";
               displayNextView();
               break;
            case "3": // purchase water
               itemNumber = "3";
               itemName = "water";
               displayNextView();
               break;
            case "4": // purchase oxen
               itemNumber = "4";
               itemName = "oxen";
               displayNextView();
               break;
            case "5": // purchase wagon parts
               itemNumber = "5";
               itemName = "wagon parts";
               displayNextView();
               break;
            case "6": // purchase bullets
               itemNumber = "6";
               itemName = "bullets";
               displayNextView();               
               break;
            default:
               System.out.println("\n*** Invalid selection *** Try again");
               break;
        }
        
        return false;
    }

    private void displayNextView() {
        //creates store quantity view object
        StoreQuantityView storeQuantityView = new StoreQuantityView();
        //display store quantity view
        storeQuantityView.displayStoreQuantityView();
    }
}
