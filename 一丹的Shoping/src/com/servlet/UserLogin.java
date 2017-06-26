package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Admin;
import com.bean.User;
import com.dao.AdminDao;
import com.dao.UserDao;
import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;
import com.service.AdminService;
import com.service.UserService;


/**
 * Servlet implementation class UserLogin
 */
@WebServlet(name = "userLogin", urlPatterns = { "/userLogin" })
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("username");
		String pass = request.getParameter("password");

		/*String checkcode = request.getParameter("checkcode");
		String piccode = (String) request.getSession().getAttribute("piccode");
		String check = checkcode.toUpperCase();
		*/
		
		
		UserService userService = new UserService();
		UserDao userDao = new UserDao();
		
		User user =  new User(name, pass);
	
		userService.setUserDao(userDao);
		System.out.println(name);
		System.out.println(pass);
		
	    	try {
			if (userService.login(user)) {
				request.getSession().setAttribute("username", name);
				request.getSession().setAttribute("user", user);
				response.sendRedirect("ShopList");
			}else {
				System.out.println("登录失败");
			
			/*	PrintWriter out = response.getWriter();
				out.println("<script>alert(111)</script>");*/
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
