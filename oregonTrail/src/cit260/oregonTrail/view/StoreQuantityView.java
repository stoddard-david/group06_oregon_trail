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
public class StoreQuantityView {
    
    private String menu;
    
    public StoreQuantityView(){
    
        this.menu = "\n"
                  + "\n-------------------------------------------"
                  + "\n| How many units do you want to purchase?  |"
                  + "\n-------------------------------------------"
                  + "\n Enter amount:                             "
                  + "\n-------------------------------------------";
    }
    public void displayStoreQuantityView() {
        
        boolean done = false; // set flag to not done
        do {
            // prompt for and get players name
            int menuOption = this.getMenuOption();
            if (menuOption == 0) // user wants to quit
                return; // exit the game
            
            // do the requested action and display the next view
            done = this.doAction(menuOption);
            
        } while (!done);
    }

    private int getMenuOption() {
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        int value = 0; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is entered
            System.out.println("\n" + this.menu);
                        
            if (value >= 0) { // value is blank
                System.out.println("\nInvalid value: value can not be blank");
            } else {            
                valid = true; // end the loop
            }
        }
        
        return value; // return the value entered
    }

    private boolean doAction(int menuOption) {
        
        //get quantity
        int quantity = menuOption;
        this.updateSupplies();
        return true;
    }

    private void updateSupplies() {
        StoreMenuView storeMenuView = new StoreMenuView();
        storeMenuView.displayStoreMenuView();
    }

}
