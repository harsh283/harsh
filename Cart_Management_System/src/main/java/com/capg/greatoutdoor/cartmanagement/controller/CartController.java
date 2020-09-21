package com.capg.greatoutdoor.cartmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.greatoutdoor.cartmanagement.model.CartDTO;
import com.capg.greatoutdoor.cartmanagement.service.ICartManagementService;

@RestController
@RequestMapping("/cart")
public class CartController {
@Autowired
private ICartManagementService service;
@PostMapping("/addtocart")
public CartDTO addToCart(@RequestBody CartDTO cart) {

	return service.addToCart(cart);
}
}
