package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entities.User;


public class UserDao {
	private  Connection conn;
	public UserDao(Connection conn){
		super();
		this.conn=conn;
	}
	// for the registration module 
	public  boolean getRegister(User u) {
		
		boolean flag=false;
		try {
		String query="insert into ui(name,email,passsword) values (?,?,?)";
		PreparedStatement pre=conn.prepareStatement(query);
		pre.setString(1, u.getName());
		pre.setString(2, u.getEmail());
		pre.setString(3, u.getPassword());
		
		pre.executeUpdate();
		flag=true;
	}catch(Exception e) {
		e.printStackTrace();
	}
	
return flag;

	}
	
	// for login process 
	public User getLogin(User us) {
	User user=null;
		try {
			String query="select * from ui where email=? and passsword=?";
			PreparedStatement pre=conn.prepareStatement(query);
			pre.setString(1, us.getEmail());
			pre.setString(2,us.getPassword());
			ResultSet rs=pre.executeQuery();
			if(rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("passsword"));
					}
		}catch(Exception e) {
			System.out.println("inside the exception");
			e.printStackTrace();
		}
		return user;
	}
}

