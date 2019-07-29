package com.encore.s0729;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class EmpDAO {
	SqlMapClient smc;

	public EmpDAO() {
		smc = MySqlMapClient.getSqlMapInstance();
	}

	public List<String> select(String keyword) {
		try {
			List<String> list = smc.queryForList("emp.selectEname", keyword);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Map<String, Object> selectEmpInfo(String ename) throws SQLException {
//		try {
//			EmpVO vo = (EmpVO)smc.queryForObject("emp.selectEmpInfo", ename);
//			return vo;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
		
		return (Map<String, Object>) smc.queryForObject("emp.selectEmpInfo", ename);
	}
}
