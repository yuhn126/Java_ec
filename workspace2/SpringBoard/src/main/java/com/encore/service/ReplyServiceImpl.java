package com.encore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.domain.Criteria;
import com.encore.domain.ReplyPageDTO;
import com.encore.domain.ReplyVO;
import com.encore.persistence.ReplyDAO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyDAO dao; 
	
	@Override
	public int register(ReplyVO vo) { //dao호출
		return dao.insert(vo);
	}

	@Override
	public int modify(ReplyVO vo) {
		return 0;
	}

	@Override
	public int remove(int rno) {
		return 0;
	}

	@Override
	public ReplyVO get(int rno) {
		return null;
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, int bno) {
		return null;
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, int bno) {
		return null;
	}

}
