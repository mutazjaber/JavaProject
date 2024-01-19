package com.project.adventure.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.adventure.models.Restaurant;
import com.project.adventure.repositories.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepository restaurantRepo;
	
	public List<Restaurant> allRestaurants(){
		return restaurantRepo.findAll();
	}
	
	public Restaurant createRestaurant(Restaurant restaurant) {
		return restaurantRepo.save(restaurant);
	}
	
	public Restaurant updateRestaurant(Restaurant restaurant) {
		return restaurantRepo.save(restaurant);
	}
	
	public Restaurant findRestaurant(Long id) {
		Optional<Restaurant> optionalRestaurant = restaurantRepo.findById(id);
		
		if(optionalRestaurant.isPresent()) {
			return optionalRestaurant.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteRestaurant(Long id) {
		restaurantRepo.deleteById(id);
	}
	
}
