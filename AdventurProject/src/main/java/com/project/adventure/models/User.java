package com.project.adventure.models;

import java.util.Date;
import java.util.List;

//import javax.management.relation.Role;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="User name is required!")
	@Size(min=3, message="User name must be at least 3 characters!")
	@Pattern(regexp="^[A-Za-z\s]*$",message = "User name must be only letters!")
	private String username;
	
	@NotEmpty(message="Email is required!")
	@Email(message="Please enter a valid email!")
	private String email;
	
	@NotEmpty(message="Password is required!")
	@Size(min=8, message="Password must be at least 8 characters!")
	private String password;
	
	@Transient
	@NotEmpty(message="Confirm Password is required!")
	@Size(min=8, message="Confirm Password must be at least 8 characters!")
	private String confirmPassword;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Plan> plans;
	
	@ManyToMany(fetch = FetchType.EAGER)
	   @JoinTable(
	       name = "users_roles", 
	       joinColumns = @JoinColumn(name = "user_id"), 
	       inverseJoinColumns = @JoinColumn(name = "role_id")
	   )
	 private List<Role> roles;
	
	@PrePersist
	protected void onCreate(){
	    this.createdAt = new Date();
	  }
	@PreUpdate
	protected void onUpdate(){
	    this.updatedAt = new Date();
	  }
	 
	public User() {}
	public User(
			@NotEmpty(message = "User name is required!") @Size(min = 3, message = "User name must be at least 3 characters!") @Pattern(regexp = "^[A-Za-z ]*$", message = "User name must be only letters!") String username,
			@NotEmpty(message = "Email is required!") @Email(message = "Please enter a valid email!") String email,
			@NotEmpty(message = "Password is required!") @Size(min = 8, message = "Password must be at least 8 characters!") String password,
			List<Plan> plans, List<Role> roles) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.plans = plans;
		this.roles = roles;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
}
