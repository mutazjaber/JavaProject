package com.project.adventure.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="activities")
public class Activity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Activity name is required!")
	@Size(min=3, message="Activity name must be at least 3 characters!")
	private String activityName;
	
	@NotEmpty(message="Price is required!")
	private double price;
	
	@NotEmpty(message="Activity description is required!")
	@Size(min = 5, message="Activity description must be at least 5 characters!")
	@Column(columnDefinition="TEXT")
	private String description;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "destination_id")
	private Destination destination;
	
	@OneToOne(mappedBy="activity", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Plan plan;
	 
	@PrePersist
	protected void onCreate(){
	   this.createdAt = new Date();
	 }
	@PreUpdate
	protected void onUpdate(){
	   this.updatedAt = new Date();
	 }
	
	public Activity() {}
	
	public Activity(
			@NotEmpty(message = "Activity name is required!") @Size(min = 3, message = "Activity name must be at least 3 characters!") String activityName,
			@NotEmpty(message = "Price is required!") double price,
			@NotEmpty(message = "Activity description is required!") @Size(min = 5, message = "Activity description must be at least 5 characters!") String description,
			Destination destination, Plan plan) {
		super();
		this.activityName = activityName;
		this.price = price;
		this.description = description;
		this.destination = destination;
		this.plan = plan;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	
	
	
}
