/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.control;

import cit260.oregonTrail.exception.GameControlException;
import cit260.oregonTrail.exception.MapControlException;
import cit260.oregonTrail.model.Player;
import cit260.oregonTrail.model.Game;
import cit260.oregonTrail.model.InventoryItem;
import cit260.oregonTrail.model.InventoryType;
import cit260.oregonTrail.model.Map;
import cit260.oregonTrail.model.PartyLeader;
import java.util.Random;
import oregontrail.OregonTrail;
/**
 *
 * @author dglinzey
 */
public class GameControl {
    
    public static void saveGame(int id) {
        
    }

    public static void loadGame(int id) {
        
    }

    public static void endGame() {
        
    }
    

    public static boolean toggleSound(boolean currentSound) {
        return !currentSound;
    }
    
    public static int changeDate(int date) {
        switch (date) {
            case 131:
                return 201;
            case 228:
                return 301;
            case 331:
                return 401;
            case 430:
                return 501;
            case 531:
                return 601;
            case 630:
                return 701;
            case 731:
                return 801;
            case 831:
                return 901;
            case 930:
                return 1001;
            case 1031:
                return 1101;
            case 1130:
                return 1201;
            case 1231:
                return 101;
            default:
                return date++;
        }
    }
    
    public static int changePace(int option) throws GameControlException {
        if (option >= 1 &&  option <= 3) {
            return option;
        } else {
            throw new GameControlException("changePace option out of acceptable range.");
        }        
    }
    
    public static int changeRations(int option) throws GameControlException {
        if (option >= 1 &&  option <= 3) {
            return option;
        } else {
            throw new GameControlException("changeRations option out of acceptable range.");
        }
    }
    
    public static void eventChance() {
        
    }
    
    public static boolean fixedItem() {
        Random rand = new Random();
        int chance = rand.nextInt(100)+1;

        return (chance >= 75);
    }

    public static Player createPlayer(String name) throws GameControlException {
        
        if (name == null) {
            throw new GameControlException("Player name is null.");
        }
        
        Player player = new Player();
        player.setName(name);
        
        OregonTrail.setPlayer(player); // save the player
        
        return player;
    }
    
    public static boolean createNewGame(Player player) throws MapControlException, GameControlException {

        if (player == null) {
            throw new GameControlException("Player name is null.");
        }        
        Game game = new Game();
        game.setPlayer(player);
        OregonTrail.setCurrentGame(game);
        
        if (game == null) {
            throw new GameControlException("game is null.");
        }

           
        InventoryItem[] items = createItems();
        for (int i=0; i<items.length; i++) {
            game.setInventoryItem(items[i], i);        
        }
        
        

        try {
            Map map = MapControl.createMap(10, 53);
            //Map map = MapControl.createMap(-10, 53);
            game.setMap(map);
        } catch (MapControlException me) {
            System.out.println(me.getMessage());
            return false;
        }
                
        
        return true;
    }

    public static InventoryItem[] createItems() {
        
        // 1 - Flour - $1
        // 2 - Meat - $5
        // 3 - Water - $.50
        // 4 - Oxen - $100
        // 5 - Wagon Parts - $25
        // 6 - Bullets - $10
        InventoryItem[] items = new InventoryItem[6];

        items[InventoryType.Flour.ordinal()] = new InventoryItem();
        InventoryItem flour = items[InventoryType.Flour.ordinal()];
        flour.setBaseCost((float) 1.00);
        flour.setMaxAmount(200);
        flour.setQuantityOwned(0);
        flour.setInventoryType("Flour");

        items[InventoryType.Meat.ordinal()] = new InventoryItem();
        InventoryItem meat = items[InventoryType.Meat.ordinal()];
        meat.setBaseCost((float) 5.00);
        meat.setMaxAmount(1000);
        meat.setQuantityOwned(0);
        meat.setInventoryType("Meat");

        items[InventoryType.Water.ordinal()] = new InventoryItem();
        InventoryItem water = items[InventoryType.Water.ordinal()];
        water.setBaseCost((float) 0.50);
        water.setMaxAmount(1000);
        water.setQuantityOwned(0);
        water.setInventoryType("Water");

        items[InventoryType.Oxen.ordinal()] = new InventoryItem();
        InventoryItem oxen = items[InventoryType.Oxen.ordinal()];
        oxen.setBaseCost((float) 100.00);
        oxen.setMaxAmount(8);
        oxen.setQuantityOwned(0);
        oxen.setInventoryType("Oxen");

        items[InventoryType.WagonParts.ordinal()] = new InventoryItem();
        InventoryItem wagonParts = items[InventoryType.WagonParts.ordinal()];
        wagonParts.setBaseCost((float) 25.00);
        wagonParts.setMaxAmount(5);
        wagonParts.setQuantityOwned(0);
        wagonParts.setInventoryType("Wagon Parts");

        items[InventoryType.Bullets.ordinal()] = new InventoryItem();
        InventoryItem bullets = items[InventoryType.Bullets.ordinal()];
        bullets.setBaseCost((float) 10.00);
        bullets.setMaxAmount(1000);
        bullets.setQuantityOwned(0);
        bullets.setInventoryType("Bullets");
        
        return items;
    }
    
    public static void setGameProfession(int profession) {
        // create a new game
        Game game = OregonTrail.getCurrentGame();
        PartyLeader partyLeader = new PartyLeader();

        partyLeader.setProfession(profession);

        switch (profession) {
            case 1: 
               partyLeader.setMoneyAmount(1600);
               break;
            case 2: 
               partyLeader.setMoneyAmount(800);
               break;
            case 3:
               partyLeader.setMoneyAmount(400);
               break;
            default:
               partyLeader.setMoneyAmount(0);
               break;
        }
        
        game.setPartyLeader(partyLeader);
    }
    
}
