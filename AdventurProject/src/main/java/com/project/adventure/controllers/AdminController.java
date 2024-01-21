package com.project.adventure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.project.adventure.models.Destination;

@Controller
public class AdminController {
	
	@GetMapping("/admin")
	public String viewAdminPage(@ModelAttribute("destination") Destination destination) {
		return "adminPage.jsp";
	}
}
