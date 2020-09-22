package com.capg.greatoutdoor.ordermanagement.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.greatoutdoor.ordermanagement.model.OrderDTO;
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
LocalDate dispatchDate=date.plusDays(2);
LocalDate cantCancel=dispatchDate.MAX;
LocalDateTime time=LocalDateTime.now();
LocalDateTime cancelTime=time.plusMinutes(3);
	@Override
	public OrderDTO addOrder(OrderDTO orderDto) {
		// TODO Auto-generated method stub
	orderDto.setOrderDispatcherStatus(0);
	orderDto.setProductUIN(random.nextInt(100000));
	orderDto.setOrderInitiateTime(time);
	orderDto.setOrderDispatchTime(cancelTime);
	orderDto.setOrderId(String.valueOf(random.nextInt()).substring(0,4));
	restTemplate.put("http://localhost:8400/userdata/setorder/"+orderDto.getUserId()+"/"+orderDto.getOrderId(), null);
	return orderRepository.save(orderDto);
	
	}

	@Override
	public OrderDTO viewOrder(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDTO> viewAll() {
		// TODO Auto-generated method stub
		return null;
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
	public String dispatchDate() {
		// TODO Auto-generated method stub
		return null;
	}



}
