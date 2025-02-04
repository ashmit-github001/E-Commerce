package com.ashmitagarwal.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ShoppingCartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private CatalogProduct product;
	
	@ManyToOne()
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	private int quantity;
	
	public String getShoppingCartId() {
		return id;
	}

	public void setShoppingCartId(String shoppingCartId) {
		this.id = shoppingCartId;
	}

	public CatalogProduct getProduct() {
		return product;
	}

	public void setProduct(CatalogProduct product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ShoppingCartItem() {
		
	}
	
	public ShoppingCartItem(CatalogProduct product, Customer customer, int quantity) {
		this.product = product;
		this.customer = customer;
		this.quantity = quantity;
	}
}
