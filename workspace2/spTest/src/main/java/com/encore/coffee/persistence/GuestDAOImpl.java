package com.encore.coffee.persistence;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.coffee.domain.GuestVO;

@Repository
public class GuestDAOImpl implements GuestDAO{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void insert(GuestVO vo) {
		sqlSession.insert("guest.insert",vo);
	}

	@Override
	public List<GuestVO> selectAll() {
		return sqlSession.selectList("guest.selectAll");
	}

	@Override
	public GuestVO select(int no) {
		return sqlSession.selectOne("guest.select", no);
	}

	@Override
	public void update(GuestVO vo) {
		sqlSession.update("guest.update",vo);
	}

	@Override
	public void delete(int no) {
		sqlSession.delete("guest.delete", no);
	}

	@Override
	public List<GuestVO> selectPage(int page, int limit) {
		/*
			RowBounds bounds = new RowBounds(offset, limit);
			offset ---> skip, limit ---> max
			
			1페이지 --->  1행 ~ 10행		offset:0 	limit:10
			2페이지 ---> 11행 ~ 20행		offset:10 	limit:10
			3페이지 ---> 21행 ~ 30행		offset:20 	limit:10
			x								y
			page						= (x-1)*10
		*/
		RowBounds bounds = new RowBounds((page-1)*limit, limit);
		
		//페이징(원하는 갯수의 행 조회)하는 select찾기
		return sqlSession.selectList("guest.selectAll", null, bounds);
	}

}
