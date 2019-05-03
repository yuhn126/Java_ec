package com.encore.j0502.person.model;

import java.util.Vector;

public class Model2 {
	//(DataStore의 벡터)데이터에 대한 CRUD 전담!
	//---> 데이터는 Person단위
	//Create - 입력
	//Read   - 조회
	//Update - 수정
	//Delete - 삭제
	
	private DataStore store;
	
	public Vector<Person> personV; //null

	public Model2(DataStore store) {
		this.store = store;
	}

	// ---------------Vector personV를 기준으로 추가,삭제,수정,조회 작업---------------

	public void insert(Person newp) {
		int no = store.getNo();  //새로운 번호 받기
		newp.setNo(no);          //Person에 번호 저장
		store.personV.add(newp); //포인트
	  //-------------
	  //    저장소
	}//insert

	
	//기존 데이터(Person의 age, job)를 수정
	public void update(Person newp) { //newp - 수정할 정보를 담는 Person
		//store.personV.get(0).setAge(변경된 나이);
		//store.personV.get(0).setJob(변경된 직업);
	   //--------------------
	   // 	   Person p
		
		//문제! --> 벡터에 첫번쨰로 저장된 Person만 계속 수정!
		//해결)newp의 번호와 일치하는 Person을 벡터에 저장된 각 Person의 번호와 비교해서 찾기 : for문
		
		for (int i = 0; i < store.personV.size(); i++) {//전체 Person
			Person oldp = store.personV.get(i);
			if (oldp.getNo() == newp.getNo()) {
				oldp.setAge(newp.getAge());
				oldp.setJob(newp.getJob());
				break;
			}
		}
		
		
	}//update

	
	//벡터에 저장된 (특정 한개)Person을 삭제
	public void delete(int no) {
		//store.personV.remove(0); --> 핵심포인트
		//문제 --> 무조건 벡터에 저장된 첫번째 Person만 삭제!
		for(int i = 0; i < store.personV.size(); i++) {
			Person oldp = store.personV.get(i);
			if (oldp.getNo() == no) {//일치하는 번호 찾았다면
				store.personV.remove(i);
			}
		}
	}// delete

	
	//(no를 조건으로하는)Person 한 개 조회 ---> 결과 리턴!
	public Person select(int no) { // 용도: 수정폼에 출력
		//return store.personV.get(0); --> 핵심포인트
		//문제 --> 벡터에 첫번째 저장된 Person정보만 리턴
		
		// 전체 벡터 조회(일치하는 번호의 Person정보 얻기)
		for (int i = 0; i < store.personV.size(); i++) {
			Person oldp = store.personV.get(i);
			if (oldp.getNo() == no) { // 일치하는 번호를 찾았다면
				return oldp;
			}
		}
		return null;//찾고자 하는 번호의 Person이 존재하지 않는다면
	}// select

	
	//조회 : 전체 Person을 리턴 == (전체 Person이 저장된)벡터 리턴
	public Vector<Person> selectAll() { // 용도: JTable출력
		return store.personV;
	}
}
