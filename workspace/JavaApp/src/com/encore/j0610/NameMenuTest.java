package com.encore.j0610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameMenuTest {

	public static void main(String[] args)throws IOException {
		NameMenu n = new NameMenu();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean b = true;
		do {
			System.out.println("<이름메뉴>");
			System.out.println("1.추가 2.검색 3.수정 4.삭제 5.종료");
			System.out.print("번호 입력 --> ");
			String num = in.readLine();
			System.out.println();
			
//			문자열 검사(숫자로 구성되었는지)!
			
			char ch = num.charAt(0);
			if (ch >= '0' && ch <= '5') {
				switch(ch) {
					case '1':
						System.out.print("이름 입력 : ");
						String inputName = in.readLine();
						n.add(inputName);
						continue;
					case '2':
						n.search();
						continue;
					case '3':
						System.out.print("기존 이름 입력 : ");
						String beforeUpdate = in.readLine();
						System.out.print("변경 이름 입력 : ");
						String afterUpdate = in.readLine();
						n.update(beforeUpdate, afterUpdate);
						continue;
					case '4':
						System.out.print("삭제 이름 입력 : ");
						String deleteName = in.readLine();
						n.delete(deleteName);
						continue;
					case '5' :
						System.out.println("프로그램을 종료합니다.");
						b = false;
					}
			}else {
				System.out.println("#번호만 입력하세요!");
//				Integer.parseInt("1234");  --->  1234 
//				Integer.parseInt("dong");  --->  dong (에러)
				
			}
		}while(b);
		
	}

}
