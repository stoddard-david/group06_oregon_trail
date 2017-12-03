/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.control;

import cit260.oregonTrail.exception.MapControlException;
import cit260.oregonTrail.model.Game;
import cit260.oregonTrail.model.Map;
import java.util.Random;
import cit260.oregonTrail.model.PartyMember;
import cit260.oregonTrail.model.Location;
import cit260.oregonTrail.model.RegularSceneType;
import cit260.oregonTrail.model.SceneType;
import cit260.oregonTrail.view.TownView;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import oregontrail.OregonTrail;

/**
 *
 * @author dglinzey
 */
public class MapControl {

    public static int move(int pace, PartyMember[] partyMemberArray) throws MapControlException {

        int totalHealth = 0;
        int partyCount = 0;
        
        //Option 1,2 or 3 must be choosen
        if(pace < 1 || pace > 3) {
            throw new MapControlException("Pace is not within acceptable range. Pace entered was: " + pace);
        }
        
        //The party member must be alive (health greater than 0)
        if (partyMemberArray[0].getHealth() == 0) {
            throw new MapControlException("Party leader is dead");
        }

        //There must be 5 party members in the array
        if (partyMemberArray.length != 5) {
            throw new MapControlException("Party does not have 5 party members. Party has: " + partyMemberArray.length);
        }

        //Cycle through each of the ParyMembers to get the average health of alive members
        for (int i=0; i<5; i++) {
            
            //Checks to make sure the health is valid
            if (partyMemberArray[i].getHealth() < 0 || partyMemberArray[i].getHealth() > 100) {
                throw new MapControlException("Party member does not have valid health. Party member has health: " + partyMemberArray[i].getHealth());
            }
            
            if (partyMemberArray[i].getHealth() > 0) {
                totalHealth += partyMemberArray[i].getHealth();
                partyCount++;
            }
        }
        
        //Make sure there is atleast one party member alive
        if (partyCount == 0) {
            throw new MapControlException("All party members are dead. You beat the secret game.");
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
    
    public static Map createMap(int width, int height) throws MapControlException {
     
        if (width < 0 || height < 0) {
            throw new MapControlException("Invalid Map size. Height is: " + height + " Width is: " + width);
        }
        
        Map map = new Map();
        map.setHeight(height);
        map.setWidth(width);
        
        Location[][] locations = createLocations(width, height);
        map.setLocation(locations);
        
        RegularSceneType[] scenes = createScenes();        
        assignScenesToLocations(scenes, locations);
        
        Location[] path = createPath(locations);
        map.setPath(path);
        
        map.setMiles(0);
        
        return map;
    }

    private static Location[][] createLocations(int width, int height) throws MapControlException {

        if (width < 1 || height < 1) {
            throw new MapControlException("Invalid location. Height is: " + height + " Width is: " + width);
        }
        
        Location[][] locations = new Location[width][height];
        
        for (int i=0; i < width; i++) {
            for (int j=0; j < height; j++) {
                locations[i][j] = new Location(i,j);
            }
        }

        return locations; 
    }
    
    
    private static RegularSceneType[] createScenes() throws MapControlException {
        
        RegularSceneType[] scenes = new RegularSceneType[6];

        scenes[SceneType.Town.ordinal()] = new RegularSceneType();
        RegularSceneType town = scenes[SceneType.Town.ordinal()];
        town.setDescription("You can purchase supplies and get advice.");
        town.setIndex(SceneType.Town.ordinal());

        scenes[SceneType.Trail.ordinal()] = new RegularSceneType();
        RegularSceneType trail = scenes[SceneType.Trail.ordinal()];
        trail.setDescription("You can hunt while on the trail.");
        trail.setIndex(SceneType.Trail.ordinal());
       
        scenes[SceneType.River.ordinal()] = new RegularSceneType();
        RegularSceneType river = scenes[SceneType.River.ordinal()];
        river.setDescription("You must find a way to cross the river.");
        river.setIndex(SceneType.River.ordinal());
        
        scenes[SceneType.Landmark.ordinal()] = new RegularSceneType();
        RegularSceneType landmark = scenes[SceneType.Landmark.ordinal()];
        landmark.setDescription("You can enjoy the area and get advice.");
        landmark.setIndex(SceneType.Landmark.ordinal());

        scenes[SceneType.Mountain.ordinal()] = new RegularSceneType();
        RegularSceneType mountain = scenes[SceneType.Mountain.ordinal()];
        mountain.setDescription("Too steep to pass.");
        mountain.setIndex(SceneType.Mountain.ordinal());

        scenes[SceneType.End.ordinal()] = new RegularSceneType();
        RegularSceneType end = scenes[SceneType.End.ordinal()];
        end.setDescription("You have made it.");
        end.setIndex(SceneType.End.ordinal());
           
        return scenes;
    }

    private static void assignScenesToLocations( RegularSceneType[] scenes, Location[][] locations) throws MapControlException {

        RegularSceneType town = scenes[SceneType.Town.ordinal()];
        RegularSceneType trail = scenes[SceneType.Trail.ordinal()];
        RegularSceneType river = scenes[SceneType.River.ordinal()];
        RegularSceneType landmark = scenes[SceneType.Landmark.ordinal()];
        RegularSceneType mountain = scenes[SceneType.Mountain.ordinal()];
        RegularSceneType end = scenes[SceneType.End.ordinal()];

        locations[8][51].setName("Independence");
        locations[8][47].setName("Kansas River");
        locations[8][45].setName("Big Blue River");
        locations[7][43].setName("Fort Kearney");
        locations[6][40].setName("Chimney Rock");
        locations[6][36].setName("Fort Larame");
        locations[5][31].setName("Independence Rock");
        locations[5][28].setName("South Pass");
        locations[5][26].setName("Green River");
        locations[5][23].setName("Soda Springs");
        locations[5][20].setName("Fort Hall");
        locations[3][11].setName("Fort Boise");
        locations[3][10].setName("Snake River");
        locations[2][6].setName("Blue Mountain");
        locations[1][4].setName("The Dallas");
        locations[1][1].setName("Oregon City");

        locations[8][51].setType(town);
        locations[8][50].setType(trail);
        locations[8][49].setType(trail);
        locations[8][48].setType(trail);
        locations[8][47].setType(river);
        locations[8][46].setType(trail);
        locations[8][45].setType(river);
        locations[8][44].setType(trail);
        locations[7][43].setType(town);
        locations[7][42].setType(trail);
        locations[6][41].setType(trail);
        locations[6][40].setType(landmark);
        locations[6][39].setType(trail);
        locations[6][38].setType(trail);
        locations[6][37].setType(trail);
        locations[6][36].setType(town);
        locations[6][35].setType(trail);
        locations[6][34].setType(trail);
        locations[6][33].setType(trail);
        locations[5][32].setType(trail);
        locations[5][31].setType(landmark);
        locations[5][30].setType(trail);
        locations[5][29].setType(trail);
        locations[5][28].setType(landmark);
        locations[5][27].setType(trail);
        locations[5][26].setType(river);
        locations[5][25].setType(trail);
        locations[5][24].setType(trail);
        locations[5][23].setType(landmark);
        locations[5][22].setType(trail);
        locations[5][21].setType(trail);
        locations[5][20].setType(town);
        locations[5][19].setType(trail);
        locations[5][18].setType(trail);
        locations[5][17].setType(trail);
        locations[5][16].setType(trail);
        locations[5][15].setType(trail);
        locations[4][14].setType(trail);
        locations[4][13].setType(trail);
        locations[4][12].setType(trail);
        locations[3][11].setType(town);
        locations[3][10].setType(river);
        locations[3][9].setType(trail);
        locations[3][8].setType(trail);
        locations[2][7].setType(trail);
        locations[2][6].setType(landmark);
        locations[1][5].setType(trail);
        locations[1][4].setType(landmark);
        locations[1][3].setType(trail);
        locations[1][2].setType(trail);
        locations[1][1].setType(end);
        
        locations[0][1].setType(river);
        locations[0][17].setType(mountain);
        locations[0][32].setType(river);
        locations[0][33].setType(river);
        locations[0][34].setType(river);
        locations[0][35].setType(river);
        locations[0][36].setType(river);
        locations[0][37].setType(river);
        locations[0][38].setType(river);
        locations[1][8].setType(river);
        locations[1][9].setType(mountain);
        locations[1][10].setType(mountain);
        locations[1][16].setType(mountain);
        locations[1][18].setType(mountain);
        locations[1][28].setType(river);
        locations[1][29].setType(river);
        locations[1][30].setType(river);
        locations[1][31].setType(river);
        locations[1][39].setType(river);
        locations[1][40].setType(river);
        locations[2][9].setType(river);
        locations[2][13].setType(mountain);
        locations[2][16].setType(mountain);
        locations[2][19].setType(mountain);
        locations[2][27].setType(river);
        locations[2][42].setType(river);
        locations[2][43].setType(river);
        locations[2][44].setType(river);
        locations[3][14].setType(mountain);
        locations[3][18].setType(mountain);
        locations[3][20].setType(mountain);
        locations[3][21].setType(mountain);
        locations[3][44].setType(river);
        locations[4][10].setType(river);
        locations[4][17].setType(mountain);
        locations[4][19].setType(mountain);
        locations[4][21].setType(mountain);
        locations[4][26].setType(river);
        locations[4][38].setType(river);
        locations[4][39].setType(river);
        locations[4][40].setType(river);
        locations[4][41].setType(river);
        locations[4][42].setType(river);
        locations[4][43].setType(river);
        locations[4][44].setType(river);
        locations[4][45].setType(river);
        locations[5][0].setType(mountain);
        locations[5][11].setType(river);
        locations[5][12].setType(river);
        locations[5][13].setType(river);
        locations[5][35].setType(river);
        locations[5][36].setType(river);
        locations[5][37].setType(river);
        locations[5][46].setType(river);
        locations[6][0].setType(mountain);
        locations[6][1].setType(mountain);
        locations[6][14].setType(river);
        locations[6][18].setType(river);
        locations[6][19].setType(river);
        locations[6][20].setType(river);
        locations[6][21].setType(river);
        locations[6][26].setType(river);
        locations[6][44].setType(river);
        locations[6][47].setType(river);
        locations[7][3].setType(mountain);
        locations[7][4].setType(mountain);
        locations[7][15].setType(river);
        locations[7][16].setType(river);
        locations[7][17].setType(river);
        locations[7][21].setType(mountain);
        locations[7][23].setType(mountain);
        locations[7][26].setType(river);
        locations[7][45].setType(river);
        locations[7][47].setType(river);
        locations[8][3].setType(mountain);
        locations[8][20].setType(mountain);
        locations[8][22].setType(mountain);
        locations[8][27].setType(river);
        locations[8][28].setType(river);
        locations[8][29].setType(river);
        locations[8][30].setType(river);
        locations[9][4].setType(mountain);
        locations[9][21].setType(mountain);
        locations[9][24].setType(river);
        locations[9][25].setType(river);
        locations[9][26].setType(river);
        locations[9][42].setType(river);
        locations[9][43].setType(river);
        locations[9][44].setType(river);
        locations[9][45].setType(river);
        locations[9][46].setType(river);
        locations[9][47].setType(river);
        locations[9][48].setType(river);
        locations[9][49].setType(river);
        locations[9][50].setType(river);
        locations[9][51].setType(river);
        locations[9][52].setType(river);        
    }
    
    private static Location[] createPath(Location[][] locations) throws MapControlException {
        Location[] path = new Location[51];
        
        path[0]  = locations[8][51];
        path[1]  = locations[8][50];
        path[2]  = locations[8][49];
        path[3]  = locations[8][48];
        path[4]  = locations[8][47];
        path[5]  = locations[8][46];
        path[6]  = locations[8][45];
        path[7]  = locations[8][44];
        path[8]  = locations[7][43];
        path[9]  = locations[7][42];
        path[10] = locations[6][41];
        path[11] = locations[6][40];
        path[12] = locations[6][39];
        path[13] = locations[6][38];
        path[14] = locations[6][37];
        path[15] = locations[6][36];
        path[16] = locations[6][35];
        path[17] = locations[6][34];
        path[18] = locations[6][33];
        path[19] = locations[5][32];
        path[20] = locations[5][31];
        path[21] = locations[5][30];
        path[22] = locations[5][29];
        path[23] = locations[5][28];
        path[24] = locations[5][27];
        path[25] = locations[5][26];
        path[26] = locations[5][25];
        path[27] = locations[5][24];
        path[28] = locations[5][23];
        path[29] = locations[5][22];
        path[30] = locations[5][21];
        path[31] = locations[5][20];
        path[32] = locations[5][19];
        path[33] = locations[5][18];
        path[34] = locations[5][17];
        path[35] = locations[5][16];
        path[36] = locations[5][15];
        path[37] = locations[4][14];
        path[38] = locations[4][13];
        path[39] = locations[4][12];
        path[40] = locations[3][11];
        path[41] = locations[3][10];
        path[42] = locations[3][9];
        path[43] = locations[3][8];
        path[44] = locations[2][7];
        path[45] = locations[2][6];
        path[46] = locations[1][5];
        path[47] = locations[1][4];
        path[48] = locations[1][3];
        path[49] = locations[1][2];
        path[50]= locations[1][1];
        
        return path;
    }
    
    public static String getLocationName() throws MapControlException{
        String name = "";

        Game game = OregonTrail.getCurrentGame();
        Map map = game.getMap();
        Location[] path = map.getPath();
        
        int index = map.getMiles()/40;
        
        name = path[index].getName();
        
        return name;
    }
    
    public static void chooseLocationView() throws MapControlException {
        Game game = OregonTrail.getCurrentGame();
        Map map = game.getMap();
        Location[] path = map.getPath();
        RegularSceneType sceneType = new RegularSceneType();
                
        int index = 0;
        int sceneIndex;
        int miles = 0;
        
        boolean playing = true;
        
        while(playing) {

            index = map.getMiles()/40;
            sceneType = path[index].getType();
            sceneIndex = sceneType.getIndex();

            if (sceneIndex == SceneType.Town.ordinal() && !path[index].getVisited()) {
                path[index].setVisited(true);
                TownView townView = new TownView();
                townView.display();
            } else if (sceneIndex == SceneType.River.ordinal() && !path[index].getVisited()) {
                path[index].setVisited(true);
                TownView townView = new TownView();
                townView.display();
            } else if(sceneIndex == SceneType.Trail.ordinal() || path[index].getVisited()) {
                miles = move((int) game.getPace(), game.getPartyMembers()); 
                map.setMiles(map.getMiles() + miles);
                path[index].setVisited(true);
            } else {
                playing = false;
            }
          
        }
        
    }

    public static void createLocationsVisited() throws MapControlException{
        String[][] locationsVisited = new String[51][3];
        
        Game game = OregonTrail.getCurrentGame();
        Map map = game.getMap();
        Location[] path = map.getPath();
        RegularSceneType sceneType = new RegularSceneType(); 
        
//        for (int i = 0; i > locationsVisited[0].length; i++) {
//            path[i].getName();
//        }
//        
//        for (int i = 0; i > locationsVisited[1].length; i++) {
//            sceneType.getDescription();
//        }
//        
//        for (int i = 0; i > locationsVisited[2].length; i++) {
//            boolean visitCheck = path[i].getVisited();
//            
//
//        }
        
       
        out.printf("%n%-20s%-15s","Name", "Visited");
        out.printf("%n%-20s%-15s","----", "-------");
        
        for (Location path1 : path) {
            

            if (path1.getName() != null) {
                out.printf("%n%-20s%-15s", path1.getName(), path1.getVisited());
            }
        }
        
    }

    public static void saveLocationsVisited(String filepath) throws MapControlException{
         try (PrintWriter out = new PrintWriter(filepath)) {
             
            Game game = OregonTrail.getCurrentGame();
            Map map = game.getMap();
            Location[] path = map.getPath();
            RegularSceneType sceneType = new RegularSceneType();
            
            out.println("\n     Locations List      ");
            out.println("---------------------------");
            out.printf("%n%-20s%-15s","Name", "Visited");
            out.printf("%n%-20s%-15s","----", "-------");

            for (Location path1 : path) {


                if (path1.getName() != null) {
                    out.printf("%n%-20s%-15s", path1.getName(), path1.getVisited());
                }
            }
         } catch (IOException ex) {
             throw new MapControlException(ex.getMessage());
         }
    }
}
