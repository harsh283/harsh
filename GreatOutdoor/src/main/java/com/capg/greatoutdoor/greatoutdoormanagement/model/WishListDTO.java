package com.capg.greatoutdoor.greatoutdoormanagement.model;

import java.util.List;

public class WishListDTO {

private String userId;
private List<String> productIds;
public WishListDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public WishListDTO(String userId, List<String> productIds) {
	super();
	this.userId = userId;
	this.productIds = productIds;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public List<String> getProductIds() {
	return productIds;
}
public void setProductIds(List<String> productIds) {
	this.productIds = productIds;
}
@Override
public String toString() {
	return "WishListDTO [userId=" + userId + ", productIds=" + productIds + "]";
}

}
