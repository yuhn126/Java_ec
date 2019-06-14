package com.encore.j0610;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	//JDBC연습
	Connection conn;
	Statement stmt;
	//-------------------DML업무(insert, delete, update)
	
	ResultSet rs;//-->조회된 결과 행열을 저장하는 클래스!
	//-------------------DQL업무(select)
	
	public JDBCTest() {
		try {
			//▶[1]드라이버 로딩(제품군 선택)
			//Class.forName("패키지명.클래스명");
			Class.forName("oracle.jdbc.driver.OracleDriver"); //ojdbc6.jar에 존재
			
			//▶[2]Connection 연결 객체 생성
			//conn = DriverManager.getConnection("url","user","password");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			//1521 : 연결 포트 넘버
			//conn.setAutoCommit(false); //프로그램 내에서 DML에 대한 AutoCommit X
			System.out.println("DB연결성공");
			
			//▶[3]Statement 실행 객체 생성
			stmt = conn.createStatement();
			
			/*
				문제1) 사원테이블(emp3)에 사원정보를 등록하시오.
				사원번호, 사원명, 급여, 부서번호
				7000, 홍길동, 2000, 10
				7002, 길라임, 3000, 20
				7004, 김주원, 4000, 30			
			*/
			String sql = "insert into emp3(empno, ename, sal, deptno) values (7000, '홍길동', 2000, 10)";
			//stmt.executeUpdate(sql);
			sql = "insert into emp3(empno, ename, sal, deptno) values (7002, '길라임', 3000, 20)";
			//stmt.executeUpdate(sql);
			sql = "insert into emp3(empno, ename, sal, deptno) values (7004, '김주원', 4000, 30)";
			//stmt.executeUpdate(sql);
			
			//문제2) 길라임 사원을 삭제
			sql = "delete from emp3 where ename = '길라임'";
			int t = stmt.executeUpdate(sql);
			System.out.println("DB삭제 성공 !! -> " + t);
			
			//문제3) 김주원 사원을 10번 부서로 이동
			sql = "update emp3 set deptno = 10 where ename = '김주원'";
			t = stmt.executeUpdate(sql); //수정요청
			if(t > 0) { //수정된 행이 있다면
				System.out.println("DB수정 성공 -> " + t);
			}else {
				System.out.println();
			}
			
			//문제4) 전체 사원에 대한 정보(사원번호, 사원명, 급여, 부서번호)출력
			//▶[4]ResultSet객체 생성 => 순차적으로 1. rs.next() 2. rs.get자료형(인덱스번호)
			sql = "select empno, ename, sal, deptno from emp3";
			//인덱스 번호 : 		1      2     3     4
			
			/*
			   boolean b = rs.next();
	        	==> b : 결과행이 있으면 true, 없으면 false 
	        	
			   rs.next();        // select count(*) from emp;
	       	   if(rs.next()){}   // select ename from emp where empno=7788;
	       	   while(rs.next()){} // select ename from emp;
			 */
			
			rs = stmt.executeQuery(sql);//실행요청
			//rs에는 조회된 행열 덩어리 데이터!
			
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");
				int deptno = rs.getInt("deptno");
				
				System.out.println(" 사원번호:"+ empno+", 사원명:"+ ename+", 급여:"+ sal+ ", 부서번호:"+deptno);
			}
			
			//--> 행데이터를 얻지 못한 상태
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//생성자

	public static void main(String[] args) {
		new JDBCTest();
	}
}
