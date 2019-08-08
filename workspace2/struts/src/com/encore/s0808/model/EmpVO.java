package com.encore.s0808.model;

import java.sql.Date;

public class EmpVO {
	private int empno;
	private String ename;
	private int sal;
	private int deptno;
	private String hiredate;
	
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

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public EmpVO(int empno, String ename, int sal, int deptno, String hiredate) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.deptno = deptno;
		this.hiredate = hiredate;
	}

	
	
}
