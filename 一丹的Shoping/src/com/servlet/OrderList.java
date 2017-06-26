package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Order;
import com.bean.Shop;
import com.dao.AdminDao;
import com.service.AdminService;

/**
 * Servlet implementation class OrderList
 */
@WebServlet(name = "administer_addorder", urlPatterns = { "/administer_addorder" })
public class OrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public OrderList() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		AdminService adminService = new AdminService();
		AdminDao adminDao = new AdminDao();
		adminService.setAdminDao(adminDao);
		try {
			List<Order> orders = adminService.orderList();
			request.setAttribute("orders", orders);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("Listorder.jsp").forward(request, response);
		
		
	
	}

}
