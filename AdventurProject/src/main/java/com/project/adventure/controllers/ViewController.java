package com.project.adventure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.adventure.models.Destination;
import com.project.adventure.services.DestinationService;
import com.project.adventure.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ViewController {
	
	@Autowired
	DestinationService destinationService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/destinations/{id}/view")
	public String viewDesination(@PathVariable("id") Long id ,Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId != null) {
			model.addAttribute("thisUser", userService.findUser(userId));
		}
		
		Destination destination = destinationService.findDestination(id);
		model.addAttribute("destination", destination);
		
		return "viewDestination.jsp";
	}
}
