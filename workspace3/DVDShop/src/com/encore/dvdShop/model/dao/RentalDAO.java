package com.encore.dvdShop.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.encore.dvdShop.model.vo.RentalVO;
import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class RentalDAO {
	SqlMapClient smc;
	
	public RentalDAO() {
		smc = MySqlMapClient.getSqlMapInstance();
	}
	
	public boolean insertRental(RentalVO vo) {
		try {
			smc.insert("dvdShop.insertRental", vo);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public List<RentalVO> selectUserList(int userCode) throws SQLException{
		return smc.queryForList("dvdShop.selectUserList", userCode);
	}
}
