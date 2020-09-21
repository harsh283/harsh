package com.capg.greatoutdoor.cartmanagement.model;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CartDTO {
@Id
private String userId;
HashMap<String,Integer> details=new HashMap<>();
public CartDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public CartDTO(String userId, HashMap<String, Integer> details) {
	super();
	this.userId = userId;
	this.details = details;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public HashMap<String, Integer> getDetails() {
	return details;
}
public void setDetails(HashMap<String, Integer> details) {
	this.details = details;
}
@Override
public String toString() {
	return "CartDTO [userId=" + userId + ", details=" + details + "]";
}



}
