package com.capg.greatoutdoor.productms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.greatoutdoor.productms.model.ProductDto;
import com.capg.greatoutdoor.productms.service.IProductMsService;
@RestController
@RequestMapping("/retailer")
public class RetailerController {
	@Autowired
	private IProductMsService productService;
	@GetMapping("/searchproduct/productDetail/{productDetail}")
	public List<ProductDto> searchProduct(@PathVariable String productDetail)
	{
		return productService.searchProduct(productDetail);
	}
}
