package com.mtl.pojo;

import java.util.Date;

public class Admin {
	private String id;
	private String uname;
	private String pwd;
	private int age;
	private String hobby;
	private Date enterDate;
	private double score;
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getEnterDate() {
		return enterDate;
	}
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}
	
	
	public Admin() {
		super();
	}
	public Admin(String id, String uname, String pwd, int age, String hobby,
			Date enterDate) {
		super();
		this.id = id;
		this.uname = uname;
		this.pwd = pwd;
		this.age = age;
		this.hobby = hobby;
		this.enterDate = enterDate;
	}
	public Admin(String id, String uname, String pwd, int age, String hobby,
			Date enterDate, double score) {
		super();
		this.id = id;
		this.uname = uname;
		this.pwd = pwd;
		this.age = age;
		this.hobby = hobby;
		this.enterDate = enterDate;
		this.score = score;
	}
	
	@Override
	public String toString() {
		return "Admin [id=" + id + ", uname=" + uname + ", pwd=" + pwd
				+ ", age=" + age + ", hobby=" + hobby + ", enterDate="
				+ enterDate + "]";
	}
	
	public Object[] toArray(){
		return new Object[]{id, uname, pwd, age, hobby, enterDate};
	}
}
