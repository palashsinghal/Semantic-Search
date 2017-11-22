package com.stackroute.socket.messenger;

import java.util.List;

public class ListUrls {

    private List<UrlRelation> result;

    public List<UrlRelation> getResult() {
        return result;
    }

    public void setResult(List<UrlRelation> result) {
        this.result = result;
    }

    public ListUrls(List<UrlRelation> result) {
        super();
        this.result = result;
    }

    public ListUrls() {
        super();
    }
    
}