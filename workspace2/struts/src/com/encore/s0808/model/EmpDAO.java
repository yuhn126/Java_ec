package com.encore.s0808.model;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class EmpDAO {
	SqlMapClient smc;
	
	public EmpDAO() {
		smc = MySqlMapClient.getSqlMapInstance();
	}
	
	public List<EmpVO> selectEnameInfo(String ename) throws SQLException {
		return smc.queryForList("emp.selectEnameInfo", ename);
	}
	
	public List<EmpVO> selectDeptInfo(int deptno) throws SQLException {
		return smc.queryForList("emp.selectDeptnoInfo", deptno);
	}
	
	//---------------------------------------------------------------------
	
	public List<EmpVO> selectMission3(Map<String, Object> map) throws SQLException{
		
		return smc.queryForList("emp.selectMission3", map);
	}
}