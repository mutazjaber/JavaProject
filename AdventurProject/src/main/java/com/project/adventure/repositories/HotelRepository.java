package com.project.adventure.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.adventure.models.Hotel;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {
	
	List<Hotel> findAll();
}
