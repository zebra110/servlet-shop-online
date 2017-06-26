package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Order;
import com.dao.AdminDao;
import com.service.AdminService;

/**
 * Servlet implementation class OrderSend
 */
@WebServlet(description = "orderSend", urlPatterns = { "/OrderSend" })
public class OrderSend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderSend() {
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
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		int orderId = Integer.parseInt(request.getParameter("id"));
		System.out.println(orderId);
		AdminService adminService = new AdminService();
		AdminDao adminDao = new AdminDao();
		adminService.setAdminDao(adminDao);
		try {
			Order orders = adminService.findOrderById(orderId);
			System.out.println(orders);
			orders.setStatus(1);
			adminService.updateOrder(orders);
			Order orders1 = adminService.findOrderById(orderId);
			System.out.println(orders1);
			response.sendRedirect("administer_addorder");
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
