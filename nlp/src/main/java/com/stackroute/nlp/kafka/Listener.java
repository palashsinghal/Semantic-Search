package com.stackroute.nlp.kafka;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.nlp.domain.SpellCheckResult;
import com.stackroute.nlp.service.NLPNerService;
import com.stackroute.nlp.service.NLPPosService;
import com.stackroute.nlp.service.StopWordsService;

@Service
public class Listener {
	public final CountDownLatch countDownLatch1 = new CountDownLatch(1);

	@Autowired
	NLPNerService nerservice;

	@Autowired
	NLPPosService nlpposservice;

	@Autowired
	StopWordsService stopWordsService;

	@KafkaListener(topics = "spellcheck6", containerFactory = "kafkaListenerContainerFactory1")
	public void listen(SpellCheckResult record) throws IOException {

		System.out.println("nermodel is listening");

		nlpposservice.findPos(record.getSpellcheckresult());

		countDownLatch1.countDown();

	}

	@KafkaListener(topics = "lemmatizer1", containerFactory = "kafkaListenerContainerFactory")
	public void listen(LemmatizedQuery record) throws IOException {

		// System.out.println("nermodel is listening");

		nerservice.findName(record.getLemQuery());
		
		

		countDownLatch1.countDown();

	}
}