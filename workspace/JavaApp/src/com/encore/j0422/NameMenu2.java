package com.encore.j0422;

import java.util.Vector;

public class NameMenu2 {
	Vector<String> names;
	
	public NameMenu2() {
		names = new Vector<>();
	}
	
	void add(String inputName){
		names.add(inputName);
		System.out.println();
		
//		for(int i = 0; i < names.length; i++) {
//			if(inputName.equals(names[i])) {
//				System.out.println("#이미 입력된 이름입니다!");
//				break;
//			}else if(names[i] == null) {
//				names[i] = inputName;
//				break;
//			}
//		}
//		System.out.println();			
	}
	
	void search() {
		System.out.println("#이름목록");
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i) + "--> 인덱스 : " + i);
		}
		System.out.println();
	}
	
	void update(String beforeUpdate, String afterUpdate){
		for(int i = 0; i < names.size(); i++) {
			if(names.get(i).equals(beforeUpdate)) {
				names.set(i,afterUpdate);
				break;
			}
			
		}System.out.println();
		
		
//		int i = 0;
//		do {
//			if(beforeUpdate.equals(names[i])) {
//				names[i] = afterUpdate;
//				break;
//			}else{
//				i++;
//				if(i >= names.length) {
//					System.out.println("#존재하지 않는 이름입니다");
//					break;
//				}
//			}
//		}while(true);		
	}
	
	void delete(String deleteName){
		if(names.remove(deleteName)) {
			System.out.println("#삭제성공");
		}else {
			System.out.println("#일치하는 이름이 없습니다.");
		}
		
//		for(int i = 0; i < names.size(); i++) {
//			if(names.get(i).equals(deleteName)) {
//				names.remove(i);
//				break;
//			}
//		}
		System.out.println();
//		int i = 0;
//		do {
//			if(deleteName.equals(names[i])) {
//				names[i] = null;
//				cnt--;
//				break;
//			}else{
//				i++;
//				if(i >= names.length) {
//					System.out.println("#존재하지 않는 이름입니다");
//					break;
//				}			
//			}
//		}while(true);
		
	}

}
