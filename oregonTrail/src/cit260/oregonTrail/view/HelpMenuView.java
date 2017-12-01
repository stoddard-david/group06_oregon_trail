/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.view.ViewInterface.View;
import java.util.Scanner;

/**
 *
 * @author erinsmith
 */
public class HelpMenuView extends View {
    

    public HelpMenuView() {
        super("\n"
                  + "\n-------------------------------------------"
                  + "\n| Help Menu                               |"
                  + "\n-------------------------------------------"
                  + "\n1 - How to move"
                  + "\n2 - How to hunt"
                  + "\n3 - How do I increase health"
                  + "\n4 - How do I cross a river"
                  + "\nQ - Quit help menu"
                  + "\n-------------------------------------------");
    }
    
    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // convert choice to upper case
        
        switch (choice) {
            case "1": // how to move
               this.howMove();
               break;
            case "2": // how to hunt
                this.howHunt();
                break;
            case "3": // increase health
                this.howHealth();
                break;
            case "4": // crossing a river
                this.howRiver();
                break;
            default:
                this.console.println("\n*** Invalid selection *** Try again");
                break;
        }
        
        return false;
    }

    private void howMove() {
        this.console.println("*** howMove function called ***");
    }

    private void howHunt() {
        this.console.println("*** howHunt function called ***");
    }

    private void howHealth() {
        this.console.println("*** howHealth function called ***");
    }

    private void howRiver() {
        this.console.println("*** howRiver function called ***");
    }

}
    
