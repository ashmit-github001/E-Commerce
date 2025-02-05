package com.ashmitagarwal.ecommerce.user.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ashmitagarwal.ecommerce.entity.Customer;
import com.ashmitagarwal.ecommerce.repository.CustomerRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private CustomerRepository customerRepository;
	
	UserDetailsServiceImpl(CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Customer> customer = customerRepository.findByEmail(username);
		UserDetails user = null;
		
		if(customer.isPresent()) {
			System.out.println("customer.get().getEmail() :" + customer.get().getEmail());
			System.out.println("customer.get().getPassword() :" + customer.get().getPassword());
			user = User.withUsername(username)
					.password(customer.get().getPassword())
					.build();
			System.out.println("user.getUsername() :" + user.getUsername());
			System.out.println("user.getPassword() :" + user.getPassword());
		}
		return user;
	}
}
