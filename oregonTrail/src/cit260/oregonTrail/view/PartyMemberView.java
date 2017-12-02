/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.PartyMemberControl;
import cit260.oregonTrail.exception.PartyMemberControlException;
import cit260.oregonTrail.model.Game;
import cit260.oregonTrail.view.ViewInterface.View;
import cit260.oregonTrail.model.PartyMember;
import oregontrail.OregonTrail;

/**
 *
 * @author Stoddard
 */
public class PartyMemberView extends View {
    
    String menuMessage;
    PartyMember[] partyMembers;
    
    public PartyMemberView() {
        super("ERROR VIEWING MEMBERS: ENTER Q TO QUIT VIEW");
        
        this.menuMessage="\n-------------------------------------------"
                  + "\n1 - Original Sort"
                  + "\n2 - Sort Names"
                  + "\n3 - Sort Health"
                  + "\n4 - Save Current Status"
                  + "\n5 - Load Previous Status"
                  + "\nQ - Quit"
                  + "\n-------------------------------------------";
        
        this.partyMembers = new PartyMember[5];
        
        try {
          originalPartyMembers();
          setMenuText();
        } catch (Throwable te) {
          ErrorView.display(this.getClass().getName(), te.getMessage());
        }
    }
    
    private void setMenuText() {
        String message = "\n-------------------------------------------";

        for (PartyMember member : this.partyMembers) {
            message = message + "\n" + member.getName() + ": " + member.getHealth();
        }
        
        this.displayMessage = message + this.menuMessage;
    }

    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // convert choice to upper case

        
        switch (choice) {
            case "1": // Orginal sort
                 try {
                   originalPartyMembers();
                 } catch (Throwable te) {
                   ErrorView.display(this.getClass().getName(), te.getMessage());
                 }
                 break;
            case "2": // Sort Names
                try {
                   this.partyMembers = PartyMemberControl.sortByName(this.partyMembers);
                } catch (PartyMemberControlException me) {
                   ErrorView.display(this.getClass().getName(), me.getMessage());
                } catch (Throwable te) {
                   ErrorView.display(this.getClass().getName(), te.getMessage());
                }
                break;
            case "3": // Sort Health
                try {
                   this.partyMembers = PartyMemberControl.sortByHealth(this.partyMembers);
                } catch (PartyMemberControlException me) {
                   ErrorView.display(this.getClass().getName(), me.getMessage());
                } catch (Throwable te) {
                   ErrorView.display(this.getClass().getName(), te.getMessage());
                }
                break;
            case "4": // save the current game
                this.savePartyInfo();
                break;
            case "5": // save the current game
                this.loadPartyInfo();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
               break;
        }
        
        try {
          setMenuText();
        } catch (Throwable te) {
           ErrorView.display(this.getClass().getName(), te.getMessage());
        }
        return false;
    }
    
    public void originalPartyMembers() {
        Game game = OregonTrail.getCurrentGame();
        
        for (int i = 0; i < partyMembers.length; i++) {
          this.partyMembers[i] = game.getPartyMembers(i);
        }
    }

    private void savePartyInfo() {
        
        this.displayMessage = "\n\nEnter the file path for the file where the party "
                            + "information will be saved to.";

        String filePath = this.getInput();
     
        try { 
            PartyMemberControl.saveInfo(partyMembers, filePath);
            this.displayMessage = "\nSaved Sucessful"
                + "\n"
                + "\nPress any key to continue";
            String temp = this.getInput();
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }

        setMenuText();

    }
    
    private void loadPartyInfo() {

        this.displayMessage = "\n\nEnter the file path for the file where the party "
                            + "information will be loaded from.";

        String filePath = this.getInput();
        
        try {
            this.displayMessage = PartyMemberControl.loadInfo(filePath)
            + "\n"
            + "\nPress any key to continue";
            String temp = this.getInput();
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
                
        setMenuText();
        
    }
    
}
