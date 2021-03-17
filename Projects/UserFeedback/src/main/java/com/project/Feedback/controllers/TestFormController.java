package com.project.Feedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.Feedback.entities.Feedback;
import com.project.Feedback.services.FeedbackService;

@Controller
public class TestFormController {

	@Autowired
	FeedbackService feedbackService;
	
	@GetMapping("/test_form")
	public String showTestForm(ModelMap model) {
		return "testformjsp";
	}
	
	
//	@PostMapping("/test_form")
//	public String submitTestForm(@RequestBody Feedback fb) {
//		feedbackService.
//		return "testformjsp";
//	TODO: Implement form submission
//	TODO: call RestTemplate and make json request to localhost.../feedback

//	}
}
