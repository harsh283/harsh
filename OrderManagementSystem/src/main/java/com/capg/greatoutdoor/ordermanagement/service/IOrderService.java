package com.capg.greatoutdoor.ordermanagement.service;

import java.util.List;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;

import com.capg.greatoutdoor.ordermanagement.model.OrderDTO;

public interface IOrderService {



	OrderDTO viewOrder(String orderId);

	List<OrderDTO> viewAll();

	void cancelOrder(String orderId);

	void cancelProduct(String orderId, String productId);

	String dispatchDate();

	OrderDTO addOrder(OrderDTO orderDto);



}
