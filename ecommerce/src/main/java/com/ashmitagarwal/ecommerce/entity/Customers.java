package com.ashmitagarwal.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Column(columnDefinition = "VARCHAR(500)")
	private String fullName;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(columnDefinition = "VARCHAR(500) NOT NULL")
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
