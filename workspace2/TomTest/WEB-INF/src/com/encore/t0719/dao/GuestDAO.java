package com.encore.t0719.dao;

import java.sql.SQLException;
import java.util.List;

import com.encore.t0719.vo.Guest;
import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class GuestDAO {
	SqlMapClient smc;

	public GuestDAO() {
		smc = MySqlMapClient.getSqlMapInstance();
	}

	public boolean insert(Guest guest) {

		try {
			Object ob = smc.insert("guestinfo.insert", guest);
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Guest> selectAll() throws SQLException { //리스트에 사용
		// List는 행의 갯수
		List<Guest> list = smc.queryForList("guestinfo.selectAll");
		return list;

	}

	public Guest selectById(int no) { //수정폼에 사용
		Guest vo = new Guest();
		try {
			vo = (Guest) smc.queryForObject("guestinfo.selectById", no);
			return vo;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public boolean update() {
		return true;
	}

	public boolean delete() {
		return true;
	}
	
}
