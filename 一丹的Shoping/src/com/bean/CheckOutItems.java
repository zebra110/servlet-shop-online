package com.bean;
/**
 * 前台购物车显示所需要的数据
 * @author Administrator
 *
 */
public class CheckOutItems {

	private int id;
	private String sPicture;
	private String sPrice;
	private String sName;
	private int count;

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getsPicture() {
		return sPicture;
	}


	public void setsPicture(String sPicture) {
		this.sPicture = sPicture;
	}


	public String getsPrice() {
		return sPrice;
	}


	public void setsPrice(String sPrice) {
		this.sPrice = sPrice;
	}


	public String getsName() {
		return sName;
	}


	public void setsName(String sName) {
		this.sName = sName;
	}


	public CheckOutItems() {
		super();
	}


	public CheckOutItems(int id, String sPicture, String sPrice, String sName,int count) {
		super();
		this.id = id;
		this.sPicture = sPicture;
		this.sPrice = sPrice;
		this.sName = sName;
		this.count = count;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}



	
	
}
