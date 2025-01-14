package com.ashmitagarwal.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ashmitagarwal.ecommerce.entity.CatalogProducts;

@Repository
public interface CatalogRepository extends JpaRepository<CatalogProducts, String> {

	@Query(value = "SELECT * FROM catalog_products u WHERE u.category=?1", nativeQuery = true)
	List<CatalogProducts> findAllByCategory(String keyword);
}
