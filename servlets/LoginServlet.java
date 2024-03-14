package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.dbConnect;
import com.entities.User;
@WebServlet("/login_servlet")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String user_email=req.getParameter("email");
	String user_password=req.getParameter("passsword");
	
	User u=new User();
	u.setEmail(user_email);
	u.setPassword(user_password);
	
	// pass the info to dao 
	UserDao dao=new UserDao(dbConnect.getConnection());
	User user=dao.getLogin(u);
	
	// check if 
	if(user!=null) {
		HttpSession session=req.getSession();
		session.setAttribute("login-sucess",user );
	resp.sendRedirect("home.jsp");

	}
	else {
		HttpSession session=req.getSession();
		session.setAttribute("faillog-msg","Invalid Username or Password");
resp.sendRedirect("login.jsp");
	}
	}
	
	

}
