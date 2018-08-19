package com.jza.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Success extends HttpServlet {


	public Success() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title></title>");
		out.println("<style type='text/css'>");
		out.println("#bg {");
		out.println("margin: 180px auto;");
		out.println("background: url('img/bg.png');");
		out.println("}");
		out.println("#LogIn{");
		out.println("height: 25px;");
		out.println("width: 57px;");
		out.println("margin-top: 150px;");
		out.println("margin-left:80px;");
		out.println("background-color:transparent;");
		out.println("font-size:20px;");
		out.println("font-weight:500;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.write("<form ethod='post' action='/pictureManage'>");	
		out.println("<div id='bg' style='height: 370px; width: 296px;'>");		
		out.println("<input type='submit' name='LogIn' value='重新登录' id='LogIn' style='height:36px;width:106px;'><br />");
		out.println("</div>");
		out.write("</form>");		
		out.println("</body>");
		out.println("</html>");

		out.println("");
		out.println("");
		
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
