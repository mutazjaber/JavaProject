package com.project.adventure.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="plans")
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Plan name is required!")
	@Size(min=3, message="Plan name must be at least 3 characters!")
	private String planName;
	
	private double cost;
	
	@NotEmpty(message="Plan description is required!")
	@Size(min = 5, message="Plan description must be at least 5 characters!")
	@Column(columnDefinition="TEXT")
	private String description;
	
	@NotNull(message = "From Date is required!")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message = "From date must be in the future!")
	private Date fromDate;
	
	@NotNull(message = "To Date is required!")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message = "To date must be in the future!")
	private Date toDate;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "destination_id")
	private Destination destination;
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="hotel_id")
    private Hotel hotel;
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="activity_id")
    private Activity activity;
	
	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	  }
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	  }
	
	public Plan() {}
	public Plan(
			@NotEmpty(message = "Plan name is required!") @Size(min = 3, message = "Plan name must be at least 3 characters!") String planName,
			double cost,
			@NotEmpty(message = "Plan description is required!") @Size(min = 5, message = "Plan description must be at least 5 characters!") String description,
			@NotNull(message = "From Date is required!") @Future(message = "From date must be in the future!") Date fromDate,
			@NotNull(message = "To Date is required!") @Future(message = "To date must be in the future!") Date toDate,
			User user, Destination destination, Hotel hotel, Restaurant restaurant, Activity activity) {
		super();
		this.planName = planName;
		this.cost = cost;
		this.description = description;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.user = user;
		this.destination = destination;
		this.hotel = hotel;
		this.restaurant = restaurant;
		this.activity = activity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	

}
