package com.capg.greatoutdoor.cartmanagement.service;

import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.greatoutdoor.cartmanagement.model.CartDTO;
import com.capg.greatoutdoor.cartmanagement.repository.ICartRepo;
@Service
public class CartServiceImpl implements ICartManagementService {
@Autowired
private ICartRepo cartRepo;
//	@Override
//	public CartDTO addToCart(CartDTO cart) {
//		System.out.println(cart.getUserId());
//		// TODO Auto-generated method stub
//		if(cartRepo.existsById(cart.getUserId()))
//		{
//			 CartDTO cartObject=cartRepo.getOne(cart.getUserId());
//			
//			//if(cartObject.getProductId().)
//			 
//			 //for (String pList: cartObject.getProductId()) {
//				if(cartObject.getProductId().equals(cart.getProductId()))
//				{
//					int quantity=cartObject.getQuantity()+cart.getQuantity();
//					cartObject.setQuantity(quantity);
//					return cartRepo.save(cartObject);
//				}
//				else
//				{
//					cartObject.setProductId(cart.getProductId());
//					cartObject.setQuantity(cart.getQuantity());
//					return cartRepo.save(cartObject);
//				}		
//				
//		}
//		else
//		{
//			CartDTO addCart = new CartDTO();
//			addCart.setUserId(cart.getUserId());
//			addCart.setQuantity(cart.getQuantity());
//			addCart.setProductId(cart.getProductId());
//			return cartRepo.save(addCart);
//		}
//			
//	}

	@Override
	public boolean removeFromCart(String productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CartDTO viewAllProductsInCart(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDTO addToCart(CartDTO cart) {
		// TODO Auto-generated method stub
		if(cartRepo.existsById(cart.getUserId()))
		{
			 CartDTO cartObject=cartRepo.getOne(cart.getUserId());
			// Set<String> productList=cart.getDetails().keySet();
			HashMap<String,Integer> map=cart.getDetails();
//			if(cartObject.getDetails().containsKey(map))
//			{
//				
//			}
			Set<String> keys=map.keySet();
			Set<String> existingKeys=cartObject.getDetails().keySet();
			
			for (String string : keys) {
				if(existingKeys.contains(string))
				{
					int q=cartObject.getDetails().get(string)+map.get(string);
					cartObject.getDetails().replace(string, q);
					
				}
				else
				{
					cartObject.setDetails(cart.getDetails());
				}
			}
			return cartRepo.save(cartObject);
		}
		else {
		
			return cartRepo.save(cart);
		}
	//	return null;
	}

//	@Override
//	public CartDTO addToCart(CartDTO cart) {
//		// TODO Auto-generated method stub
//		boolean flag=false;
//		if(cartRepo.existsById(cart.getUserId()))
//		{
//			 CartDTO cartObject=cartRepo.getOne(cart.getUserId());
//			
//			 for (String pList: cartObject.getProductId()) {
//			if(cartObject.getProductId().equals(cart.getProductId()))
//			{
//				flag=true;
//				break;
//				
//			}
//		}
//			 if(flag==true)
//			 {
//				 int quantity=cartObject.getQuantity()+cart.getQuantity();
//					cartObject.setQuantity(quantity);
//			 }
//			 else
//			 {
//				 cartObject.setProductId(cart.getProductId());
//					cartObject.setQuantity(cart.getQuantity());
//					return cartRepo.save(cartObject);
//			 }
//			 return cartRepo.saveAndFlush(cartObject);
//		}
//		else
//		{
//			
//			CartDTO addCart = new CartDTO();
//			addCart.setUserId(cart.getUserId());
//			addCart.setQuantity(cart.getQuantity());
//			addCart.setProductId(cart.getProductId());
//			return cartRepo.saveAndFlush(addCart);
//		}
//		
//			
//	}

}
