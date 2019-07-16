package com.encore.t0716.dao;

import java.sql.SQLException;
import java.util.List;

import com.encore.t0716.vo.Emp;
import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class EmpDAO {
	SqlMapClient smc;
	
	public EmpDAO() {
		smc = MySqlMapClient.getSqlMapInstance();
	}
	
	public List<Emp> findAll(){
		List<Emp> list = null;
		try {
			list = smc.queryForList("empInfo2.select");
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
