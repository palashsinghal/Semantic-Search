package com.stackroute.domainexpert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.stackroute.domainexpert.App;

//@EnableAutoConfiguration
@SpringBootApplication
public class App{
	public static void main(String args[]) {
	
	SpringApplication.run(App.class, args);
	}
}