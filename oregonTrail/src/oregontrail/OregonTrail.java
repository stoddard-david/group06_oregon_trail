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
import cit260.oregonTrail.model.Game;
import cit260.oregonTrail.model.RiverScene;
import cit260.oregonTrail.model.StoreScene;
import cit260.oregonTrail.view.StartProgramView;


/**
 *
 * @author Stoddard
 */
public class OregonTrail {

    /**
     * @param args the command line arguments
     */
    
    private static Game currentGame = null;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        OregonTrail.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        OregonTrail.player = player;
    }
    
    private static Player player = null;
    
    public static void main(String[] args) {
        
        // create StartProgramViewOrig and display the start program view
        StartProgramView startProgramView = new StartProgramView();
        
        try {
            startProgramView.displayStartProgramView();
        } catch (Throwable te) {
            System.out.println(te.getMessage());
            te.printStackTrace();
            startProgramView.displayStartProgramView();
        }
        
        

    }
    
}
