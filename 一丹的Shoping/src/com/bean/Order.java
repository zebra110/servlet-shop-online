package com.bean;

import java.util.Date;

/**
 * 订单
 * @author Administrator
 *
 */
public class Order {
private int id;
private String orderId;
private String sName;
private String sDate;
private String sPrice;
private String address;
private String sPicture;
public String getsPicture() {
	return sPicture;
}
public void setsPicture(String sPicture) {
	this.sPicture = sPicture;
}
private int count;
private int user_id;
private int status;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getsName() {
	return sName;
}
public void setsName(String sName) {
	this.sName = sName;
}


public String getsDate() {
	return sDate;
}
public void setsDate(String sDate) {
	this.sDate = sDate;
}
public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}
public String getsPrice() {
	return sPrice;
}
public void setsPrice(String sPrice) {
	this.sPrice = sPrice;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}


public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public Order(String orderId, String sName, String sDate, String sPrice, String address) {
	super();
	this.orderId = orderId;
	this.sName = sName;
	this.sDate = sDate;
	this.sPrice = sPrice;
	this.address = address;
}
public Order() {
	super();
}

public Order(int id,String orderId, String sName, String sDate, String sPrice, String address, int count, int user_id,int  status) {
	super();
	this.id = id;
	this.orderId = orderId;
	this.sName = sName;
	this.sDate = sDate;
	this.sPrice = sPrice;
	this.address = address;
	this.count = count;
	this.user_id = user_id;
	this.status = status;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public Order(int id, String orderId, String sName, String sDate, String sPrice, String address, int count) {
	super();
	this.id = id;
	this.orderId = orderId;
	this.sName = sName;
	this.sDate = sDate;
	this.sPrice = sPrice;
	this.address = address;
	this.count = count;
}





}
