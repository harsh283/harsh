package com.capg.greatoutdoor.wishlistmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.greatoutdoor.wishlistmanagement.exceptions.ProductAlreadyExistsException;
import com.capg.greatoutdoor.wishlistmanagement.exceptions.UserDoesnotExistsException;
import com.capg.greatoutdoor.wishlistmanagement.model.ProductDto;
import com.capg.greatoutdoor.wishlistmanagement.model.WishListDTO;
import com.capg.greatoutdoor.wishlistmanagement.repository.IWishListRepository;
@Service
public class WishListServiceImpl implements IWishListService {
@Autowired
private IWishListRepository wishListRepository;
@Autowired
private RestTemplate restTemplate;
	@Override
	public WishListDTO addToWishList(WishListDTO wishListObject) {
		// TODO Auto-generated method stub
		String product="";
		System.out.println(wishListObject.getProductIds());
		if(wishListRepository.existsById(wishListObject.getUserId()))
		{

				WishListDTO existingWishList=wishListRepository.getOne(wishListObject.getUserId());
				for (String productId : wishListObject.getProductIds()) {
					product=productId;
					if(existingWishList.getProductIds().contains(product))
					{
						throw new ProductAlreadyExistsException("Product with product id "+productId+" already exists");
					}
					existingWishList.getProductIds().add(product);	
					restTemplate.put("http://localhost:8400/userdata/setlist/"+wishListObject.getUserId()+"/"+product,null);
				}
				
				
				return wishListRepository.save(existingWishList);
				
		}
		else
		{
			System.err.println(product+"dhidqhdihiadhiajdiofjoisfhoisfhifhievh");
			restTemplate.put("http://localhost:8400/userdata/setlist/"+wishListObject.getUserId()+"/"+product,null);
			return wishListRepository.save(wishListObject);
		}
		
	}
	@Override
	public boolean deleteFromWishList(String userId, String productId) {
		// TODO Auto-generated method stub
		if(wishListRepository.existsById(userId))
		{
			WishListDTO existingWishList=wishListRepository.getOne(userId);
			existingWishList.getProductIds().remove(productId);
			restTemplate.delete("http://localhost:8400/userdata/deletelist/"+userId+"/"+productId);
			wishListRepository.save(existingWishList);
			return true;
		}
		throw new UserDoesnotExistsException("User with userId "+userId+" doesnot exist");
	}
	@Override
	public List<ProductDto> viewProductsInWishList(String userId) {
		// TODO Auto-generated method stub
		if(wishListRepository.existsById(userId))
		{
		WishListDTO wishListObject=wishListRepository.getOne(userId);
		List<String> products= wishListObject.getProductIds();
		System.out.println(products);
		List<ProductDto> productList=new ArrayList<>();
		for (String string : products) {
			ProductDto product=restTemplate.getForObject("http://localhost:8300/productmaster/get/productId/"+string, ProductDto.class);
			System.out.println(product);
			productList.add(product);
		}
		
		return productList;
		
	}
		else throw new RuntimeException("dhajd");
		
	

}
}