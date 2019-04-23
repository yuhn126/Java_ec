package com.encore.j0423;

import java.util.Vector;

public class PersonMenu2 {
	Vector<Person> personV;
	Person p = new Person();
	int no = 0;
	
	public PersonMenu2(){
		personV = new Vector<>();
	}
	
	public void insert(Person p) {
		p.setNo(++no);
		personV.add(p);
	}
	
	public void select() {
		System.out.println("#사람 목록");
		for (int i = 0; i < personV.size(); i++) {
			Person p = personV.get(i);
			System.out.println(p);
		}
	}
	
	public void update(Person newP) {		
		for (int i = 0; i < personV.size(); i++) {//일치하는 번호 찾기
//			personV.get(i).getNo();
//			Person p.getNo()
			Person oldP = personV.get(i);
//			벡터(데이터저장소)에 저장된 개개의 사람 정보
			if(oldP.getNo() == newP.getNo()) {	//일치하는 번호를 찾았다면
				//수정작업(나이, 직업만)
				oldP.setAge(newP.getAge());
				oldP.setJob(newP.getJob());
			}
		}
	}//update
	
	public void delete(int delNo) {
		for (int i = 0; i < personV.size(); i++) {
			Person oldP = personV.get(i);
//			if (oldP.getNo() == delNo) {
			if (personV.get(i).getNo() == delNo) {
				personV.remove(i);
				break;
			}
		}
	}
}
