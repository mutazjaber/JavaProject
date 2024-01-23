package com.project.adventure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.adventure.models.Activity;
import com.project.adventure.models.Destination;
import com.project.adventure.models.Hotel;
import com.project.adventure.models.LoginUser;
import com.project.adventure.models.Plan;
import com.project.adventure.models.Restaurant;
import com.project.adventure.models.User;
import com.project.adventure.services.ActivityService;
import com.project.adventure.services.DestinationService;
import com.project.adventure.services.HotelService;
import com.project.adventure.services.PlanService;
import com.project.adventure.services.RestaurantService;
import com.project.adventure.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@Controller
public class HomeController {
	@Autowired
	private UserService userService; 
	@Autowired
	private PlanService planService;
	@Autowired
	private DestinationService destService;
	@Autowired
	private HotelService hotelService;
	@Autowired
	private RestaurantService restService;
	@Autowired
	private ActivityService actService;
	
	@RequestMapping("/")
    public String homePage(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId != null) {
			model.addAttribute("thisUser", userService.findUser(userId));
		}
        return "home.jsp";
    }  
	@RequestMapping("/login")
    public String loginPage(Model model) {
		model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }  
	@RequestMapping("/register")
    public String registerPage(Model model) {
		model.addAttribute("newUser", new User());
        return "register.jsp";
    }  
	@RequestMapping("/plan/{id}")
    public String planPage(@PathVariable("id") Long destinationId , HttpSession session,Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			// User is not logged in, so redirect them to the login and registration page
			return "redirect:/login";
		} else {
			model.addAttribute("newPlan", new Plan());
			//List<Destination> dest = destService.allDestinations();
			//model.addAttribute("dests", dest);
			//List<Hotel> hotel = hotelService.allHotels();
			//model.addAttribute("hotels", hotel);
			//List<Restaurant> rests = restService.allRestaurants();
			//model.addAttribute("rests", rests);
			//List<Activity> activities = actService.allActivities();
			//model.addAttribute("activities", activities);
			model.addAttribute("thisUser", userService.findUser(userId));
			model.addAttribute("destination", destService.findDestination(destinationId));
			
			return "plan.jsp";
		}
		
    }  
	@RequestMapping("/userPlans")
    public String userPlanPage(HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			// User is not logged in, so redirect them to the login and registration page
			return "redirect:/login";
		}
		Long userId = (Long) session.getAttribute("userId");
		model.addAttribute("thisUser", userService.findUser(userId));
        return "userPlans.jsp";
    }  
	@RequestMapping("/about")
    public String aboutUs(HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId != null) {
			model.addAttribute("thisUser", userService.findUser(userId));
		}
        return "about.jsp";
    } 
	
	@PostMapping("/register")
	public String registerPost(@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model model,
            HttpSession session)  {
		User user = userService.register(newUser, result);
		if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "register.jsp";
        }
		 else {
			 session.setAttribute("userId", user.getId());
	       	 session.setAttribute("userName", user.getUsername());
			 return "redirect:/";
		 }
		
		
	}
	 @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result,
	            Model model,
	            HttpSession session) {
	        
	         User user = userService.login(newLogin, result);
	    
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "login.jsp";
	        }
	    
	        session.setAttribute("userId", user.getId());
	      	session.setAttribute("userName", user.getUsername());
	        return "redirect:/";
	    }
	
	 @PostMapping("/plan/{id}")
	 public String planPost(@Valid @ModelAttribute("plan") Plan plan, BindingResult result, 
			 HttpSession session,
				Model model, @PathVariable("id") Long id){
		 Long userId = (Long) session.getAttribute("userId");
		 
		 if (result.hasErrors()) {
			 
			 	model.addAttribute("newPlan", new Plan());
				//List<Destination> dest = destService.allDestinations();
				//model.addAttribute("dests", dest);
				//List<Hotel> hotel = hotelService.allHotels();
				//model.addAttribute("hotels", hotel);
				//List<Restaurant> rests = restService.allRestaurants();
				//model.addAttribute("rests", rests);
				//List<Activity> activities = actService.allActivities();
				//model.addAttribute("activities", activities);
				model.addAttribute("thisUser", userService.findUser(userId));
				model.addAttribute("destination", destService.findDestination(id));
				return "plan.jsp";
			}
		 else {
			 
			 User currentUser = userService.findUser(userId);
			 plan.setUser(currentUser);
			 plan.setDestination(destService.findDestination(id));
			 planService.createPlan(plan);
			  return "redirect:/userPlans";
		 }
		 
		
	 }
	 
	 @RequestMapping("/plan/{planId}/delete")
	 public String deletePlan(@PathVariable("planId") Long id, HttpSession session) {
		 Plan plan = planService.findPlan(id);
		 plan.setUser(null);
		 plan.setDestination(null);
		 planService.deletePlan(id);
		 return "redirect:/userPlans";
	 }
	 
	 
	 @RequestMapping("/plan/{planId}/take")
	 public String BookPlan(@PathVariable("planId") Long id, HttpSession session) {
		 Plan plan = planService.findPlan(id);
		 Long userId = (Long) session.getAttribute("userId");
		 User currentUser = userService.findUser(userId);
		 currentUser.getPlans().remove(plan);
		 plan.setUser(null);
		 planService.updatePlan(plan);
		 userService.updateUser(currentUser);
		 return "redirect:/userPlans";
	 }
	 
	 
	 
	 
	 
	
	
	
	

}
