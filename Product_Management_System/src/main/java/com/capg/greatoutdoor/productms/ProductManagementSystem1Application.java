package com.capg.greatoutdoor.productms;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductManagementSystem1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProductManagementSystem1Application.class, args);
	}
@Bean
public Random getRandom()
{
return new Random();	
}
@Bean
public RestTemplate getRestTemplate()
{
return new RestTemplate();	
}
}
