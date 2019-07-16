package com.encore.t0716.vo;

public class Emp {
	private int empno;
	private String ename;
	private String dname;
	private int grade;

	public Emp() {

	}

	public Emp(int empno, String ename, String dname, int grade) {
		this.empno = empno;
		this.ename = ename;
		this.dname = dname;
		this.grade = grade;
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

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
