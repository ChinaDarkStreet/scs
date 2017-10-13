package com.mtl.pojo;

import java.util.Date;

public class Course {
	private int cno;
	private String name;
	private int credit;
	private Date periodStart;
	private Date periodEnd;
	private Teacher teacher;
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Date getPeriodStart() {
		return periodStart;
	}

	public void setPeriodStart(Date periodStart) {
		this.periodStart = periodStart;
	}

	public Date getPeriodEnd() {
		return periodEnd;
	}

	public void setPeriodEnd(Date periodEnd) {
		this.periodEnd = periodEnd;
	}

	public Course(String name, int credit, Date periodStart, Date periodEnd) {
		super();
		this.name = name;
		this.credit = credit;
		this.periodStart = periodStart;
		this.periodEnd = periodEnd;
	}
	
	public Course(int cno, String name, int credit, Date periodStart,
			Date periodEnd) {
		super();
		this.cno = cno;
		this.name = name;
		this.credit = credit;
		this.periodStart = periodStart;
		this.periodEnd = periodEnd;
	}

	public Course(int cno, String name, int credit, Date periodStart,
			Date periodEnd, Teacher teacher) {
		super();
		this.cno = cno;
		this.name = name;
		this.credit = credit;
		this.periodStart = periodStart;
		this.periodEnd = periodEnd;
		this.teacher = teacher;
	}

	public Object[] toArray(){
		return new Object[]{name, credit, periodStart, periodEnd};
	}
}
