package com.ashmitagarwal.ecommerce;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain configureSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity
		.authorizeHttpRequests(customizer -> {
			customizer
			.requestMatchers("/login.html", "/register.html").permitAll()
			.requestMatchers("/js/*").permitAll()
			.requestMatchers("/user/*").permitAll()
			.anyRequest().authenticated();
		})
		.formLogin(customizer -> {
			customizer
			.loginPage("/login.html")
			.loginProcessingUrl("/login")
			.defaultSuccessUrl("/catalog.html")
			.permitAll();
		})
		.csrf(customizer -> customizer.disable())
		.httpBasic(Customizer.withDefaults());
		
		return httpSecurity.build();		
	}
	
	@Bean
	public AuthenticationManager authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
		
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		
		return new ProviderManager(daoAuthenticationProvider);
	}
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		
//		UserDetails userDetails1 = User
//				.withUsername("ram")
//				.passwordEncoder(password -> passwordEncoder().encode(password)) 
//				//OR .passwordEncoder(passwordEncoder()::encode)
//				.password("test")
//				//OR .password(passwordEncoder().encode("test")) without .passwordEncoder(...)
//				//.roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(userDetails1);
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
}
