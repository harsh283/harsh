package com.capg.greatoutdoor.cartmanagement.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
* CartDTO bean class
*/
@Entity
public class CartDTO {
	@Id
	private String userId;
	@ElementCollection
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
