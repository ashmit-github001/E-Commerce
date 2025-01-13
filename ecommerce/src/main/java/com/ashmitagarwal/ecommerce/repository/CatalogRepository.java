package com.ashmitagarwal.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ashmitagarwal.ecommerce.entity.CatalogItem;

@Repository
public interface CatalogRepository extends JpaRepository<CatalogItem, String> {

	@Query(value = "SELECT * FROM catalog_item u WHERE u.category=?1", nativeQuery = true)
	List<CatalogItem> findAllByCategory(String keyword);
}
