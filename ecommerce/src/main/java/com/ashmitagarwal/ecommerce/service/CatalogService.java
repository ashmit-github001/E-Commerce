package com.ashmitagarwal.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ashmitagarwal.ecommerce.entity.CatalogProduct;
import com.ashmitagarwal.ecommerce.repository.CatalogRepository;

@Service
public class CatalogService {

	private CatalogRepository catalogRepository;
	
	CatalogService(CatalogRepository catalogRepository){
		this.catalogRepository = catalogRepository;
	}
	
	public List<CatalogProduct> getFullCatalog() {
		
		return catalogRepository.findAll();
	}
	
	public List<CatalogProduct> getProductsByKeywords(String keywords) {
		
		System.out.println(keywords);
		//String[] uniqueKeywords = keywords.split(" ");
		return catalogRepository.findAllByCategory(keywords);
	}
}
