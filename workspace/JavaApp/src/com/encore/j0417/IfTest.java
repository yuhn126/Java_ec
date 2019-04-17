package com.encore.j0417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IfTest {

	public static void main(String[] args) throws IOException {
		System.out.print("원하는 달 : ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int input = Integer.parseInt(br.readLine());
	
		String month = null;
		
		long startTime = System.nanoTime(); // < -- 현재 시간 입력
		
		if (input == 1)
			month = "January";
		else if (input == 2)
			month = "February";
		else if (input == 3)
			month = "March";
		else if (input == 4)
			month = "April"; 
		else if (input == 5)
			month = "May";
		else if (input == 6)
			month = "June"; 
		else if (input == 7)
			month = "July"; 
		else if (input == 8)
			month = "August"; 
		else if (input == 9)
			month = "September"; 
		else if (input == 10)
			month = "October"; 
		else if (input == 11)
			month = "November"; 
		else if (input == 12)
			month = "December";
		
		System.out.println(month);
		
	    long finalTime = System.nanoTime();    //<-- 현재 시간 출력(작업 마무리된후)

	    long time = finalTime - startTime;   //<-- 마무리한후 시간 - 시작시간=걸린시간

	    System.out.println("걸린 시간: " + time + " 나노초");
	}

}
