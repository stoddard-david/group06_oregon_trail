/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.control;

import cit260.oregonTrail.exception.InventoryControlException;
import cit260.oregonTrail.model.InventoryItem;
import cit260.oregonTrail.view.StoreQuantityView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
/**
 *
 * @author dglinzey
 */
public class InventoryControl {
    public static int foodConsumed(int rations, int numPartyMembers) throws InventoryControlException {
        // checks for inputs too low
        if (rations < 1 || numPartyMembers < 1) {
            throw new InventoryControlException("Rations or Party Members is too low. Your rations is: " + rations + " your Party Members are: " + numPartyMembers);
        }
        
        // checks for inputs too high
        if (rations > 3 || numPartyMembers > 5) {
            throw new InventoryControlException("Rations or Party Members is too high. Your rations is: " + rations + " your Party Members are: " + numPartyMembers);
        }
        
        // declares var rawFoodConsumed
        double rawFoodConsumed = 0;
        
        // generates random number 0-1
        double randomNumber = Math.random();
        
        // rations level 1
        if (rations == 1) {
            rawFoodConsumed = (randomNumber * numPartyMembers * 3);
        }
        
        // rations level 2
        if (rations == 2) {
            rawFoodConsumed = (randomNumber * numPartyMembers * 2);
        }
        
         // rations level 3
        if (rations == 3) {
            rawFoodConsumed = (randomNumber * numPartyMembers);
        }
        
        // rounds to nearest integer
        int foodConsumed = (int) Math.round(rawFoodConsumed);
        
        // ensures at least three pound of food is consumed each day at lowest rations
        if (foodConsumed < 3 && rations == 1) {
            foodConsumed = 3;
        }
        
        // ensures at least two pounds of food is consumed each day at middle rations
        if (foodConsumed < 2 && rations == 2) {
            foodConsumed = 2;
        }
        
        // ensures at least one pounds of food is consumed each day at highest rations
        if (foodConsumed < 1 && rations == 3) {
            foodConsumed = 1;
        }
        
        return foodConsumed;
    }
    
    public static String lowInventory(InventoryItem[] inventoryItems) {
        
        InventoryItem tempItem = new InventoryItem();
        
        int minQuantity = 1000;
        String item = "";
         
        for (int i = 0; i < inventoryItems.length; i++) {
            if (inventoryItems[i].getQuantityOwned() < minQuantity) {
                minQuantity = inventoryItems[i].getQuantityOwned();
                item = "Your Inventory of " + inventoryItems[i].getInventoryType() +
                        " is: " + minQuantity + ". That is kind of Low.\n";
            }
        }
        
        return item;
    }
    
    public static void viewSupplies(InventoryItem[] inventoryItems) {
        
        out.printf("%n%-30s%6s","Supply","Quantity");
        out.printf("%n%-30s%6s","-----","-------");
        
        for (int i = 0; i < inventoryItems.length; i++) {
            out.printf("%n%-30s%4d",inventoryItems[i].getInventoryType(),inventoryItems[i].getQuantityOwned());
        }
        
    }
    public static void saveSuppliesReport(InventoryItem[] inventoryItems, String filepath) throws InventoryControlException, FileNotFoundException {
        try (PrintWriter out = new PrintWriter(filepath)) {
            
            //Print title and columns
            out.println("\n   Current Supplies");
            out.printf("%n%-30s%6s","Supply","Quantity");
            out.printf("%n%-30s%6s","---","------");
            
            for (int i = 0; i < inventoryItems.length; i++) {
                out.printf("%n%-30s%4d",inventoryItems[i].getInventoryType(),inventoryItems[i].getQuantityOwned());
            }
           
        } catch (IOException ex) {
            throw new InventoryControlException(ex.getMessage());
        }

    }
    public static void updateSupplies(InventoryItem[] inventoryItems, int quantity, int indexNumber){
    
        int currentQuantity = 0;
        currentQuantity = inventoryItems[indexNumber].getQuantityOwned();
        currentQuantity = currentQuantity + quantity;
        inventoryItems[indexNumber].setQuantityOwned(currentQuantity);                
    }
    
}
