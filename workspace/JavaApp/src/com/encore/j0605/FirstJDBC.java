package com.encore.j0605;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FirstJDBC {

	public static void main(String[] args) {
		try {
			// JDBC프로그래밍
			// 1. 드라이버 로딩 Driver loading( = 제품군 선택(Oracle인지, MySQL인지, MS-SQL인지..)
			// Class.forName("드라이버 클래스명");
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 연결 객체 생성 : Connection
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; //"localhost" == "127.0.0.1" == 내PC
			String user = "scott";
			String password = "tiger";
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB연결성공");

//--------------------------------DML작업(C,S)--------------------------------
			// 3.실행객체 생성 : Statement --> SQL문(DML, DQL) 실행 가능!!
			Statement stmt = conn.createStatement();

			
			// 문제)테이블 dept_copy에서 10번 부서를 삭제하시오.
			// ---> SQL문 작성
			String sql = "delete from dept_copy where deptno=10";
			// ---> SQL문 실행 요청!
			//DML의 경우 : stmt.executeUpdate(sql)사용
			//DQL의 경우 : ResultSet stmt.executeQuery(sql)사용
			int t = stmt.executeUpdate(sql); // 삭제시점
			if (t == 1) { // 삭제된 행이 한 행이라면
				System.out.println("삭제 성공!, T : " + t); // 1, 0 ==> 삭제(수정)된 행의 갯수
			}

			
			// 문제)테이블 dept_copy에서 20번, 30번 부서를 삭제하시오.(삭제 성공 메시지 출력!)
			String sql2 = "delete from dept_copy where deptno in (20, 30)";
			int t2 = stmt.executeUpdate(sql2); // 실행요청 --> 삭제시점, auto commit
			// conn.setAutoCommit(true); --> false하면 오토커밋 꺼짐!
			// conn.commit(); conn.rollback();
			if (t2 > 0) { // 삭제된 행이 있다면(위의 sql문 실행 시 처음에는 t2 = 2)
				System.out.println("삭제 성공!, T2 : " + t2); // 1, 0 ==> 삭제(수정)된 행의 갯수
			} else {
				System.out.println("삭제 할 부서가 존재하지 않습니다!");
			}
			
//--------------------------------DQL작업(C,S,R)--------------------------------
			//4. 결과 객체 생성 : ResultSet --> 조회된 결과(행열데이터)를 저장!
			//DQL의 경우 : ResultSet stmt.executeQuery(sql)사용
			
			
			//문제)20번 부서의 부서번호, 부서명, 부서위치를 출력하시오.
			sql = "select deptno, dname, loc from dept where deptno=20"; //안에 ';'넣으면 안됨
			//DB인덱스  : 		1       2     3
			//			   20   RESEARCH DALLAS
			
			ResultSet rs = stmt.executeQuery(sql); //조회 요청, 조회된 결과 값(행열데이터) 리턴
			//rs ==> 행 열 덩어리 데이터
			//첫번째 : 행 단위 데이터 얻기 --> re.next();
			rs.next();
			
			//두번째 : 얻어온 행 안에서 개별 열데이터 얻기! --> rs.get자료형();
			//rs.getInt(int columnIndex); 		rs.getInt(1);
			//rs.getInt(String columnLabel);	rs.getInt("deptno");
			int deptno = rs.getInt(1); //첫번째 컬럼
			String dname = rs.getString(2); //두번째 컬럼
			String loc = rs.getString(3); //세번째 컬럼
			System.out.println("부서번호 : " + deptno + ", 부서명 : " + dname + ", 부서위치 : " + loc);
			
			System.out.println("===========================================================");
			
			//문제)전체 부서의 부서번호, 부서명, 부서위치를 출력하시오.
			sql = "select deptno d, dname, loc from dept";
			rs = stmt.executeQuery(sql); //조회요청
//			while(rs.next()) {	
//				deptno = rs.getInt("d"); //첫번째 컬럼 (만약 alias를 쓰면 별명을 넣어야됨)
//				dname = rs.getString("dname"); //두번째 컬럼
//				loc = rs.getString(3); //세번째 컬럼
//				System.out.println("부서번호 : " + deptno + ", 부서명 : " + dname + ", 부서위치 : " + loc);
//			}
			System.out.println("===============================");
			for(int i = 0; rs.next()==true; i++ ) {
				deptno = rs.getInt("d"); //첫번째 컬럼 (만약 alias를 쓰면 별명을 넣어야됨)
				dname = rs.getString("dname"); //두번째 컬럼
				loc = rs.getString(3); //세번째 컬럼
				System.out.println("부서번호 : " + deptno + ", 부서명 : " + dname + ", 부서위치 : " + loc);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
