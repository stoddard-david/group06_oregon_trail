/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.control;

import cit260.oregonTrail.model.Player;
import java.util.Random;
import oregontrail.OregonTrail;
/**
 *
 * @author dglinzey
 */
public class GameControl {
    
    public static void createNewGame(Player player) {
        System.out.println("\n*** called createNewGame function ***");
    }
    
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
    
    public static int changePace(int option) {
        if (option >= 1 &&  option <= 3) {
            return option;
        } else {
            return -1;
        }        
    }
    
    public static int changeRations(int option) {
        if (option >= 1 &&  option <= 3) {
            return option;
        } else {
            return -1;
        }
    }
    
    public static void eventChance() {
        
    }
    
    public static boolean fixedItem() {
        Random rand = new Random();
        int chance = rand.nextInt(100)+1;

        return (chance >= 75);
    }

    public static Player createPlayer(String name) {
        
        if (name == null) {
            return null;
        }
        
        Player player = new Player();
        player.setName(name);
        
        OregonTrail.setPlayer(player); // save the player
        
        return player;
    }
    
}
