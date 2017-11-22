//package com.intentgraph.controller;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//import org.springframework.boot.context.embedded.LocalServerPort;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//
//import com.intentgraph.Application;
//import com.intentgraph.domain.IntentOf;
//import com.intentgraph.domain.Query;
//import com.intentgraph.domain.SameAs;
//import com.intentgraph.domain.Terms;
//
//
//import ch.qos.logback.classic.Level;
//
//
//import static org.junit.Assert.*;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.context.embedded.LocalServerPort;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class IntentControllerTest {
//	    String user1;
//	    @LocalServerPort
//	    private int port;
//	    TestRestTemplate restTemplate = new TestRestTemplate();
//	    HttpHeaders headers = new HttpHeaders();
//	    IntentOf intentOf;
//	    Level level;
//	    Query query;
//	    SameAs sameAs;
//	    Terms terms;
//	    @Before
//	    public void setUp() throws Exception {
//			terms=new Terms("concept1");
//			
//			query=new Query("hi");
//			float i=1;
//			
//	    }
//	    
//	    private String createURLWithPort(String uri) {
//	        return "http://localhost:" + port + uri;
//	    }
//	    @After
//	    public void tearDown() throws Exception {
//	    }
//	    @Test
//	    public void testSaveUser() throws Exception {
//	        HttpEntity<SameAs> entity = new HttpEntity<SameAs>(sameAs, headers);
//	        ResponseEntity<String> response = restTemplate.exchange(
//	                createURLWithPort("/postcsvsubconcept?csvname=hi"),
//	                HttpMethod.POST, entity, String.class);
//	        assertNotNull(response);
//	        String actual = response.getBody();
//	        System.out.println(actual);
////	        assertEquals("all nodes created from csv",actual);
//	        assertNotNull(response);
//	    }
//	    @Test
//	    public void testGetUser() throws Exception {
//	        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//	        ResponseEntity<String> response = restTemplate.exchange(
//	                createURLWithPort("/graphconcept"),
//	                HttpMethod.GET, entity, String.class);
//	        assertNotNull(response);
//	    }
//	    
//}