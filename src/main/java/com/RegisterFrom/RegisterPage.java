package com.RegisterFrom;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class RegisterPage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String fname=req.getParameter("fname1");
		String lname=req.getParameter("lname1");
		String email=req.getParameter("email1");
		String mnum=req.getParameter("mnum1");
		String address=req.getParameter("address1");
		String gender=req.getParameter("gender1");
		String dob=req.getParameter("dob1");
		String city=req.getParameter("city1");
		String state=req.getParameter("state1");
		String country=req.getParameter("country1");
		String age=req.getParameter("age1");
		String degree=req.getParameter("degree1");
		String pyear=req.getParameter("pyear1");
		String pass=req.getParameter("pass1");
		
		System.out.println(fname);
		System.out.println(lname);
		System.out.println(email);
		System.out.println(mnum);
		System.out.println(address);
		System.out.println(gender);
		System.out.println(dob);
		System.out.println(city);
		System.out.println(state);
		System.out.println(country);
		System.out.println(age);
		System.out.println(degree);
		System.out.println(pyear);
		System.out.println(pass);
		
		PrintWriter out=resp.getWriter();
		out.print(fname);
		out.print(lname);
		out.print(email);
		out.print(mnum);
		out.print(address);
		out.print(gender);
		out.print(dob);
		out.print(city);
		out.print(state);
		out.print(country);
		out.print(age);
		out.print(degree);
		out.print(pyear);
		out.print(pass);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?useSSL=false","root","root");
			PreparedStatement ps=c.prepareStatement("insert into registerform(first_name,last_name ,email,mob_number,address,gender,DOB,city,state,country,age,degree ,p_year ,pass) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
			ps.setString(1,fname);
			ps.setString(2,lname);
			ps.setString(3,email);
			ps.setString(4,mnum);
			ps.setString(5,address);
			ps.setString(6,gender);
			ps.setString(7,dob);
			ps.setString(8,city);
			ps.setString(9,state);
			ps.setString(10,country);
			ps.setString(11,age);
			ps.setString(12,degree);
			ps.setString(13,pyear);
			ps.setString(14,pass);
			ps.addBatch();
			ps.executeUpdate();
		} catch (Exception e) {
			
			
		}
	}
}
