package com.capg.greatoutdoor.wishlistms.service;

import com.capg.greatoutdoor.wishlistms.model.ProductDto;

public interface IWishListService {
public boolean addProductToWishList(ProductDto productObject,String userId);
}
