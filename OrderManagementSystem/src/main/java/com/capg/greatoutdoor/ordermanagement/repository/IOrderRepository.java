package com.capg.greatoutdoor.ordermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.greatoutdoor.ordermanagement.model.OrderDTO;

public interface IOrderRepository extends JpaRepository<OrderDTO, String> {
List<OrderDTO> findByUserId(String userId);
List<OrderDTO> findOrdersByUserId(String userId);
}
