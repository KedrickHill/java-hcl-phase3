package com.project.Feedback.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

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
	public String submitTestForm(@RequestBody Feedback fb, ModelMap model) {
			RestTemplate restTemplate = new RestTemplate();
//			URL testForm = new URL("http://localhost:8090/feedbacks/{feedback}");
//			ResponseEntity<String> response = restTemplate.getForEntity(testForm + "/7", String.class);
//			ObjectMapper mapper = new ObjectMapper();
//			JsonNode root = mapper.readTree(response.getBody());
//			JsonNode name = root.path("name");
//			model.addAttribute(name);
			String result = restTemplate.getForObject("http://localhost:8090/feedbacks/{feedback}", String.class, 7); 
			return "testformjsp";
	}
		
//	TODO: Implement form submission
//	TODO: call RestTemplate and make json request to localhost.../feedback

}
