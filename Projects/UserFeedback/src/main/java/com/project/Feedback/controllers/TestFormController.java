package com.project.Feedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.Feedback.entities.Feedback;
import com.project.Feedback.services.FeedbackService;

@Controller
public class TestFormController {

	@Autowired
	FeedbackService feedbackService;
	
	@GetMapping("/test_form")
	public String showTestForm(ModelMap model) {
		model.addAttribute("test", new Feedback());
		return "testformjsp";
	}
	
	
	@PostMapping("/test_form")
	public String submitTestForm(@RequestBody Feedback fb, ModelMap model) throws JsonMappingException, JsonProcessingException {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String testForm = "http://localhost:8090/feedbacks";
			ResponseEntity<String> response = restTemplate.getForEntity(testForm + "/7", String.class);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(response.getBody());
			JsonNode name = root.path("name");
			model.addAttribute(name);
			return "testformjsp";
		} catch (JsonMappingException e) {
			throw e;
		} catch (JsonProcessingException e2) {
			throw e2;
		}
		
//	TODO: Implement form submissiont
//	TODO: call RestTemplate and make json request to localhost.../feedback

	}
}
