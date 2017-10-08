/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.model;


/**
 *
 * @author erinsmith
 */
public class PartyLeader extends PartyMember{
    
    // class attribute variables
    private int moneyAmount;
    private int profession;
    
    // constructor 
    public PartyLeader() {
    }
    
    
    // getters and setters
    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(int moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public int getProfession() {
        return profession;
    }

    public void setProfession(int profession) {
        this.profession = profession;
    }
    
    // equals() and hashCode()
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.moneyAmount;
        hash = 67 * hash + this.profession;
        return hash;
    }

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
        final PartyLeader other = (PartyLeader) obj;
        if (this.moneyAmount != other.moneyAmount) {
            return false;
        }
        if (this.profession != other.profession) {
            return false;
        }
        return true;
    }
    
    // toString()

    @Override
    public String toString() {
        return "PartyLeader{" + "moneyAmount=" + moneyAmount + ", profession=" + profession + '}';
    }
    
    
    
}
