package com.encore.j0610;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NameMenu {
	Connection conn;
	Statement stmt;

	ResultSet rs;

	public NameMenu() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			stmt = conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void add(String inputName) {
		NameMenu nm = new NameMenu();
		String sql = "insert into names values ('" + inputName + "')";
		try {
			nm.stmt.executeUpdate(sql);
			nm.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	void search() {
		NameMenu nm = new NameMenu();
		String sql = "select name from names";
		System.out.println("#이름목록");
		try {
			rs = nm.stmt.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
			}
			nm.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	void update(String beforeUpdate, String afterUpdate) {
		NameMenu nm = new NameMenu();
		String sql = "update names set name = '"+ afterUpdate + "' where name = '" + beforeUpdate + "'";
		try {
			nm.stmt.executeUpdate(sql);
			nm.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	void delete(String deleteName) {
		NameMenu nm = new NameMenu();
		String sql = "delete from names where name = '" +deleteName + "'";
		try {
			nm.stmt.executeUpdate(sql);
			nm.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println();
	}


}
