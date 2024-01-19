package com.project.adventure.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.adventure.models.Activity;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {
	
	List<Activity> findAll();
}
