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
import cit260.oregonTrail.model.Animal;
import cit260.oregonTrail.model.RegularSceneType;
import cit260.oregonTrail.model.HuntingScene;
import cit260.oregonTrail.model.AdviceScene;
import cit260.oregonTrail.model.RiverScene;
import cit260.oregonTrail.model.StoreScene;


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

        System.out.println(Actor.PartyLeader.getName() + " - " + Actor.PartyLeader.getDescription() + "\n");
        
        //Store scene test
        StoreScene store1 = new StoreScene();
        store1.setDescription("Welcome to the first General Store! Don't spend all your money in one place");
        String store1Description = store1.getDescription();
        System.out.println(store1Description + "\n");
        
        //River scene test
        RiverScene river1D = new RiverScene();
        RiverScene river1W = new RiverScene();
        river1D.setCurrentDepth(4);
        river1W.setCurrentWidth(15);
        int river1Depth = river1D.getCurrentDepth();
        int river1Width = river1W.getCurrentWidth();
        System.out.println("The river is " + river1Depth + " feet deep, and " + river1Width + " feet wide. Good Luck!" + "\n");
        
        //Advice Scene test
        AdviceScene help = new AdviceScene();
        help.setDescription("Better turn back!");
        String advice = help.getDescription();
        System.out.println(advice + "\n");
        
        RegularSceneType regularHunt = new RegularSceneType();
        regularHunt.setDescription("Hunting on the plains.");

        HuntingScene hunt = new HuntingScene();
        hunt.setTimer(2.5);
        hunt.setCurrentAnimal("Elk"); 
        hunt.setTotalMeat(13);
        hunt.setDistanceToAnimal(97.4);
        hunt.setRegularScene(regularHunt);
        
        System.out.println(regularHunt.toString());
        System.out.println(hunt.toString());
        System.out.println(Animal.Elk.getType() + " runs at " + Animal.Elk.getSpeed() + " the base rate. You can get " + Animal.Elk.getMinMeat()
                + " to " +  Animal.Elk.getMaxMeat() + " pounds.\n");        

    }
    
}
