package com.ilkun.textprocessing;

/**
 *
 * @author alexander-ilkun
 */
public class PunctuationMark extends PartOfSentence {
    
    private static final String regex = "(\\.|,|-|_|!|\\?)";
    
    public PunctuationMark(String mark) {
        super(mark);
    }

    public static boolean isPunctuationMark(String ch) {
        return ch.matches(regex);
    }

    @Override
    public int hashCode() {
        return token.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof PunctuationMark) {
            return token.equals(((PunctuationMark) o).token);
        } else {
            return false;
        }
    }

}
