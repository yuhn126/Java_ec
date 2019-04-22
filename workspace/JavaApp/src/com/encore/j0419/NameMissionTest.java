package com.encore.j0419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NameMissionTest {
	public static void main(String[] args)throws IOException {
		//반복되는 메뉴 출력(화면 뷰 처리)
		//번호 입력을 위한 read() 또는 readLine() 메인에서 사용
		//이름 입력을 위한 readLine() 메인에서 사용
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		NameMission nm = new NameMission();
		int no = 0;
		do {
			System.out.println("<이름메뉴>");
			System.out.println("1.추가  2.검색  3.수정  4.삭제  5.종료");
			System.out.print("번호입력 --> ");	
			String noStr = in.readLine();
			
			boolean flag = nm.checkNum(noStr);
			if (!flag) {//(flag == false)
				System.out.println("#번호만 입력하세요");
				System.out.println();
				continue;  //반복문을 계속 진행
//				for문(증감자를 거친 조건식으로), while(조건식으로), do~while(조건식으로)
				
//				break;		switch와 반복문을 종료
//				return;		메소드 종료
			}
			
			no = Integer.parseInt(noStr);	//no = "1" "2" "3" "4" "5"
			
			System.out.println("");
			switch(no) {
				case 1:
					System.out.print("이름 입력 : ");
					String name = in.readLine();
					nm.add(name);
					break;
				case 2:
					nm.search();
					break;
				case 3:
					System.out.print("기존 이름 입력 : ");
					String oldName = in.readLine();
					System.out.print("변경 이름 입력 : ");
					String newName = in.readLine();
					
					nm.update(oldName, newName);
					
					break;
				case 4:
					System.out.print("삭제 이름 입력 : ");
					String delName = in.readLine();
					nm.delete(delName);
			}
			
			System.out.println("");
		}while(no != 5);	// 번호에 1,2,3,4번을 입력했다면 
									// 클래스 --> 주소비교
		
		System.out.println("--END--");
		
		/*

		<!NOT연산자>
		!(논리데이터)
		 예) !true ----> false
			!false ---> true
			
		*/
	}
}
