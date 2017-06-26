package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Admin;
import com.bean.Car;
import com.bean.Order;
import com.bean.Shop;
import com.bean.User;
import com.tools.DBUtil;


public class AdminDao  {

	private DBUtil db = null;
	public boolean login(Admin admin) throws Exception {
		// TODO Auto-generated method stub 
		String sql = "select count(*) from admin where name ='"
				+ admin.getName() + "' and password='" + admin.getPassword() + "'";
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
	public Shop getShopBysName(int shopId) throws Exception {
		// TODO Auto-generated method stub
		Shop shop = null;
		String sql = "select * from shop where id = ?" ;
		db = new DBUtil();
		ResultSet rs = db.exeQuery2(sql,shopId);
		while(rs.next()){
			 shop = new Shop( rs.getInt("id"),rs.getString("sName"),rs.getString("sPrice"), rs.getString("sDate"), rs.getString("sPicture"), rs.getString("sInfo"));
		}
		db.close();
		return shop;
	}
	
	
	public boolean ShopDelete(int sName) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from shop where id = ?" ;
		db  = new DBUtil();
		boolean b = db.execute2(sql,sName);
		db.close();
		return b;
	}
	public boolean addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into user (username,password) values('" + user.getUsername() + "','" + user.getPassword() + "')";
		db =  new DBUtil();
		boolean b = db.execute(sql);
		db.close();
		
		return b;
	}
	public List<User> userList() throws Exception {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		String sql = "select * from user ";
		db = new DBUtil();
		ResultSet rSet = db.exeQuery(sql);
		while(rSet.next()){
			User user = new User(rSet.getInt("id"),rSet.getString("username"), rSet.getString("password"));
			users.add(user);
			
		}
		
		db.close();
		return users;
	}
	
	public boolean userDelete(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from user where id = ?" ;
		db  = new DBUtil();
		boolean b = db.execute2(sql,id);
		db.close();
		return b;
	}
	public List<Order> orderList() throws Exception {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<Order>();
		String sql = "select * from orderinfo";
		db = new DBUtil();
		ResultSet rSet = db.exeQuery(sql);
		while(rSet.next()){
			Order order = new Order(rSet.getInt("id"),rSet.getString("orderId"), rSet.getString("sName"),rSet.getString("sDate"), rSet.getString("sPrice"), rSet.getString("address"),rSet.getInt("count"),rSet.getInt("user_id"),rSet.getInt("status"));
			orders.add(order);
		}
		db.close();
		return orders;
	}
	public boolean orderDelete(int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from orderinfo where id = ?";
		db = new DBUtil();
		
		boolean b = db.execute2(sql, id);
		db.close();
		return b;
	}
	public boolean shopUpdate(Shop shop,int id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update shop set  sPrice ='" +shop.getsPrice()  +"',sName ='" +shop.getsName()  +"',sDate ='" + shop.getsDate()
				 + "',sInfo = '" + shop.getsInfo() + "'where id = " + id ; 
		db = new DBUtil();
		boolean b = db.execute(sql);
		return b;
	}
	public Order findOrderById(int orderId)throws Exception {
		// TODO Auto-generated method stub
		Order order = null;
		String sql = "select * from orderinfo where id = ?" ;
		db = new DBUtil();
		ResultSet rs = db.exeQuery2(sql,orderId);
		while(rs.next()){
			 order = new Order(rs.getInt("id"),rs.getString("orderId"), rs.getString("sName"),rs.getString("sDate"), rs.getString("sPrice"), rs.getString("address"),rs.getInt("count"),rs.getInt("user_id"),rs.getInt("status"));
		}
		db.close();
		return order;
	}
	public void updateOrder(Order orders) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update orderinfo set  status =" + orders.getStatus()  + " where id = " + orders.getId() ; 
		db = new DBUtil();
		db.execute(sql);
		db.close();

	}
	public Car findCarById(int carId) throws Exception {
		// TODO Auto-generated method stub
		Car car = null;
		db = new DBUtil();
		String sql = "select * from cart where id=" + carId;
		ResultSet rSet  = db.exeQuery2(sql);
		while(rSet.next()){
		
			car = new Car(rSet.getInt("id"),rSet.getInt("count"),rSet.getString("pullTime"));
			
		}
	
	
		return car;
	}
	public void updateCar(Car car) throws Exception{
		// TODO Auto-generated method stub
		String sql = "update cart set  count =" + car.getCount()  + " where id = " + car.getId() ; 
		db = new DBUtil();
		db.execute(sql);
		db.close();
	}
	public List<Order> orderList1() throws Exception{
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<Order>();
		String sql = "select * from orderinfo a where a.status = 0 ";
		db = new DBUtil();
		ResultSet rSet = db.exeQuery(sql);
		while(rSet.next()){
			Order order = new Order(rSet.getInt("id"),rSet.getString("orderId"), rSet.getString("sName"),rSet.getString("sDate"), rSet.getString("sPrice"), rSet.getString("address"),rSet.getInt("count"),rSet.getInt("user_id"),rSet.getInt("status"));
			orders.add(order);
		}
		db.close();
		return orders;
	}
	public List<Order> orderList2() throws Exception {
		// TODO Auto-generated method stub
		List<Order> orders = new ArrayList<Order>();
		String sql = "select * from orderinfo a where a.status = 2 ";
		db = new DBUtil();
		ResultSet rSet = db.exeQuery(sql);
		while(rSet.next()){
			Order order = new Order(rSet.getInt("id"),rSet.getString("orderId"), rSet.getString("sName"),rSet.getString("sDate"), rSet.getString("sPrice"), rSet.getString("address"),rSet.getInt("count"),rSet.getInt("user_id"),rSet.getInt("status"));
			orders.add(order);
		}
		db.close();
		return orders;
	}


	

}
