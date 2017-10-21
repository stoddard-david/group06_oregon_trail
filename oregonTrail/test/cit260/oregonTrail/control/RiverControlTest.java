/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dglinzey
 */
public class RiverControlTest {
    
    public RiverControlTest() {
    }

    /**
     * Test of calcRiverSuccess method, of class RiverControl.
     */
    @Test
    public void testCalcRiverSuccess() {
        System.out.println("calcRiverSuccess1");
        int currentDepth = 5;
        int minDepth = 1;
        int maxDepth = 30;
        int currentWidth = -1;
        int minWidth = 1;
        int maxWidth = 200;
        boolean expResult = true;
        boolean result = RiverControl.calcRiverSuccess(currentDepth, maxDepth, currentWidth, maxWidth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("calcRiverSuccess2");
        currentDepth = -1;
        minDepth = 1;
        maxDepth = 30;
        currentWidth = 50;
        minWidth = 1;
        maxWidth = 200;
        expResult = true;
        result = RiverControl.calcRiverSuccess(currentDepth, maxDepth, currentWidth, maxWidth);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
