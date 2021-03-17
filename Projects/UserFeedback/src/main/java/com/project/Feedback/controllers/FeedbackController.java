package com.project.Feedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.Feedback.entities.Feedback;
import com.project.Feedback.services.FeedbackService;

public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;
	
	@GetMapping("/feeback")
	public @ResponseBody Iterable<Feedback> getallFeedbacks(){
		return feedbackService.GetAllFeedback();
	}
	
	@PostMapping("/feedback") 
	public Feedback addNewFeedback(@RequestBody Feedback fb) {
		return new Feedback();
	}
}