package com.encore.j0423;

import java.util.Scanner;

public class PersonMenuTest {

	public static void main(String[] args) {
		Person ps = new Person();
		PersonMenu menu = new PersonMenu();
		Scanner scan = new Scanner(System.in);
		boolean loop = true;

		do {
			System.out.println("<사람메뉴>");
			System.out.println("1.추가 2.검색 3.수정 4.삭제 5.종료");
			System.out.print("번호 입력 --> ");
			int no = scan.nextInt();
			switch (no) {
			case 1:
				System.out.print("이름 : ");
				String name = scan.next();
				System.out.print("나이 : ");
				int age = scan.nextInt();
				System.out.print("직업 : ");
				String job = scan.next();
				
				menu.insert(name, age, job);
				// 메소드명 (데이터);	-->   메소드호출
				continue;
				
			case 2:
				menu.select();
				continue;
			case 3:
				System.out.print("수정할 번호 : ");
				int updNo = scan.nextInt();
				System.out.print("나이 : ");
				int updAge = scan.nextInt();
				System.out.print("직업 :");
				String updJob = scan.next();
				
				menu.update(updNo,updAge,updJob);
				continue;

			case 4:
				System.out.print("삭제할 번호 : ");
				int delNo = scan.nextInt();
				menu.delete(delNo);
				continue;
			case 5:
				System.out.println(" -- END -- ");
				loop = false;

			}

		} while (loop);
	}

}
