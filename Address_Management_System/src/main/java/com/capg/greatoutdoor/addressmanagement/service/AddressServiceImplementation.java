package com.capg.greatoutdoor.addressmanagement.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.greatoutdoor.addressmanagement.exceptions.AddressDoesnotExist;
import com.capg.greatoutdoor.addressmanagement.exceptions.EmptyAddressListException;
import com.capg.greatoutdoor.addressmanagement.model.Address;
import com.capg.greatoutdoor.addressmanagement.repository.IAddressRepository;
@Service
public class AddressServiceImplementation implements IAddressService {
@Autowired
private Random random;
@Autowired
private IAddressRepository addressRepository;
	@Override
	public boolean addAddress(Address addressObject) {
		// TODO Auto-generated method stub
		addressObject.setAddressId(String.valueOf(random.nextInt(100000)));
		addressRepository.save(addressObject);
		return true;
	}

	@Override
	public List<Address> getAllAddress(String userId) {
		// TODO Auto-generated method stub
		if(addressRepository.existsByUserId(userId))
		{
			List<Address> addressList=addressRepository.findByUserId(userId);
			return addressList;
		}
		else
		{
			throw new EmptyAddressListException("Please note that there are no address provided for this userId");
		}
	}

	@Override
	public boolean deleteAddress(Address address) {
		// TODO Auto-generated method stub
		if(addressRepository.existsById(address.getAddressId()))
		{
			addressRepository.delete(address);
			return true;
		}
		else
			throw new AddressDoesnotExist("the address doesnot exist");
	
	}

	@Override
	public boolean updateAddress(Address address) {
		// TODO Auto-generated method stub
		if(addressRepository.existsById(address.getAddressId()))
		{
			Address existingAddress=addressRepository.getOne(address.getAddressId());
			existingAddress.setBuildingNo(address.getBuildingNo());
			existingAddress.setCity(address.getCity());
			existingAddress.setField(address.getField());
			addressRepository.save(existingAddress);
			return true;
		}
		throw new AddressDoesnotExist("Please enter the valid address details");
	}

}
