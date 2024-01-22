package com.project.adventure.controllers;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.adventure.models.Destination;
import com.project.adventure.services.DestinationService;
import com.project.adventure.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MutazController {
	@Autowired
	private UserService userService;
	@Autowired
	private DestinationService destinationService;
	
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	@GetMapping("/destinations")
	public String destinations(HttpSession session, Model model) {

//		if (session.getAttribute("loginId") == null) {
//			return "redirect:/login";
//		}
//		Long id = (Long) session.getAttribute("loginId");
//		User user = userService.findUser(id);
//		model.addAttribute("email", user.getEmail());
//		model.addAttribute("userName", user.getUsername());

		List<Destination> destinations = destinationService.allDestinations();
		for (Destination destination : destinations) {
			System.out.println(destination.getId());
		}

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

//		if (session.getAttribute("loginId") == null) {
//			return "redirect:/login";
//		}
//		Long id = (Long) session.getAttribute("loginId");
//		User user = userService.findUser(id);
//		model.addAttribute("email", user.getEmail());
//		model.addAttribute("userName", user.getUsername());

		List<Destination> destinations = destinationService.allDestinations();
//		for (Destination destination : destinations) {
//			System.out.println(destination.getId());
//		}

		model.addAttribute("destinations", destinations);

		return "dashboard.jsp";
		
}
	@GetMapping("/destinations/{id}/delete")
	public String delete(@PathVariable("id") Long destinationId, HttpSession session) {
//		Long id = (Long) session.getAttribute("loginId");
		
		destinationService.deleteDestination(destinationId);
		return "redirect:/admin/dashboard";
	}
}
