package com.ilkun.textprocessing;

/**
 *
 * @author alexander-ilkun
 */
public class Char extends PartOfSentence {
    
    public Char(String ch) {
        super(ch);
    }

    @Override
    public int hashCode() {
        return token.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Char) {
            return token.equals(((Char) o).token);
        } else {
            return false;
        }
    }

}
