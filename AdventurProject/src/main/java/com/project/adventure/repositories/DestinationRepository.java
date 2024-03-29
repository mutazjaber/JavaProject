package com.project.adventure.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.adventure.models.Destination;

@Repository
public interface DestinationRepository extends CrudRepository<Destination, Long> {
	
	List<Destination> findAll();
	List<Destination> findByDestinationNameContaining(String query);
	Destination findByDestinationName (String name) ;
}
