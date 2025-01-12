package com.ashmitagarwal.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ashmitagarwal.ecommerce.entity.CatalogItem;

public interface CatalogRepository extends JpaRepository<CatalogItem, String> {

}
