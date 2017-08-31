package com.spring.SpringRestMongoDemo.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class UserCollection {

	@Id
	private String id;
	private String uname;
	private String pwd;
	private String fname;
	public UserCollection() {}
	public UserCollection(String id, String uname, String pwd, String fname) {
		super();
		this.id = id;
		this.uname = uname;
		this.pwd = pwd;
		this.fname = fname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	@Override
	public String toString() {
		return "UserCollection [id=" + id + ", uname=" + uname + ", pwd=" + pwd + ", fname=" + fname + "]";
	}
	
}
