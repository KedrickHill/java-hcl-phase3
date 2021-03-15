package com.example.SpringExample.Beans;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener implements ApplicationListener<CustomEvent> {

	public void onApplicationEvent(CustomEvent event) {
		System.out.println(event.toString());
	}

}
