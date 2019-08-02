package com.encore.s0801.vo;

import java.util.Date;

public class EmpInfo {
	private int empno;
	private String ename;
	private Date hiredate;
	private String dname;
	private String job;
	
	public EmpInfo() {
	}
	
	
	
	public EmpInfo(int empno, String ename, Date hiredate, String dname, String job) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.dname = dname;
		this.job = job;
	}
	
	@Override
	public String toString() {
		return "EmpInfo [empno=" + empno + ", ename=" + ename + ", hiredate=" + hiredate + ", dname=" + dname + ", job="
				+ job + "]";
	}



	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
}
