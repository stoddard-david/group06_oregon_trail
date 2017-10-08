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
    
    PartyLeader("You","You are the party leader. Don't fail your team."),
    Member1("Spouse","Your loving spouse."),
    Member2("Girl","She loves dolls."),
    Member3("Boy","Loves to play cowboys and indians."),
    Member4("Baby","Wants mommy all the time."),
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
