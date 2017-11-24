package com.stackroute.domainexpert.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.domainexpert.messenger.Sender;
import com.stackroute.domainexpert.model.DomainExpertModel;


@RequestMapping("/domainexpert")
@RestController
public class DomainExpertController {
	
	@Autowired
	Sender sender;
	
	@CrossOrigin("*")
//	@RequestMapping(method = RequestMethod.POST, value = "/{domain}/{concepts}")
	@PostMapping("/{domain}/{concepts}")
	public ResponseEntity<?> add(@PathVariable String concepts ,@PathVariable String domain) throws InterruptedException {
		
		String[] conceptarray= concepts.split(",");
		int len = conceptarray.length;
		for(int i=0; i<len;i++) {
			DomainExpertModel domainmodel= new DomainExpertModel();
			domainmodel.setDomain(domain);
			domainmodel.setConcept(conceptarray[i]);
			System.out.println(domainmodel.getDomain());
			System.out.println(domainmodel.getConcept());
			sender.send(domainmodel);
			Thread.sleep(3000);
			
			
		}
		return new ResponseEntity<String>("Concept Posted Successfully", HttpStatus.OK);
		
	}
	
//	@CrossOrigin("*")
//    @PostMapping("/mohit")
//    public @ResponseBody ResponseEntity<?> saveNewSubconcept(@RequestParam String domain,@RequestParam String concept) {
//        try {
//        System.out.println(subconcept.getName());
//            return new ResponseEntity<Subconcept>(subconceptService.postnode(subconcept), HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }

}
