package com.entities;


import java.sql.Timestamp;

public class Post {
private int id;
private String title;
private String content;
private Timestamp pdate;
private int uid;
private com.entities.User user;
public Post(int id, String title, String content, Timestamp pdate, User user ,int uid) {
	super();
	this.id = id;
	this.title = title;
	this.content = content;
	this.pdate = pdate;
	this.user = user;
	this.uid=uid;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public Post() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Timestamp getPdate() {
	return pdate;
}
public void setPdate(Timestamp timestamp) {
	this.pdate = timestamp;
}
public com.entities.User getUser() {
	return user;
}
public void setUser(com.entities.User user) {
	this.user = user;
}


}
