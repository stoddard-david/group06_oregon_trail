/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.exception;

/**
 *
 * @author Stoddard
 */
public class PartyMemberControlException extends Exception {

    public PartyMemberControlException() {
    }

    public PartyMemberControlException(String string) {
        super(string);
    }

    public PartyMemberControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public PartyMemberControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public PartyMemberControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
