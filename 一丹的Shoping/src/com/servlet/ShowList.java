package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Order;
import com.bean.User;
import com.dao.AdminDao;
import com.dao.UserDao;
import com.service.AdminService;
import com.service.UserService;

/**
 * Servlet implementation class ShowList
 */
@WebServlet(name = "orderList", urlPatterns = { "/orderList" })
public class ShowList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowList() {
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
		response.setContentType("text/html");
		User user = (User) request.getSession().getAttribute("user");
		response.setCharacterEncoding("utf-8");
		UserService userService = new UserService();
		UserDao userDao = new UserDao();
		userService.setUserDao(userDao);
		
		
		
		try {
			int userId = userService.findUserId(user);
			List<Order> orders = userDao.orderList(userId);
			request.setAttribute("orders", orders);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("order2.jsp").forward(request, response);
	}

}
