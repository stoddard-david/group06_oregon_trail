/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.MapControl;
import cit260.oregonTrail.exception.MapControlException;
import cit260.oregonTrail.model.Game;
import cit260.oregonTrail.model.Map;
import cit260.oregonTrail.view.ViewInterface.View;
import oregontrail.OregonTrail;

/**
 *
 * @author Stoddard
 */
public class RiverView extends View {
    
    public RiverView() {
        super("\n"
                  + "\n-------------------------------------------"
                  + "\n| River Control                           |"
                  + "\n-------------------------------------------"
                  + "\n1 - Cross river"
                  + "\n2 - Change pace"
                  + "\n3 - Change rations"
                  + "\n4 - View Map"
                  + "\n5 - View Supplies"
                  + "\n6 - View Party Members"
                  + "\n7 - Stop to rest"
                  + "\nR - Return to Main Menu"
                  + "\nQ - Quit"
                  + "\n-------------------------------------------");
        
        String locationName;
        try {
            locationName = MapControl.getLocationName();
            this.displayMessage = "\nYou are on the banks of " + locationName + this.displayMessage;
        } catch (MapControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
    }
    
    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // convert choice to upper case
        
        switch (choice) {
            case "1": // travel the trail
                travelTrail();
                return true;
            case "2": // change travel pace
                this.changePace();
                break;
            case "3": // change food rations
                this.changeRations();
                break;
            case "4": // view map
                this.viewMap();
                break;
            case "5": // view inventory
                this.viewInventory();
                break;
            case "6": //view party members
                this.viewPartyMembers();
                break;
            case "7": // stop and rest
                this.rest();
                break;
            case "R":
                this.mainView();
                return true;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
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
        SuppliesView supplies = new SuppliesView();
        supplies.display();
    }

    private void viewPartyMembers() {
        PartyMemberView party = new PartyMemberView();
        party.display();
    }

    private void advice() {
        this.console.println("\n*** Get advice");
    }

    private void rest() {
        this.console.println("\n*** Rest");
    }

    private void trade() {
        this.console.println("\n*** Trade");
    }

    private void mainView() {
        // Create MainMenuView object
        MainMenuView mainMenuView = new MainMenuView();
                
        // Display the main menu view
        mainMenuView.display();
    }

    private void travelTrail() {
        Game game = OregonTrail.getCurrentGame();
        Map map = game.getMap();
        map.setTraveling(true);
    }
}
