package com.project.adventure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.adventure.models.Destination;
import com.project.adventure.models.Plan;
import com.project.adventure.services.DestinationService;
import com.project.adventure.services.PlanService;
import com.project.adventure.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MutazController {
	@Autowired
	private UserService userService;
	@Autowired
	private DestinationService destinationService;
	@Autowired
	private PlanService planService;
	

	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/destinations")
	public String destinations(HttpSession session, Model model) {

		Long userId = (Long) session.getAttribute("userId");
		if(userId != null) {
			model.addAttribute("thisUser", userService.findUser(userId));
		}

		List<Destination> destinations = destinationService.allDestinations();

		model.addAttribute("destinations", destinations);

		
		
		return "allDestinations.jsp";
	}
//	@GetMapping("/destinations")
//	public String bookDetails(@PathVariable("bookId") Long bookId, HttpSession session, Model model) {
//		Long id = (Long) session.getAttribute("loginId");
//		User user = userService.find_User(id);
//		Book book = bookService.findBook(bookId);
//		model.addAttribute("book", book);
//		model.addAttribute("user", user);
//		return "bookDetails.jsp";
//	}

	@GetMapping("/admin/dashboard")
	public String dashboard(HttpSession session, Model model) {

	if (session.getAttribute("userId") == null) {
		return "redirect:/login";
		}
	else if((Long) session.getAttribute("userId") != 1){
		return "redirect:/";
	}
		List<Destination> destinations = destinationService.allDestinations();
		
		model.addAttribute("plans", planService.allPlans());

		model.addAttribute("destinations", destinations);

		return "dashboard.jsp";
	
		
}
	@GetMapping("/destinations/{id}/delete")
	public String delete(@PathVariable("id") Long destinationId, HttpSession session) {
//		Long id = (Long) session.getAttribute("loginId");
		
		destinationService.deleteDestination(destinationId);
		return "redirect:/admin/dashboard";
	}
	
	
	   @PostMapping("/search")
	    public String search(@RequestParam(name = "query", required = false) String query, Model model) {
	        // Implement your search logic here
	        // For example, you can use a service method to retrieve plans based on the query

	        // Replace this with your actual service method
	         Destination searchResults = destinationService.search(query);
	         
	         if(searchResults == null) {
	        	 
	        	 return "redirect:/destinations";
	         }

	        // Add the search results to the model
	        model.addAttribute("searchResults", searchResults);

	        // Return the view where you want to display the search results
	        return "redirect:/destinations/" + searchResults.getId() + "/view"  ;
	    }
}
