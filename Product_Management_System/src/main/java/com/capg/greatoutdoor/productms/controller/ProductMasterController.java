package com.capg.greatoutdoor.productms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.greatoutdoor.productms.exceptions.UserNotFoundException;
import com.capg.greatoutdoor.productms.model.ProductDto;
import com.capg.greatoutdoor.productms.model.ProductMaster;
import com.capg.greatoutdoor.productms.service.IProductMsService;
@RestController
@RequestMapping("/productmaster")
public class ProductMasterController {
	@Autowired
	private IProductMsService productService;
	@GetMapping("/getallproducts")
	List<ProductDto> viewAllProducts(){
		return productService.getAllProducts();
	}
	
	@PostMapping("/addproduct/{userId}")
	String addProduct(@PathVariable String userId,@RequestBody ProductDto product) {
		String status = "product added";
		if(productService.addProduct(userId,product)) {
			return status;
		}
		
		return "failed to add product!";
		
	}
	
	@DeleteMapping("/deleteproduct/productId/{userId}/{productId}")
	String deleteProduct(@PathVariable String userId,@PathVariable String productId) {
		if(productService.deleteProduct(userId,productId)) {
			return "product deleted!";
		}
		return "error";
	}
	
	@PutMapping("/updateproduct")
	String editProduct(@RequestBody ProductDto product) {
		String status = "product updated";
		
		if(productService.editProduct(product)) {
			return status;
		}
		
		return "fail to update product!";
		
	}
	@GetMapping("/searchproduct/productDetail/{productDetail}")
	public List<ProductDto> searchProduct(@PathVariable String productDetail)
	{
		return productService.searchProduct(productDetail);
	}
	@GetMapping("/get/productId/{productId}")
	public ProductDto getProduct(@PathVariable String productId)
	{
		return productService.getProduct(productId);
	}
	@GetMapping("/get/{userId}")
	public List<ProductDto> getProductByUserId(@PathVariable String userId)
	{
		return productService.getProductByUserId(userId);
	}
	@GetMapping("/login/{userId}/{userPassword}")
	public ProductMaster login(@PathVariable String userId,@PathVariable String userPassword) throws UserNotFoundException
	{
	return productService.login(userId,userPassword);	
	}

	
	
}
