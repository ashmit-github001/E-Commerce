package com.ashmitagarwal.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashmitagarwal.ecommerce.dto.ShoppingCartPk;
import com.ashmitagarwal.ecommerce.entity.ShoppingCartItems;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCartItems, ShoppingCartPk> {

}
