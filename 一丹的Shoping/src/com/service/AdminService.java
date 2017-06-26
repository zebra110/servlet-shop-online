package com.service;

import java.util.List;

import com.bean.Admin;
import com.bean.Car;
import com.bean.Order;
import com.bean.Shop;
import com.bean.User;
import com.dao.AdminDao;


public class AdminService  {
	
	private AdminDao adminDao;
	public boolean login(Admin admin) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.login(admin);
	}
	
	public boolean shopAdd(Shop shop) throws Exception {
		return adminDao.shopAdd(shop);
	}
	
	public List<Shop> shopList() throws Exception {
		return adminDao.shopList();
	}
	
	public Shop getShopBysName(int shopId) throws Exception{
		return adminDao.getShopBysName(shopId);
	}
	public boolean ShopDelete(int sName) throws Exception{
		return adminDao.ShopDelete(sName);
	}
	public AdminDao getAdminDao() {
		return adminDao;
	}
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public boolean addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.addUser(user);
	}

	public List<User> userList() throws Exception {
		// TODO Auto-generated method stub
		return adminDao.userList();
	}

	public boolean userDelete(int id)  throws Exception{
		// TODO Auto-generated method stub
		return adminDao.userDelete(id);
	}

	public List<Order> orderList() throws Exception {
		// TODO Auto-generated method stub
		return adminDao.orderList();
	}

	public boolean orderDelete(int id) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.orderDelete(id);
	}

	public boolean shopUpdate(Shop shop,int id) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.shopUpdate(shop,id);
	}

	public Order findOrderById(int orderId) throws Exception{
		// TODO Auto-generated method stub
		return adminDao.findOrderById(orderId);
	}

	public void updateOrder(Order orders)throws Exception {
		// TODO Auto-generated method stub
		adminDao.updateOrder(orders);
	}

	public Car findCarById(int carId) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.findCarById(carId);
	}

	public void updateCar(Car car) throws Exception {
		// TODO Auto-generated method stub
		adminDao.updateCar(car);
	}

	public List<Order> orderList1() throws Exception{
		// TODO Auto-generated method stub
		return adminDao.orderList1();
	}

	public List<Order> orderList2() throws Exception{
		// TODO Auto-generated method stub
		return adminDao.orderList2();
	}
	
	
}
