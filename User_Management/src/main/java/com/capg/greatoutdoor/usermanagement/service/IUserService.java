package com.capg.greatoutdoor.usermanagement.service;

import java.util.List;

import com.capg.greatoutdoor.usermanagement.model.User;

public interface IUserService {

	User add(User user);
	List<User> getAllUsers();
	void setTheWishList(String userId, String productId);
	void deleteFromTheWishList(String userId, String productId);
	void setCartListData(String userId, String productId);
	void setAddressListData(String userId, String addressId);
	void setOrderData(String userId, String orderId);
	void setOrdersToNull(String userId, String productId);
	void setOrderObjectToNull(String userId);
	void removeProduct(String userId, String productId);
	User updateUser(User user);
	boolean deleteUser(String userId);

	User getUserByUserId(String userId);
	void deleteAddressData(String userId, String addressId);
	User login(String userId, String userPassword);

}
