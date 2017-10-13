package com.mtl.pojo;

/**
 * @author MTL
 *
 */
public class Clazz {
	private int clazzno;
	private String cname;
	private String chteacher;
	private String clazzroom;
	public int getClazzno() {
		return clazzno;
	}
	public void setClazzno(int clazzno) {
		this.clazzno = clazzno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getChteacher() {
		return chteacher;
	}
	public void setChteacher(String chteacher) {
		this.chteacher = chteacher;
	}
	public String getClazzroom() {
		return clazzroom;
	}
	public void setClazzroom(String clazzroom) {
		this.clazzroom = clazzroom;
	}
	
	public Clazz(int clazzno, String cname, String chteacher, String clazzroom) {
		super();
		this.clazzno = clazzno;
		this.cname = cname;
		this.chteacher = chteacher;
		this.clazzroom = clazzroom;
	}
	public Clazz() {
		super();
	}
	
	@Override
	public String toString() {
		return "Clazz [clazzno=" + clazzno + ", cname=" + cname
				+ ", chteacher=" + chteacher + ", clazzroom=" + clazzroom + "]";
	}
	
}
