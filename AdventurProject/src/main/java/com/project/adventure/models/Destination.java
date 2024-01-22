package com.project.adventure.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="destinations")

public class Destination {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Destination name is required!")
	@Size(min=3, message="Destination name must be at least 3 characters!")
	private String destinationName;
	
	@NotEmpty(message="Destination name is required!")
	@Size(min=3, message="Destination image must be at least 3 characters!")
	@Column(columnDefinition="TEXT")
	private String image;
	
	@NotEmpty(message="Destination description is required!")
	@Size(min = 5, message="Destination description must be at least 5 characters!")
	@Column(columnDefinition="TEXT")
	private String description;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy = "destination", fetch = FetchType.LAZY)
	private List<Plan> plans;
	
	@OneToMany(mappedBy = "destination", fetch = FetchType.LAZY)
	private List<Hotel> hotels;
	
	@OneToMany(mappedBy = "destination", fetch = FetchType.LAZY)
	private List<Activity> activities;
	
	@OneToMany(mappedBy = "destination", fetch = FetchType.LAZY)
	private List<Restaurant> restaurants;
	
	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	  }
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	  }
	
	public Destination() {}
	public Destination(
			@NotEmpty(message = "Destination name is required!") @Size(min = 3, message = "Destination name must be at least 3 characters!") String destinationName,
			@NotEmpty(message = "Destination name is required!") @Size(min = 3, message = "Destination image must be at least 3 characters!") String image,
			@NotEmpty(message = "Destination description is required!") @Size(min = 5, message = "Destination description must be at least 5 characters!") String description,
			List<Plan> plans, List<Hotel> hotels, List<Activity> activities, List<Restaurant> restaurants) {
		super();
		this.destinationName = destinationName;
		this.image = image;
		this.description = description;
		this.plans = plans;
		this.hotels = hotels;
		this.activities = activities;
		this.restaurants = restaurants;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public List<Plan> getPlans() {
		return plans;
	}
	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}
	public List<Hotel> getHotels() {
		return hotels;
	}
	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}
	public List<Activity> getActivities() {
		return activities;
	}
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	
	
}
