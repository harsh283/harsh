package com.capg.greatoutdoor.addressmanagement;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddressManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressManagementSystemApplication.class, args);
	}
@Bean
public Random getRandomObject()
{
return new Random();

}
}
