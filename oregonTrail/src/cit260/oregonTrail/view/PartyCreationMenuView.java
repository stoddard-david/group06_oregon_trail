/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.view.ViewInterface.View;
import cit260.oregonTrail.model.Game;
import cit260.oregonTrail.model.PartyMember;
import java.util.Scanner;
import oregontrail.OregonTrail;

/**
 *
 * @author Stoddard
 */
public class PartyCreationMenuView extends View {
    
    private String[] menu;
    private int memberIndex = 0;
    
    public PartyCreationMenuView() {
        super("");

        //An array is used, so the seperate strings can be adjusted
        this.menu = new String[8];
        this.menu[0] = "\n-------------------------------------------"
                     + "\n| Party Creation                          |"
                     + "\n-------------------------------------------";
        this.menu[1] = "\n1 ";
        this.menu[2] = "\n2 ";
        this.menu[3] = "\n3 ";
        this.menu[4] = "\n4 ";
        this.menu[5] = "\n5 ";
        this.menu[6] = "\n-------------------------------------------"
                     + "\n";
        this.menu[7] = "\nPlease enter party leader's name: ";
 
        setMenuText();
    }

    private void setMenuText() {
        String message = "";

        for (int i = 0; i < 8; i++) {
            message = message + this.menu[i];
        }
        
        this.displayMessage = message;
    }
        
    @Override
    public boolean doAction(String choice) {
        
        if (choice.length() < 2) {
            System.out.println("\nInvalid players name: "
                + "The name must be greater than one character in length");
            return false;
        }
        
        PartyMember partyMember = new PartyMember();
        partyMember.setName(choice);
        partyMember.setHealth(100);
        partyMember.setStatus(1);
        
        Game game = OregonTrail.getCurrentGame();
        game.setPartyMembers(partyMember, this.memberIndex);
        
        this.menu[this.memberIndex + 1] = this.menu[this.memberIndex + 1] + " " + choice;

        this.memberIndex++;
        this.menu[7] = "\nPlease enter next party member's name: ";
        setMenuText(); 

        //Check if need to create more party members
        if (this.memberIndex < 5) {
            return false;
        }

        //Go to the next view when done
        displayNextView();
        
        return true; // success !
    }    
    
    private void displayNextView() {
        
        // Create MainMenuView object
        StartDateView startDateView = new StartDateView();
                
        // Display the main menu view
        startDateView.display();
    }
}
