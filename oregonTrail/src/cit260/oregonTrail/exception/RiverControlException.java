/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit260.oregonTrail.exception;

/**
 *
 * @author dglin
 */
public class RiverControlException extends Exception{

    public RiverControlException() {
    }

    public RiverControlException(String string) {
        super(string);
    }

    public RiverControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public RiverControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public RiverControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
