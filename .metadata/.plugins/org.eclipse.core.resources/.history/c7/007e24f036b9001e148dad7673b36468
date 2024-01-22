package com.project.adventure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;

import com.project.adventure.models.Destination;
import com.project.adventure.services.DestinationService;

@Controller
public class ViewController {
	
	@Autowired
	DestinationService destinationService;
	
	@GetMapping("/destinations/1/view")
	public String viewDesination(Model model) {
		long id = 1;
		Destination destination = destinationService.findDestination(id);
		model.addAttribute("destination", destination);
		
		return "viewDestination.jsp";
	}
}
