/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.InventoryControl;
import cit260.oregonTrail.model.Game;
import cit260.oregonTrail.model.InventoryItem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import oregontrail.OregonTrail;

/**
 *
 * @author dglinzey
 */
public class StoreQuantityView {
    
    private String menu;
        
    protected final BufferedReader keyboard = OregonTrail.getInFile();
    protected final PrintWriter console = OregonTrail.getOutFile();
    private String item;
    
    public StoreQuantityView(){
    
        this.menu = "\n"
                  + "\n-------------------------------------------"
                  + "\n| How many units do you want to purchase?  |"
                  + "\n-------------------------------------------"
                  + "\n Enter amount:                             "
                  + "\n-------------------------------------------";
    }
    public void displayStoreQuantityView(String itemNumber) {
        
        item = itemNumber;
        int indexNum = Integer.parseInt(item);
        int indexNumber = indexNum - 1;
        boolean done = false; // set flag to not done// set flag to not done
        do {
            // prompt for and get players name
            int menuOption = this.getMenuOption();
            if (menuOption == 0) // user wants to quit
                return; // exit the game
            
            // do the requested action and display the next view
            done = this.doAction(menuOption, indexNumber);
            
        } while (!done);
    }

    private int getMenuOption() {
        
        String valueString = "";
        int value = 0;
        
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is entered
            this.console.println("\n" + this.menu);
            try {
                valueString = this.keyboard.readLine(); // value to be returned
            } catch (IOException ex) {
                ErrorView.display(this.getClass().getName(), "You must enter a value.");
            }
            try {
                value = Integer.parseInt(valueString);
            } catch (NumberFormatException nf) {
                ErrorView.display(this.getClass().getName(), "\nYou must enter a valid number.");
            }
            if (value < 0) { // value is blank
                ErrorView.display(this.getClass().getName(), "\nYou must enter a valid number.");
            } else {            
                valid = true; // end the loop
            }
        }
        
        return value; // return the value entered
    }

    private boolean doAction(int menuOption, int indexNumber) {
        
        //get quantity
        int quantity = menuOption;
        this.updateSupplies(quantity, indexNumber);
        return true;
    }

    private void updateSupplies(int quantity, int indexNumber) {
        Game currentGame = OregonTrail.getCurrentGame();
        InventoryItem[] inventoryItems = currentGame.getInventoryItems();
        InventoryControl supplies = new InventoryControl();
        supplies.updateSupplies(inventoryItems, quantity, indexNumber);
    }

}
