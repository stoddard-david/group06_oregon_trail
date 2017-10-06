/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oregontrail;

import cit260.oregonTrail.model.Player;
import cit260.oregonTrail.model.Actor;

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
        
        String PlayerOneName = playerOne.getName();
        int PlayerOneScore = playerOne.getScore();
        
        System.out.println("Name " + PlayerOneName + " has a score of " + PlayerOneScore);
        System.out.println(playerOne.toString() + "\n");
        
        System.out.println(Actor.PartyLeader.getName() + " - " + Actor.PartyLeader.getDescription());
    }
    
}
