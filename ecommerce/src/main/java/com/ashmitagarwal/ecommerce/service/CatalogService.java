package com.ashmitagarwal.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ashmitagarwal.ecommerce.entity.CatalogItem;
import com.ashmitagarwal.ecommerce.repository.CatalogRepository;

@Service
public class CatalogService {

	private CatalogRepository catalogRepository;
	
	CatalogService(CatalogRepository catalogRepository){
		this.catalogRepository = catalogRepository;
	}
	
	public List<CatalogItem> getFullCatalog() {
		
		return catalogRepository.findAll();
	}
}
