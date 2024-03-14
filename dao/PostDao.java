package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entities.Post;

public class PostDao {
	private Connection conn;

	public PostDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean AddNotes(String c, int uid, String t) {
		boolean f = false;
		try {
			String query = "insert into post(content,uid,title) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, c);
			ps.setInt(2, uid);
			ps.setString(3, t);

			int i = ps.executeUpdate();
			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public List<Post> getData(int id) {
		System.out.println("id in postdao" + id);
		List<Post> list = new ArrayList<Post>();
		Post p = null;
		try {
			String q = "select * from post where uid=?";
			PreparedStatement ps = conn.prepareStatement(q);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				p = new Post();
				p.setId(rs.getInt(1));
				p.setContent(rs.getString(2));
				p.setPdate(rs.getTimestamp(3));
				p.setTitle(rs.getString(5));
				list.add(p);
				System.out.println(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public Post getDataById(int note_id) {

		Post p = null;
		try {
			String q = "select * from post where id=?";
			PreparedStatement pre = conn.prepareStatement(q);
			pre.setInt(1, note_id);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				p = new Post();
				p.setId(rs.getInt(1));
				p.setTitle(rs.getString(5));
				p.setContent(rs.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}

	public boolean postUpdate(int id, String title, String content) {
		boolean f = false;
		try {
			String query = "update post set title=?,content=? where id=?";
			PreparedStatement pre = conn.prepareStatement(query);
			pre.setString(1, title);
			pre.setString(2, content);
			pre.setInt(3, id);
			int i = pre.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean deleteData(int id) {
		boolean f = false;
		try {
			String query = "delete  from post where id=?";
			PreparedStatement pre = conn.prepareStatement(query);
			pre.setInt(1, id);
			int i = pre.executeUpdate();
			if (i == 1)
				f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
}