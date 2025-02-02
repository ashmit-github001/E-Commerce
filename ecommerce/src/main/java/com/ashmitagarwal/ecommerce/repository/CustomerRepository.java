package com.ashmitagarwal.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashmitagarwal.ecommerce.entity.Customers;

public interface CustomerRepository extends JpaRepository<Customers, String> {

	@Query(value = "SELECT * FROM customers c WHERE c.email=?1", nativeQuery = true)
	public Optional<Customers> findByEmail(String email);
}
