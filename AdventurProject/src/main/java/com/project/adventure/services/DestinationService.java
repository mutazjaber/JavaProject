package com.project.adventure.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.adventure.models.Destination;
import com.project.adventure.repositories.DestinationRepository;

@Service
public class DestinationService {
	
	@Autowired
	DestinationRepository destinationRepo;
	
	public List<Destination> allDestinations(){
		return destinationRepo.findAll();
	}
	
	public Destination createDestination(Destination destination) {
		return destinationRepo.save(destination);
	}
	
	public Destination updateDestination(Destination destination) {
		return destinationRepo.save(destination);
	}
	
	public Destination findDestination(Long id) {
		Optional<Destination> optionalDestination = destinationRepo.findById(id);
		
		if(optionalDestination.isPresent()) {
			return optionalDestination.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteDestination(Long id) {
		destinationRepo.deleteById(id);
	}
	
}
