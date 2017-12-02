/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author dglinzey
 */
public class Location implements Serializable {
    
    //class instance variables
    private String name;
    private int coordinateWidth;
    private int coordinateHeight;
    private boolean visited;
    private RegularSceneType type;

    //Constructor
    public Location(int coordinateWidth, int coordinateHeight) {
        this.coordinateWidth = coordinateWidth;
        this.coordinateHeight = coordinateHeight;
        this.visited = false;
    }

    //Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoordinateWidth() {
        return coordinateWidth;
    }

    public void setCoordinateWidth(int coordinateWidth) {
        this.coordinateWidth = coordinateWidth;
    }

    public int getCoordinateHeight() {
        return coordinateHeight;
    }

    public void setCoordinateHeight(int coordinateHeight) {
        this.coordinateHeight = coordinateHeight;
    }

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    public RegularSceneType getType() {
        return type;
    }

    public void setType(RegularSceneType type) {
        this.type = type;
    }

  
    //hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.coordinateWidth);
        hash = 53 * hash + Objects.hashCode(this.coordinateHeight);
        hash = 53 * hash + Objects.hashCode(this.type);
        return hash;
    }

    //equals
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
        final Location other = (Location) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.coordinateWidth, other.coordinateWidth)) {
            return false;
        }
        if (!Objects.equals(this.coordinateHeight, other.coordinateHeight)) {
            return false;
        }
        return true;
    }

    //toString
    @Override
    public String toString() {
        return "Location{" + "name=" + name + ", coordinates=" + coordinateWidth + "," + coordinateHeight + ", type=" + type + "}";
    }
    
    
}
