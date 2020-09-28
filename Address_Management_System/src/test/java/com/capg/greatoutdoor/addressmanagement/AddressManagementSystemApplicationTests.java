package com.capg.greatoutdoor.addressmanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.greatoutdoor.addressmanagement.exceptions.AddressDoesnotExist;
import com.capg.greatoutdoor.addressmanagement.model.Address;
import com.capg.greatoutdoor.addressmanagement.service.AddressServiceImplementation;

@SpringBootTest
class AddressManagementSystemApplicationTests {

	@Autowired
	AddressServiceImplementation service;
	Address address1, address2;
	@BeforeEach
	public void init()
	{
		address1=new Address("","91391","b-11","Tandur","Telangana","chopper","501158");
		address2=new Address("1452","91391","b-11","hyderabad","telangana","chopper","500049");
	
	}

	
	

	@Test
	public void testAddCenter()
	{
	
		assertEquals(true,service.addAddress(address1));
	}
	
	@Test
	public void testAddressDoesnotExistException() {
		 
		
		Assertions.assertThrows(AddressDoesnotExist.class,
				  ()->service.deleteAddress(address2.getAddressId()));
	} 
	
	@Test
	public void testDeleteAddress() {
		 
		
		assertEquals(true,service.deleteAddress(address1.getAddressId()));
	} 
	
	
}
