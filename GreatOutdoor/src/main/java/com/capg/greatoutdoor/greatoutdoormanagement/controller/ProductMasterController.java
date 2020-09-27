package com.capg.greatoutdoor.greatoutdoormanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.greatoutdoor.greatoutdoormanagement.model.ProductDto;
import com.capg.greatoutdoor.greatoutdoormanagement.model.ProductMaster;
import com.capg.greatoutdoor.greatoutdoormanagement.service.IGreatOutdoorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("productmaster")
public class ProductMasterController {

	@Autowired
	private IGreatOutdoorService service;
	
	@GetMapping("/getall")
	public List<ProductDto> getAllProducts()
	{
	return service.getallProducts();
	}
	@PostMapping("/add/{userId}")
	public String addProduct(@PathVariable String userId,@RequestBody ProductDto product)
	{
		return service.addProduct(userId,product);
	}
	@PutMapping("/update")
	public String updateProduct(@RequestBody ProductDto product)
	{
		return service.updateProduct(product);
	}
	@DeleteMapping("/delete/{userId}/{productId}")
	public String deleteProduct(@PathVariable String userId,@PathVariable String productId)
	{
		return service.deleteProduct(userId,productId);
	}
	@GetMapping("/searchproduct/{productDetail}")
	public List<ProductDto> searchProduct(@PathVariable String productDetail)
	{
		return service.searchProduct(productDetail);
	}
	@GetMapping("/getproduct/{productId}")
	public ProductDto getProduct(@PathVariable String productId)
	{
		return service.getProduct(productId);
	}
	@GetMapping("/login/{userId}/{password}")
	public ProductMaster login(@PathVariable String userId,@PathVariable String password)
	{
		return service.loginProductMaster(userId,password);
	}
	@GetMapping("/get/{userId}")
	public List<ProductDto> getProductByUserId(@PathVariable String userId)
	{
		return service.getProductByUserId(userId);
	}
}
