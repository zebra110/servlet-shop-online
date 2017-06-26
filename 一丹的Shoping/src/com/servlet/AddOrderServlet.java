package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Car;
import com.bean.Order;
import com.bean.Shop;
import com.bean.User;
import com.dao.UserDao;
import com.service.UserService;


/**
 * Servlet implementation class AddOrderServlet
 */
@WebServlet(name = "administer_addorder", urlPatterns = { "/administer_addorder" })
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		UserService userService = new UserService();
		UserDao userDao = new UserDao() ;
		userService.setUserDao(userDao);
		int userId;
		double result = 0;
		try {
			userId = userService.findUserId(user);
			List<Car> carList = userService.find(userId);
			if(carList==null){
				System.out.println("购物车是空的");
			}
			List<Shop> shopList = new ArrayList<Shop>();
			for (Car car : carList) {
				// 根据shopid找出商品
				Shop shop = userService.findShop(car.getShopId());
				shopList.add(shop);
				int a = car.getCount();
				result += Double.parseDouble(shop.getsPrice()) * a ;
			}
			//准备给jsp的数据
			
			List<Order> orders = new ArrayList<Order>();
			for (int i = 0; i < carList.size(); i++) {
				Order order = new Order();	
				Date date = new Date();
				SimpleDateFormat sFormat = new SimpleDateFormat("yyyy.MM.dd");
				String Sdate = sFormat.format(date);
				order.setAddress("宁波大红鹰");
				order.setsName(shopList.get(i).getsName());
				order.setsPrice(shopList.get(i).getsPrice());
				order.setOrderId(null);
				order.setCount(carList.get(i).getCount());
				order.setUser_id(userId);
				order.setsDate(Sdate);
				order.setStatus(0);
				order.setsPicture(shopList.get(i).getsPicture());
				userDao.saveOrder(order,userId);
				System.out.println("dsjf" + userId);
				orders.add(order);
				
			}
			
			request.setAttribute("orders", orders);
			request.setAttribute("result", result);
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 根据用户ID找购物车内容
		
		// 根据Car信息找出shop信息
		
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}

}
