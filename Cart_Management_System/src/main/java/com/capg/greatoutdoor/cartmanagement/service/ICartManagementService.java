package com.capg.greatoutdoor.cartmanagement.service;

import com.capg.greatoutdoor.cartmanagement.model.CartDTO;

public interface ICartManagementService {
CartDTO addToCart(CartDTO cart);
boolean removeFromCart(String productId);
CartDTO viewAllProductsInCart(String userId);
}
