package com.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedImage bImage = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		Graphics graphics  = bImage.getGraphics();
		Color color  = new Color(200, 150, 255);
		graphics.setColor(color);
		graphics.fillRect(0, 0, 68, 22);
		
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random random  = new Random();
		int len = ch.length,index;
		StringBuffer sbBuffer = new StringBuffer();
		for(int i= 0 ; i < 4; i++){
			index = random.nextInt(len);
			graphics.setColor(new Color(random.nextInt(88), random.nextInt(188), random.nextInt(255)));
			graphics.drawString(ch[index] + "", (i*15)+3, 18);
			sbBuffer.append(ch[index]);
		}
		
		request.getSession().setAttribute("piccode", sbBuffer.toString());
		ImageIO.write(bImage, "JPG", response.getOutputStream());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
