package com.encore.myapp.persistence;

import java.util.List;

import com.encore.domain.EmpVO;

public interface EmpDAO2 {
	public boolean insertEmp(EmpVO vo);
	public List<EmpVO> selectAll();
	public List<EmpVO> selectDept(int deptno);
}
