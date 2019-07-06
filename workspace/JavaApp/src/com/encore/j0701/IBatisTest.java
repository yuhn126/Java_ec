package com.encore.j0701;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class IBatisTest {
	public static void main(String[] args) {
		try {
			//emp.xml파일안의 sql문을 호출
			//==> SqlMapClient객체 필요!!
			
			SqlMapClient smc = MySqlMapClient.getSqlMapInstance();
			
			//1. 사원추가!! (8000, 'gildong', 3000, 20)
			//smc.insert(String id);
			//smc.insert("id명");
			//smc.insert("네임스페이스명.아이디명");
			smc.insert("empcopy.insert1");
			
			System.out.println("입력성공");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
