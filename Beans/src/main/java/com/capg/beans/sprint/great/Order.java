package com.capg.beans.sprint.great;

import java.util.Date;

public class Order {
	//id
	private String orderId;

	private String userId;
	
	private String addressId;

	private byte orderDispatchStatus;
	
	private Date orderInitiateTime;

	private Date orderDispatchTime;
	private double totalcost;
}
