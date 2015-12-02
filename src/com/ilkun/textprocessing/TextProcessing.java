package com.ilkun.textprocessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author alexander-ilkun
 */
public class TextProcessing {

    private List<Sentence> sentences = new ArrayList<>();

    public TextProcessing(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int currentCharacter = 0;
            StringBuilder currentWord = new StringBuilder();
            Sentence sent = new Sentence();
            while ((currentCharacter = br.read()) != -1) { // reading file by one character
                if (currentWord.length() != 0 && !Character.isAlphabetic(currentCharacter)) {
                    sent.add(new Word(currentWord.toString()));
                    currentWord.delete(0, currentWord.length()); // clearing word
                } 
                if (Character.isWhitespace(currentCharacter)) {
                    sent.add(new Char(((char) currentCharacter) + ""));
                }
                if (PunctuationMark.isPunctuationMark(((char) currentCharacter) + "")) {
                    sent.add(new PunctuationMark(((char) currentCharacter) + ""));
                    if (((char) currentCharacter) == '.') {
                        sentences.add(sent);
                        sent = new Sentence();
                    }
                }
                if (Character.isAlphabetic(currentCharacter)) {
                    currentWord.append((char) currentCharacter);
                }
            }

        } catch (IOException ex) {
            System.out.println("File not found!");
        }
    }

    public List<Word> getSortedByVowels() {
        List<Word> dictionary;
        Set<Word> HSDictionary = new HashSet<>();
        for (Sentence sent : sentences) {
            for (PartOfSentence pofs : sent.getTokens()) {
                if (pofs instanceof Word) {
                        HSDictionary.add((Word) pofs);
                }
            }
        }
        dictionary = new ArrayList<>(HSDictionary);
        Collections.sort(dictionary, (Word o1, Word o2) -> Double.compare(o1.getRatio(), o2.getRatio()));
        return dictionary;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Sentence sent : sentences) {
            for (PartOfSentence pofs : sent.getTokens()) {
                result.append(pofs.toString());
            }

        }
        return result.toString();
    }

    public static void main(String[] args) {
        TextProcessing tp = new TextProcessing("test.txt");
        System.out.println(tp);
        for (Word word : tp.getSortedByVowels()) {
            System.out.println(word + " " + word.getRatio());
        }
    }

}
