package com.encore.t0716;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class UserInfoDAO {
	SqlMapClient smc;
	
	public UserInfoDAO() {
		smc = MySqlMapClient.getSqlMapInstance();
	}
	
	public boolean insert(UserInfo vo) {
		try {
			smc.insert("user.join", vo);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public String selectLogin(String id) {
		try {
			String pass = (String)smc.queryForObject("user.selectLogin", id);
			return pass;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
