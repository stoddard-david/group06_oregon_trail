/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.GameControl;
import cit260.oregonTrail.view.ViewInterface.View;

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
        
        choice = choice.toUpperCase(); // convert choice to uppercase
        
        switch (choice) {
            case "1": // set rations to "Filling"
                GameControl.changeRations(3);
                break;
            case "2": // set rations to "Meager"
                GameControl.changeRations(2);
                break;
            case "3": // set rations to "Bare Bones"
                GameControl.changeRations(1);
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }
}