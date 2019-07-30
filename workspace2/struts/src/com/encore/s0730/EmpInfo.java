package com.encore.s0730;

import java.sql.Date;

public class EmpInfo {
	private int empno;
	private String ename;
	private String hiredate;
	
	public EmpInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public EmpInfo(int empno, String ename, String hiredate) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
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
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "EmpInfo [empno : " + empno + ", ename : " + ename + ", hiredate : " + hiredate + "]";
	}
	
	
}
