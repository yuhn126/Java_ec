package com.encore.s0729;

import java.sql.Date;

public class EmpVO {
	private int empno;
	private String ename;
	private String hiredate;
	private String dname;
	
	public EmpVO() {
		
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

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public EmpVO(int empno, String ename, String hiredate, String dname) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.dname = dname;
	}
	
}
