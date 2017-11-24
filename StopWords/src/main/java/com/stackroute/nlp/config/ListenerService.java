package com.stackroute.nlp.config;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.nlp.domain.PosModel;
import com.stackroute.nlp.domain.StopWordsResult;
import com.stackroute.nlp.service.StopWordsService;

import ch.qos.logback.core.net.SyslogOutputStream;



@Service
public class ListenerService {

    public final CountDownLatch countDownLatch1 = new CountDownLatch(1);
    
    @Autowired
    StopWordsService stopWordsService;  
    
    @Autowired
    SenderService sender;

    
    @KafkaListener(topics = "posproducer2")
    public void listen(PosModel record) throws IOException {
    
//        System.out.println(record.getPosmap());
//        System.out.println(record.getUserInput());
    	
    	String[] words=record.getWords();
    	String[] pos=record.getPos();
    	
    	for (int i=0;i<words.length;i++) {
    	System.out.println(words[i]);
    	System.out.println(pos[i]);
    	}
     
    	StopWordsResult swr=stopWordsService.removeStopwords(words, pos);
    	
    	swr.setQuery(record.getQuery());
    	swr.setCorrectedquery(record.getCorrectedquery());
    	
    	
        sender.send(swr);
        
        
        countDownLatch1.countDown();
            
        
    }
}
