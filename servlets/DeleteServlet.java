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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Integer noteid=Integer.parseInt(req.getParameter("note_id"));
		PostDao pd=new PostDao(dbConnect.getConnection());
	boolean f=pd.deleteData(noteid);
	HttpSession session=null;
	if(f) {
		 session=req.getSession();
		session.setAttribute("delete-msg", "Notes Deleted Sucessfully");
		resp.sendRedirect("ShowNotes.jsp");
	}
	else {
		System.out.print("not updated");
		 session=req.getSession();
		session.setAttribute("delete-fail", "Notes Not Deleted Sucessfully");
	}
	}
	
}
