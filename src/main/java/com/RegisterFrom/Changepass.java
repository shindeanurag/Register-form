package com.RegisterFrom;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/changepass")

public class Changepass extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pass=req.getParameter("password");
		String cpass=req.getParameter("cpassword");
		String femail=Forgetpassword.email;
		System.out.println(pass);
		System.out.println(cpass);
		System.out.println(femail);
		
		if(pass.equals(cpass)) {
			try {
				System.out.println("if block entered");
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?useSSL=false", "root", "root");
				PreparedStatement ps=c.prepareStatement("update registerform set pass=? where email=?;");
				ps.setString(1, cpass);
				ps.setString(2, femail);
				ps.executeUpdate();
				PrintWriter out=resp.getWriter();
				out.print("Update password successfully...");
				System.out.println("Update password successfully...");
				resp.setContentType("text/html");
				RequestDispatcher rd=req.getRequestDispatcher("/LoginPage.html");
				rd.forward(req, resp);
				c.close();
				System.out.println("if block end");
			} catch (Exception e) {
				
			}
			}
			else {
				PrintWriter out=resp.getWriter();
				out.print("<style>");
		        out.print("body { font-family: Arial, sans-serif; background-color: #f4f4f4; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }");
		        out.print(".error-container {padding: 40px; border-radius: 10px; box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1); max-width: 400px; width: 100%; }");
		        out.print("h3 { color: #e74c3c; font-size: 20px; margin-bottom: 20px; }");
		        out.print("p { font-size: 1.2em; color: #555; margin-bottom: 30px; }");
		        out.print(".back-button { padding: 12px 20px; background-color: #4285f4; color: white; border: none; border-radius: 5px; font-size: 1.2em; cursor: pointer; text-decoration: none; transition: background-color 0.3s; }");
		        out.print(".back-button:hover { background-color: #357ae8; }");
		        out.print("</style>");
	            out.print("<div class='error-container'>");
		        out.print("<h3>password and confirm password does not match</h3>");
		        out.print("<p>Please check your credentials and try again.</p>");
				resp.setContentType("text/html");
				RequestDispatcher rd=req.getRequestDispatcher("/Changepassword.html");
				rd.include(req, resp);
			}
		
	}
}
