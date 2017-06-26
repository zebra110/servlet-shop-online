package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Admin;
import com.bean.Car;
import com.bean.Order;
import com.bean.Shop;
import com.bean.User;
import com.mysql.jdbc.Connection;
import com.tools.DBManager;
import com.tools.DBUtil;

public class UserDao  {

	private DBUtil db = null;
	public boolean login(User user) throws Exception {
		// TODO Auto-generated method stub 
		String sql = "select count(*) from user where username ='"
				+ user.getUsername() + "' and password='" + user.getPassword() + "'";
		db = new DBUtil();
		ResultSet rs = db.exeQuery(sql);
		int result = 0;
		db.close();
		while (rs.next())
		{
			result = rs.getInt(1);
		}
		if (result > 0)
			return true;
		return false;
	}
	public int findUserId(User user) throws Exception {
		// TODO Auto-generated method stub 
		String sql = "select id from user where username ='"
				+ user.getUsername() + "' and password='" + user.getPassword() + "'";
		db = new DBUtil();
		ResultSet rs = db.exeQuery(sql);
		int result = 0;
		db.close();
		while (rs.next())
		{
			result = rs.getInt(1);
		}
		if (result > 0)
			return result;
		return 0;
	}
	public boolean shopAdd(Shop shop) throws Exception {
		// TODO Auto-generated method stub
		db=new DBUtil();
		String sql = "insert into shop (sName,sPrice,sDate,sPicture,sInfo)  values('"
				+ shop.getsName() + "','" + shop.getsPrice() + "','"
				+ shop.getsDate() + "','" +  shop.getsPicture() + "','" + shop.getsInfo() + "')";
		boolean b =  db.execute(sql);
		
		db.close();
	return b;
		
	}
	public List<Shop> shopList() throws Exception {
		// TODO Auto-generated method stub
		List<Shop> shops = new ArrayList<Shop>();
		String sql = "select  * from shop ";
		db=new DBUtil();	
		ResultSet rs = db.exeQuery(sql);
		while(rs.next()){
			Shop shop = new Shop(rs.getInt("id"), rs.getString("sName"),rs.getString("sPrice"), rs.getString("sDate"), rs.getString("sPicture"), rs.getString("sInfo"));
			shops.add(shop);
		}
		db.close();
		return shops;
	}
	public Shop getShopBysName(String sName) throws Exception {
		// TODO Auto-generated method stub
		Shop shop = null;
		String sql = "select * from shop where sName = ?" ;
		db = new DBUtil();
		ResultSet rs = db.exeQuery2(sql,sName);
		while(rs.next()){
			 shop = new Shop( rs.getInt("id"),rs.getString("sName"),rs.getString("sPrice"), rs.getString("sDate"), rs.getString("sPicture"), rs.getString("sInfo"));
		}
		db.close();
		return shop;
	}
	
	
	
	
	
	
	
	public List<Order> orderList() throws Exception {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<Order>();
		String sql = "select * from order";
		db = new DBUtil();
		ResultSet rSet = db.exeQuery(sql);
		while(rSet.next()){
			Order order = new Order(rSet.getString("orderId"), rSet.getString("sName"),rSet.getString("sDate"), rSet.getString("sPrice"), rSet.getString("address"));
			orders.add(order);
		}
		db.close();
		return orders;
	}
	
	public boolean addCar(Car car) throws Exception {
		// TODO Auto-generated method stub
		db=new DBUtil();
		String sql = "insert into cart (count,pullTime,shop_id,user_id)  values('"
				+ car.getCount() + "','" + car.getPull_date() + "','"
				+ car.getShopId() + "','" +  car.getUserId() +  "')";
		boolean b =  db.execute(sql);
		
		db.close();
		return b;
	}
	public List<Car> find(int id) throws Exception {
		List<Car> cars = new ArrayList<Car>();
		// TODO Auto-generated method stub
		db=new DBUtil();
		String sql = "select * from cart where user_id=?";
		ResultSet rs = db.exeQuery2(sql, id);
		while(rs.next()){
			Car car = new Car(rs.getInt("id"), rs.getInt("shop_id"),rs.getInt("user_id"), rs.getInt("count"), rs.getString("pullTime"));
			cars.add(car);
		}
		db.close();
		return cars;
		
	}
	public Shop findShop(int shopId) throws Exception {
		// TODO Auto-generated method stub
		db=new DBUtil();
		Shop shop = null;
		String sql = "select * from shop where id=?";
		ResultSet rs = db.exeQuery2(sql, shopId);
		while (rs.next()) {
			 shop = new Shop(rs.getInt("id"), rs.getString("sName"), rs.getString("sPrice"),rs.getString("sDate") , rs.getString("sPicture"), rs.getString("sInfo"));
			
		}
		rs.close();
		db.close();
		return shop;
	
		
	}
	public boolean deleteCar(int parseInt) throws Exception {
		// TODO Auto-generated method stub
		db=new DBUtil();
		String sql = "delete from cart where id = ?";
		boolean b = db.execute2(sql, parseInt);
		db.close();
		
		return b;
	}
	
	
	public void saveOrder(Order order, int id) throws Exception {
		// TODO Auto-generated method stub
		db=new DBUtil();
		String sql = "insert into orderinfo (sDate,sPrice,address,sName,user_id,count,status) values('"
				+ order.getsDate() + "','" + order.getsPrice() + "','"
				+ order.getAddress() + "','" +  order.getsName() + "','"  +  id + "','" + order.getCount() + "','" + order.getStatus()  +"')";
		
		
		String sql1 = "delete from cart where user_id = ?";
		System.out.println(1);
		db.execute(sql);
		System.out.println(2);
		System.out.println("id" + id);
		db.execute2(sql1, id);
		
		db.close();
		
	}
	
	public List<Order> orderList(int userId) throws Exception {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<Order>();
		// TODO Auto-generated method stub
		db=new DBUtil();
		String sql = "select * from orderinfo where user_id=?";
		ResultSet rs = db.exeQuery2(sql, userId);
		while(rs.next()){
			Order order = new Order(rs.getInt("id"),null, rs.getString("sName"), rs.getString("sDate"), rs.getString("sPrice"), rs.getString("address"),rs.getInt("count"),rs.getInt("user_id"),rs.getInt("status"));
			orders.add(order);
		}
		db.close();
		return orders;
	}
	
	
	public void register(User user) throws Exception {
		// TODO Auto-generated method stub
		db = new DBUtil();
		String sql = "insert into user(username,password) values('" + 
		user.getUsername() + "','" + user.getPassword() + "')";
		db.execute(sql);
		db.close();
	}
	public Car findCarByUserId(int userId,int shopId) throws Exception {
		// TODO Auto-generated method stub
		Car car = null;
		db = new DBUtil();
		String sql = "select * from cart where user_id=" + userId + " and shop_id =" + shopId;
		ResultSet rSet  = db.exeQuery2(sql);
		while(rSet.next()){
		
			car = new Car(rSet.getInt("id"),rSet.getInt("count"),rSet.getString("pullTime"));
			
		}
	
	
		return car;
	}
	public void updateCar(int a ,int userId, int shopId) throws Exception {
		// TODO Auto-generated method stub
		db = new DBUtil();
		
		String sql = "update cart set count = " + a + " where user_id=" + userId + " and shop_id =" + shopId;
		db.execute(sql);
	}
	


	

}
