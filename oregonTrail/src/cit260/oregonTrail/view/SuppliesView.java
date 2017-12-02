/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.InventoryControl;
import cit260.oregonTrail.model.Game;
import cit260.oregonTrail.model.InventoryItem;
import cit260.oregonTrail.view.ViewInterface.View;
import oregontrail.OregonTrail;

/**
 *
 * @author dglinzey
 */
public class SuppliesView extends View {
    
    public SuppliesView() {
        
        super("\n"
                  + "\n-------------------------------------------"
                  + "\n| View your Supplies                       |"
                  + "\n-------------------------------------------"
                  + "\n1 - View Supplies"
                  + "\n2 - Low Supplies Indicator"
                  + "\n3 - Save a Report of your Supplies"
                  + "\nQ - Quit"
                  + "\n-------------------------------------------");
    }

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); // convert choice to upper case
       
        switch (choice) {
            case "1": // low supplies indicator
                try {
                    viewSupplies();
                }catch (Throwable te){
                    ErrorView.display(this.getClass().getName(), te.getMessage());
                }
                break;
            case "2": //Save supplies report
                try {
                    viewLowSupplies();
                }catch (Throwable te){
                    ErrorView.display(this.getClass().getName(), te.getMessage());
                }
                break;
            case "3": //Save supplies report
                try {
                    saveSuppliesReport();
                }catch(Throwable te){
                    ErrorView.display(this.getClass().getName(), te.getMessage());
                }
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }

    private void viewSupplies() {
        Game currentGame = OregonTrail.getCurrentGame();
        InventoryItem[] inventoryItems = currentGame.getInventoryItems();
        InventoryControl supplies = new InventoryControl();
        supplies.viewSupplies(inventoryItems);
    }

    private void saveSuppliesReport() {
        Game currentGame = OregonTrail.getCurrentGame();
        InventoryItem[] inventoryItems = currentGame.getInventoryItems();
        InventoryControl supplies = new InventoryControl();
        this.console.println("\n\nEnter the file path for the file where the party "
                            + "information will be saved to.");

        String filePath = this.getInput();
     
        try { 
            InventoryControl.saveSuppliesReport(inventoryItems, filePath);
            this.console.println("\nSaved Sucessful"
                + "\n"
                + "\nPress any key to continue");
            String temp = this.getInput();
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }

    }

    private void viewLowSupplies() {
        Game currentGame = OregonTrail.getCurrentGame();
        InventoryItem[] inventoryItems = currentGame.getInventoryItems();
        InventoryControl low = new InventoryControl();
        String inventoryLow = low.lowInventory(inventoryItems);
        this.console.println(inventoryLow);
    }
}
