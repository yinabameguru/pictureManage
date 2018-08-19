package com.jza.web.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CodeServlet extends HttpServlet {


	public CodeServlet() {
		super();
	}


	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.setIntHeader("expires", 0);
		
		int width = 85;
		int height = 25;
		String code = ""; 
		int[] line = new int[4];
		for(int i=0;i<4;i++){  
            int j = (int)(Math.random()*10);  
            line[i] = j;  
            code += "" + j;
        }
		HttpSession session = request.getSession();
		session.setAttribute("code", code);
		
		BufferedImage img= new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		g.setColor(Color.YELLOW);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.RED);
		g.drawRect(0, 0, width-1, height-1);
		g.setColor(Color.GRAY);
		g.setFont(new Font("宋体", Font.BOLD|Font.ITALIC, 15));
		Random rand = new Random();
		int position = 15;
		for (int i = 0; i < 4; i++) {
			g.drawString(line[i]+"", position, 18);
			position +=15;
		}
		for (int i = 0; i < 4; i++) {
			g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width), rand.nextInt(height));
		}
		ImageIO.write(img, "jpg", response.getOutputStream());
		
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
