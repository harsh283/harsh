package com.capg.greatoutdoor.productms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.greatoutdoor.productms.exceptions.UserNotFoundException;
import com.capg.greatoutdoor.productms.model.ProductDto;
import com.capg.greatoutdoor.productms.model.ProductMaster;
import com.capg.greatoutdoor.productms.repository.IProductMasterRepository;
import com.capg.greatoutdoor.productms.repository.ProductMsRepository;
@Service
public class ProductMsServiceImpl implements IProductMsService{
	@Autowired
	private ProductMsRepository productRepository;
	@Autowired
	private IProductMasterRepository masterRepo;
	@Autowired
	private Random random;
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public List<ProductDto> getAllProducts() {
		return (List<ProductDto>) productRepository.findAll();
	}

	@Override
	public boolean addProduct(String userId,ProductDto product) {
		if(productRepository.existsById(product.getProductId()))
		{
			throw new RuntimeException("Product already exists with this id");
		}
		setProductId(userId, product.getProductId());
		productRepository.save(product);
		return true;
	}

	@Override
	public boolean editProduct(ProductDto product) {
		//Option is a data type 
		if(productRepository.existsById(product.getProductId()))
		{
			ProductDto existingProduct=productRepository.getOne(product.getProductId());
			if(product.getColour()==null)
			{
				existingProduct.setColour(existingProduct.getColour());
			}
			else
			{
				existingProduct.setColour(product.getColour());
			}
			if(product.getDimension()==null)
			{
				existingProduct.setDimension(existingProduct.getDimension());
			}
			else
			{
				existingProduct.setDimension(product.getDimension());
			}
			if(product.getPrice()==0)
			{
				existingProduct.setPrice(existingProduct.getPrice());
			}
			else
			{
				existingProduct.setPrice(product.getPrice());
			}
			
			productRepository.saveAndFlush(existingProduct);
			System.out.println(existingProduct);
			return true;
		}
		 
		return false;
	}

	@Override
	public boolean deleteProduct(String userId,String productId) {
		removeProductId(userId, productId);
		productRepository.deleteById(productId);
		return true;
	}

	@Override
	public List<ProductDto> searchProduct(String productDetail) {
		// TODO Auto-generated method stub
		List<ProductDto> productList=new ArrayList<>();
		if(productRepository.findByProductName(productDetail)==null)
		{
			throw new RuntimeException("Please enter correct details");
		}
		else
		{
			List<ProductDto> allProductsList=productRepository.findAll();
			for (ProductDto productDto : allProductsList) {
			if(productDto.getProductName().equals(productDetail))
			{
				productList.add(productDto);
			}
		}
			
		return productList;	
		}
	}



	@Override
	public ProductDto getProduct(String productId) {
		// TODO Auto-generated method stub
		
		return productRepository.getOne(productId);
	}

	@Override
	public ProductMaster addMaster(ProductMaster master) {
		// TODO Auto-generated method stub
		master.setUserId(String.valueOf(random.nextInt(100000)));
		return  masterRepo.save(master);
	}

	@Override
	public void setProductId(String userId, String productId) {
		// TODO Auto-generated method stub
		ProductMaster master=masterRepo.getOne(userId);
		master.getProductIds().add(productId);
		masterRepo.save(master);
		
	}
	@Override
	public void removeProductId(String userId, String productId) {
		// TODO Auto-generated method stub
		ProductMaster master=masterRepo.getOne(userId);
		master.getProductIds().remove(productId);
		masterRepo.save(master);
		
	}

	@Override
	public List<ProductDto> getProductByUserId(String userId) {
		// TODO Auto-generated method stub
		List<ProductDto> productList=new ArrayList<>();
		ProductMaster master=masterRepo.getOne(userId);
		for (String productId : master.getProductIds()) {
			ProductDto product=getProduct(productId);
			productList.add(product);
		}
		return productList;
	}

	@Override
	public ProductMaster login(String userId, String userPassword) {
		// TODO Auto-generated method stub
		if(masterRepo.existsById(userId))
		{
		ProductMaster productMaster = masterRepo.getOne(userId);
		System.out.println(productMaster);
			if(productMaster.getUserPassword().equals(userPassword))
			{
				return productMaster;	
			}
			throw new UserNotFoundException(" User password mismatch");
			
		}
		else
		{
			throw new UserNotFoundException(" User with user id "+userId+" doesnot exist");
		}
	
	}

}
