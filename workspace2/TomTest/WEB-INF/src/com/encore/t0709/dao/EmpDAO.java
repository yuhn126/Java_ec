package com.encore.t0709.dao;

import java.sql.SQLException;
import java.util.List;

import com.encore.t0709.vo.Emp;
import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class EmpDAO {
	SqlMapClient smc;
	
	public EmpDAO() {
		smc = MySqlMapClient.getSqlMapInstance();
	}
	
	public List<Emp> findAll() {
		try {
			List<Emp> list = smc.queryForList("empInfo.select");
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
