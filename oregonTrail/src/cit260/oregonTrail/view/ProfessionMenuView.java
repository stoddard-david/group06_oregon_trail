/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.view;

import cit260.oregonTrail.view.ViewInterface.View;
import cit260.oregonTrail.control.GameControl;
import java.util.Scanner;

/**
 *
 * @author Stoddard
 */
public class ProfessionMenuView extends View {
    
    public ProfessionMenuView() {
        super("\n"
                  + "\n-------------------------------------------"
                  + "\n| Many kinds of people made the trip to   |"
                  + "\n| Oregon. Who will you be?                |"
                  + "\n-------------------------------------------"
                  + "\n1 - Be a banker from Boston"
                  + "\n2 - Be a carpenter from Ohio"
                  + "\n3 - Be a farmer from Illinois"
                  + "\n4 - Find out the differences between the choices"
                  + "\nQ - Quit"
                  + "\n-------------------------------------------");
    }

    @Override
    public boolean doAction(String choice) {
        
        boolean valid = true; //Stores if a valid option is choosen
        choice = choice.toUpperCase(); // convert choice to upper case
        
        switch (choice) {
            case "1": // Set the money and profession to banker
               GameControl.setGameProfession(1);
               displayNextView();
               break;
            case "2": // Set the money and profession to carpenter
               GameControl.setGameProfession(2);
               displayNextView();
               break;
            case "3": // Set the money and profession to farmer
               GameControl.setGameProfession(3);
               displayNextView();
               break;
            case "4": // View a help screen
               viewProfessionHelp();
               valid = false; //Sets the to invalid, so you can choose a valid profession
               break;
            default:
               System.out.println("\n*** Invalid selection *** Try again");
               valid = false; //Sets the answer to invalid answer to return
               break;
        }
        
        //Return if a valid choice was picked
        return valid;
    }
    
    private void viewProfessionHelp() {
        String helpProfession = "\n"
            + "\n-------------------------------------------"
            + "\nTraveling to Oregon isn't easy."
            + "\nThe banker has the most money for supplies"
            + "\nmaking the journey easier, but receives"
            + "\nfewer points. The farmer has the least"
            + "\namount of money making the journey harder,"
            + "\nbut provides the most points. The carpenter"
            + "\nis between the banker and farmer in money"
            + "\nand points."                
            + "\n-------------------------------------------"
            + "\n"
            + "\nPress any key to continue";
        
        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
        System.out.println(helpProfession); //Print the help
        keyboard.nextLine(); // get next line typed on keyboard, used to pause
    }
    
    private void displayNextView() {
        
        // Create MainMenuView object
        PartyCreationMenuView partyCreationMenuView = new PartyCreationMenuView();
                
        // Display the main menu view
        partyCreationMenuView.display();
    }
}
