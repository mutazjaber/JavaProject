package com.project.adventure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.adventure.models.Activity;
import com.project.adventure.models.Destination;
import com.project.adventure.models.Hotel;
import com.project.adventure.models.Restaurant;
import com.project.adventure.services.ActivityService;
import com.project.adventure.services.DestinationService;
import com.project.adventure.services.HotelService;
import com.project.adventure.services.RestaurantService;

import jakarta.validation.Valid;

@Controller
public class AdminController {
	
	@Autowired
	DestinationService destinationService;
	
	@Autowired
	HotelService hotelService;
	
	@Autowired
	RestaurantService restaurantService;
	
	@Autowired
	ActivityService activityService;
	
	@GetMapping("/admin/destination")
	public String viewDestinationPage(@ModelAttribute("destination") Destination destination) {
		return "destinationPage.jsp";
	}
	
	@GetMapping("/admin/hotel")
	public String viewHotelPage(@ModelAttribute("hotel") Hotel hotel, Model model) {
		model.addAttribute("destinations", destinationService.allDestinations());
		return "hotelPage.jsp";
	}
	
	@GetMapping("/admin/restaurant")
	public String viewRestaurantPage(@ModelAttribute("restaurant") Restaurant restaurant, Model model) {
		model.addAttribute("destinations", destinationService.allDestinations());
		return "restaurantPage.jsp";
	}

	@GetMapping("/admin/activity")
	public String viewActivityPage(@ModelAttribute("activity") Activity activity, Model model) {
		model.addAttribute("destinations", destinationService.allDestinations());
		return "activityPage.jsp";
	}
	
	@PostMapping("/destinations/new")
	public String newDestination(@Valid @ModelAttribute("destination") Destination destination, BindingResult result) {
		if(result.hasErrors()) {
			return "destinationPage.jsp";
		}
		else {
			destinationService.createDestination(destination);
			return "redirect:/admin/destination";
		}
	}
	
	@PostMapping("/hotels/new")
	public String newhotel(@Valid @ModelAttribute("hotel") Hotel hotel, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("destinations", destinationService.allDestinations());
			return "hotelPage.jsp";
		}
		else {
			hotelService.createHotel(hotel);
			return "redirect:/admin/hotel";
		}
	}
	
	@PostMapping("/restaurants/new")
	public String newRestaurant(@Valid @ModelAttribute("restaurant") Restaurant restaurant, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("destinations", destinationService.allDestinations());
			return "restaurantPage.jsp";
		}
		else {
			restaurantService.createRestaurant(restaurant);
			return "redirect:/admin/restaurant";
		}
	}
	
	@PostMapping("/activities/new")
	public String newActivity(@Valid @ModelAttribute("activity") Activity activity, 
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("destinations", destinationService.allDestinations());
			return "activityPage.jsp";
		}
		else {
			activityService.createActivity(activity);
			return "redirect:/admin/activity";
		}
	}
}
