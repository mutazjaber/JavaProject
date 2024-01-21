package com.project.adventure.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.adventure.models.Activity;
import com.project.adventure.repositories.ActivityRepository;

@Service
public class ActivityService {
	
	@Autowired
	ActivityRepository activityRepo;
	
	public List<Activity> allActivities(){
		return activityRepo.findAll();
	}
	
	public Activity createActivity(Activity activity) {
		return activityRepo.save(activity);
	}
	
	public Activity updateActivity(Activity activity) {
		return activityRepo.save(activity);
	}
	
	public Activity findActivity(Long id) {
		Optional<Activity> optionalActivity = activityRepo.findById(id);
		
		if(optionalActivity.isPresent()) {
			return optionalActivity.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteActivity(Long id) {
		activityRepo.deleteById(id);
	}
	
}
