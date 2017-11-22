package com.stackroute.socket.messenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class Listener {
	
	private ListUrls listUrls;

	public ListUrls getListUrls() {
		return listUrls;
	}

	public void setListUrls(ListUrls listUrls) {
		this.listUrls = listUrls;
	}
	
    @KafkaListener(topics = "neo4j")
    public void listen(ListUrls record) {
    	System.out.println("LISTENING");
    	System.out.println(record.getResult());
    	setListUrls(record);
    }
    
    public ListUrls geturls() {
    	return getListUrls();
    }
   

	
}