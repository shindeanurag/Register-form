package com.RegisterFrom;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/forgetpass")
public class Forgetpassword extends HttpServlet {
	
	static String email;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		email=req.getParameter("email");
		System.out.println(email);
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?useSSL=false","root","root");
			PreparedStatement ps=c.prepareStatement("select * from registerform where email=?");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
					
			if(rs.next()) {
				
				RequestDispatcher rd=req.getRequestDispatcher("/Changepassword.html");
				rd.forward(req, resp);
			}else {
				PrintWriter out=resp.getWriter();
				out.print("<h3 color='red'>Invalid email</h3>");
				resp.setContentType("text/html");
				RequestDispatcher rd=req.getRequestDispatcher("/Forgetpass.html");
				rd.include(req, resp);
			}
			c.close();
		} catch (Exception e) {
			
		}
		
	}
}
