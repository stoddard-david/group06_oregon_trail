/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.model.Game;
import cit260.oregonTrail.model.PartyMember;
import java.util.Scanner;
import oregontrail.OregonTrail;

/**
 *
 * @author Stoddard
 */
public class PartyCreationMenuView {
    
    private String[] menu;
    private String prompt;
    
    public PartyCreationMenuView() {
        //An array is used, so the seperate strings can be adjusted
        this.menu = new String[7];
        this.menu[0] = "\n-------------------------------------------"
                     + "\n| Party Creation                          |"
                     + "\n-------------------------------------------";
        this.menu[1] = "1 ";
        this.menu[2] = "2 ";
        this.menu[3] = "3 ";
        this.menu[4] = "4 ";
        this.menu[5] = "5 ";
        this.menu[6] = "-------------------------------------------";
        
        //Sets the prompt for the intail request
        prompt = "\nPlease enter party leader's name: ";
    }
    
    public void displayPartyCreationMenuView() {
        
        boolean done = false; // set flag to not done
        int memberIndex = 0;  // keeps track of the party member index
        
        do {
            // prompt for and get party members name name
            String menuOption = this.getMemberName();
            if (menuOption.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
            
            // do the requested save the members name
            done = this.doAction(menuOption, memberIndex);
            
            //Checks for a valid return and if goes to next if there is one
            if (memberIndex < 4 && done) {
                memberIndex++;
                prompt = "\nPlease enter next party member's name: ";
                done = false;
            }
            
        } while (!done);

        //Go to the next view when done
        displayNextView();
    }

    private String getMemberName() {
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is entered
            System.out.println("\n");
            for (int i = 0; i < 7; i++) {
              System.out.println(this.menu[i]);
            }
            
            System.out.println(this.prompt);
        
            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim off leading and trailing blanks
            
            if (value.length() <1) { // value is blank
                System.out.println("\nInvalid value: value can not be blank");
            } else {          
                valid = true; // end the loop
            }
        }
        
        return value; // return the value entered
    }

    private boolean doAction(String memberName, int memberIndex) {
        if (memberName.length() < 2) {
            System.out.println("\nInvalid players name: "
                + "The name must be greater than one character in length");
            return false;
        }
        
        PartyMember partyMember = new PartyMember();
        partyMember.setName(memberName);
        
        Game game = OregonTrail.getCurrentGame();
        game.setPartyMembers(partyMember, memberIndex);
        
        this.menu[memberIndex + 1] = this.menu[memberIndex + 1] + " " + memberName;
        
        return true; // success !
    }    
    
    private void displayNextView() {
        System.out.println("\n**** displayNextView *****");
    }
}
