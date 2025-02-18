package com.ashmitagarwal.ecommerce.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ashmitagarwal.ecommerce.dto.UserDTO;
import com.ashmitagarwal.ecommerce.entity.Customer;
import com.ashmitagarwal.ecommerce.repository.CustomerRepository;

@Service
public class UserServiceImpl implements UserService {

	private CustomerRepository customerRepository;
	
	private PasswordEncoder passwordEncoder;
	
	UserServiceImpl(CustomerRepository customerRepository, PasswordEncoder passwordEncoder){
		this.customerRepository = customerRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public String registerUser(UserDTO userDto) {
		
		Optional<Customer> cust = customerRepository.findByEmail(userDto.getEmail());
		if(cust.isPresent())
			return "User already exists!";
		else {
			userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
			customerRepository.save(new Customer(userDto));
			return "User registered successfully!";
		}
	}
}
