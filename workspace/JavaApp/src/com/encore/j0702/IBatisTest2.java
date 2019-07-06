package com.encore.j0702;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import iba.MySqlMapClient;

public class IBatisTest2 {
	public static void main(String[] args) {
		SqlMapClient smc = MySqlMapClient.getSqlMapInstance();
		// XML문서 내의 태그 호출 ==> SqlMapClient
		try {
			/*
			//1.사원 추가(8002, '김주원', 3000, 30)
			EmpVO vo = new EmpVO(8002, "김주원", 3000, 30);
			//smc.insert("네임스페이스.아이디명", 전달데이터);
			smc.insert("empClone.insert", vo);
			System.out.println("#사원 입력 성공");
			*/

			/*
			// 2.사원삭제(MARTIN사원 삭제)
			String delEname = "lime";
			int t = smc.delete("empClone.delete", delEname);
			// t : 삭제된 행의 갯수
			if (t > 0) {
				System.out.println("#[" + delEname + "]사원 삭제");
			} else {
				System.out.println("#[" + delEname + "]사원은 존재하지 않습니다.");
			}
			*/
			
			/* 
			//3.사원 수정(KING의 급여를 5000 ---> 6000으로 변경
			String upName = "KING";
			smc.update("empClone.update", upName);
			System.out.println("업데이트");
			*/
			
			//4. 조회
			//문제1) 특정 사번(7788)을 전달하여 사원명 조회 - selectEname
			System.out.println("============================");
			int searchEmpno = 7788;
			String ename = (String)smc.queryForObject("empClone.selectEname", searchEmpno);
			System.out.println("#조회 사원명 : " + ename);
			
			//문제2) 30번 부서에 근무하는 사원명 조회 - select30Enames
			System.out.println("============================");
			List<String> list = smc.queryForList("empClone.select30Enames");
			System.out.println("#30번 부서");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			
			//문제3) 특정 부서에 근무하는 사원명 조회 - selectEnames
			System.out.println("============================");
			int selDeptno3 = 10;
			List list2 = smc.queryForList("empClone.selectEnames", selDeptno3);
			System.out.println("#"+selDeptno3+"번 부서");
			for (int i = 0; i < list2.size(); i++) {
				System.out.println(list2.get(i));
			}
			
			//추가문제 3-2) 전제 부서에 근무하는 사원명 조회
			
			
			
			//문제4) 특정 부서에 근무하는 사원의 사원번호, 사원명, 급여, 부서번호를 출력 - selectDeptno
			System.out.println("============================");
			int selDeptno4 = 20;
			System.out.println("#"+selDeptno4+"번 부서 사원정보");
			List<EmpVO> list3 = smc.queryForList("empClone.selectDeptno", selDeptno4);
			for (int i = 0; i < list3.size(); i++) {
				System.out.println(list3.get(i).toString());
			}
			
			//문제 5) 30번 부서에 근무하는 사원중 급여가 1300이하인 사원의 사원명가 급여 출력 - selectEmpInfo
			//		파라미터 : deptno, sal ==> inMap
			//		리턴결과 : ename, sal  ==> outMap
			System.out.println("============================");
			Map<String, Integer> inMap = new HashMap();
			inMap.put("deptno", 30);
			inMap.put("sal", 1300);
			List<Map> list4 = smc.queryForList("empClone.selectEmpInfo", inMap);
			System.out.println("<<30번 부서 급여정보(1300이하)");
			for (int i = 0; i < list4.size(); i++) {
				Map<String,Object> map = list4.get(i);
				//map : {ename : 'ALLEN', sal : 1500}
				System.out.println("사원명 : " + map.get("ENAME") + ", 급여 : " + map.get("SAL"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
