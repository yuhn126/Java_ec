package com.encore.persistence;

import java.util.List;

public interface EmpDAO {
	//Controller와 EmpDAOImpl클래스를 연결해주는 객체
	//두 클래스의 관계를 느슨하게 하여서 Impl(구현클래스)을 쉽게 변경할 수 있도록 함.
	//--> 유지보수에 유리함
	public List<String> selectEnames();
}
