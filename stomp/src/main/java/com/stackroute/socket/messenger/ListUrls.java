package com.stackroute.socket.messenger;

import java.util.List;

public class ListUrls {
    
    private String query;
    private String correctedquery;
 
    public ListUrls() {
        super();
    }
    public ListUrls(String query, String correctedquery, List<UrlRelation> result) {
        super();
        this.query = query;
        this.correctedquery = correctedquery;
        this.result = result;
    }
    private List<UrlRelation> result;
    public List<UrlRelation> getResult() {
        return result;
    }
    public void setResult(List<UrlRelation> result) {
        this.result = result;
    }
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }
    public String getCorrectedquery() {
        return correctedquery;
    }
    public void setCorrectedquery(String correctedquery) {
        this.correctedquery = correctedquery;
    }
    
}