package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Car;
import com.bean.CheckOutItems;
import com.bean.Shop;
import com.bean.User;
import com.dao.UserDao;
import com.service.UserService;



/**
 * Servlet implementation class ShowCarServlet
 */
@WebServlet(name = "showCar", urlPatterns = { "/showCar" })
public class ShowCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		System.out.println(user);
		// 根据用户ID找购物车内容
		UserService userService = new UserService();
		UserDao userDao = new UserDao();
		
		userService.setUserDao(userDao);
		int userId;
		try {	
			List<Car> carList;
			userId = userService.findUserId(user);
			carList = userService.find(userId);
			List<Shop> shopList = new ArrayList<Shop>();
			// 根据Car信息找出shop信息
			for (Car car : carList) {
				// 根据shopid找出商品
				Shop shop = userDao.findShop(car.getShopId());
				shopList.add(shop);
			}
			
			List<CheckOutItems> cList = new ArrayList<CheckOutItems>();
			for (int i = 0; i < carList.size(); i++) {
				CheckOutItems checkOutItems = new CheckOutItems(carList.get(i).getId(), shopList.get(i).getsPicture(),
						shopList.get(i).getsPrice(), shopList.get(i).getsName(),carList.get(i).getCount());
				cList.add(checkOutItems);
			}
			
			request.setAttribute("car", cList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		//准备给jsp的数据
	
		
		request.getRequestDispatcher("car.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
