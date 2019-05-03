package com.encore.j0502.person.model;

import java.util.Vector;

public class DataStore {//데이터 저장소(메모리, FileSystem, DataBase)
						//유일한 번호 발생기
		
	Vector<Person> personV = new Vector<>();
	
	private int no; //=0 위의 벡터에 입력될 Person에 유일한 번호를 부여
	
	public int getNo() {
		return ++no;
	}
	
	
}
