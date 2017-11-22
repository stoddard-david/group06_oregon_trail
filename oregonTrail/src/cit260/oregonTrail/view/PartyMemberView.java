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
public class PartyMemberView  extends View {
    
    String menuMessage;
    PartyMember[] partyMembers;
    
    public PartyMemberView() {
        super("ERROR VIEWING MEMBERS: ENTER Q TO QUIT VIEW");
        
        this.menuMessage="\n-------------------------------------------"
                  + "\n1 - Original Sort"
                  + "\n2 - Sort Names"
                  + "\n3 - Sort Health"
                  + "\nQ - Quit"
                  + "\n-------------------------------------------";
        
        this.partyMembers = new PartyMember[5];
        
        try {
          originalPartyMembers();
          setMenuText();
        } catch (Throwable te) {
          System.out.println(te.getMessage());
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
        
        //For Invalid testing
        this.partyMembers = new PartyMember[0];
        
        switch (choice) {
            case "1": // Orginal sort
                 try {
                   originalPartyMembers();
                 } catch (Throwable te) {
                   System.out.println(te.getMessage());
                 }
                 break;
            case "2": // Sort Names
                 try {
                 this.partyMembers = PartyMemberControl.sortByName(this.partyMembers);
                } catch (PartyMemberControlException me) {
                   System.out.println(me.getMessage());
                } catch (Throwable te) {
                   System.out.println(te.getMessage());
                }
                break;
            case "3": // Sort Health
                try {
                    this.partyMembers = PartyMemberControl.sortByHealth(this.partyMembers);
                } catch (PartyMemberControlException me) {
                   System.out.println(me.getMessage());
                } catch (Throwable te) {
                   System.out.println(te.getMessage());
                }
                break;
            default:
               System.out.println("\n*** Invalid selection *** Try again");
               break;
        }
        
        try {
          setMenuText();
        } catch (Throwable te) {
           System.out.println(te.getMessage());
        }
        return false;
    }
    
    public void originalPartyMembers() {
        Game game = OregonTrail.getCurrentGame();
        
        for (int i = 0; i < partyMembers.length; i++) {
          this.partyMembers[i] = game.getPartyMembers(i);
        }
    }
   
}
