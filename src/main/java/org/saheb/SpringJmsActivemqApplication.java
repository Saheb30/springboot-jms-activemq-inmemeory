package org.saheb;

import java.util.Date;

import javax.jms.Queue;

import org.saheb.jms.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableJms
public class SpringJmsActivemqApplication implements CommandLineRunner{
	@Autowired
	Queue queue;
	@Autowired
	JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringJmsActivemqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Sending a message...");
		jmsTemplate.convertAndSend(queue, new Message(1001L, "test body", new Date()));
	}

}
