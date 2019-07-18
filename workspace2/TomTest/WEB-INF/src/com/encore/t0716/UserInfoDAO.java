package com.encore.t0716;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class UserInfoDAO {//DAO(Data Access Object) DB전담클래스
	SqlMapClient smc;
	
	public UserInfoDAO() {
		smc = MySqlMapClient.getSqlMapInstance();
	}
	
	public boolean insert(UserInfo vo) {
		try {
			smc.insert("userinfo.join", vo);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public String selectLogin(String id) {
		try {
			String pass = (String)smc.queryForObject("userinfo.selectLogin", id);
			return pass;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public UserInfo selectModify(String id) {
		try {
			UserInfo vo = (UserInfo) smc.queryForObject("userinfo.selectModify", id);
			return vo;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean update(UserInfo vo) throws SQLException {
		if(smc.update("userinfo.modify", vo) == 1) {
			return true;
		}
		return false;
	}
	
	public boolean delete(String id) throws SQLException{
		if(smc.update("userinfo.remove", id) == 1) {
			return true;
		}
		return false;
	}
	
	public int selectExistId(String id) throws Exception{
		return (Integer)smc.queryForObject("userinfo.selectExistId", id );
	}
	
}
