package com.ashmitagarwal.ecommerce.dto;

import com.ashmitagarwal.ecommerce.entity.CatalogProduct;

public class UserCartDto {
	
	public UserCartDto() {
	}
	
	public UserCartDto(CatalogProduct product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public CatalogProduct getProduct() {
		return product;
	}

	public void setProduct(CatalogProduct product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	private CatalogProduct product;
	
	private int quantity;

}
