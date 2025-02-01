package com.ashmitagarwal.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class AppStarter 
{
    public static void main( String[] args )
    {
        SpringApplication.run(AppStarter.class, args);
    }
}
