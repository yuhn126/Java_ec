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
		return dao.update(vo);
	}

	@Override
	public int remove(int rno) {
		return dao.delete(rno);
	}

	@Override
	public ReplyVO get(int rno) {
		return dao.find(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, int bno) {
		return null;
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, int bno) {
		int count = dao.getCountByBno(bno); //특정 게시물에 대한 전체 댓글 수
		List<ReplyVO> list = dao.getListWithPaging(cri,bno); //특정페이지의 제한된(10개) 조회
		return new ReplyPageDTO(count,list);
	}

}
