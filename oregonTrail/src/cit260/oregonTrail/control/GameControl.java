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
import cit260.oregonTrail.view.ErrorView;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;
import oregontrail.OregonTrail;
/**
 *
 * @author dglinzey
 */
public class GameControl {
    
    public static void saveGame(Game game, String filepath) throws GameControlException {
        try( FileOutputStream fops = new FileOutputStream(filepath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(game);
        } catch (Exception e) {
            throw new GameControlException(e.getMessage());
        }
    }

    public static void loadGame(String filepath) throws GameControlException {
        Game game = null;
        
        try( FileInputStream fips = new FileInputStream(filepath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            
            game = (Game) input.readObject();
        } catch (Exception e) {
            throw new GameControlException(e.getMessage());
        }
        
        OregonTrail.setCurrentGame(game);
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
                date++;
                return date;
        }
    }
    
    public static String getHumanDate(int date) {
        String textDate = "";
        
        int month = date/100;
        int day = date%100;

        switch (month) {
            case 1:
                textDate = "January ";
                break;
            case 2:
                textDate = "February ";
                 break;
           case 3:
                textDate = "March ";
                break;
            case 4:
                textDate = "April ";
                break;
            case 5:
                textDate = "May ";
                break;
            case 6:
                textDate = "June ";
                break;
            case 7:
                textDate = "July ";
                break;
            case 8:
                textDate = "August ";
                break;
            case 9:
                textDate = "September ";
                break;
            case 10:
                textDate = "October ";
                break;
            case 11:
                textDate = "November ";
                break;
            case 12:
                textDate = "December ";
                break;
            default:
                textDate = "Unknown ";
        }

        if ((day >= 4 && day <= 20) || (day >= 24 && day <= 30)){
            textDate = textDate + day + "th";
        } else if (day == 1 || day == 21 || day == 31 ){
            textDate = textDate + day + "st";
        } else if (day == 2 || day == 22){
            textDate = textDate + day + "nd";
        } else if (day == 3 || day == 23){
            textDate = textDate + day + "nd";
        } else {
            textDate = textDate + day;
        }
        
        return textDate;
    }
    
    public static void changePace(int option) throws GameControlException {
        if (option >= 1 &&  option <= 3) {
            Game game = OregonTrail.getCurrentGame();
            game.setPace(option);
        } else {
            throw new GameControlException("changePace option out of acceptable range.");
        }        
    }
    
    public static void changeRations(int option) throws GameControlException {
        if (option >= 1 &&  option <= 3) {
            Game game = OregonTrail.getCurrentGame();
            game.setRations(option);
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
        game.setPace(1);
        game.setRations(1);

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
            ErrorView.display("createNewGame - ", "Error creating map: " + me.getMessage());
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
