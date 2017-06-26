package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.bean.Shop;
import com.dao.AdminDao;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.service.AdminService;

/**
 * Servlet implementation class ShopUpdate1Servlet
 */
public class ShopUpdate1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopUpdate1Servlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	
		int shopId = (int) request.getSession().getAttribute("shopId");
		String sname = request.getParameter("sName");
		System.out.println(sname);
		String sprice = request.getParameter("sPrice");
		String sdata = request.getParameter("sDate");
		String sinfo = request.getParameter("sInfo");
		
		Shop shop = new Shop(sname, sprice, sdata, sinfo);
		System.out.println(shop);
		AdminService adminService =  new AdminService();
		AdminDao adminDao = new AdminDao();
		adminService.setAdminDao(adminDao);
		try
		{
			if (adminService.shopUpdate(shop,shopId))
			{
				response.sendRedirect("AdminShopList");
			}
			else
			{
				response.sendRedirect("error.jsp");
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
