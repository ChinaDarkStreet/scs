package com.mtl.pojo;

import java.util.Date;

public class Teacher {
	private int tno;
	private String tname;
	private String pwd;
	private String phone;
	private Date hireDate;
	private String remark;
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Teacher(String tname, String pwd, String phone, Date hireDate,
			String remark) {
		super();
		this.tname = tname;
		this.pwd = pwd;
		this.phone = phone;
		this.hireDate = hireDate;
		this.remark = remark;
	}
	
	public Teacher(int tno, String tname, String pwd, String phone,
			Date hireDate, String remark) {
		super();
		this.tno = tno;
		this.tname = tname;
		this.pwd = pwd;
		this.phone = phone;
		this.hireDate = hireDate;
		this.remark = remark;
	}
	public Object[] toArray(){
		return new Object[]{tname, pwd, phone, hireDate, remark};
	}
}
