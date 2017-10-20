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
public class HuntingControlTest {
    
    public HuntingControlTest() {
    }

    /**
     * Test of calcHuntingControl method, of class HuntingControl.
     */
    @Test
    public void testCalcHuntingControl() {
        System.out.println("calcHuntingControl Test1");
        double speed = 2.0;
        double distanceToAnimal = 150.0;
        double timer = 1.5;
        boolean expResult = false;
        boolean result = HuntingControl.calcHuntingControl(speed, distanceToAnimal, timer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("calcHuntingControl Test2");
        speed = 1.2;
        distanceToAnimal = 100.0;
        timer = 2.0;
        expResult = true;
        result = HuntingControl.calcHuntingControl(speed, distanceToAnimal, timer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("calcHuntingControl Test3");
        speed = 0;
        distanceToAnimal = 75.0;
        timer = 0.5;
        expResult = false;
        result = HuntingControl.calcHuntingControl(speed, distanceToAnimal, timer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("calcHuntingControl Test4");
        speed = 4.0;
        distanceToAnimal = 0.0;
        timer = 3.0;
        expResult = false;
        result = HuntingControl.calcHuntingControl(speed, distanceToAnimal, timer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("calcHuntingControl Test5");
        speed = 1.2;
        distanceToAnimal = 125.0;
        timer = -1.0;
        expResult = false;
        result = HuntingControl.calcHuntingControl(speed, distanceToAnimal, timer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("calcHuntingControl Test6");
        speed = 1.0;
        distanceToAnimal = 50.0;
        timer = 0.0;
        expResult = true;
        result = HuntingControl.calcHuntingControl(speed, distanceToAnimal, timer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("calcHuntingControl Test7");
        speed = 6.0;
        distanceToAnimal = 200.0;
        timer = 8.0;
        expResult = false;
        result = HuntingControl.calcHuntingControl(speed, distanceToAnimal, timer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
}
