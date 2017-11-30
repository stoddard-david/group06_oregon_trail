/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.InventoryControl;
import cit260.oregonTrail.exception.GameControlException;
import cit260.oregonTrail.view.ViewInterface.View;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stoddard
 */
public class TownView  extends View {

    public TownView() {
        super("\n"
                  + "\n-------------------------------------------"
                  + "\n| Town/Fort Control                       |"
                  + "\n-------------------------------------------"
                  + "\n1 - Travel on the trail"
                  + "\n2 - Talk to people"
                  + "\n3 - General Store"
                  + "\n4 - Change pace"
                  + "\n5 - Change rations"
                  + "\n6 - View Map"
                  + "\n7 - View Inventory"
                  + "\n8 - View Party Members"
                  + "\n9 - Stop to rest"
                  + "\n10 - Attempt to trade"
                  + "\nR - Return to Main Menu"
                  + "\nQ - Quit game controls"
                  + "\n-------------------------------------------"); 
    }
    
    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // convert choice to upper case
        
        switch (choice) {
            case "1": // travel the trail
                this.travelTrail();
                break;
            case "2": // talk to people
                this.advice();
                break;
            case "3": // purchase at general store
                this.generalStore();
                break;
            case "4": // change travel pace
                this.changePace();
                break;
            case "5": // change food rations
                this.changeRations();
                break;
            case "6": // view map
                this.viewMap();
                break;
            case "7": // view inventory
                this.viewInventory();
                break;
            case "8": //view party members
                this.viewPartyMembers();
                break;
            case "9": // stop and rest
                this.rest();
                break;
            case "10": // attempt to trade
                this.trade();
                break;
            case "R":
                this.mainView();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }
    
  
    private void changePace() {
        //display change pace menu
        ChangePaceView changePaceView = new ChangePaceView();
        changePaceView.display();
    }
    
    private void changeRations() {
        ChangeRationsView changeRationsView = new ChangeRationsView();
        changeRationsView.display();
    }

    private void viewMap() {
        MapView map = new MapView();
        map.displayMapView();
    }

    private void viewInventory() {
        InventoryControl low = new InventoryControl();
        low.lowInventory();
    }

    private void viewPartyMembers() {
        PartyMemberView party = new PartyMemberView();
        party.display();
    }

    private void travelTrail() {
        System.out.println("\n*** Travel trail");
    }

    private void advice() {
        System.out.println("\n*** Get advice");
    }

    private void generalStore() {
        StoreMenuView storeMenuView = new StoreMenuView();
        storeMenuView.display();
    }

    private void rest() {
        System.out.println("\n*** Rest");
    }

    private void trade() {
        System.out.println("\n*** Trade");
    }

    private void mainView() {
        // Create MainMenuView object
        MainMenuView mainMenuView = new MainMenuView();
                
        // Display the main menu view
        mainMenuView.display();
    }
    
}
