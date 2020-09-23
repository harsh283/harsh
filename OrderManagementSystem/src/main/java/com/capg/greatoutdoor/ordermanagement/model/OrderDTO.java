package com.capg.greatoutdoor.ordermanagement.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderDTO {
@Id
private String orderId;
private String userId;
@ElementCollection 
private List<String> productsList;
private int productUniqueId;
private String addressId;
private int orderDispatcherStatus;
private LocalDateTime orderInitiateTime;
private LocalDateTime orderDispatchTime;
public OrderDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public OrderDTO(String orderId, String userId, List<String> productsList, int productUniqueId, String addressId,
		int orderDispatcherStatus, LocalDateTime orderInitiateTime, LocalDateTime orderDispatchTime) {
	super();
	this.orderId = orderId;
	this.userId = userId;
	this.productsList = productsList;
	this.productUniqueId = productUniqueId;
	this.addressId = addressId;
	this.orderDispatcherStatus = orderDispatcherStatus;
	this.orderInitiateTime = orderInitiateTime;
	this.orderDispatchTime = orderDispatchTime;
}
public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public List<String> getProductsList() {
	return productsList;
}
public void setProductsList(List<String> productsList) {
	this.productsList = productsList;
}
public int getProductUniqueId() {
	return productUniqueId;
}
public void setProductUniqueId(int productUniqueId) {
	this.productUniqueId = productUniqueId;
}
public String getAddressId() {
	return addressId;
}
public void setAddressId(String addressId) {
	this.addressId = addressId;
}
public int getOrderDispatcherStatus() {
	return orderDispatcherStatus;
}
public void setOrderDispatcherStatus(int orderDispatcherStatus) {
	this.orderDispatcherStatus = orderDispatcherStatus;
}
public LocalDateTime getOrderInitiateTime() {
	return orderInitiateTime;
}
public void setOrderInitiateTime(LocalDateTime orderInitiateTime) {
	this.orderInitiateTime = orderInitiateTime;
}
public LocalDateTime getOrderDispatchTime() {
	return orderDispatchTime;
}
public void setOrderDispatchTime(LocalDateTime orderDispatchTime) {
	this.orderDispatchTime = orderDispatchTime;
}
@Override
public String toString() {
	return "OrderDTO [orderId=" + orderId + ", userId=" + userId + ", productsList=" + productsList
			+ ", productUniqueId=" + productUniqueId + ", addressId=" + addressId + ", orderDispatcherStatus="
			+ orderDispatcherStatus + ", orderInitiateTime=" + orderInitiateTime + ", orderDispatchTime="
			+ orderDispatchTime + "]";
}

}
