package com.capg.greatoutdoor.wishlistms.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;


public class User {
	private String userName;
	private String userId;
	private String userMail;
	private String userPassword;
	private long userNumber;
	private int userCategory;
	private String userRole;
	@ElementCollection
	private List<String> wishListIds;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String userId, String userMail, String userPassword, long userNumber, int userCategory,
			String userRole) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userMail = userMail;
		this.userPassword = userPassword;
		this.userNumber = userNumber;
		this.userCategory = userCategory;
		this.userRole = userRole;
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
	public int getUserCategory() {
		return userCategory;
	}
	public void setUserCategory(int userCategory) {
		this.userCategory = userCategory;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public List<String> getWishListIds() {
		return wishListIds;
	}
	public void setWishListIds(List<String> wishListIds) {
		this.wishListIds = wishListIds;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userId=" + userId + ", userMail=" + userMail + ", userPassword="
				+ userPassword + ", userNumber=" + userNumber + ", userCategory=" + userCategory + ", userRole="
				+ userRole + ", wishListIds=" + wishListIds + "]";
	}

	

}
