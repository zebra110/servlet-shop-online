package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Car;
import com.bean.User;
import com.dao.UserDao;
import com.service.UserService;

/**
 * Servlet implementation class DeleteCar
 */
@WebServlet(name = "CarList1", urlPatterns = { "/CarList1" })
public class CarList1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarList1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String name =  (String) request.getSession().getAttribute("username");
				User user = (User) request.getSession().getAttribute("user");
				System.out.println("用户的mima是"+user.getPassword());
				
				if (name==null) {
					response.sendRedirect("login.jsp");
				}else{
				// 根据用户ID找购物车内容
					UserService userService = new UserService();
					UserDao userDao = new UserDao();
					userService.setUserDao(userDao);
				int shopId = Integer.parseInt(name);
				Date date = new Date();
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				String dat = sf.format(date);
				Car car;
				try {
					int userId = userService.findUserId(user);
					System.out.println(userId);
					car = userService.findCarByUserId(userId,shopId);
				
					if (car==null) {
						car = new Car();
						car.setShopId(shopId);
						car.setUserId(userId);
						car.setCount(1);
						car.setPull_date(dat);
						userService.addCar(car);
						
						request.getSession().setAttribute("user", user);
						request.getRequestDispatcher("ShopList").forward(request, response);
					}else{
						int a = car.getCount();
						a++;
						userService.updateCar(a,userId,shopId);
						request.getSession().setAttribute("user", user);
						request.getRequestDispatcher("ShopList").forward(request, response);
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
