package com.capg.greatoutdoor.wishlistms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.greatoutdoor.wishlistms.model.ProductDto;
import com.capg.greatoutdoor.wishlistms.service.IWishListService;

@RestController
@RequestMapping("/wishlist")
public class WishListController {
	@Autowired
	IWishListService service;
	@PostMapping("/addtowishlist/{userId}")
	public boolean addProductToWishList(@RequestBody ProductDto productObject,@PathVariable String userId)
	{
		return service.addProductToWishList(productObject,userId);
	}

}
