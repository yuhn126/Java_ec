package com.encore.t0719.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

	public List<Guest> selectAll(int page) throws SQLException { //리스트에 사용
		// List는 행의 갯수
		//List<Guest> list = smc.queryForList("guestinfo.selectAll");
		
		/*
			List<Guest> list = smc.queryForList(String id, int skip, int max);
			---> skip 		   : 전체 조회 행 중에서 건너뛰기 할 행의 수
			---> max(=length)  :  조회 할 최대 행 수
			
			글 번호 30    ~    20     
				skip 10 ===> 글 번호 30부터 10개 skip!! ==> 글 번호 20번부터 조회
				skip 20 ===> 글 번호 20부터 10개 skip!! ==> 글 번호 10번부터 조회
				skip 30 ===> 글 번호 30부터 10개 skip!! ==> 글 번호 0번부터 조회
				
			1페이지 : 32 ~ 23 조회!! skip :  0, max : 10
			1페이지 : 22 ~ 13 조회!! skip : 10, max : 10
			1페이지 : 12 ~ 3  조회!! skip : 20, max : 10
			1페이지 :  2 ~ 0  조회!! skip : 30, max : 10
								page * 10 - 10
			

		*/
		
		List<Guest> list = smc.queryForList("guestinfo.selectAll", page*10-10, 10);
		return list;

	}
	
	public List<Guest> selectPage(Map<String, Integer> map) throws SQLException { //리스트에 사용
		// List는 행의 갯수
		List<Guest> list = smc.queryForList("guestinfo.selectPage", map);
		//map(1,10) map(11,20)
		return list;
		
	}
	
	public int selectTotalPage() {
		try {
			return Integer.parseInt((smc.queryForObject("guestinfo.count").toString()));
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		return 0;
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

	public boolean update(Guest vo) {
		try {
			if(smc.update("guestinfo.modify", vo) == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean update2(Guest vo) {//비번수정용..ㅎㅎ
		try {
			if(smc.update("guestinfo.modify2", vo) == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean delete(int delNo) {
		try {
			if(smc.delete("guestinfo.remove", delNo) == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean selectPassCheck(Map<String, Object>map) throws SQLException{ 
		return false;
		
	}
	
}
