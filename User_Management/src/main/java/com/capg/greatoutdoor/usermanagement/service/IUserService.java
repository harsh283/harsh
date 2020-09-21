package com.capg.greatoutdoor.usermanagement.service;

import java.util.List;

import com.capg.greatoutdoor.usermanagement.model.User;

public interface IUserService {

	User add(User user);

	User setTheWishList(String userId, String productId);


	List<User> getAllUsers();

}
