package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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

public class ShopAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShopAddServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

				response.setContentType("text/html");
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
			
				SmartUpload su = new SmartUpload();
				JspFactory fac = JspFactory.getDefaultFactory();
				PageContext pageContext = fac.getPageContext(this, request, response,
						null, false, 8 * 1024, true);
				su.initialize(pageContext);
				
				try
				{// �ļ��ϴ�
					su.upload();
					int count = su.save("/upload");
					System.out.println("count=" + count);
				} catch (Exception e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String sname = su.getRequest().getParameter("sName");
				String sprice = su.getRequest().getParameter("sPrice");
				String sdata = su.getRequest().getParameter("sDate");
				String sinfo = su.getRequest().getParameter("sInfo");
				String spicture = su.getFiles().getFile(0).getFileName();
				System.out.println(sname);
				Shop shop = new Shop(0,sname, sprice, sdata, spicture, sinfo);
				AdminService adminService =  new AdminService();
				AdminDao adminDao = new AdminDao();
				adminService.setAdminDao(adminDao);
				try
				{
					if (adminService.shopAdd(shop))
					{
						response.sendRedirect("sucess.jsp");
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
