package com.capg.greatoutdoor.greatoutdoormanagement.model;

import java.io.Serializable;

import java.util.List;

public class ProductMaster implements Serializable {
private String userName;
private String userId;
private String userMail;
private String userPassword;
private long userNumber;
private List<String> productIds;
public ProductMaster() {
	super();
	// TODO Auto-generated constructor stub
}
public ProductMaster(String userName, String userId, String userMail, String userPassword, long userNumber,
		List<String> productIds) {
	super();
	this.userName = userName;
	this.userId = userId;
	this.userMail = userMail;
	this.userPassword = userPassword;
	this.userNumber = userNumber;
	this.productIds = productIds;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getUserMail() {
	return userMail;
}
public void setUserMail(String userMail) {
	this.userMail = userMail;
}
public String getUserPassword() {
	return userPassword;
}
public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
}
public long getUserNumber() {
	return userNumber;
}
public void setUserNumber(long userNumber) {
	this.userNumber = userNumber;
}
public List<String> getProductIds() {
	return productIds;
}
public void setProductIds(List<String> productIds) {
	this.productIds = productIds;
}
@Override
public String toString() {
	return "ProductMaster [userName=" + userName + ", userId=" + userId + ", userMail=" + userMail + ", userPassword="
			+ userPassword + ", userNumber=" + userNumber + ", productIds=" + productIds + "]";
}

}
