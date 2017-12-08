/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.control.MapControl;
import cit260.oregonTrail.model.Game;
import cit260.oregonTrail.model.Location;
import cit260.oregonTrail.model.Map;
import cit260.oregonTrail.view.ViewInterface.View;
import oregontrail.OregonTrail;

/**
 *
 * @author erinsmith
 */
public class LocationsView extends View {
    
    public LocationsView() {
        
        super("\n"
                  + "\n-------------------------------------------"
                  + "\n| View Locations                          |"
                  + "\n-------------------------------------------"
                  + "\n1 - View Locations Visited/Not Visited"
                  + "\n2 - Save a Report of Locations Visited/Not Visited"
                  + "\nQ - Quit"
                  + "\n-------------------------------------------");
    }

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase(); // convert choice to upper case
       
        switch (choice) {
            case "1": 
                try {
                    MapControl.createLocationsVisited();
                }catch (Throwable te){
                    ErrorView.display(this.getClass().getName(), te.getMessage());
                }
                break;
            case "2": 
                try {
                    this.saveVisitedLocations();
//                    MapControl.saveLocationsVisited();
                }catch (Throwable te){
                    ErrorView.display(this.getClass().getName(), te.getMessage());
                }
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }

    private void saveVisitedLocations() {
    
        this.displayMessage = "\n\nEnter the file path for where you would like the Locations List saved.";
        
        String filepath = this.getInput();
        

        
        try {
            MapControl.saveLocationsVisited(filepath);

            this.displayMessage = "\nSave successful"
                    + "\n"
                    + "\nPress any key to continue";
            String temp = this.getInput();
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), ex.getMessage());
        }
        
    }

    
    
    


}
