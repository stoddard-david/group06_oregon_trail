/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.control;

import cit260.oregonTrail.model.PartyMember;

/**
 *
 * @author Stoddard
 */
public class PartyMemberControl {
    
    public static PartyMember[] sortByHealth(PartyMember[] partyMembers) {
        
        PartyMember tempMember = new PartyMember();
        
        for (int i=1; i < partyMembers.length; i++){
            for (int j=i; j > 0; j--) {
                if (partyMembers[j].getHealth() > partyMembers[j-1].getHealth()) {
                    tempMember = partyMembers[j];
                    partyMembers[j] = partyMembers[j-1];
                    partyMembers[j-1] = tempMember;
                } else {
                    break;
                }
            }            
        }
        
        return partyMembers;
    }
    
    public static PartyMember[] sortByName(PartyMember[] partyMembers) {
        
        PartyMember tempMember = new PartyMember();
        
        for (int i=1; i < partyMembers.length; i++){
            for (int j=i; j > 0; j--) {
                if (partyMembers[j].getName().compareTo(partyMembers[j-1].getName()) < 0) {
                    tempMember = partyMembers[j];
                    partyMembers[j] = partyMembers[j-1];
                    partyMembers[j-1] = tempMember;
                } else {
                    break;
                }
            }            
        }
        
        return partyMembers;
    }
    
}
