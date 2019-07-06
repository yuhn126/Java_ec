package com.encore.j0702;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class IBatisTest {
	public static void main(String[] args) {
		try {
			SqlMapClient smc = MySqlMapClient.getSqlMapInstance();
			
			//라임사원 추가(8000, 'lime', 2000, 30)
			//smc.insert("create");
			
			//부서 추가(50, '개발부', '남부터미널')
			Map<String, String> map = new HashMap<>();
			 //map.put(String key, Object value);
			 map.put("dname","개발부");
			 map.put("loc","남부터미");
			smc.insert("deptClone.create", map);
			//네임스페이스를 통해 
			
			System.out.println("입력성공^______________^");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//main
}
