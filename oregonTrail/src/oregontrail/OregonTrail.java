/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oregontrail;

import cit260.oregonTrail.exception.GameControlException;
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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Stoddard
 */
public class OregonTrail {
    

    /**
     * @param args the command line arguments
     */
    
    private static Game currentGame = null;
    private static Player player = null;
    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        OregonTrail.logFile = logFile;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        OregonTrail.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        OregonTrail.inFile = inFile;
    }
    

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
    
    
    
    public static void main(String[] args) throws GameControlException {
        
        // create StartProgramViewOrig and display the start program view
        StartProgramView startProgramView = new StartProgramView();
        
        try {
            
            OregonTrail.inFile = new BufferedReader(new InputStreamReader(System.in));
            
            OregonTrail.outFile = new PrintWriter(System.out, true);
            
            String filePath = "log.txt";
            OregonTrail.logFile = new PrintWriter(filePath);
            
            startProgramView.displayStartProgramView();
        } catch (Throwable e) {
                System.out.println("Exception: " + e.toString() +
                                   "\nCause: " + e.getCause() +
                                   "\nMessage: " + e.getMessage());
    
                e.printStackTrace();
                startProgramView.displayStartProgramView();
        }
        
        finally {
            try {
                if (OregonTrail.inFile != null)
                    OregonTrail.inFile.close();
                
                if (OregonTrail.outFile != null)
                    OregonTrail.outFile.close();
                
                if (OregonTrail.logFile != null)
                    OregonTrail.logFile.close();
            } catch (IOException ex) {
                System.out.println("Error closing files");
                return;
            }
            
        }
        
        

    }
    
    
    
}
