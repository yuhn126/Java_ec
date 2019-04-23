package com.encore.j0423;

import java.util.Vector;

public class PersonMenu {
	Vector<Person> persons;
	Person p = new Person();
	int no = 1;
	
	public PersonMenu(){
		persons = new Vector<>();
	}
	
	public void insert(String name, int age, String job) {
		Person p = new Person();
		p.setNo(no);
		p.setName(name);
		p.setAge(age);
		p.setJob(job);
		persons.add(p);
		
		no++;
	}
	
	public void select() {
		System.out.println("#사람 목록");
		for (int ind = 0; ind < persons.size(); ind++) {
			System.out.print(persons.get(ind));
			System.out.println();
		}
	}
	
	public void update(int updNo,int updAge,String updJob) {		
		for (int i = 0; i < persons.size(); i++) {
			if (updNo==p.getNo()) {
				p.setAge(updAge);
				p.setJob(updJob);
			}break;
		}
	}
	
	public void delete(int delNo) {
		for (int i = 0; i < persons.size(); i++) {
			if(delNo == p.getNo()) {
				
			}
		}
	}
}
