/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.control;

import cit260.oregonTrail.exception.RiverControlException;

/**
 *
 * @author dglinzey
 */
public class RiverControl {
    
    public static boolean calcRiverSuccess(int currentDepth, int maxDepth, int currentWidth, int maxWidth) throws RiverControlException {
    
        //get random multipliers
        double win = 1.5;
        double widthMultiplier = (Math.random() - 0.5) * 2;
        double depthMultiplier = (Math.random() - 0.5) * 2;
        
        double newWidth = currentWidth + (currentWidth * widthMultiplier);
        double newDepth = currentDepth + (currentDepth * depthMultiplier);
        
        //check if valid
        if (newWidth <= 0){
            return true;
        }
        if (newDepth <= 0){
            return true;
        }
        if (newWidth >= maxWidth){
            return false;
        }
        if (newDepth >= maxDepth){
            return false;
        }
        
        //calculations
        double riverSuccess = (newDepth * newWidth) / (currentDepth * currentWidth);
        if (riverSuccess >= win) {
            return true;
        }else{
            return false;
        }
    }
}
