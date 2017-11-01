/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.model;

import java.io.Serializable;

/**
 *
 * @author Stoddard
 */
public class Game implements Serializable {
    
    //class instance variables
    private boolean soundToggle;
    private int date;
    private float pace;
    private float rations;
    private int id;
    private int score;
    private Player player;
    private PartyLeader partyLeader;
    private PartyMember[] partyMembers;

    //constructor
    public Game() {
        partyMembers = new PartyMember[5];
    }

    //setter and getter functions
    public boolean isSoundToggle() {
        return soundToggle;
    }

    public void setSoundToggle(boolean soundToggle) {
        this.soundToggle = soundToggle;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public float getPace() {
        return pace;
    }

    public void setPace(float pace) {
        this.pace = pace;
    }

    public float getRations() {
        return rations;
    }

    public void setRations(float rations) {
        this.rations = rations;
    }

    public float getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    } 
    
    //class getter and setter
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public PartyLeader getPartyLeader() {
        return partyLeader;
    }
    
    public void setPartyLeader(PartyLeader partyLeader) {
        this.partyLeader = partyLeader;
    }  
    
    public PartyMember getPartyMembers(int partyMemberIndex) {
        return partyMembers[partyMemberIndex];
    }
    
    public void setPartyMembers(PartyMember partyMembers, int partyMemberIndex) {
        this.partyMembers[partyMemberIndex] = partyMembers;
    }  
    
    //hashcode functions
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.soundToggle ? 1 : 0);
        hash = 97 * hash + this.date;
        hash = 97 * hash + this.id;
        hash = 97 * hash + this.score;
        hash = 97 * hash + Float.floatToIntBits(this.pace);
        hash = 97 * hash + Float.floatToIntBits(this.rations);
        return hash;
    }

    //equals function
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.soundToggle != other.soundToggle) {
            return false;
        }
        if (this.date != other.date) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (this.score != other.score) {
            return false;
        }
        if (Float.floatToIntBits(this.pace) != Float.floatToIntBits(other.pace)) {
            return false;
        }
        if (Float.floatToIntBits(this.rations) != Float.floatToIntBits(other.rations)) {
            return false;
        }
        return true;
    }

    //toString function
    @Override
    public String toString() {
        return "Game{" + "soundToggle=" + soundToggle + ", date=" + date + ", pace=" + pace + ", rations=" + rations + ", id=" + id + ", score=" + score + '}';
    }

}
