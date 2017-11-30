/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.model.Game;
import cit260.oregonTrail.model.Location;
import cit260.oregonTrail.model.Map;
import cit260.oregonTrail.model.RegularSceneType;
import cit260.oregonTrail.model.SceneType;
import static jdk.nashorn.internal.objects.NativeArray.map;
import oregontrail.OregonTrail;

/**
 *
 * @author Stoddard
 */
public class MapView {
    
    private String mapImage;
    
    public void MapView() {
    }
    
    public void displayMapView() {
        Game game = OregonTrail.getCurrentGame();
        Map map = game.getMap();
        Location[][] locations = map.getLocation();
        
        RegularSceneType scene;
        int type;
        boolean visited;
        this.mapImage = "";

        for (int i = 0; i<locations.length; i++) {
            for(int j = 0; j<locations[i].length; j++) {
                
                scene = locations[i][j].getType();
                visited = locations[i][j].getVisited();
                if (scene != null) {
                    type = scene.getIndex();
                } else {
                    type = -1;
                }

                if (type == SceneType.Town.ordinal()) {
                    this.mapImage = mapImage + "o";
                } else if(type == SceneType.River.ordinal()) {
                    this.mapImage = mapImage + ",";
                } else if(type == SceneType.Landmark.ordinal()) {
                    this.mapImage = mapImage + "*";
                } else if(type == SceneType.End.ordinal()) {
                    this.mapImage = mapImage + "X";
                } else if(type == SceneType.Mountain.ordinal()) {
                    this.mapImage = mapImage + "^";
                } else if(type == SceneType.Trail.ordinal()) {
                    if (visited) {
                        this.mapImage = mapImage + "-";
                    } else {
                        this.mapImage = mapImage + ".";
                    }
                } else {
                    this.mapImage = mapImage + " ";
                }
            }
            this.mapImage = mapImage + "\n";
        }

        System.out.println("\n");
        System.out.println(this.mapImage);
        
        System.out.println("-------------------------------------------"
                  + "\n|                 KEY                     |"
                  + "\n-------------------------------------------"
                  + "\n| o Town/Fort           * Landmark        |"
                  + "\n| . Untraveled Trail    - Traveled Trail  |"
                  + "\n| ^ Mountain            , River           |"
                  + "\n| X Oregon                                |"
                  + "\n-------------------------------------------");

    }
    
}
