package com.encore.coffee.persistence;

import java.util.List;

import com.encore.coffee.domain.GuestVO;

public interface GuestDAO {
	public  void insert(GuestVO vo);
	public List<GuestVO> selectAll();
	public List<GuestVO> selectPage(int page, int limit);
	public GuestVO select(int no);
	public void update(GuestVO vo);
	public void delete(int no);
}
