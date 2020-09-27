package com.capg.greatoutdoor.cartmanagement.service;

import java.util.List;

import com.capg.greatoutdoor.cartmanagement.exception.ProductNotFound;
import com.capg.greatoutdoor.cartmanagement.exception.UserNotFound;
import com.capg.greatoutdoor.cartmanagement.model.CartDTO;
import com.capg.greatoutdoor.cartmanagement.model.ProductDto;

public interface ICartManagementService {
	public CartDTO addToCart(CartDTO cart);

	public boolean removeFromCart(String userId, String productId) throws ProductNotFound, UserNotFound;

	public List<ProductDto> viewAllProductsInCart(String userId) throws UserNotFound;

	public void removeProduct(String userId, String productId);
}
