/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.control;

import cit260.oregonTrail.model.Map;
import java.util.Random;
import cit260.oregonTrail.model.PartyMember;
import cit260.oregonTrail.model.Location;
import cit260.oregonTrail.model.RegularSceneType;

/**
 *
 * @author dglinzey
 */
public class MapControl {

    public static int move(int pace, PartyMember[] partyMemberArray) {

        int totalHealth = 0;
        int partyCount = 0;
        
        //Option 1,2 or 3 must be choosen
        if(pace < 1 || pace > 3) {
            return -1;
        }
        
        //The party member must be alive (health greater than 0)
        if (partyMemberArray[0].getHealth() == 0) {
            return -1;
        }

        //There must be 5 party members in the array
        if (partyMemberArray.length != 5) {
            return -1;
        }

        //Cycle through each of the ParyMembers to get the average health of alive members
        for (int i=0; i<5; i++) {
            
            //Checks to make sure the health is valid
            if (partyMemberArray[i].getHealth() < 0 || partyMemberArray[i].getHealth() > 100) {
                return -1;
            }
            
            if (partyMemberArray[i].getHealth() > 0) {
                totalHealth += partyMemberArray[i].getHealth();
                partyCount++;
            }
        }
        
        //Make sure there is atleast one party member alive
        if (partyCount == 0) {
            return -1;
        }

        //Create and set a random number for the base distance form 10 to 15
        Random rand = new Random();
        int distance = rand.nextInt(6) + 10;
        
        /*pace setttings
        10-15 is steady - base (1X)
        15-22.5 is strenuous (1.5X)
        20-30 is grueling (2X)
        average health will produce a .75 (0 average health) to 1 (100 average health) multiplier, so if you are less healthy you travel slower*/

        double paceMultiplier = (double) ((double)(pace)*0.5 + 0.5);
        double healtMultiplier = (double) ((double)totalHealth /((double)partyCount*100.0)*.25  + .75);

        //change output floats then to int, May need to round, but will test when I program
        distance = (int)Math.round((double)(distance) * paceMultiplier * healtMultiplier);

        return distance;
    }
    
    public static Map createMap(int width, int height) {
      
        if (width < 0 || height < 0) {
            return null;
        }
        
        Map map = new Map();
        map.setHeight(height);
        map.setWidth(width);
        
        Location[][] locations = createLocations(width, height);
        //locations = createLocations(noOfRows, noOfColumns)
        
        //Assign the locations array to the map
        //scenes = createScenes()
  
        
        return map;
    }

    private static Location[][] createLocations(int width, int height) {
 
        if (width < 1 || height < 1) {
            return null;
        }
        
        Location[][] locations = new Location[width][height];
        
        for (int i=0; i < width; i++) {
            for (int j=0; j < height; j++) {
                locations[i][j] = new Location(i,j);
            }
        }

        return locations; 
    }
    
    private static RegularSceneType[] createScenes() {
        //scenes = Create an array Scene objects
        //scene1 = Create a new Scene object
        //Assign values to each attribute in the Scene object
        //Assign scene1 to its position in the scenes array
        //scene2 = Create a new ConstructionScene object
        //Assign values to each attribute in the Scene object
        //Assign scene2 to its position in the scenes array
        //scene2 = Create a new ResourceScene object
        //Assign values to each attribute in the Scene object
        //Assign scene2 to its position in the scenes array
        RegularSceneType[] scenes = new RegularSceneType[7];  
        
        return scenes;
    }

    private static void assignScenesToLocations( RegularSceneType[] scenes, Location[][] locations) {
        System.out.println("*** assignScenesToLocations function called ***");
    }
    
}
