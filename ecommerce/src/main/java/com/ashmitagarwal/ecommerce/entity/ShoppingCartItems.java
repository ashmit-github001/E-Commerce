package com.ashmitagarwal.ecommerce.entity;

import com.ashmitagarwal.ecommerce.dto.ShoppingCartPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class ShoppingCartItems {
	
	@EmbeddedId
	private ShoppingCartPk shoppingCartId;
	
	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "product_id")
	private CatalogProducts product;
	
	@ManyToOne()
	@MapsId("userId")
	@JoinColumn(name = "customer_id")
	private Customers customer;
	
	private int quantity;
	
	public ShoppingCartPk getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(ShoppingCartPk shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public CatalogProducts getProduct() {
		return product;
	}

	public void setProduct(CatalogProducts product) {
		this.product = product;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ShoppingCartItems() {
		
	}
	
	public ShoppingCartItems(CatalogProducts product, Customers customer, int quantity) {
		this.shoppingCartId = new ShoppingCartPk(product.getId(), customer.getId());
		this.product = product;
		this.customer = customer;
		this.quantity = quantity;
	}
}
