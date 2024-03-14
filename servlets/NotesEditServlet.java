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

@WebServlet("/NotesEditServlet")
public class NotesEditServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer noteid=Integer.parseInt(req.getParameter("note_id"));
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		
		PostDao pd=new PostDao(dbConnect.getConnection());
		boolean f=pd.postUpdate(noteid, title, content);
		if(f) {
			System.out.print("updated");
			HttpSession session=req.getSession();
			session.setAttribute("update-msg", "Notes Updated Sucessfully");
			resp.sendRedirect("ShowNotes.jsp");
		}
		else {
			System.out.print("not updated");
			HttpSession session=req.getSession();
			session.setAttribute("update-fail", "Notes Updation Unsucessfull");
		}
	}

}
