package com.capg.greatoutdoor.greatoutdoormanagement.service;

import java.util.List;

import com.capg.greatoutdoor.greatoutdoormanagement.model.Address;
import com.capg.greatoutdoor.greatoutdoormanagement.model.CartDTO;
import com.capg.greatoutdoor.greatoutdoormanagement.model.OrderDTO;
import com.capg.greatoutdoor.greatoutdoormanagement.model.ProductDto;
import com.capg.greatoutdoor.greatoutdoormanagement.model.ProductMaster;
import com.capg.greatoutdoor.greatoutdoormanagement.model.User;
import com.capg.greatoutdoor.greatoutdoormanagement.model.WishListDTO;

public interface IGreatOutdoorService {
public static int i=5;
	List<ProductDto> getallProducts();
	String addProduct(String userId,ProductDto product);
	String updateProduct(ProductDto product);
	String deleteProduct(String userId,String productId);
	List<ProductDto> searchProduct(String productDetail);
	ProductDto getProduct(String productId);
	CartDTO addToCart(CartDTO cart);
	boolean removeFromCart(String userId, String productId);
	List<ProductDto> getAllProductsInCart(String userId);

	OrderDTO placeOrder(OrderDTO order);
	OrderDTO viewOrder(String orderId);
	boolean cancelOrder(String orderId);
	boolean cancelProductOrder(String orderId, String productId);
	boolean addAddress(Address order);

	boolean updateAddress(Address address);
	List<Address> getAddressByUserId(String userId);
	List<ProductDto> getWishListByUserId(String userId);
	boolean deleteFromWishList(String userId, String productId);
	WishListDTO addToWishList(WishListDTO wishListObject);
	User addUser(User user);
	boolean deleteUser(String userId);
	boolean deleteAddress(Address addressObject);
	User updateUser(User user);
	List<User> getAllUsers();

	ProductMaster registerProductMaster(ProductMaster master);
	ProductMaster loginProductMaster(String userId, String password);
	User userLogin(String userId, String password);
	List<ProductDto> getProductByUserId(String userId);
	List<ProductDto> getAllOrders(String userId);
	List<String> getAllOrdersIds(String userId);
	List<ProductDto> getAllOrdersByOrderId(String orderId);


}
