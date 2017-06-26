package com.bean;

import java.util.Date;
/**
 * ���ﳵ
 * @author Administrator
 *
 */
public class Car {

	private int id;
	private int shopId;//商品id
	private int userId;//用户ID
	private int count;//购买数量
	private String pull_date;//加入购物车时间
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getShopId() {
		return shopId;
	}
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	public Car(int id, int shopId, int userId, int count, String pull_date) {
		super();
		this.id = id;
		this.shopId = shopId;
		this.userId = userId;
		this.count = count;
		this.pull_date = pull_date;
	}
	public Car() {
		super();
	}

	public String getPull_date() {
		return pull_date;
	}
	public void setPull_date(String pull_date) {
		this.pull_date = pull_date;
	}
	public Car(int count) {
		super();
		this.count = count;
	}
	public Car(int id, int count, String pull_date) {
		super();
		this.id = id;
		this.count = count;
		this.pull_date = pull_date;
	}

	
	
}
