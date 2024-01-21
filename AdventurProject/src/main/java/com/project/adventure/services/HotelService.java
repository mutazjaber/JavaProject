package com.project.adventure.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.adventure.models.Hotel;
import com.project.adventure.repositories.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	HotelRepository hotelRepo;
	
	public List<Hotel> allHotels(){
		return hotelRepo.findAll();
	}
	
	public Hotel createHotel(Hotel hotel) {
		return hotelRepo.save(hotel);
	}
	
	public Hotel updateHotel(Hotel hotel) {
		return hotelRepo.save(hotel);
	}
	
	public Hotel findHotel(Long id) {
		Optional<Hotel> optionalHotel = hotelRepo.findById(id);
		
		if(optionalHotel.isPresent()) {
			return optionalHotel.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteHotel(Long id) {
		hotelRepo.deleteById(id);
	}
	
}
