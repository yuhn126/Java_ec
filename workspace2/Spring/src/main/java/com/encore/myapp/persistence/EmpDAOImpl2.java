package com.encore.myapp.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.encore.domain.EmpVO;
import com.encore.persistence.EmpDAO;

@Repository //데이터 저장과 관련된 클래스
public class EmpDAOImpl2 implements EmpDAO2{
	
	@Inject
	private SqlSession sqlSession;//sql호출

	@Override
	public boolean insertEmp(EmpVO vo) {
		if(sqlSession.insert("emp.insert", vo) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<EmpVO> selectAll() {
		return sqlSession.selectList("emp.selectAll");
	}

	@Override
	public List<EmpVO> selectDept(int deptno) {
		return sqlSession.selectList("emp.selectDept", deptno);
	}
	
}
