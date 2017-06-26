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
 * Servlet implementation class Userdelete
 */
@WebServlet(name = "userdelete", urlPatterns = { "/userdelete" })
public class Userdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Userdelete() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	int id = Integer.parseInt(request.getParameter("id"));
	AdminService adminService = new AdminService();
	AdminDao adminDao = new AdminDao();
	adminService.setAdminDao(adminDao);
	try {
		if (adminService.userDelete(id)) {
			response.sendRedirect("userList");
		}else{
			response.sendRedirect("administer_index");
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
