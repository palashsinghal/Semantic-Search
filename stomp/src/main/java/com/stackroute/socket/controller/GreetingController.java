package com.stackroute.socket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.stackroute.socket.domain.HelloMessage;
import com.stackroute.socket.messenger.ListUrls;
import com.stackroute.socket.messenger.Listener;

@Controller
public class GreetingController {

	@Autowired
	Listener listener;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ListUrls greeting(HelloMessage message) throws Exception {
        Thread.sleep(3000); // simulated delay
        System.out.println(message);
        System.out.println("vinayak"+message.getName());
        System.out.println("IN CONTROLLER");
        return listener.getListUrls();
//        return new Greeting("Hello, " + message.getName() + "!");
    }

}
