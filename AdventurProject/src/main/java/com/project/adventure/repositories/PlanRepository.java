package com.project.adventure.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.adventure.models.Plan;

@Repository
public interface PlanRepository extends CrudRepository<Plan, Long> {
	
	List<Plan> findAll();
}
