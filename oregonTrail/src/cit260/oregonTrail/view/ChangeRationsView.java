/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.GameControl;
import cit260.oregonTrail.exception.GameControlException;
import cit260.oregonTrail.view.ViewInterface.View;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erinsmith
 */
public class ChangeRationsView extends View {
    
    public ChangeRationsView() {
        super("\n"
                  + "\n-------------------------------------------"
                  + "\n| Change your rations level               |"
                  + "\n-------------------------------------------"
                  + "\n1 - Filling -- Meals are large and generous."
                  + "\n2 - Meager -- Meals are small, but adequate."
                  + "\n3 - Bare Bones -- Meals are very small. Everyone stays hungry,"
                  + "\nand your health may suffer."
                  + "\nQ - Quit"
                  + "\n-------------------------------------------");
    }
    
    @Override
    public boolean doAction(String choice) {
        
        try {
            choice = choice.toUpperCase(); // convert choice to uppercase
            
            switch (choice) {
                case "1": // set rations to "Filling"
                    GameControl.changeRations(3);
                    this.console.println("Set to Filling.");
                    return true;
                case "2": // set rations to "Meager"
                    GameControl.changeRations(2);
                    this.console.println("Set to Meager.");
                    return true;
                case "3": // set rations to "Bare Bones"
                    this.console.println("Set to Bare Bones.");
                    return true;
                default:
                    this.console.println("\n*** Invalid selection *** Try again");
                    break;
            }
            
            return false;
        } catch (GameControlException ex) {
            Logger.getLogger(ChangeRationsView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
