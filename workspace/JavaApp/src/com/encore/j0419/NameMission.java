package com.encore.j0419;

public class NameMission {
	String []names;
	
	public NameMission() {
		names = new String[5];
	}
	
	public void add(String name) { //배열에 이름 저장 Create
		//빈 방(==null)에 이름 저장하기
		for (int i = 0; i < names.length; i++) {		
			if(names[i] == null) {//빈 방을 찾았다면
				names[i] = name; //null
				break;
			}
			
		}
	}
	
	public void search() { //배열 내의 이름들 조회 Read
		System.out.println("#이름목록");
		for(int i = 0; i<names.length; i++) { //배열인덱스
//			if(names[i] != null)			  //널은 출력xx
				System.out.println(" " + names[i]);
		}
	}
	
	public void update(String oldName, String newName) { //배열에 저장된 이름을 변경 Update
		for (int i = 0; i < names.length; i++) {
//			if(names[i].equals(oldName)) {	//NullPointerException발생
//			NullPointerException 방지
//			1. if(oldName.equals(name[i])
//			   : oldName에 null값은 절대 전달되지 않음!
//			2. if(names[i] != null && names[i].equals(oldName))	
//			   : names[i]번지 값이 null이 아닐 때 equals()메소드 호출
			if(names[i] != null && names[i].equals(oldName)) {
				names[i] = newName;	//수정 
				break;
			}
		}
	}//update

	
	public void delete(String delName) { //배열에 저장된 이름을 삭제 Delete
		// 배열에 저장된 데이터 삭제 표현 : 배열명[번지] = null;
		for (int i = 0; i < names.length; i++) {// 배열에서 삭제할 이름 찾기
			if(names[i] != null) {
				if (delName.equals(names[i])) {
					names[i] = null;
					break;
				}
			}
		}
	}//delete
	
//	추가메소드정의!
	
//	문자열 데이터가 숫자 조합인지 체크!
	public boolean checkNum(String str) {
//		문자열 검사(숫자로 구성되었는지 체크!)
		char ch;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch<'0' || ch>'9') {//숫자로 구성된 문자가 아니라면
				return false;
			}
		}
		return true;	//전체 문자가 숫자로 구성되었다면		
	}//checkNum
}
