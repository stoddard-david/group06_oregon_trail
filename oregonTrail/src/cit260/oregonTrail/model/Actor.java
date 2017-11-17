/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.model;

/**
 *
 * @author Stoddard
 */
public enum Actor {
    
    GeneralStore1("David","David works at the first general store. He is here to sell you supplies. Get the best deals in town."),
    GeneralStore2("Erin","Erin works at a general store. He is here to sell you supplies. Get the best deals in town."),
    GeneralStore3("Max","Max works at a general store. He is here to sell you supplies. Get the best deals in town.");
        
    //class instance variables
    private final String name;
    private final String description;

    //constructor
    Actor(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //getter functions
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", description=" + description + '}';
    }
    
        
    
}
