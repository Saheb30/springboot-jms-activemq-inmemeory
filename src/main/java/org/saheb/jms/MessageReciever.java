package org.saheb.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReciever {
	@JmsListener(destination = "in-memory.queue")
	public void receiveMessage(Message msg) {
		System.out.println("Received... " + msg);
	}
}
