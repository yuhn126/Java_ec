package com.encore.j0612.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.encore.j0612.model.vo.MembershipVO;
import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class MembershipDAO2 {
	// Controller클래스 : MembershipDAO ---> MembershipDAO2 변경
	// membership.xml파일 생성하고 DAO2에 있는 모든 sql문을 옮기고 실행
	SqlMapClient smc;

	public MembershipDAO2() {
		smc = MySqlMapClient.getSqlMapInstance();
	}// 생성자

	public boolean create(MembershipVO vo) {
		try {
			smc.insert("membershipDAO.create", vo);
			System.out.println("insert 성공");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// create

	public boolean modify(MembershipVO vo) {
		try {
			if (smc.update("member.modify", vo) == 1)
				return true;// t:수정된 행의 갯수
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean remove(String id) {
		try {
			if (smc.delete("member.remove", id) == 1)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// remove

	public int findExistId(String id) throws SQLException {
		return (Integer) smc.queryForObject("member.findExistId", id);
	}

	// (전체)회원 정보 조회
	public List<MembershipVO> findAll() throws SQLException {
		return smc.queryForList("member.findAll");
	} // findAll

	public List<MembershipVO> findByName(String name) throws SQLException {
		// stmt.setString(1, "%" + name + "%");
		return smc.queryForList("mamber.findByName", "%" + name + "%");
	}// findByName

	public MembershipVO findById(String id) throws SQLException {
		return (MembershipVO) smc.queryForObject("member.findById", id);
	}// findById

	public boolean findLogin(String id, String pass) throws SQLException {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pass", pass);
		int cnt = (Integer) smc.queryForObject("member.findLogin", map);
		if (cnt > 0) return true;
		return false;
	}// findLogin

	public String findLogin2(String id, String pass) throws SQLException {
		String dpass = (String) smc.queryForObject("member.findLogin2", id);
		if (dpass != null) {
			// 아이디 존재 O
			if (dpass.equals(pass)) {// 1. 아이디 존재O, 비번 일치O
				return "success";
			} else {// 2. 아이디 존재O, 비번 일치X
				return "fail_pass";
			}
		}
		return "fail_id";
	}// findLogin2

//	// (이름패턴)회원 정보 조회
//	public ArrayList<MembershipVO> findSearch(Map<String, String> map) {
//		connect();
//		ArrayList<MembershipVO> list = new ArrayList<MembershipVO>();
//		// 컬럼 : id, pass, name, ssn1, ssn2, phone, addr, job
//
//		String title = map.get("title");
//		String keyword = map.get("keyword");
//
//		try {
//			String sql = "select id,name,ssn1,ssn2,phone,addr,job from membership ";
//
//			if (title.equals("아이디"))
//				sql += "where id like ?";
//			else if (title.equals("이름"))
//				sql += "where name like ?";
//			else if (title.equals("주소"))
//				sql += "where addr like ?";
//
//			stmt = conn.prepareStatement(sql);
//			stmt.setString(1, "%" + keyword + "%");
//			rs = stmt.executeQuery();// sql문 실행요청(실행시점!!)
//			// 덩어리
//
//			while (rs.next()) {// 행얻기
//				// 열데이터 얻기
//				MembershipVO vo = new MembershipVO();
//				// 7개의 관련있는 속성데이터를 묶어주기 위해 사용.
//				vo.setId(rs.getString("id"));
//				vo.setName(rs.getString("name"));
//				vo.setSsn1(rs.getInt("ssn1"));
//				vo.setSsn2(rs.getInt("ssn2"));
//				vo.setPhone(rs.getString("phone"));
//				vo.setAddr(rs.getString("addr"));
//				vo.setJob(rs.getString("job"));
//
//				list.add(vo);
//			} // while
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disconnect();
//		}
//
//		return list;
//	}
}// MembershipDAO
