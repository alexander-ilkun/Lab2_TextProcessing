package com.ilkun.textprocessing;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author alexander-ilkun
 */
public class Word extends PartOfSentence {
    
    private static final Set<Character> vowels = new HashSet<>();
    static {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('y');
    }
    
    private double ratio;
    
    public Word(String word) {
        super(word);
        int numberOfVowels = 0;
        for (char c: word.toCharArray()) {
            if (vowels.contains(Character.toLowerCase(c))) {
                numberOfVowels++;
            }
        }
        ratio = (double) (numberOfVowels) / word.length();
    }

    @Override
    public int hashCode() {
        return token.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Word) {
            return token.equals(((Word) o).token);
        } else {
            return false;
        }
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

}
