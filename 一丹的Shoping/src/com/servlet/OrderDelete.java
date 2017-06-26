package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.service.AdminService;

/**
 * Servlet implementation class OrderDelete
 */
@WebServlet(name = "orderDelete", urlPatterns = { "/orderDelete" })
public class OrderDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDelete() {
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
	response.setCharacterEncoding("utf-8");
	AdminService adminService = new AdminService();
	AdminDao adminDao = new AdminDao();
	adminService.setAdminDao(adminDao);
	int id = Integer.parseInt(request.getParameter("id"));
	System.out.println("dingdan " + id);
	try {
		if (adminService.orderDelete(id)) {
			response.sendRedirect("administer_addorder");
		}else 
			response.sendRedirect("error.jsp");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	

}
