package com.service;

import java.util.List;

import com.bean.Car;
import com.bean.Order;
import com.bean.Shop;
import com.bean.User;
import com.dao.UserDao;

public class UserService  {
	
	private UserDao userDao;
	public boolean login(User user) throws Exception {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}
	
	public boolean shopAdd(Shop shop) throws Exception {
		return userDao.shopAdd(shop);
	}
	
	public List<Shop> shopList() throws Exception {
		return userDao.shopList();
	}
	
	public Shop getShopBysName(String sName) throws Exception{
		return userDao.getShopBysName(sName);
	}
	
	public int findUserId(User user) throws Exception{
		
		return userDao.findUserId(user);
	}


	public List<Order> orderList() throws Exception {
		// TODO Auto-generated method stub
		return userDao.orderList();
	}

	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean addCar(Car car) throws Exception {
		// TODO Auto-generated method stub
		 return userDao.addCar(car);
	}

	public List<Car> find(int id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.find(id);
	}

	public Shop findShop(int shopId) throws Exception {
		return userDao.findShop(shopId);
	}
	
	public boolean deleteCar(int parseInt) throws Exception {
		// TODO Auto-generated method stub
		 return userDao.deleteCar(parseInt);
	}
	public void saveOrder(Order order, int id) throws Exception {
		// TODO Auto-generated method stub
		userDao.saveOrder(order,id);
	}
	
	public List<Order> orderList(int userId) throws Exception {
		// TODO Auto-generated method stub
		return userDao.orderList(userId);
	}

	public void register(User user) throws Exception {
		// TODO Auto-generated method stub
		userDao.register(user);
	}

	public Car findCarByUserId(int userId,int shopId) throws Exception {
		// TODO Auto-generated method stub
		return userDao.findCarByUserId(userId,shopId);
	}

	public void updateCar(int a,int userId, int shopId) throws Exception {
		// TODO Auto-generated method stub
		userDao.updateCar(a,userId,shopId);
	}
	
}
