package com.encore.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(ReplyVO vo) {
		return sqlSession.insert("reply.insert", vo);
	}

	@Override
	public int update(ReplyVO vo) {
		return 0;
	}

	@Override
	public int delete(int rno) {
		return 0;
	}

	@Override
	public ReplyVO find(int rno) {
		return null;
	}

	@Override
	public List<ReplyVO> findAll() {
		return null;
	}
	
}
