package com.capg.greatoutdoor.wishlistms.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.greatoutdoor.wishlistms.model.ProductDto;
import com.capg.greatoutdoor.wishlistms.model.User;
import com.capg.greatoutdoor.wishlistms.model.WishList;
import com.capg.greatoutdoor.wishlistms.repo.WishListRepository;

@Service
public class WishListServiceImpl implements IWishListService {
@Autowired
private WishListRepository repo;
@Autowired
private RestTemplate restTemplate;
@Autowired
private Random random;

	@Override
	public boolean addProductToWishList(ProductDto productObject,String userId) {
		// TODO Auto-generated method stub
		String wishListId=String.valueOf(random.nextInt(1000)).substring(0, 3);
		WishList wishToAdd=new WishList();
	
		wishToAdd.setProduct(productObject);
		wishToAdd.setUserId(userId);
		wishToAdd.setWishListId(wishListId);
		restTemplate.put("http://localhost:8900/userdata/setlist/"+userId+"/"+wishListId, WishList.class);
		repo.save(wishToAdd);
		return true;
	}

}
