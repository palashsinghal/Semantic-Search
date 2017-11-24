package com.intentgraph.messenger;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.intentgraph.domain.IntentSearchResult;
import com.intentgraph.domain.NerModel;
import com.intentgraph.service.SameAsInterface;

@Service
public class Listener {

	@Autowired
	SameAsInterface sameAsService;
	
	@Autowired
	Sender sender;

	public final CountDownLatch countDownLatch1 = new CountDownLatch(1);

	@KafkaListener(topics = "nerproducer1")
	public void listen(NerModel record) {
		System.out.println("Intent Service is listening");

		// for (int i=0;i<record.getQuery().length;i++)
		// System.out.println(record.getConcepts()[i]);
		//
		// String[] query= {"define", "interface"};

		System.out.println("intent search is listening");
		String words = "";
		IntentSearchResult intentSearchResult = new IntentSearchResult();
		String intent = "default";

		for (int i = 0; i < record.getWords().size(); i++) {
			words = record.getWords().get(i);
			try {
				System.out.println(words);
				intent = sameAsService.findquerybyname(words);
				System.out.println("intent : " + intent);

			} catch (NullPointerException e) {
				e.getMessage();
			}
		}
		if (intent == "default")
			intent = "Basic";

		intentSearchResult.setIntent(intent);
		
		String concept = "";
		ArrayList<String> keywords = record.getKeywords();
		
		for (int anj = 0; anj < record.getKeywords().size(); anj++) {
			System.out.println(keywords.get(anj));
			concept += keywords.get(anj) + " ";
		}
		intentSearchResult.setConcept(concept);
		System.out.println("listening?" + intent);
		System.out.println("CONCEPT" + concept);
		
		intentSearchResult.setQuery(record.getQuery());
		intentSearchResult.setCorrectedquery(record.getCorrectedquery());
		System.out.println("INSIDE LISTENER");
		
		System.out.println(intentSearchResult.getQuery());
		System.out.println(intentSearchResult.getCorrectedquery());
		
		
		sender.send(intentSearchResult);
		System.out.println("intent search result has been sent");
		countDownLatch1.countDown();
	}
}
