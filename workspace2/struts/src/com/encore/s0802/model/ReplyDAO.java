package com.encore.s0802.model;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class ReplyDAO {
	SqlMapClient smc;
	
	public ReplyDAO() {
		smc = MySqlMapClient.getSqlMapInstance(); //parameterClass, resultClass등 검사
	}//생성자 : 초기화 메소드(가장 먼저 1번 호출되는 메소드)
	
	
	public boolean create(Reply vo) {
		try {
			smc.insert("reply0802.create", vo);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//create

	public List<Reply> findAll() throws SQLException {
		return smc.queryForList("reply0802.findAll");
	}//findAll
	
	public boolean modify(Reply vo) throws SQLException {//리턴 int : 수정된 행의 갯수
		int upCnt = smc.update("reply0802.modify", vo);
		if(upCnt == 1) {
			return true;
		} else {
			return false;
		}
	}//modify
	
	public boolean remove(int no) throws SQLException {
		int delCnt = smc.delete("reply0802.remove", no);
		if(delCnt == 1) {
			return true;
		} else {
			return false;
		}
	}
}
