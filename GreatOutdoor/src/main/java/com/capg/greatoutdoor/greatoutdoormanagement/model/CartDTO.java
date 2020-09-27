package com.capg.greatoutdoor.greatoutdoormanagement.model;

import java.util.List;
/**
* CartDTO bean class
*/

public class CartDTO {

	private String userId;
	private List<String> productList;
	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartDTO(String userId, List<String> productList) {
		super();
		this.userId = userId;
		this.productList = productList;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<String> getProductList() {
		return productList;
	}
	public void setProductList(List<String> productList) {
		this.productList = productList;
	}
	@Override
	public String toString() {
		return "CartDTO [userId=" + userId + ", productList=" + productList + "]";
	}

	


}
