/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.control;

import cit260.oregonTrail.exception.MapControlException;
import cit260.oregonTrail.model.PartyMember;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stoddard
 */
public class MapControlTest {
    
    public MapControlTest() {
    }

    /**
     * Test of move method, of class MapControl.
     */
    @Test
    public void testMove() throws MapControlException {

        PartyMember[] partyMemberArray = new PartyMember[5];
        
        for (int i=0; i<5; i++) {
            partyMemberArray[i] = new PartyMember();
        }
        
        int pace;
        int min;
        int max;
        int result;
        
        System.out.println("move Case 1");
        partyMemberArray[0].setHealth(75);
        partyMemberArray[1].setHealth(65);
        partyMemberArray[2].setHealth(60);
        partyMemberArray[3].setHealth(40);
        partyMemberArray[4].setHealth(80);
        pace = 1;
        min = 9;
        max = 14;
        
        result = MapControl.move(pace, partyMemberArray);
        assertTrue(result >= min && result <= max);
        System.out.println("Result Case 1: " + result + "\n");

        //Next Case.
        System.out.println("move Case 2");
        partyMemberArray[0].setHealth(90);
        partyMemberArray[1].setHealth(30);
        partyMemberArray[2].setHealth(0);
        partyMemberArray[3].setHealth(15);
        partyMemberArray[4].setHealth(20);
        pace = 2;
        min = 13;
        max = 19;
        
        result = MapControl.move(pace, partyMemberArray);
        System.out.println("Result Case 2: " + result + "\n");
        assertTrue(result >= min && result <= max);
        
        //Next Case.
        System.out.println("move Case 3");
        partyMemberArray[0].setHealth(60);
        partyMemberArray[1].setHealth(50);
        partyMemberArray[2].setHealth(45);
        partyMemberArray[3].setHealth(65);
        partyMemberArray[4].setHealth(30);
        pace = 0;
        min = -1;
        max = -1;
        
        result = MapControl.move(pace, partyMemberArray);
        assertTrue(result >= min && result <= max);
        System.out.println("Result Case 3: " + result + "\n");
        
        //Next Case.
        System.out.println("move Case 4");
        partyMemberArray[0].setHealth(10);
        partyMemberArray[1].setHealth(15);
        partyMemberArray[2].setHealth(80);
        partyMemberArray[3].setHealth(75);
        partyMemberArray[4].setHealth(90);
        pace = 4;
        min = -1;
        max = -1;
        
        result = MapControl.move(pace, partyMemberArray);
        assertTrue(result >= min && result <= max);
        System.out.println("Result Case 4: " + result + "\n");

        //Next Case.
        System.out.println("move Case 5");
        partyMemberArray[0].setHealth(0);
        partyMemberArray[1].setHealth(95);
        partyMemberArray[2].setHealth(20);
        partyMemberArray[3].setHealth(10);
        partyMemberArray[4].setHealth(70);
        pace = 1;
        min = -1;
        max = -1;
        
        result = MapControl.move(pace, partyMemberArray);
        assertTrue(result >= min && result <= max);
        System.out.println("Result Case 5: " + result + "\n");

        //Next Case.
        System.out.println("move Case 6");
        partyMemberArray[0].setHealth(65);
        partyMemberArray[1].setHealth(-1);
        partyMemberArray[2].setHealth(20);
        partyMemberArray[3].setHealth(55);
        partyMemberArray[4].setHealth(75);
        pace = 2;
        min = -1;
        max = -1;
        
        result = MapControl.move(pace, partyMemberArray);
        assertTrue(result >= min && result <= max);
        System.out.println("Result Case 6: " + result + "\n");

        //Next Case.
        System.out.println("move Case 7");
        partyMemberArray[0].setHealth(100);
        partyMemberArray[1].setHealth(45);
        partyMemberArray[2].setHealth(150);
        partyMemberArray[3].setHealth(35);
        partyMemberArray[4].setHealth(60);
        pace = 3;
        min = -1;
        max = -1;
        
        result = MapControl.move(pace, partyMemberArray);
        assertTrue(result >= min && result <= max);
        System.out.println("Result Case 7: " + result + "\n");

        //Next Case.
        System.out.println("move Case 8");
        partyMemberArray[0].setHealth(1);
        partyMemberArray[1].setHealth(0);
        partyMemberArray[2].setHealth(0);
        partyMemberArray[3].setHealth(0);
        partyMemberArray[4].setHealth(0);
        pace = 1;
        min = 8;
        max = 11;
        
        result = MapControl.move(pace, partyMemberArray);
        assertTrue(result >= min && result <= max);
        System.out.println("Result Case 8: " + result + "\n");

        //Next Case.
        System.out.println("move Case 9");
        partyMemberArray[0].setHealth(100);
        partyMemberArray[1].setHealth(100);
        partyMemberArray[2].setHealth(100);
        partyMemberArray[3].setHealth(100);
        partyMemberArray[4].setHealth(100);
        pace = 3;
        min = 20;
        max = 30;
        
        result = MapControl.move(pace, partyMemberArray);
        assertTrue(result >= min && result <= max);
        System.out.println("Result Case 9: " + result + "\n");
    }
    
}
