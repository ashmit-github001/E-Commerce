package com.ashmitagarwal.ecommerce.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.ashmitagarwal.ecommerce.entity.CatalogProduct;
import com.ashmitagarwal.ecommerce.entity.Customer;
import com.ashmitagarwal.ecommerce.entity.ShoppingCartItem;
import com.ashmitagarwal.ecommerce.repository.CatalogRepository;
import com.ashmitagarwal.ecommerce.repository.CustomerRepository;
import com.ashmitagarwal.ecommerce.repository.ShoppingCartRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ShoppingCartService {
	
	private ShoppingCartRepository shoppingCartRepository;
	private CatalogRepository catalogRepository;
	private CustomerRepository customerRepository;
	
	ShoppingCartService(ShoppingCartRepository shoppingCartRepository, CatalogRepository catalogRepository, CustomerRepository customerRepository){
		this.shoppingCartRepository = shoppingCartRepository;
		this.catalogRepository = catalogRepository;
		this.customerRepository = customerRepository;
	}
	
	public boolean addItemToCart(String addToCartDetails) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();		
		Map<?,?> productIdObj = mapper.readValue(addToCartDetails, Map.class);
		String productId = (String) productIdObj.get("productId");
		System.out.println("Product id to add to cart :" + productId);
			
		Optional<CatalogProduct> product = catalogRepository.findById(productId);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		System.out.println("Username of customer for add to cart :" + userDetails.getUsername());
		
		Optional<Customer> cust = customerRepository.findByEmail(userDetails.getUsername());
		
		if(product.isPresent() && cust.isPresent()) {
			
			Customer customer = cust.get();
			System.out.println("Customer found in db : " + customer);
			
			CatalogProduct catalogProduct = product.get();
			System.out.println("Product found with this id: "  + catalogProduct);
			
			ShoppingCartItem cartItem = new ShoppingCartItem(catalogProduct, customer, 1);
			
			if(shoppingCartRepository.save(cartItem) != null)
				return true;
		}
		return false;
	}

}
