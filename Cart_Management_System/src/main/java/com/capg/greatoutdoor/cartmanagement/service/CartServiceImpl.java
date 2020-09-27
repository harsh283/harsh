package com.capg.greatoutdoor.cartmanagement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.greatoutdoor.cartmanagement.exception.ProductIdAlreadyExists;
import com.capg.greatoutdoor.cartmanagement.exception.ProductNotFound;
import com.capg.greatoutdoor.cartmanagement.exception.UserNotFound;
import com.capg.greatoutdoor.cartmanagement.model.CartDTO;
import com.capg.greatoutdoor.cartmanagement.model.ProductDto;
import com.capg.greatoutdoor.cartmanagement.repository.ICartRepo;

/**
* CartServiceImp class implements the service interface and to access the cartRepository methods
*/
@Service
public class CartServiceImpl implements ICartManagementService {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ICartRepo cartRepo;
	/**
	* Adding products to cart
	*/
	@Override
	public CartDTO addToCart(CartDTO cart) {
		System.out.println(cart);
	   boolean flag=false;

	   System.out.println(cart.getProductList());
		if (cartRepo.existsById(cart.getUserId())) {
			CartDTO cartObject = cartRepo.getOne(cart.getUserId());
			for (String productId : cart.getProductList()) {
				if(cartObject.getProductList().contains(productId))
			flag=true;
			break;
			}
			
			if(flag==true)
			{
				throw new ProductIdAlreadyExists(" Product quantity can be set at ordering time");
			}
			else
			{
				for (String productId : cart.getProductList()) {
					cartObject.getProductList().add(productId);
					restTemplate.put("http://localhost:8400/userdata/setcartlist/"+cartObject.getUserId()+"/"+productId, null);
				}
				return cartRepo.save(cartObject);
			}
		}
		else
		{
			for ( String productId : cart.getProductList()) {
				restTemplate.put("http://localhost:8400/userdata/setcartlist/"+cart.getUserId()+"/"+productId, null);
			}
			
			return cartRepo.save(cart);
		}
			
	}
	
	/**
	* Removing products from cart
	*/
	@Override
	public boolean removeFromCart(String userId, String productId) throws ProductNotFound, UserNotFound {
		boolean flag = false;
		if (cartRepo.existsById(userId)) {
			CartDTO cartDto = cartRepo.getOne(userId);
			List<String> products=cartDto.getProductList();
			if (products.contains(productId)) {
				cartDto.getProductList().remove(productId);
				restTemplate.put("http://localhost:8400/userdata/removefromcart/"+userId+"/"+productId, null);
				cartRepo.save(cartDto);
				flag = true;
			} else {
				throw new ProductNotFound("product not found");
			}
		} else {
			throw new UserNotFound("invalid user");
		}

		return flag;
	}
	/**
	* fetching all products from cart
	*/
	@Override
	public List<ProductDto> viewAllProductsInCart(String userId) throws UserNotFound {
		
		if (cartRepo.existsById(userId)) {
			CartDTO cartDto = cartRepo.getOne(userId);
			List<ProductDto> productList=new ArrayList<>();
			
			for (String productId : cartDto.getProductList()) {
				ProductDto productObject=restTemplate.getForObject("http://localhost:8300/productmaster/get/productId/"+productId, ProductDto.class);
				productList.add(productObject);
			}
			
			return productList;
		} 
		else 
		{
			throw new UserNotFound("invalid user");
		}

	}

	@Override
	public void removeProduct(String userId, String productId) {
		// TODO Auto-generated method stub
		CartDTO cart=cartRepo.getOne(userId);
		cart.getProductList().remove(productId);
		cartRepo.save(cart);
		
	}
}
