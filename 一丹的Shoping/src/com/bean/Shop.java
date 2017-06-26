package com.bean;


public class Shop {
	private int id;
	private String sName;
	private String sPrice;
	private String sDate;
	private String sPicture;
	private String sInfo;
	
	
	
	public Shop(int id,String sName, String sPrice, String sDate, String sPicture,
			String sInfo) {
		super();
		this.id=id;
		this.sName = sName;
		this.sPrice = sPrice;
		this.sDate = sDate;
		this.sPicture = sPicture;
		this.sInfo = sInfo;
	}
	
	
	public Shop(String sName, String sPrice, String sDate, String sInfo) {
		super();
		this.sName = sName;
		this.sPrice = sPrice;
		this.sDate = sDate;
		this.sInfo = sInfo;
	}


	public Shop() {
		// TODO Auto-generated constructor stub
	}


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
	public String getsPrice() {
		return sPrice;
	}
	public void setsPrice(String sPrice) {
		this.sPrice = sPrice;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public String getsPicture() {
		return sPicture;
	}
	public void setsPicture(String sPicture) {
		this.sPicture = sPicture;
	}
	public String getsInfo() {
		return sInfo;
	}
	public void setsInfo(String sInfo) {
		this.sInfo = sInfo;
	}


	@Override
	public String toString() {
		return "Shop [id=" + id + ", sName=" + sName + ", sPrice=" + sPrice + ", sDate=" + sDate + ", sPicture="
				+ sPicture + ", sInfo=" + sInfo + "]";
	}
	
	
	
}
