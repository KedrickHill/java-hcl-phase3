package com.example.SpringExample.Beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CustomEventPublisher {

	@Autowired
	private ApplicationEventPublisher publisher;

	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	public void publish() {
		System.out.println("Publishing Custom Event.");
		CustomEvent ce = new CustomEvent(this);
		publisher.publishEvent(ce);
	}

}
