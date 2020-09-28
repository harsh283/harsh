package com.capg.greatoutdoor.addressmanagement.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.greatoutdoor.addressmanagement.exceptions.AddressDoesnotExist;
import com.capg.greatoutdoor.addressmanagement.exceptions.EmptyAddressListException;
import com.capg.greatoutdoor.addressmanagement.model.Address;
import com.capg.greatoutdoor.addressmanagement.repository.IAddressRepository;
/**
* AddressServiceImp class implements the service interface and to access the AddressRepository methods
*/
@Service
public class AddressServiceImplementation implements IAddressService {
@Autowired
private Random random;
@Autowired
private IAddressRepository addressRepository;
@Autowired
private RestTemplate restTemplate;
	@Override
	/**
	* add address methods adds addressIds to the user database and address to address  database 
	* @author: shambu harsh kumar
	* @Input Parameters: Address Object
	* @Returns:boolean
	* 
	*/
	public boolean addAddress(Address addressObject) {
	
		addressObject.setAddressId(String.valueOf(random.nextInt(100000)));//sets the address id with random generated number
		String addressId=addressObject.getAddressId();//gets the address ID that is being set in the above line
		restTemplate.put("http://localhost:8400/userdata/setaddresslist/"+addressObject.getUserId()+"/"+addressId, null);//adds the address to particular user
		addressRepository.save(addressObject);//saves the address in address table
		return true;
	}
	/**
	* Get list of address  by passing the userId
	* @author: shambu harsh kumar
	* @Input Parameters: retailer's id
	* @Returns:List of address
	* 
	*/
	@Override
	public List<Address> getAllAddress(String userId) {
		
		if(addressRepository.existsByUserId(userId))//searches for the address if it exists for users 
		{
			List<Address> addressList=addressRepository.findByUserId(userId);//gets the list of address for the user
			return addressList;
		}
		else
		{
			throw new EmptyAddressListException("Please note that there are no address provided for this userId");
		}
	}

	@Override
	/**
	*Delete address from address table and reflects into user table also
	* @author: shambu harsh kumar
	* @Input Parameters: AddressID
	* @Returns:boolean
	* 
	*/
	public boolean deleteAddress(String addressId) {
		// TODO Auto-generated method stub
		if(addressRepository.existsById(addressId))//checks for the address by the address Id
		{
			Address address=addressRepository.getOne(addressId);
			addressRepository.deleteById(addressId);//deletes the address from address table
			restTemplate.put("http://localhost:8400/userdata/deletefromaddresslist/"+address.getUserId()+"/"+addressId, null);//deletes address form user table
			return true;
		}
		else
			throw new AddressDoesnotExist("the address doesnot exist");
	
	}

	@Override
	/**
	* Update the address of user 
	* @author: shambu harsh kumar
	* @Input Parameters: address Object
	* @Returns:Updated Address of the user
	* 
	*/
	public boolean updateAddress(Address address) {
		// TODO Auto-generated method stub
		if(addressRepository.existsById(address.getAddressId()))//check whether the address exists in address table
		{
			Address existingAddress=addressRepository.getOne(address.getAddressId());//if exists then get the address into a variable of address
			existingAddress.setBuildingNo(address.getBuildingNo());//set  the buuilding number
			existingAddress.setCity(address.getCity());//set the city
			existingAddress.setField(address.getField());//set field
			addressRepository.save(existingAddress);//save the address
			return true;
		}
		throw new AddressDoesnotExist("Please enter the valid address details");
	}

}
