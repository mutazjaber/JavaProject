package com.project.adventure.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.adventure.models.Plan;
import com.project.adventure.repositories.PlanRepository;

@Service
public class PlanService {
	
	@Autowired
	PlanRepository planRepo;
	
	public List<Plan> allPlans(){
		return planRepo.findAll();
	}
	
	public Plan createPlan(Plan plan) {
		return planRepo.save(plan);
	}
	
	public Plan updatePlan(Plan plan) {
		return planRepo.save(plan);
	}
	
	public Plan findPlan(Long id) {
		Optional<Plan> optionalPlan = planRepo.findById(id);
		
		if(optionalPlan.isPresent()) {
			return optionalPlan.get();
		}
		else {
			return null;
		}
	}
	
	public void deletePlan(Long id) {
		planRepo.deleteById(id);
	}
	
}
