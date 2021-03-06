/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.MapControl;
import cit260.oregonTrail.exception.InventoryControlException;
import cit260.oregonTrail.exception.MapControlException;
import cit260.oregonTrail.exception.PartyMemberControlException;
import cit260.oregonTrail.view.ViewInterface.View;
import cit260.oregonTrail.model.Game;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oregontrail.OregonTrail;


/**
 *
 * @author Stoddard
 */
public class StartDateView extends View {

    public StartDateView() {
        super("\n"
            + "\n-------------------------------------------"
            + "\n| It is 1848 in Independence, Missouri.   |"
            + "\n| You must decide which month to leave.   |"
            + "\n-------------------------------------------"
            + "\n1 - March"
            + "\n2 - April"
            + "\n3 - May"
            + "\n4 - June"
            + "\n5 - July"
            + "\n6 - Ask for advice"
            + "\nQ - Quit"
            + "\n-------------------------------------------");
    }

    @Override
    public boolean doAction(String choice) {
        
        try {
            boolean valid = true; //Stores if a valid option is choosen
            choice = choice.toUpperCase(); // convert choice to upper case
            Game game = OregonTrail.getCurrentGame();
            
            switch (choice) {
                case "1": // Set March
                    game.setDate(301);
                    displayNextView();
                    break;
                case "2": // Set April
                    game.setDate(401);
                    displayNextView();
                    break;
                case "3": // Set May
                    game.setDate(501);
                    displayNextView();
                    break;
                case "4": // Set June
                    game.setDate(601);
                    displayNextView();
                    break;
                case "5": // Set July
                    game.setDate(701);
                    displayNextView();
                    break;
                case "6": // Go to help
                    displayDateHelp();
                    valid = false; //Set to false, so it won't exit
                    break;
                default:
                    ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                    valid = false; //Sets the answer to invalid answer to return
                    break;
            }
            
            //Return if a valid choice was picked
            return valid;
        } catch (PartyMemberControlException ex) {
            Logger.getLogger(StartDateView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InventoryControlException ex) {
            Logger.getLogger(StartDateView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    private void displayDateHelp() {
        String helpProfession = "\n"
            + "\n-------------------------------------------"
            + "\nIf you leave too early, there won't be any"
            + "\ngrass for your oxen to eat. If you leave"
            + "\ntoo late, you may not get to Oregon before"
            + "\nwinter comes. If you leave at the right"
            + "\ntime, there will be green grass and the"
            + "\nweather will still be cool."
            + "\n-------------------------------------------"
            + "\n"
            + "\nPress any key to continue";
        
        this.console.println(helpProfession); //Print the help
        try {
            this.keyboard.readLine(); // get next line typed on keyboard, used to pause
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "You must enter a value.");        
        }
}
    
    private void displayNextView() throws PartyMemberControlException, InventoryControlException {

        /*
        // Create GameMenuView object
        GameMenuView gameMenuView = new GameMenuView();
            
        // Display the game menu view
        gameMenuView.display();
            
        TownView townView = new TownView();
        townView.display();*/
            
        try {      
            MapControl.chooseLocationView();
        } catch (MapControlException ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());        
        }
    }
}
