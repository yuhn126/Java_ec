package com.encore.myapp.db;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MyBatisTest {
	//원격지 repository에서 가져옴
	
	@Autowired //참조하는 BeanContainer에서 일치하는 자료형이 있다면 '주입실행'!
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testFactory() throws Exception{
       //SqlSessionFactory객체 테스트
		System.out.println("sqlFactory==> "+ sqlFactory);
	}
	
	@Test
	public void testSession() throws Exception{
		//SqlSessionFactory객체 테스트
		SqlSession session = sqlFactory.openSession();
		System.out.println("session ==> "+ session);
	}
}
