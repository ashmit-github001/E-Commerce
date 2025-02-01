package com.ashmitagarwal.ecommerce.entity;

import com.ashmitagarwal.ecommerce.dto.ShoppingCartPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class ShoppingCart {
	
	@EmbeddedId
	private ShoppingCartPk shoppingCartId;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	@MapsId("productId")
	private CatalogProducts product;
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	@MapsId("userId")
	private UserDetails user;
	
	private int quantity;

	public CatalogProducts getProduct() {
		return product;
	}

	public void setProduct(CatalogProducts product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
