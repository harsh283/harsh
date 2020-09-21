package com.capg.greatoutdoor.wishlistms.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class WishList {
@Id 
private String wishListId;
private ProductDto product;
private String userId;
public WishList() {
	super();
	// TODO Auto-generated constructor stub
}
public WishList(String wishListId, ProductDto product, String userId) {
	super();
	this.wishListId = wishListId;
	this.product = product;
	this.userId = userId;
}
public String getWishListId() {
	return wishListId;
}
public void setWishListId(String wishListId) {
	this.wishListId = wishListId;
}
public ProductDto getProduct() {
	return product;
}
public void setProduct(ProductDto product) {
	this.product = product;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
@Override
public String toString() {
	return "WishList [wishListId=" + wishListId + ", product=" + product + ", userId=" + userId + "]";
}
}
