package com.intentgraph.domain;

import java.util.ArrayList;
import java.util.ArrayList;

public class NerModel {

    // Query stored in array of strings words
    private ArrayList<String> words;

    public NerModel() {
        super();
    }

    public NerModel(ArrayList<String> words, ArrayList<String> keywords) {
        super();
        this.words = words;
        this.keywords = keywords;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    // Keywords stored in array of strings keywords
    private ArrayList<String> keywords;

}