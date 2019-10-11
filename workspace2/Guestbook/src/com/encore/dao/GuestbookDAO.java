package com.encore.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.encore.vo.GuestbookVO;

import mybatis.MySqlSession;

public class GuestbookDAO {
	
	private SqlSession sqlSession;
	
	public GuestbookDAO() {
		sqlSession = MySqlSession.getSqlSession();
	}
	
	public void insert(GuestbookVO vo) {
		sqlSession.insert("guestbook.insert",vo);
	}
	
	public void update(GuestbookVO vo) {
		sqlSession.update("guestbook.update",vo);
	}
	
	public void delete(int no) {
		sqlSession.delete("guestbook.delete",no);
	}
	
	public GuestbookVO select(int no) {
		return sqlSession.selectOne("guestbook.select", no);
	}
	
	public List<GuestbookVO> selectAll() {
		return sqlSession.selectList("guestbook.selectAll");
	}
}
