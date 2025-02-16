package com.ashmitagarwal.ecommerce.entity;

import java.util.List;

import com.ashmitagarwal.ecommerce.dto.UserDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;

	@Column(columnDefinition = "VARCHAR(500)")
	private String fullName;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(columnDefinition = "VARCHAR(500) NOT NULL")
	private String password;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customer", orphanRemoval = true)
	private List<ShoppingCartItem> shoppingCartItemList;

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

	public List<ShoppingCartItem> getShoppingCartItemList() {
		return shoppingCartItemList;
	}

	public void setShoppingCartItemList(List<ShoppingCartItem> shoppingCartItemList) {
		this.shoppingCartItemList = shoppingCartItemList;
	}

	public Customer() {
		
	}
	
	public Customer(UserDTO userDto) {
		this.fullName = userDto.getFullName();
		this.email = userDto.getEmail();
		this.password = userDto.getPassword();
		this.shoppingCartItemList =  null;
	}
}
