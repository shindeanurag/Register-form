package com.RegisterFrom;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.module.ModuleDescriptor.Requires;
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

@WebServlet("/login")
public class Loginpage extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?useSSL=false","root", "root");
			PreparedStatement ps=c.prepareStatement("select * from registerform where email=? and pass=?;");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("Login Successfully...");
				PrintWriter out=resp.getWriter();
				out.print("<h1 color=green>Login Successfully...</h1>");
				RequestDispatcher rd=req.getRequestDispatcher("Profile.jsp");
				rd.forward(req, resp);
				
				 
			}else {
				System.out.println("invalid username and password...");
				PrintWriter out=resp.getWriter();
				out.print("<style>");
		        out.print("body { font-family: Arial, sans-serif; background-color: #f4f4f4; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }");
		        out.print(".error-container { background-color: #fff; padding: 40px; border-radius: 10px; box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1); text-align: center; max-width: 400px; width: 100%; }");
		        out.print("h3 { color: #e74c3c; font-size: 20px; margin-bottom: 20px; }");
		        out.print("p { font-size: 1.2em; color: #555; margin-bottom: 30px; }");
		        out.print(".back-button { padding: 12px 20px; background-color: #4285f4; color: white; border: none; border-radius: 5px; font-size: 1.2em; cursor: pointer; text-decoration: none; transition: background-color 0.3s; }");
		        out.print(".back-button:hover { background-color: #357ae8; }");
		        out.print("</style>");
	            out.print("<div class='error-container'>");
		        out.print("<h3>Invalid Email & Password</h3>");
		        out.print("<p>Please check your credentials and try again.</p>");
				resp.setContentType("text/html");
				RequestDispatcher rd=req.getRequestDispatcher("LoginPage.html");
				rd.include(req, resp);
			}
			
		} catch (Exception e) {
			
		}
	}
}
