package com.encore.j0419;

public class NameMenu{
	String []names = new String[5];
	
	
	void add(String inputName){
		for(int i = 0; i < names.length; i++) {
			if(names[i] == null) {
				names[i] = inputName;
				break;
			}
		}	
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
			if(names[i].equals(beforeUpdate)) {
				names[i] = afterUpdate;
				break;
			}else{
				i++;
			}
		}while(true);		
	}
	
	void delete(String deleteName){
		int i = 0;
		do {
			if(names[i].equals(deleteName)) {
				names[i] = null;
				break;
			}else{
				i++;
			}
		}while(true);
		
	}
	
	
}
