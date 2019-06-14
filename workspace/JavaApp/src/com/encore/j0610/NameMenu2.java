package com.encore.j0610;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NameMenu2{

	Connection conn;
	Statement stmt;
	ResultSet rs;

	public NameMenu2() {
		// 1.드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}// 생성자

	public void add(String name) {// DB에 이름 저장 Create
		try {
			// 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			// sql실행(요청)
			stmt = conn.createStatement();
			// String sql="insert into names (name) values ("+name+")";
			// 출력==> insert into names (name) values (홍길동)
			String sql = "insert into names (name) values ('" + name + "')";
			// 출력==> insert into names (name) values ('홍길동')
			// System.out.println("추가SQL: "+ sql);
			stmt.executeUpdate(sql);// 데이터 입력 요청!!

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// DB자원: Connection생성 ---> Statement생성 ---> ResultSet생성
				// DB자원반환은 역순!! rs.close() stmt.close() conn.close()
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();

				// 연결끊기
				if (conn != null)
					conn.close(); // DB는 데이터 공유를 위해 사용!!
				// Connection은 유한개 ----> 다른 사람을 위해 사용한 연결객체는 반환!!
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}// add

	public void search() {// 현재 DB내의 모든 이름들 조회 Read
		try {
			// 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

			System.out.println("#이름목록");

			// sql(조회)요청
			stmt = conn.createStatement();
			String sql = "select name from names";
			rs = stmt.executeQuery(sql);// 조회요청!!
			// rs.next() ---> rs.get자료형(컬럼인덱스 또는 "컬럼명" 또는 "별명");
			while (rs.next()) {// 조회된 행이 존재한다면
				System.out.println(" " + rs.getString("name"));// rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 연결끊기(DB자원반환)
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void update(String oldName, String newName) {// DB에 저장된 이름을 변경 Update
		connect();

		try {
			// 실행객체생성 stmt=
			// sql실행요청 stmt.executeUpdate();
			// String sql="update names set name='길동이' where name='홍길동'";
			stmt = conn.createStatement();
			String sql = "update names set name='" + newName + "' where name='" + oldName + "'";
			// System.out.println("수정 SQL: "+ sql);
			int t = stmt.executeUpdate(sql);// t:수정된 행의 갯수
			if (t < 1)
				System.out.println("#일치하는 이름이 존재하지 않습니다!!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}// update

	public void delete(String delName) {// DB에 저장된 이름을 삭제 Delete
		connect();

		try {
			stmt = conn.createStatement();
			String sql = "delete from names where name='" + delName + "'";
			// ==> delete from names where name='홍길동'
			int t = stmt.executeUpdate(sql); // 삭제요청==> execute!!

			if (t < 1) {// 삭제된 행이 없다면
				System.out.println("#존재하지 않는 이름입니다!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect(); // 자원반환
		}

	}// delete

	private void connect() {
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// connect

	private void disconnect() {
		try {
			// 연결끊기(DB자원반환)
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// disconnect

}// class NameMenu
