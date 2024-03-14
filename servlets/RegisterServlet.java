package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.entities.User;
import com.db.dbConnect;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends  HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String user_name=req.getParameter("name");
	String user_email=req.getParameter("email");
	String user_password=req.getParameter("passsword");
	// store the information into register servlet 
	User u=new User();
	u.setName(user_name);
	u.setEmail(user_email);
	u.setPassword(user_password);
	
	
	// give this info to dao layer 
	UserDao dao=new UserDao(dbConnect.getConnection());
	boolean f=dao.getRegister(u);
	
	if (f) {
		
		HttpSession session=req.getSession();
		session.setAttribute("reg-msg", "REGISTREATION SUCESSFULLY");
		resp.sendRedirect("login.jsp");
	}
	else {
		HttpSession session=req.getSession();
		session.setAttribute("error-msg", "UNSUCESSFULL");
		resp.sendRedirect("register.jsp");
	}
	}

}
