package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Shop;
import com.bean.User;
import com.dao.AdminDao;
import com.service.AdminService;

/**
 * Servlet implementation class AdminshopList
 */
@WebServlet(name = "AdminShopList", urlPatterns = { "/AdminShopList" })
public class AdminshopList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminshopList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		AdminService adminService = new AdminService();
		AdminDao adminDao = new AdminDao();
		adminService.setAdminDao(adminDao);
		try {
			List<Shop> shops = adminService.shopList();
			request.setAttribute("shops", shops);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			
			request.getRequestDispatcher("administer_shopList.jsp").forward(request, response);
			return;
			
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
