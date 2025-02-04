package com.ashmitagarwal.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashmitagarwal.ecommerce.entity.ShoppingCartItem;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCartItem, String> {

}
