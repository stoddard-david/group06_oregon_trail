/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.GameControl;
import cit260.oregonTrail.exception.GameControlException;
import cit260.oregonTrail.view.ViewInterface.View;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erinsmith
 */
public class ChangePaceView extends View {
    
    
    public ChangePaceView() {
        super("-------------------------------------------"
                  + "\n| Change your pace of travel                |"
                  + "\n-------------------------------------------"
                  + "\n1 - Steady --You travel 8 hours a day. You take many rests and rarely get very tired."
                  + "\n2 - Strenuous --You travel 12 hours a day, starting at sunrise and stopping at"
                  + "\nsunset. You stop to rest only when you must. You finish each day very tired."
                  + "\n3 - Grueling --You travel 16 hours a day, starting before sunrise and continuing"
                  + "\nuntil dark. You rarely rest and you don't get enough sleep. You finish each"
                  + "\nday exhausted and your health suffers."
                  + "\nQ - Quit"
                  + "\n-------------------------------------------");
        
        try {
            this.console.println(GameControl.viewPace());
        } catch (GameControlException ex) {
            ErrorView.display(this.getClass().getName(), "Error printing pace: " + ex.getMessage());
        }
    }

    
    @Override
    public boolean doAction(String choice) {
        
        try {
            choice = choice.toUpperCase(); // convert choice to upper case
            
            switch (choice) {
                case "1": // set pace to "Steady"
                    GameControl.changePace(1);
                    this.console.println("Set to steady.");
                    return true;
                case "2": // set pace to "Strenuous"
                    GameControl.changePace(2);
                    this.console.println("Set to strenuous.");
                    return true;
                case "3": // set pace to "Grueling"
                    GameControl.changePace(3);
                    this.console.println("Set to Grueling.");
                    return true;
                default:
                    this.console.println("\n*** Invalid selection *** Try again");
                    break;
            }
            
            return false;
        } catch (GameControlException ex) {
            ErrorView.display(this.getClass().getName(), "Error: " + ex.getMessage());
        }
        return false;
    }

}
