package com.ilkun.textprocessing;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexander-ilkun
 */
public class Sentence {
    
    private final List<PartOfSentence> tokens = new ArrayList<>();

    public void add(PartOfSentence pofs) {
        tokens.add(pofs);
    }

    public List<PartOfSentence> getTokens() {
        return tokens;
    }

}
