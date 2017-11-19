/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.PartyMemberControl;
import cit260.oregonTrail.model.Game;
import cit260.oregonTrail.view.ViewInterface.View;
import cit260.oregonTrail.model.PartyMember;
import oregontrail.OregonTrail;

/**
 *
 * @author Stoddard
 */
public class PartyMemberView  extends View {
    
    String menuMessage;
    PartyMember[] partyMembers;
    
    public PartyMemberView() {
        super("");
        
        this.menuMessage="\n-------------------------------------------"
                  + "\n1 - Original Sort"
                  + "\n2 - Sort Names"
                  + "\n3 - Sort Health"
                  + "\nQ - Quit"
                  + "\n-------------------------------------------";
        
        this.partyMembers = new PartyMember[5];
        
        originalPartyMembers();
        setMenuText();
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
               originalPartyMembers();
               break;
            case "2": // Sort Names
               this.partyMembers = PartyMemberControl.sortByName(this.partyMembers);
               break;
            case "3": // Sort Health
               this.partyMembers = PartyMemberControl.sortByHealth(this.partyMembers);
               break;
            default:
               System.out.println("\n*** Invalid selection *** Try again");
               break;
        }
        
        setMenuText();
        return false;
    }
    
    public void originalPartyMembers() {
        Game game = OregonTrail.getCurrentGame();
        
        for (int i = 0; i < partyMembers.length; i++) {
          this.partyMembers[i] = game.getPartyMembers(i);
        }
    }
   
}
