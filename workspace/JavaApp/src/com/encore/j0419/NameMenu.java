package com.encore.j0419;

public class NameMenu{
	String []names = new String[5];
	int cnt = 0;
	
	void add(String inputName){
		for(int i = 0; i < names.length; i++) {
			if(cnt < 5) {
				if(inputName.equals(names[i])) {
					System.out.println("#이미 입력된 이름입니다!");
					break;
				}else if(names[i] == null) {
					names[i] = inputName;
					cnt++;
					break;
				}
			}else if(cnt >= 5){
				System.out.println("#더 이상 입력할 수 없습니다");
				System.out.println("#한 개 이상의 이름을 먼저 삭제 한 후 입력하세요");
				break;
			}
			
		}
		System.out.println();
	}
	
	void search() {
		System.out.println("#이름목록");
		for(int i = 0; i < names.length; i++) {
			if(names[i] != null)
				System.out.println(names[i]);
		}
	}
	
	void update(String beforeUpdate, String afterUpdate){
		int i = 0;
		do {
			if(beforeUpdate.equals(names[i])) {
				names[i] = afterUpdate;
				break;
			}else{
				i++;
				if(i >= names.length) {
					System.out.println("#존재하지 않는 이름입니다");
					break;
				}
			}
		}while(true);		
	}
	
	void delete(String deleteName){
		int i = 0;
		do {
			if(deleteName.equals(names[i])) {
				names[i] = null;
				cnt--;
				break;
			}else{
				i++;
				if(i >= names.length) {
					System.out.println("#존재하지 않는 이름입니다");
					break;
				}			}
		}while(true);
		
	}
	
	
}
