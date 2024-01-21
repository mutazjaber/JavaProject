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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="restaurants")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Restaurant name is required!")
	@Size(min=3, message="Restaurant name must be at least 3 characters!")
	private String restaurantName;
	
	@NotEmpty(message="Restaurant image is required!")
	@Size(min=3, message="Restaurant image must be at least 3 characters!")
	private String image;
	
	@NotNull(message="Price is required!")
	private double price;
	
	@NotEmpty(message="Restaurant description is required!")
	@Size(min = 5, message="Restaurant description must be at least 5 characters!")
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
	
	 @OneToOne(mappedBy="restaurant", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	 private Plan plan;
	 
	 @PrePersist
	 protected void onCreate(){
	    this.createdAt = new Date();
	  }
	 @PreUpdate
	 protected void onUpdate(){
	    this.updatedAt = new Date();
	  }
		
	public Restaurant() {}
	
	public Restaurant(
			@NotEmpty(message = "Restaurant name is required!") @Size(min = 3, message = "Restaurant name must be at least 3 characters!") String restaurantName,
			@NotEmpty(message = "Restaurant image is required!") @Size(min = 3, message = "Restaurant image must be at least 3 characters!") String image,
			@NotNull(message = "Price is required!") double price,
			@NotEmpty(message = "Restaurant description is required!") @Size(min = 5, message = "Restaurant description must be at least 5 characters!") String description,
			Destination destination, Plan plan) {
		super();
		this.restaurantName = restaurantName;
		this.image = image;
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
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
