package com.capg.greatoutdoor.ordermanagement.service;

import java.util.List;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;

import com.capg.greatoutdoor.ordermanagement.model.OrderDTO;
import com.capg.greatoutdoor.ordermanagement.model.ProductDto;

public interface IOrderService {



	OrderDTO viewOrder(String orderId);



	void cancelOrder(String orderId);

	void cancelProduct(String orderId, String productId);


	OrderDTO addOrder(OrderDTO orderDto);



	List<ProductDto> getProducts(String userId);
	List<ProductDto> getProductsByOrderId(String orderId);


	List<String> getOrderByUserId(String userId);



	

	



}
