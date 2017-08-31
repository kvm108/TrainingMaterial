package com.spring.SpringRestMongoDemo.entity;

public class User {
	private String uname;
	private String pwd;
	private String fname;
	public User() {}
	public User(String uname, String pwd, String fname) {
		super();
		this.uname = uname;
		this.pwd = pwd;
		this.fname = fname;
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
		return "User [uname=" + uname + ", pwd=" + pwd + ", fname=" + fname + "]";
	}
	
}
