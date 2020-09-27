package com.capg.greatoutdoor.greatoutdoormanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.greatoutdoor.greatoutdoormanagement.model.Address;
import com.capg.greatoutdoor.greatoutdoormanagement.model.CartDTO;
import com.capg.greatoutdoor.greatoutdoormanagement.model.OrderDTO;
import com.capg.greatoutdoor.greatoutdoormanagement.model.ProductDto;
import com.capg.greatoutdoor.greatoutdoormanagement.model.ProductMaster;
import com.capg.greatoutdoor.greatoutdoormanagement.model.User;
import com.capg.greatoutdoor.greatoutdoormanagement.model.WishListDTO;


@Service
public class GreatOutdoorServiceImpl implements IGreatOutdoorService {

	@Autowired
	private RestTemplate restTemplate;
	@Override
	public List<ProductDto> getallProducts() {
		// TODO Auto-generated method stub
		ResponseEntity<List<ProductDto>> productEntity=restTemplate.exchange("http://localhost:8300/productmaster/getallproducts", HttpMethod.GET,null,new ParameterizedTypeReference<List<ProductDto>>() {
		});
		List<ProductDto> productList=productEntity.getBody();
		return productList;
	}

	@Override
	public String addProduct(String userId,ProductDto product) {
		// TODO Auto-generated method stub
		restTemplate.postForObject("http://localhost:8300/productmaster/addproduct/"+userId, product, String.class);
		return "Product added";
	}

	@Override
	public String updateProduct(ProductDto product) {
		// TODO Auto-generated method stub
		restTemplate.put("http://localhost:8300/productmaster/updateproduct", product,ProductDto.class);
		return "Product updated";
	}

	@Override
	public String deleteProduct(String userId,String productId) {
		// TODO Auto-generated method stub
		restTemplate.delete("http://localhost:8300/productmaster/deleteproduct/productId/"+userId+"/"+productId);
		return "Product deleted";
	}

	@Override
	public List<ProductDto> searchProduct(String productDetail) {
		// TODO Auto-generated method stub
		ResponseEntity<List<ProductDto>> productEntity=restTemplate.exchange("http://localhost:8300/productmaster/searchproduct/productDetail/"+productDetail, HttpMethod.GET,null,new ParameterizedTypeReference<List<ProductDto>>() {
		});
		List<ProductDto> productList=productEntity.getBody();
		return productList;
	}
	@Override
	public ProductMaster registerProductMaster(ProductMaster master) {
		// TODO Auto-generated method stub
		ProductMaster masterObject=restTemplate.postForObject("http://localhost:8300/admin/registermaster", master, ProductMaster.class);
		return masterObject;
	}
	@Override
	public List<ProductDto> getProductByUserId(String userId) {
		// TODO Auto-generated method stub
		ResponseEntity<List<ProductDto>> productEntity=restTemplate.exchange("http://localhost:8300/productmaster/get/"+userId, HttpMethod.GET,null,new ParameterizedTypeReference<List<ProductDto>>() {
		});
		List<ProductDto> productList=productEntity.getBody();
		return productList;
	}
	@Override
	public ProductDto getProduct(String productId) {
		// TODO Auto-generated method stub
		
		return null;
	}

	
	
	
	@Override
	public CartDTO addToCart(CartDTO cart) {
		// TODO Auto-generated method stub
		CartDTO cartObject=restTemplate.postForObject("http://localhost:8200/cart/addtocart",cart, CartDTO.class);
		return cartObject;
	}

	@Override
	public boolean removeFromCart(String userId, String productId) {
		// TODO Auto-generated method stub
		restTemplate.delete("http://localhost:8200/cart/remove/user/"+userId+"/productid/"+productId);
		return true;
	}

	@Override
	public List<ProductDto> getAllProductsInCart(String userId) {
		// TODO Auto-generated method stub
		ResponseEntity<List<ProductDto>> productEntity=restTemplate.exchange("http://localhost:8200/cart/getallproducts/userid/"+userId, HttpMethod.GET,null,new ParameterizedTypeReference<List<ProductDto>>() {
		});
		List<ProductDto> productList=productEntity.getBody();
		return productList;
	}

	@Override
	public OrderDTO placeOrder(OrderDTO order) {
		// TODO Auto-generated method stub
		OrderDTO orderObject=restTemplate.postForObject("http://localhost:8600/order/add", order, OrderDTO.class);
		return orderObject;
	}

	@Override
	public OrderDTO viewOrder(String orderId) {
		// TODO Auto-generated method stub
		OrderDTO orderObject=restTemplate.getForObject("http://localhost:8600/order/orderId/"+orderId, OrderDTO.class);
		return orderObject;
	}

	@Override
	public boolean cancelOrder(String orderId) {
		// TODO Auto-generated method stub
		restTemplate.delete("http://localhost:8600/order/delete/orderId/"+orderId);
		return true;
	}

	

	@Override
	public boolean cancelProductOrder(String orderId, String productId) {
		restTemplate.delete("http://localhost:8600/order/delete/orderId/"+orderId+"/productId/"+productId);
		return true;
	}

	@Override
	public boolean addAddress(Address address) {
		// TODO Auto-generated method stub
		restTemplate.postForObject("http://localhost:8100/address/addaddress", address,boolean.class);
		return true;
	}

	@Override
	public boolean deleteAddress(Address addressObject) {
		// TODO Auto-generated method stub
		System.out.println(addressObject);
		restTemplate.delete("http://localhost:8100/address/deleteaddress",addressObject);
		return true;
	}

	@Override
	public boolean updateAddress(Address address) {
		// TODO Auto-generated method stub
		restTemplate.put("http://localhost:8100/address/updateaddress", address);
		return true;
	}

	@Override
	public List<Address> getAddressByUserId(String userId) {
		// TODO Auto-generated method stub
		ResponseEntity<List<Address>> productEntity=restTemplate.exchange("http://localhost:8100/address/getaddress/"+userId, HttpMethod.GET,null,new ParameterizedTypeReference<List<Address>>() {
		});
		List<Address> addressList=productEntity.getBody();
		return addressList;
	}

	@Override
	public List<ProductDto> getWishListByUserId(String userId) {
		// TODO Auto-generated method stub
		ResponseEntity<List<ProductDto>> productEntity=restTemplate.exchange("http://localhost:8500/wishlist/getwishlist/"+userId, HttpMethod.GET,null,new ParameterizedTypeReference<List<ProductDto>>() {
		});
		List<ProductDto> productList=productEntity.getBody();
		return productList;
	}

	@Override
	public boolean deleteFromWishList(String userId, String productId) {
		// TODO Auto-generated method stub
		restTemplate.delete("http://localhost:8500/wishlist/delete/"+userId+"/"+productId);
		return true;
	}

	@Override
	public WishListDTO addToWishList(WishListDTO wishListObject) {
		// TODO Auto-generated method stub
		WishListDTO wishedObject=restTemplate.postForObject("http://localhost:8500/wishlist/add",wishListObject,WishListDTO.class);
		return wishedObject;
	}

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		User userPosted = restTemplate.postForObject("http://localhost:8400/userdata/add",user, User.class);
		return user;
	}


	@Override
	public boolean deleteUser(String userId) {
		// TODO Auto-generated method stub
		restTemplate.delete("http://localhost:8400/userdata/deleteuser/"+userId);
		return true;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
	restTemplate.put("http://localhost:8400/userdata/updateuser", user,User.class);
	User userObject=restTemplate.getForObject("http://localhost:8400/userdata/getuser/"+user.getUserId(), User.class);
		return userObject;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		ResponseEntity<List<User>> userEntity=restTemplate.exchange("http://localhost:8400/userdata/getallusers", HttpMethod.GET,null,new ParameterizedTypeReference<List<User>>() {
		});
		List<User> userList=userEntity.getBody();
		return userList;
	}

	@Override
	public ProductMaster loginProductMaster(String userId, String password) {
		// TODO Auto-generated method stub
		ProductMaster master = restTemplate.getForObject("http://localhost:8300/productmaster/login/"+userId+"/"+password, ProductMaster.class);
		return master;
	}

	@Override
	public User userLogin(String userId, String password) {
		// TODO Auto-generated method stub
		User user=restTemplate.getForObject("http://localhost:8400/userdata/login/"+userId+"/"+password, User.class);
		return user;
	}

	@Override
	public List<ProductDto> getAllOrders(String userId) {
		// TODO Auto-generated method stub
		ResponseEntity<List<ProductDto>> productEntity=restTemplate.exchange("http://localhost:8600/order/get/"+userId, HttpMethod.GET,null,new ParameterizedTypeReference<List<ProductDto>>() {
		});
		List<ProductDto> productList=productEntity.getBody();
		return productList;
		
	}

	@Override
	public List<String> getAllOrdersIds(String userId) {
		// TODO Auto-generated method stub
		ResponseEntity<List<String>> productEntity=restTemplate.exchange("http://localhost:8600/order/find/"+userId, HttpMethod.GET,null,new ParameterizedTypeReference<List<String>>() {
		});
		List<String> productList=productEntity.getBody();
		return productList;
	
	}

	@Override
	public List<ProductDto> getAllOrdersByOrderId(String orderId) {
		// TODO Auto-generated method stub
		ResponseEntity<List<ProductDto>> productEntity=restTemplate.exchange("http://localhost:8600/order/findbyorderid/"+orderId, HttpMethod.GET,null,new ParameterizedTypeReference<List<ProductDto>>() {
		});
		List<ProductDto> productList=productEntity.getBody();
		return productList;
	}

	







}
