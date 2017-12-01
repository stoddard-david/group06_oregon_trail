/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.GameControl;
import cit260.oregonTrail.exception.GameControlException;
import cit260.oregonTrail.exception.MapControlException;
import cit260.oregonTrail.view.ViewInterface.View;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import oregontrail.OregonTrail;

/**
 *
 * @author erinsmith
 */
public class MainMenuView extends View {
    
    public MainMenuView() {
         super("\n"
                  + "\n-------------------------------------------"
                  + "\n| Main Menu                               |"
                  + "\n-------------------------------------------"
                  + "\n1 - Start new game"
                  + "\n2 - Get and start saved game"
                  + "\n3 - Get help on how to play the game"
                  + "\n4 - Game controls"
                  + "\n5 - Save game"
                  + "\n6 - Test Hunting"
                  + "\nQ - Quit"
                  + "\n-------------------------------------------");
    }
    
    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // convert choice to upper case
        
        
        switch (choice) {
            case "1": 
                try {
                    // create and start a new game
                    this.startNewGame();
                } catch (MapControlException ex) {
                    Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
                } catch (GameControlException ex) {
                    Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
                }
               break;
            case "2": // get and start an existing game
                this.startExistingGame();
                break;
            case "3": // display the help menu
                this.displayHelpMenu();
                break;
            case "4": // save the current game
                this.displayGameMenu();
                break;
            case "5": // save the current game
                this.saveGame();
                break;
            case "6": // test hunting
                this.testHunting();
                break;
            default:
                ErrorView.display("MainMenuView", "*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }

    private void startNewGame() throws MapControlException, GameControlException {
        // create a new game
        boolean returnValue = GameControl.createNewGame(OregonTrail.getPlayer());
        if (!returnValue) {
            ErrorView.display(this.getClass().getName(), "ERROR - Failed to create new game");
        } else {
            // display the game menu
            ProfessionMenuView professionMenu = new ProfessionMenuView();
            professionMenu.display();
        }
    }

    private void startExistingGame() {
        this.console.println("\n\nEnter the file path for the file where the game "
                            + " is to be saved.");
        
        String filePath = this.getInput();
        
        try {
            GameControl.loadGame(filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }
    
    private void displayGameMenu() {
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }
    
    private void testHunting() {
        HuntingView huntingMenu = new HuntingView();
        huntingMenu.display();
    }

    private void saveGame() {
        this.console.println("\n\nEnter the file path for the file where the game"
                            + "is to be saved.");
        String filePath = this.getInput();
        
        try { 
            GameControl.saveGame(OregonTrail.getCurrentGame(), filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }
    
}
