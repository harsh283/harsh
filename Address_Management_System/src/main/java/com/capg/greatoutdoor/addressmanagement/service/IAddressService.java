package com.capg.greatoutdoor.addressmanagement.service;

import java.util.List;

import com.capg.greatoutdoor.addressmanagement.model.Address;

public interface IAddressService {

	boolean addAddress(Address addressObject);
	List<Address> getAllAddress(String userId);
	boolean deleteAddress(Address address);
	boolean updateAddress(Address address);
	

}
