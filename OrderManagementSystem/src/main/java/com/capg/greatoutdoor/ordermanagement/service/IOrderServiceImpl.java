package com.capg.greatoutdoor.ordermanagement.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.greatoutdoor.ordermanagement.model.OrderDTO;
import com.capg.greatoutdoor.ordermanagement.model.ProductDto;
import com.capg.greatoutdoor.ordermanagement.repository.IOrderRepository;
@Service
public class IOrderServiceImpl implements IOrderService {
@Autowired
private IOrderRepository orderRepository;
@Autowired
private Random random;
@Autowired
private RestTemplate restTemplate;
LocalDate date=LocalDate.now();

LocalDateTime time=LocalDateTime.now();
LocalDateTime cancelTime=time.plusMinutes(1);
	@Override
	public OrderDTO addOrder(OrderDTO orderDto) {
		// TODO Auto-generated method stub
	orderDto.setOrderDispatcherStatus(0);
	orderDto.setProductUniqueId((random.nextInt(100000)));
	orderDto.setOrderInitiateTime(time);
	orderDto.setOrderDispatchTime(cancelTime);
	orderDto.setOrderId(String.valueOf(Math.abs(random.nextInt())).substring(0,4));
	System.err.println(time+" "+cancelTime);
	for (String product : orderDto.getProductsList()) {
		restTemplate.put("http://localhost:8200/cart/removefromcart/"+orderDto.getUserId()+"/"+product, null);
	}
	
	restTemplate.put("http://localhost:8400/userdata/setorder/"+orderDto.getUserId()+"/"+orderDto.getOrderId(), null);
	return orderRepository.save(orderDto);
	
	}

	@Override
	public OrderDTO viewOrder(String orderId) {
		// TODO Auto-generated method stub
		OrderDTO order=orderRepository.getOne(orderId);
		return order;
	}



	@Override
	public void cancelOrder(String orderId) {
		// TODO Auto-generated method stub
		OrderDTO orderObject=orderRepository.getOne(orderId);
		
		if(time.isBefore(orderObject.getOrderDispatchTime()))
		{	
			
			restTemplate.put("http://localhost:8400/userdata/orderremove/"+orderObject.getUserId(), null);
			orderRepository.delete(orderObject);
			
		}
		else
		{
			throw new RuntimeException("order cannot be deleted");
		}
		
	}

	@Override
	public void cancelProduct(String orderId, String productId) {
		// TODO Auto-generated method stub
		OrderDTO orderObject=orderRepository.getOne(orderId);
		if(time.isBefore(orderObject.getOrderDispatchTime()))
		{
			if(orderObject.getProductsList()==null)
			{
				orderRepository.deleteById(orderId);
			}
			restTemplate.put("http://localhost:8400/userdata/orderproductremove/"+orderObject.getUserId()+"/"+productId, null);
			orderObject.getProductsList().remove(productId);
			orderRepository.save(orderObject);
			
		}
		else
		{
			throw new RuntimeException("order cannot be deleted");
		}
		
	}

	@Override
	public List<ProductDto> getProducts(String userId) {
		// TODO Auto-generated method stub
		List<ProductDto> products=new ArrayList<>();
		List<OrderDTO> productsList=orderRepository.findByUserId(userId);
		for (OrderDTO order  : productsList) {
			System.out.println(order);
			for (String productId : order.getProductsList()) {
				ProductDto productObject=restTemplate.getForObject("http://localhost:8300/productmaster/get/productId/"+productId, ProductDto.class);
				products.add(productObject);
			}
			
		}
		return products;
	}

	@Override
	public List<String> getOrderByUserId(String userId) {
		List<OrderDTO> orders=orderRepository.findOrdersByUserId(userId);
		List<String> orderIdsList=new ArrayList<>();
		System.out.println(orders);
		for ( OrderDTO order: orders) {
			orderIdsList.add(order.getOrderId());
		}
		
				return orderIdsList;
	}

	@Override
	public List<ProductDto> getProductsByOrderId(String orderId) {
		// TODO Auto-generated method stub
		OrderDTO myOrder=orderRepository.getOne(orderId);
		List<String> productList=myOrder.getProductsList();
		List<ProductDto> products=new ArrayList<>();
		for (String string : productList) {
			ProductDto productObject=restTemplate.getForObject("http://localhost:8300/productmaster/get/productId/"+string, ProductDto.class);
			products.add(productObject);
		}
		return products;
	}




}
