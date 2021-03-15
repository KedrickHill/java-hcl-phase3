package com.example.SpringExample.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.SpringExample.Beans.CustomEventPublisher;

@Controller
public class MainController {

	@Autowired
	CustomEventPublisher cvp;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showIndexPage(ModelMap model) {
		return "index";
	}
	@RequestMapping(value = "/customevent", method = RequestMethod.GET)
	public String customEvent(ModelMap map) {

		cvp.publish();
		cvp.publish();
		return "customEvent";
	}

}
