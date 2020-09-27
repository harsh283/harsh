package com.capg.greatoutdoor.greatoutdoormanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.greatoutdoor.greatoutdoormanagement.model.Address;
import com.capg.greatoutdoor.greatoutdoormanagement.model.CartDTO;
import com.capg.greatoutdoor.greatoutdoormanagement.model.OrderDTO;
import com.capg.greatoutdoor.greatoutdoormanagement.model.ProductDto;
import com.capg.greatoutdoor.greatoutdoormanagement.model.User;
import com.capg.greatoutdoor.greatoutdoormanagement.model.WishListDTO;
import com.capg.greatoutdoor.greatoutdoormanagement.service.IGreatOutdoorService;
@CrossOrigin
@RestController
@RequestMapping("/retailer")
public class RetailerController {
@Autowired 
private IGreatOutdoorService service;
	@PostMapping("/addcart")
	public CartDTO addToCart(@RequestBody CartDTO cart)
	{
		System.out.println(cart);
	return service.addToCart(cart);
	}
	@GetMapping("/getall")
	public List<ProductDto> getAllProducts()
	{
	return service.getallProducts();
	}
	@DeleteMapping("/removecart/{userId}/{productId}")
	public boolean removeFromCart(@PathVariable String userId,@PathVariable String productId)
	{
	return service.removeFromCart(userId,productId);
	}
	@GetMapping("/getproductsincart/{userId}")
	public List<ProductDto> getProductsInCart(@PathVariable String userId)
	{
	return service.getAllProductsInCart(userId);
	}
	@PostMapping("/placeorder")
	public OrderDTO placeOrder(@RequestBody OrderDTO order)
	{
	return service.placeOrder(order);	
	}
	@GetMapping("/orderId/{orderId}")
	public OrderDTO viewOrder(@PathVariable String orderId) {
		
		return service.viewOrder(orderId);
	}
	@DeleteMapping("/cancel/{orderId}")
	public boolean cancelOrder(@PathVariable String orderId)
	{
		return service.cancelOrder(orderId);
	}
	@DeleteMapping("/cancelproduct/{orderId}/{productId}")
	public boolean cancelProductOrder(@PathVariable String orderId,@PathVariable String productId)
	{
		return service.cancelProductOrder(orderId,productId);
	}
	@PostMapping("/addaddress")
	public boolean addAddress(@RequestBody Address order)
	{
		return service.addAddress(order);
	}
	@DeleteMapping("/deleteaddress")
	public boolean deleteAddress(@RequestBody Address addressObject)
	{
		return service.deleteAddress(addressObject);
	}
	@PutMapping("/updateaddress")
	public boolean updateAddress(@RequestBody Address address)
	{
		return service.updateAddress(address);
	}
	@GetMapping("/getaddress/{userId}")
	public List<Address> getAddressByUserId(@PathVariable String userId)
	{
	return service.getAddressByUserId(userId);
	}
	@GetMapping("/productsinwishlist/{userId}")
	public List<ProductDto> wishListProductByUserId(@PathVariable String userId)
	{
	return service.getWishListByUserId(userId);
	}
	@DeleteMapping("/delete/{userId}/{productId}")
	public boolean deleteFromWishList(@PathVariable String userId,@PathVariable String productId)
	{
		return service.deleteFromWishList(userId,productId);
	}
	@PostMapping("/addwish")
	public WishListDTO addToWishList(@RequestBody WishListDTO wishListObject)
	{
		return service.addToWishList(wishListObject);
	}
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user)
	{
		return service.addUser(user);
	}

	@PutMapping("/updateuser")
	public User updateUser(@RequestBody User user)
	{
		
		return service.updateUser(user);
	}

	@GetMapping("/login/{userId}/{password}")
	public User login(@PathVariable String userId,@PathVariable String password)
	{
		return service.userLogin(userId,password);
	}
	@GetMapping("/get/{userId}")
	public List<ProductDto> getProducts(@PathVariable String userId)
	{
		return service.getAllOrders(userId);
	}
	@GetMapping("/find/{userId}")
	public List<String> getOrders(@PathVariable String userId)
	{
		return service.getAllOrdersIds(userId);
	}
	@GetMapping("/findorderbyid/{orderId}")
	public List<ProductDto> getOrdersByOrderId(@PathVariable String orderId)
	{
		return service.getAllOrdersByOrderId(orderId);
	}
}
