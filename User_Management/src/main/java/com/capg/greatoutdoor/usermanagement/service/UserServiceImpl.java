package com.capg.greatoutdoor.usermanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.greatoutdoor.usermanagement.exceptions.ContactNumberAlreadyExistException;
import com.capg.greatoutdoor.usermanagement.exceptions.EmailAlreadyExistException;
import com.capg.greatoutdoor.usermanagement.exceptions.IllegalUserException;
import com.capg.greatoutdoor.usermanagement.exceptions.PasswordIncorrectException;
import com.capg.greatoutdoor.usermanagement.exceptions.UserEmailInvalidException;
import com.capg.greatoutdoor.usermanagement.exceptions.UserNameAlreadyExistException;
import com.capg.greatoutdoor.usermanagement.exceptions.UserNameInvalidException;
import com.capg.greatoutdoor.usermanagement.exceptions.UserNotFoundException;
import com.capg.greatoutdoor.usermanagement.exceptions.UserNumberInvalidException;
import com.capg.greatoutdoor.usermanagement.exceptions.UserPasswordInvalidException;
import com.capg.greatoutdoor.usermanagement.model.User;
import com.capg.greatoutdoor.usermanagement.repository.IUserRepository;
@Service
public class UserServiceImpl implements IUserService{
@Autowired
private IUserRepository userRepo;
@Autowired
private Random random;
	@Override
	public User add(User user) {
		// TODO Auto-generated method stub
		if(user.getUserRole().equals("retailer")||user.getUserRole().equals("sales representative"))
		{
		Pattern p1=Pattern.compile("[A-Z]{1}[a-zA-Z0-9]{6,14}$");
		Matcher m1=p1.matcher(user.getUserName());
		Pattern p2=Pattern.compile("^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{8,20}$");
		Matcher m2=p2.matcher(user.getUserPassword());
		Pattern p3=Pattern.compile("^(.+)@(.+)$");
		Matcher m3=p3.matcher(user.getUserMail());
		Pattern p4=Pattern.compile("\\d{10}");
		Matcher m4=p4.matcher(String.valueOf(user.getUserNumber()));
		if(!(m1.find() &&  m1.group().equals(user.getUserName())))
		{
			throw new UserNameInvalidException("Username should start with capital letter ad size should be 6-14  characters");
			
		}
		else if(!( m2.find() &&  m2.group().equals(user.getUserPassword())) )
		{
   			throw new UserPasswordInvalidException("User password must contain "
   					+ "capital letter,small letters and special character "
   					+ "without starting with number and range should be between 8 and 20");
		}
		else if(!( m3.find() &&  m3.group().equals(user.getUserMail())) )
		{
   			throw new UserEmailInvalidException("user email is not valid");
		}
		/*
		 * else if(!( m4.find() && m4.group().equals(user.getUserNumber())) ) { throw
		 * new
		 * UserNumberInvalidException("contact number should contain 10 digits and starting may be 7,8 or 9"
		 * ); }
		 */
		else if(userRepo.getUserByUserName(user.getUserName())!=null)
			throw new UserNameAlreadyExistException("User with Name "+user.getUserName()+" already exist");
		
		else if(userRepo.getUserByUserNumber(user.getUserNumber())!=null)
			throw new ContactNumberAlreadyExistException("User with ContactNumber "+user.getUserNumber()+" already exist");
		
		else if(userRepo.getUserByUserMail(user.getUserMail())!=null)
			throw new EmailAlreadyExistException("User with Email "+user.getUserMail()+" already exist");
		 else
		
			 user.setUserId(String.valueOf(random.nextInt(10000)));
		  System.out.println(user.getUserId());
		  userRepo.save(user);
		  User user1 = userRepo.getOne(user.getUserId());
		   return user1;
		}
		else
			throw new IllegalUserException("You have entered  wrong user role");
		
		
	}
	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		if(userRepo.existsById(user.getUserId()))
		{
			User existingUser=userRepo.getOne(user.getUserId());
			existingUser.setUserPassword(user.getUserPassword());
			existingUser.setUserMail(user.getUserMail());
			existingUser.setUserNumber(user.getUserNumber());
			return userRepo.save(existingUser);
		}
		else
		{
			throw new UserNotFoundException("User with userId : "+user.getUserId()+" doesnot exist");
		}
	}
	@Override
	public boolean deleteUser(String userId) {
		// TODO Auto-generated method stub
		if(userRepo.existsById(userId))
		{
			userRepo.deleteById(userId);
			return true;
		}
		else
		{
			throw new UserNotFoundException("User with userId : "+userId+" doesnot exist");
		}

	}
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		if(userRepo.findAll()==null)
		{
			throw new UserNotFoundException(" User list is empty ");
		}
		List<User> userList=userRepo.findAll();
		return userList;
	}
	
	
	
	
	
	@Override
	public void setTheWishList(String userId, String productId) {
		// TODO Auto-generated method stub
		User user=userRepo.getOne(userId);
		List<String> ids=new ArrayList<>();
		if(user.getWishListIds()==(null))
		{
			ids.add(productId);
			user.setWishListIds(ids);
			userRepo.save(user);
		}
		else
		{
			user.getWishListIds().add(productId);
		    userRepo.save(user);
		}	
	}

	
	
	
	
	
	@Override
	public void deleteFromTheWishList(String userId, String productId) {
		// TODO Auto-generated method stub
		User user=userRepo.getOne(userId);
		User userWishList= userRepo.getOne(userId);
		userWishList.getWishListIds().remove(productId);
		userRepo.save(userWishList);
		
	}

	@Override
	public void setCartListData(String userId, String productId) {
		// TODO Auto-generated method stub
		User user=userRepo.getOne(userId);
		User userCartList= userRepo.getOne(userId);
		
		userCartList.getCartList().add(productId);
		userRepo.save(userCartList);
		
	}
	@Override
	public void setAddressListData(String userId, String addressId) {
	
		
				User userAddressList= userRepo.getOne(userId);
				
				userAddressList.getAddressIds().add(addressId);
				userRepo.save(userAddressList);
		
		
	}
	@Override
	public void setOrderData(String userId, String orderId) {
		// TODO Auto-generated method stub
		
		User userOrderList= userRepo.getOne(userId);
		
		userOrderList.getOrderIds().add(orderId);
		userRepo.save(userOrderList);
	}
	@Override
	public void setOrdersToNull(String userId, String productId) {
		// TODO Auto-generated method stub
		User userOrder= userRepo.getOne(userId);
		userOrder.getOrderIds().remove(productId);
		userRepo.save(userOrder);
		
	}
	@Override
	public void setOrderObjectToNull(String userId) {
		// TODO Auto-generated method stub
		User userOrder= userRepo.getOne(userId);
		userOrder.setOrderIds(null);
		userRepo.save(userOrder);
		
	}
	@Override
	public void removeProduct(String userId, String productId) {
		// TODO Auto-generated method stub
		User userCart= userRepo.getOne(userId);
		userCart.getCartList().remove(productId);
		userRepo.save(userCart);
		
	}
	@Override
	public User getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		User user=userRepo.getOne(userId);
		return user;
	}
	@Override
	public void deleteAddressData(String userId, String addressId) {
		// TODO Auto-generated method stub
		User userOrder= userRepo.getOne(userId);
		userOrder.getAddressIds().remove(addressId);
		userRepo.save(userOrder);
		
	}
	@Override
	public User login(String userId, String userPassword) {
		// TODO Auto-generated method stub
		if(userRepo.existsById(userId))
		{
		User user = userRepo.getOne(userId);
			if(user.getUserPassword().equals(userPassword))
			{
				return user;
			}
			throw new PasswordIncorrectException("Password is incorrect");
	
		}
		else
		{
			throw new UserNotFoundException(" User with user id "+userId+" doesnot exist");
		}
	}
	

}
