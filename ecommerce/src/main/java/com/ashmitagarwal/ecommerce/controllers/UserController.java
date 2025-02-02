package com.ashmitagarwal.ecommerce.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashmitagarwal.ecommerce.dto.UserDTO;
import com.ashmitagarwal.ecommerce.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	UserController(UserService userService){
		this.userService = userService;
	}
	@PostMapping("/register")
	public String registerUser(@RequestBody UserDTO userDto) {
		return userService.registerUser(userDto);
	}
}
