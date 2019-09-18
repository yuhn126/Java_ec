package com.encore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encore.persistence.SampleDAO;

@Service
public class SampleTxServiceImpl implements SampleTxService{

	@Autowired
	private SampleDAO dao;
	
	@Override
	@Transactional
	public void addUserame(String username) {
		//전달받은 이름을 두 개의 테이블에 저장하는 업무!
		dao.insertSample1(username);
		dao.insertSample2(username);
		
	}
}
