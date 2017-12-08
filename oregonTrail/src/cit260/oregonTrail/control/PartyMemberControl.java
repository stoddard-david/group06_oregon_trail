/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.control;

import cit260.oregonTrail.exception.PartyMemberControlException;
import cit260.oregonTrail.model.InventoryItem;
import cit260.oregonTrail.model.PartyMember;
import cit260.oregonTrail.view.ErrorView;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import oregontrail.OregonTrail;

/**
 *
 * @author Stoddard
 */
public class PartyMemberControl {
    
    public static boolean changeHealth(PartyMember[] partyMembers, int pace, int rations, InventoryItem meat) throws PartyMemberControlException {
        if (partyMembers == null) {
            throw new PartyMemberControlException("Party members does not exsist.");
        }
        
         if (partyMembers.length == 0) {
            throw new PartyMemberControlException("There are no party members.");
        }
        
        int adjustHealth = 0;
        int numberDead = 0;
        Random rand = new Random();

        //For messages
        BufferedReader keyboard = OregonTrail.getInFile();
        PrintWriter console = OregonTrail.getOutFile();
        
        for (int i=0; i < partyMembers.length; i++){
            if (partyMembers[i].getHealth() > 0) {
                adjustHealth = rand.nextInt(7) - 3;
                
                switch (pace) {
                    case 1: 
                        adjustHealth = adjustHealth + 3;
                        break;
                    case 2:
                        break;
                    case 3: 
                        adjustHealth = adjustHealth - 3;
                        break;
                    default:
                        //Something else and you will die faster
                        adjustHealth = adjustHealth - 10;
                }
                
                //Check to see if we have food first
                if (meat.getQuantityOwned() > 0) {
                    switch (rations) {
                        case 1: 
                            adjustHealth = adjustHealth + 3;
                            break;
                        case 2:
                            break;
                        case 3: 
                            adjustHealth = adjustHealth - 3;
                            break;
                        default:
                            //Something else and you will die faster
                            adjustHealth = adjustHealth - 10;
                    } 
                } else {
                    //You are starving and losing health
                    adjustHealth = adjustHealth - 7;
                }
            
                partyMembers[i].setHealth(partyMembers[i].getHealth() + adjustHealth);
                
                if (partyMembers[i].getHealth() > 100) {
                    partyMembers[i].setHealth(100);
                }
                
                if (partyMembers[i].getHealth() <= 0) {
                    partyMembers[i].setHealth(0);
                    numberDead++;

                    //Message of death
                    console.println("\n" + partyMembers[i].getName() + " has died.");
                    console.println("Press any key to continue");
                    try {
                        keyboard.readLine(); // get next line typed on keyboard, used to pause
                    } catch (IOException ex) {
                        ErrorView.display("PartyMemberControl", "You must enter a value.");        
                    }
                }
            } else {
                numberDead++;
            }
        }
        
        if (numberDead >= 5) {
            console.println("\nEveryone has died. You have lost, please try again.");
            console.println("\nPress any key to continue");
            try {
                keyboard.readLine(); // get next line typed on keyboard, used to pause
            } catch (IOException ex) {
                ErrorView.display("PartyMemberControl", "You must enter a value.");        
            }
            return false;
        } else if (partyMembers[0].getHealth() == 0) {
            console.println("\nYour party leader has died. You have lost, please try again.");
            console.println("\nPress any key to continue");
            try {
                keyboard.readLine(); // get next line typed on keyboard, used to pause
            } catch (IOException ex) {
                ErrorView.display("PartyMemberControl", "You must enter a value.");        
            }
            return false;
        } else {
            return true;
        }
    }
    
    public static PartyMember[] sortByHealth(PartyMember[] partyMembers) throws PartyMemberControlException {
        
        PartyMember tempMember = new PartyMember();
        
        if (partyMembers == null) {
            throw new PartyMemberControlException("Party members does not exsist.");
        }
        
        if (partyMembers.length == 0) {
            throw new PartyMemberControlException("There are no party members.");
        }

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
    
    public static PartyMember[] sortByName(PartyMember[] partyMembers) throws PartyMemberControlException {
        
        PartyMember tempMember = new PartyMember();

        if (partyMembers == null) {
            throw new PartyMemberControlException("Party members does not exsist.");
        }
        
        if (partyMembers.length == 0) {
            throw new PartyMemberControlException("There are no party members.");
        }
        
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
    
    public static void saveInfo(PartyMember[] partyMembers, String filepath) throws PartyMemberControlException {
        try (PrintWriter out = new PrintWriter(filepath)) {
            
            //Print title and columns
            out.println("\n\n   Previous Party Information   ");
            out.printf("%n%-30s%6s","Name","Health");
            out.printf("%n%-30s%6s","---","------");
            
            for (PartyMember partyMember : partyMembers) {
                out.printf("%n%-30s%4d",partyMember.getName(),partyMember.getHealth());
            }
           
        } catch (IOException ex) {
            throw new PartyMemberControlException(ex.getMessage());
        }

    }

    public static String loadInfo(String filepath) throws PartyMemberControlException {
        String report = "";
        
        try (Scanner in = new Scanner(new FileReader(filepath))) {
            
            
            while (in.hasNextLine()) {
                report = report + "\n" + in.nextLine();
            }
            
        } catch (IOException ex) {
            throw new PartyMemberControlException(ex.getMessage());
        }
       
        return report;
    }
}
