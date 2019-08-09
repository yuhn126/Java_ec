package com.encore.s0809;

import java.sql.Date;

public class EmpVO {
	private int empno;
	private String ename;
	private Date hiredate;
	private int sal;
	
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
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}

	public EmpVO(int empno, String ename, Date hiredate, int sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.sal = sal;
	}
}
