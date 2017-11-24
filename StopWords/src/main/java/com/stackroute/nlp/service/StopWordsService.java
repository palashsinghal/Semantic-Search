package com.stackroute.nlp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.nlp.config.SenderService;
import com.stackroute.nlp.domain.StopWords;
import com.stackroute.nlp.domain.StopWordsResult;

@Service
public class StopWordsService {

	StopWords stopWords = new StopWords();
	StopWordsResult stopWordsResult = new StopWordsResult();

	@Autowired
	SenderService sender;

	// remove stopwords
	public StopWordsResult removeStopwords(String[] words, String[] pos) {
		// for (String word:pos)
		// System.out.println(word);

		List<String> stopwords = stopWords.getStopWords();

//		String[] finalwords = new String[words.length];
//		
//		String[] finalpos = new String[pos.length];
		

		ArrayList<String> finalwords=new ArrayList<String>();
		ArrayList<String> finalpos=new ArrayList<String>();
		
		int i = 0, current = 0;

		for (String word : words) {
			boolean flag = false;
			System.out.println(i + " " + word);

			for (String stopword : stopwords) {

				if (word.equals(stopword)) {
					flag = true;
					break;
				}

			}
			// System.out.println(flag);
			if (flag == false) {
				finalwords.add(word);
				finalpos.add(pos[i]);
				current++;
			}

			i++;
		}

		// System.out.println(finalwords.length);
		


//		for (int x = 0; x < finalwords.length; x++) {
//
////			if (finalwords[x]==null)
////				finalwords[x] = "0";
////			if (finalpos[x]==null)
////				finalpos[x] = "0";
//
//		}
		System.out.println("FINALWORDS");
		for (int x = 0; x < finalwords.size(); x++) {

			System.out.println(finalwords.get(x));
			System.out.println(finalpos.get(x));

		}



		stopWordsResult.setWords(finalwords);
		stopWordsResult.setPos(finalpos);
		return stopWordsResult;
		//sender.send(stopWordsResult);
		
	}
}
