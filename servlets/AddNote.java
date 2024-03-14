package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.PostDao;
import com.db.dbConnect;
import com.entities.Post;
import com.entities.User;

@WebServlet("/AddNoteServlet")
public class AddNote extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int uid = Integer.parseInt(req.getParameter("uid"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
 
		
		PostDao pd = new PostDao(dbConnect.getConnection());

		boolean f = pd.AddNotes(content, uid,title);
		
		if (f) {
//		HttpSession session=req.getSession();
//		session.setAttribute("post-sucess","NOTES ADDED SUCESSFULLY");
			System.out.println("data inserted sucessfully ");
			resp.sendRedirect("ShowNotes.jsp");
		} else {
//		HttpSession session=req.getSession();
//		session.setAttribute("post-fail","ADDITION UNSUCESSFULL");
			System.out.println("data inserted sucessfully ");
		}
	}

}
