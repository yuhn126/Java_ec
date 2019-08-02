package com.encore.s0731;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class AddrDAO {
	SqlMapClient smc;
	
	public AddrDAO() {
		smc = MySqlMapClient.getSqlMapInstance();
	}
	
	public List<String> selectSido() throws SQLException{
		return smc.queryForList("addr.sido");
	}
	
	public List<String> selectGugun(String sido) throws SQLException{
		return smc.queryForList("addr.gugun", sido);
	}
	
	public List<String> selectDong(Map<String, String> map) throws SQLException{
		return smc.queryForList("addr.dong", map);
	}
	

}
