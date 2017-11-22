package com.stackroute.neo4j.domain;

public class IntentSearchResult {
    private String intent;
    private String concept;

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getConcept() {
        return concept;
    }

    public IntentSearchResult() {
        super();
    }

    public IntentSearchResult(String intent, String concept) {
        super();
        this.intent = intent;
        this.concept = concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

}