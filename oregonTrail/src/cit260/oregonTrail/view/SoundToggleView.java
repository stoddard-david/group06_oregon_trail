/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.view.ViewInterface.View;

/**
 *
 * @author erinsmith
 */
public class SoundToggleView extends View {
    
    
    public SoundToggleView() {
        super("\n"
            + "\n----------------------------------------"
            + "\n| Turn Sound On or Off                 |"
            + "\n----------------------------------------"
            + "\n1 - Turn sound on"
            + "\n2 - Turn sound off"
            + "\nQ - Quit sound controls"
            + "\n----------------------------------------");
    }
    
    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // conver choice to upper case
        
        switch (choice) {
            case "1": // turn sound on
                this.soundOn();
                break;
            case "2": // turn sound off
                this.soundOff();
                break;
            default:
                System.out.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }
    
    private void soundOn() {
        System.out.println("*** soundOn function called ***");
    }
    
    private void soundOff() {
        System.out.println("*** soundOff function called ***");
    }
}
