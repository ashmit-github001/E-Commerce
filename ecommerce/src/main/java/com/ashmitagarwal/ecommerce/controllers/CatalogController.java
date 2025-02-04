package com.ashmitagarwal.ecommerce.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashmitagarwal.ecommerce.entity.CatalogProduct;
import com.ashmitagarwal.ecommerce.service.CatalogService;

@RestController
public class CatalogController {

	private CatalogService catalogService;
	
	CatalogController(CatalogService catalogService){
		this.catalogService = catalogService;
	}
	
	@GetMapping("/allProducts")
	public List<CatalogProduct> getFullCatalog() {
		return catalogService.getFullCatalog();
	}
	
	@GetMapping("/getProductsByKeywords")
	public List<CatalogProduct> getProductsByKeywords(@RequestParam("keywords") String keywords) {
		return catalogService.getProductsByKeywords(keywords);
	}
}
