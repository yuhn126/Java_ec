package com.encore.s0730;

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
	
	public List<String> selectName() throws SQLException {
		return smc.queryForList("emp.selectAll");
	}
	
	public List<EmpInfo> selectDeptno(int deptNo) throws SQLException {
		return smc.queryForList("emp.selectDeptInfo",deptNo);
	}
	
	public int selectMin() throws SQLException {
		return (Integer)smc.queryForObject("emp.selectMin");
	}
	
	
}
