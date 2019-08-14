package com.encore.dvdShop.model.dao;

import java.sql.SQLException;
import java.util.Map;

import com.encore.dvdShop.model.vo.UserVO;
import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class UserDAO {
	SqlMapClient smc;

	public UserDAO() {
		smc = MySqlMapClient.getSqlMapInstance();
	}
	
	public boolean insertUser(UserVO vo) {
		try {
			smc.insert("dvdShop.insertUser", vo);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public int loginConfirm(UserVO vo) {
		try {
			return (int) smc.queryForObject("dvdShop.login", vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
