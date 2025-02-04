package com.ashmitagarwal.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashmitagarwal.ecommerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

	@Query(value = "SELECT * FROM customers c WHERE c.email=?1", nativeQuery = true)
	public Optional<Customer> findByEmail(String email);
}
