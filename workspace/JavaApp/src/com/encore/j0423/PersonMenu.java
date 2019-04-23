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
		Person newP = new Person();
		newP.setNo(updNo);
		newP.setAge(updAge);
		newP.setJob(updJob);
		
		for (int i = 0; i < persons.size(); i++) {
			Person oldP = persons.get(i);
			if(oldP.getNo() == newP.getNo()) {
				oldP.setAge(newP.getAge());
				oldP.setJob(newP.getJob());
			}
			
			//persons.get(i).getNo();
//			if (persons.get(i).getNo() == updNo) {
//				persons.get(i).setAge(updAge);
//				persons.get(i).setJob(updJob);
//			}break;
			
		}
	}
	
	public void delete(int delNo) {
		for (int i = 0; i < persons.size(); i++) {
			Person delP = persons.get(i);
//			if(persons.get(i).getNo() == delNo) {
			if(delP.getNo() == delNo) {
				persons.remove(i);
			}
		}
	}
}
