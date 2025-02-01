package com.ashmitagarwal.ecommerce.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController()
@RequestMapping("/cart")
public class ShoppingCartController {
	
	@PostMapping("/add")
	public boolean addItemToCart(@RequestBody(required = true) String addToCartDetails) throws JsonProcessingException {
		
		System.out.println("Add to cart :" + addToCartDetails);
		ObjectMapper mapper = new ObjectMapper();		
		Map<String,String> productIdObj = mapper.readValue(addToCartDetails, Map.class);
		System.out.println("Add to cart :" + productIdObj.get("productId"));
		return true;
	}

}
