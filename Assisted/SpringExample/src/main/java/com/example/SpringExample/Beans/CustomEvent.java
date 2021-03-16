package com.example.SpringExample.Beans;

import org.springframework.context.ApplicationEvent;

//Used for an event that is activated via a selection method
public class CustomEvent extends ApplicationEvent {

	public CustomEvent(Object source) {
		super(source);
	}

	public String toString() {
		return "This is a custom event";
	}

}
