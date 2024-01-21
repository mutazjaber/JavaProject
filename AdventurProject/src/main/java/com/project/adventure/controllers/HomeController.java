package com.project.adventure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
    public String homePage() {
        return "home.jsp";
    }  
	@RequestMapping("/login")
    public String loginPage() {
        return "login.jsp";
    }  
	@RequestMapping("/register")
    public String registerPage() {
        return "register.jsp";
    }  
	@RequestMapping("/plan")
    public String planPage() {
        return "plan.jsp";
    }  
	@RequestMapping("/userPlans")
    public String userPlanPage() {
        return "userPlans.jsp";
    }  
	@RequestMapping("/about")
    public String aboutUs() {
        return "about.jsp";
    } 
	
	
	

}
