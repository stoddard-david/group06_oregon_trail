/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.view.ViewInterface.View;

/**
 *
 * @author Stoddard
 */
public class EndView extends View{
    
     public EndView() {
        super("\n"
                  + "\n-------------------------------------------"
                  + "\n| YOU MADE IT TO OREGON                   |"
                  + "\n-------------------------------------------"
                  + "\n"
                  + "\nPress any key to quit");        
    }
    
    @Override
    public boolean doAction(String choice) {
        return true;
    }
}
