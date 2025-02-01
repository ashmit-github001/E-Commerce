package com.ashmitagarwal.ecommerce.dto;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ShoppingCartPk implements Serializable{
	
	private String productId;
	
	private String userId;
	
	ShoppingCartPk(){
		
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
