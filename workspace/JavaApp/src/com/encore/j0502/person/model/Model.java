package com.encore.j0502.person.model;

import java.util.Vector;

public class Model {
	public Vector<Person> personv; // 데이터 저장소
	private int no;

	public Model() {
		personv = new Vector<Person>();
	}

	// ---------------Vector personv를 기준으로 추가,삭제,수정,조회 작업---------------

	public void insert(Person p) {
		no++;
		p.setNo(no);
		personv.add(p);
	}//insert

	public void update(Person newp) {
		// 전체 벡터 조회(일치하는 번호의 Person정보 얻기)
		for (int i = 0; i < personv.size(); i++) {
			Person oldp = personv.get(i);
			if (oldp.getNo() == newp.getNo()) { // 일치하는 번호를 찾았다면
				//수정 작업
				oldp.setAge(newp.getAge());
				oldp.setJob(newp.getJob());
			}
		}
	}//update

	public void delete(int delNo) {
		for (int i = 0; i < personv.size(); i++) {
			Person oldp = personv.get(i);
			if(oldp.getNo() == delNo) {
				personv.remove(i);
			}
		}
	}// delete

	public Person select(int no) { // 용도: 수정폼에 출력
		// 전체 벡터 조회(일치하는 번호의 Person정보 얻기)
		for (int i = 0; i < personv.size(); i++) {
			Person oldp = personv.get(i);
			if (oldp.getNo() == no) { // 일치하는 번호를 찾았다면
				return oldp;
			}
		}
		return null;
	}// select

	public Vector<Person> selectAll() { // 용도: JTable출력
		return personv;
	}
}
