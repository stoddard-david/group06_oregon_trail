/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oregontrail;

import cit260.oregonTrail.model.Player;
import cit260.oregonTrail.model.Actor;
import cit260.oregonTrail.model.InventoryItem;
import cit260.oregonTrail.model.PartyLeader;
import cit260.oregonTrail.model.PartyMember;

/**
 *
 * @author Stoddard
 */
public class OregonTrail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Player playerOne = new Player();
        
        playerOne.setName("Best Player");
        playerOne.setScore(0);
        
        // testing PartyMember class
        PartyMember partyMemberOne = new PartyMember();
        
        partyMemberOne.setName("Bob");
        partyMemberOne.setLocation("Oregon");
        partyMemberOne.setHealth(2);
        partyMemberOne.setStatus(1);
        
        // testing PartyLeader class
        PartyLeader partyLeaderOne = new PartyLeader();
        
        partyLeaderOne.setName("John");
        partyLeaderOne.setLocation("Utah");
        partyLeaderOne.setHealth(3);
        partyLeaderOne.setStatus(0);
        partyLeaderOne.setMoneyAmount(800);
        partyLeaderOne.setProfession(2);
        
        // testing InventoryItem class
        InventoryItem itemOne = new InventoryItem();
        
        itemOne.setPlayer(playerOne);
        itemOne.setInventoryType("oxen");
        itemOne.setBaseCost(40);
        itemOne.setMaxAmount(20);
        itemOne.setQuantityOwned(12);
        
        String PlayerOneName = playerOne.getName();
        int PlayerOneScore = playerOne.getScore();
        
        System.out.println("Name " + PlayerOneName + " has a score of " + PlayerOneScore);
        System.out.println(playerOne.toString() + "\n");
        
        System.out.println(Actor.PartyLeader.getName() + " - " + Actor.PartyLeader.getDescription());
        
        System.out.println(partyMemberOne.toString() + "\n");
        
        System.out.println(partyLeaderOne.toString() + "\n");
        
        System.out.println(itemOne.toString() + "\n");
    }
    
}
