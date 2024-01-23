package com.project.adventure.services;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.project.adventure.models.LoginUser;
import com.project.adventure.models.User;
import com.project.adventure.repositories.UserRepository;

import io.micrometer.common.util.StringUtils;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public List<User> allUsers(){
		return userRepo.findAll();
	}
	
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public User updateUser(User user) {
		return userRepo.save(user);
	}
	
	public User findUser(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
	 private boolean isValidEmail(String email) {
	        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	        return Pattern.compile(regex).matcher(email).matches();
	    }
	
	 public User register(User newUser, BindingResult result) {
	       
	        if (StringUtils.isEmpty(newUser.getEmail()) || !isValidEmail(newUser.getEmail())) {
	            result.rejectValue("email", "Invalid", "Email is not valid.");
	        } else {
	            Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
	            if (potentialUser.isPresent()) {
	                result.rejectValue("email", "Matches", "An account with that email already exists.");
	            }
	        }
	 
	        if (StringUtils.isEmpty(newUser.getPassword()) || newUser.getPassword().length() < 8) {
	            result.rejectValue("password", "Invalid", "Password must be at least 8 characters long and not blank.");
	        }

	        if (!newUser.getPassword().equals(newUser.getConfirmPassword())) {
	            result.rejectValue("confirmPassword", "Invalid", "The Confirm Password must match Password.");
	        }

	        if (result.hasErrors()) {
	            return null;
	        }
	    	String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	        newUser.setPassword(hashedPassword);
	        return userRepo.save(newUser);
	    }
	 
	 
	 public User login(LoginUser newLogin, BindingResult result) {
			Optional<User> optionalUser = userRepo.findByEmail(newLogin.getEmail());

	    	if(!optionalUser.isPresent()) {
	    		result.rejectValue("email", "Matches", "User not found!");
	    		return null;
	    	}
	    	User user = optionalUser.get();
	    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
	    	    result.rejectValue("password", "Matches", "Invalid Password!");
	    	}
	    	if(result.hasErrors()) {
	    		return null;
	    	}
	    	
	        return user;
	        
	    }
	
	 
	 
	 
	 
	 
}
