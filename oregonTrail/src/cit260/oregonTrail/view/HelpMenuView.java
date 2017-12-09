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
        this.displayMessage = "\n\nWhen you choose to continue on the trail, your wagon party "
                            + "\nwill move along the trail according to the pace that you have chosen."
                            + "\nTake time to rest along the way to help your party regain health"
                            + "\nbut don't take too long. Winter is coming!";
    }

    private void howHunt() {
        this.displayMessage = "\n\nIf you want more food while on the trail, you can choose "
                            + "\nto go hunting. You will encounter animals and need quick reflexes"
                            + "\nto shoot the animal. Hopefully you won't run out of bullets before"
                            + "\nyou get the meat you need!";
    }

    private void howHealth() {
        this.displayMessage = "\n\nAs you travel along the trail, members in your party might get "
                            + "\nhurt or get sick. Someone might even die if left untreated. Party"
                            + "\nmembers are more likely to get sick if you are low on food supplies"
                            + "\nor the pace is too fast. Stop to rest and take care of your party"
                            + "\nmembers if you need to.";
    }

    private void howRiver() {
        this.displayMessage = "\n\nRivers are trecherous. Not only do you need to think about the"
                            + "\ndepth of the river and the speed of the water, but you need to "
                            + "\nthink about how much your wagon weighs. If the river is too strong,"
                            + "\nsomeone might drown or your wagon might tip over.";
    }

}
    
