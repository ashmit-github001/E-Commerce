package com.ashmitagarwal.ecommerce.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashmitagarwal.ecommerce.service.ShoppingCartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController()
@RequestMapping("/cart")
public class ShoppingCartController {
	
	private ShoppingCartService shoppingCartService;
	
	ShoppingCartController(ShoppingCartService shoppingCartService){
		this.shoppingCartService = shoppingCartService;
	}
	
	@PostMapping("/add")
	public boolean addItemToCart(@RequestBody(required = true) String addToCartDetails) throws JsonMappingException, JsonProcessingException {
		
		System.out.println("Add to cart :" + addToCartDetails);
		return shoppingCartService.addItemToCart(addToCartDetails);
	}
	
	@GetMapping("/getForUser")
	public ResponseEntity<?> getUserCart() {
		
		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String email = authentication.getName();
			
			System.out.println("userEmail :" + email);
			return shoppingCartService.getUserCart(email);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}
