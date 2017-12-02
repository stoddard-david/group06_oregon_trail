/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.InventoryControl;
import cit260.oregonTrail.view.ViewInterface.View;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author erinsmith
 */
public class GameMenuView extends View{

    
    public GameMenuView() {
        super("\n"
                  + "\n-------------------------------------------"
                  + "\n| Game Controls                           |"
                  + "\n-------------------------------------------"
                  + "\n1 - Turn sound on/off"
                  + "\n2 - Change pace"
                  + "\n3 - Change rations"
                  + "\nQ - Quit game controls"
                  + "\n-------------------------------------------"); 
    }
    
    
    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // convert choice to upper case
        
        switch (choice) {
            case "1": // turn sound on and off
                this.toggleSound();
                break;
            case "2": // change travel pace
                this.changePace();
                break;
            case "3": // change food rations
                this.changeRations();
                break;
            /*case "4": // view map
                this.viewMap();
                break;
            case "5": // view inventory
                this.viewInventory();
                break;
            case "6": //view party members
                this.viewPartyMembers();
                break;*/
            default:
                this.console.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }
    
  
    private void toggleSound() {
        SoundToggleView soundToggleView = new SoundToggleView();
        soundToggleView.display();
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

    /*private void viewMap() {
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
    }*/
    

}
