package com.encore.j0610.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.encore.j0610.model.dto.Person;

public class PersonDAO {// DAO : Data(Base) Access Object
						// 데이터 베이스 전용 클래스/객체(DB관련된 일 전담!!) --> DB관련된 업무 담당
						// 각 메소드에는 sql문 실행에 관련된 코드들로 구성, CRUD작업 실행하는 메소드를 정의
						// ---> CRUD작성(Create, Read, Update, Delete)
						// 				insert select update  delete

	Connection conn;
	Statement stmt;

	Properties pro;

	public ArrayList<Person> person;

	public PersonDAO() {
		try {
			pro = new Properties(); // 속성 무
			pro.load(new FileReader("conn/conn.properties"));
			Class.forName(pro.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// 생성자

	// public boolean insert(자바빈즈){}
	public boolean insert(Person p) {
		// 또는 public boolean insert(Person p){}
		connect(); // Connection작업
		try {
			stmt = conn.createStatement(); // 실행 객체 생성
			String sql = "insert into person (no, name, age, job) values (person_seq.nextval, '" + p.getName() + "', "
					+ p.getAge() + ", '" + p.getJob() + "')";
			// System.out.println("추가SQL==> "+ sql);
			stmt.executeUpdate(sql);

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(); // DB자원반환(Connection반환)
		}

		return false;
	}

	// public boolean update(자바빈즈){}
	public boolean update(Person p) {
		connect();
		try {
			stmt = conn.createStatement();
			String sql = "update person set age = " + p.getAge() + ", job = '" + p.getJob() + "' where no = " + p.getNo();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		} 
		return false;
	}// 또는 public boolean update(Person p){}

	
	// public void delete(primary key){}
	public boolean delete(int no) {
		connect();
		try {
			stmt = conn.createStatement();
			String sql = "delete from person where no = " + no;
			int t = stmt.executeUpdate(sql);
			if(t > 0) {
				return true;				
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false;
	}// 또는 public boolean delete(int no){}

	
	// public void select(primary key){}
	public Person select(int no) { // 한 개의 Person정보 얻어오기 --> 수정폼
		connect();
		Person p = new Person();
		try {
			stmt = conn.createStatement();
			String sql = "select no, name, age, job from person where no=" + no;
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			
			int selNo = rs.getInt("no");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String job = rs.getString("job");
			
			Person selP = new Person(selNo, name, age, job);
			return selP;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return null;
	}

	
	public ArrayList<Person> selectAll() { // 모든 Person 정보 얻어오기
		ArrayList<Person> list = new ArrayList<Person>();
		connect();

		try {
			stmt = conn.createStatement();
			String sql = "select no, name, age, job from person order by no";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				/*
				  int no = rs.getInt("no"); String name = rs.getString("name"); int age =
				  rs.getInt("age"); String job = rs.getString("job");
				  
				  //4개의 변수를 하나의 변수로 저장 Person p = new Person(no, name, age, job); //p.getNo
				  list.add(p);
				*/
				list.add(new Person(rs.getInt("no"), rs.getString("name"), rs.getInt("age"), rs.getString("job")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	private void connect() {
		try {
			conn = DriverManager.getConnection(pro.getProperty("url"), pro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} //connect

	private void disconnect() {
		try {
			// 연결끊기(DB자원반환)
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// disconnect

}// PersonDAO
