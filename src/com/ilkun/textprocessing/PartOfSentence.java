package com.ilkun.textprocessing;

/**
 *
 * @author alexander-ilkun
 */
public abstract class PartOfSentence {
    
    protected String token;

    public PartOfSentence(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return token;
    }
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
