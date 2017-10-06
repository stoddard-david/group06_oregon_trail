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
    private Player player;

    //constructor
    public Game() {
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

    //class getter and setter
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }    
    
    //hashcode functions
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.soundToggle ? 1 : 0);
        hash = 97 * hash + this.date;
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
        return "Game{" + "soundToggle=" + soundToggle + ", date=" + date + ", pace=" + pace + ", rations=" + rations + '}';
    }

}