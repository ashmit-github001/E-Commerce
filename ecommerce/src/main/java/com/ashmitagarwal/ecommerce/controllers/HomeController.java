package com.ashmitagarwal.ecommerce.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashmitagarwal.ecommerce.entity.CatalogItem;
import com.ashmitagarwal.ecommerce.service.CatalogService;

@RestController
public class HomeController {

	private CatalogService catalogService;
	
	HomeController(CatalogService catalogService){
		this.catalogService = catalogService;
	}
	
	@GetMapping("/allProducts")
	public List<CatalogItem> getFullCatalog() {
		return catalogService.getFullCatalog();
	}
}
