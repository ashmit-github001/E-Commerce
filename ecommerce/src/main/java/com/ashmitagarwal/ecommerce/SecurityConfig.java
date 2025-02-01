package com.ashmitagarwal.ecommerce;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain configureSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity
		.authorizeHttpRequests(customizer -> {
			customizer
			.requestMatchers("/login.html", "/register.html").permitAll()
			.anyRequest().authenticated();
		})
		.formLogin(customizer -> {
			customizer
			.loginPage("/login.html")
			.loginProcessingUrl("/login")
			.defaultSuccessUrl("/catalog.html")
			.permitAll();
		})
		.csrf(customizer -> customizer.disable());
		
		return httpSecurity.build();		
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails userDetails1 = User
				.withUsername("ram")
				.passwordEncoder(password -> passwordEncoder().encode(password)) //OR .passwordEncoder(passwordEncoder()::encode)
				.password("test")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(userDetails1);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
}
