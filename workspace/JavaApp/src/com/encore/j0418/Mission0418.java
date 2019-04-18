package com.encore.j0418;

public class Mission0418 {
	public static void main(String[] args) {
		int []su = { 1, 2, 3, 4, 5 };
		
		System.out.println("<문제1>");
		for (int i = 0; i < su.length; i++) {
			System.out.println("su[" + i + "] : " + su[i]);
		}System.out.println("==============================");
		
		
		System.out.println("<문제2>");
		for (int i = su.length - 1; i >= 0; i--) {
			System.out.println("su[" + i + "] : " + su[i]);
		}System.out.println("==============================");
		
		
		System.out.println("<문제 3>");
		int su2[][] = { {1}, {1, 2}, {1, 2, 3} };
		for (int i = 0; i < su2.length; i++) {
			for (int j = 0; j < su2[i].length; j++) {
				System.out.println("su[" + i + "]["+ j +"] : " + su2[i][j]);
			}
		}System.out.println("==============================");
		
		
		System.out.println("<문제 4>");
		int []su3 = new int[su.length];
		for (int i = 0; i < su.length; i++) {
//			su3 = su;  ---> su의 주소가 su3에 복사 되는것
//					   ---> su와 su3이 같은 메모리를 참조
			su3[i] = su[i];
			su3[2] = 33;
			System.out.println("su3[" + i + "] : " + su3[i]);
		}System.out.println(su3[2] + " " + su[2]); 	//영향을 끼치지 않음
		System.out.println("==============================");
		
		
		System.out.println("<문제 5>");
		int temp = 0;
		for (int i = 0; i < su.length; i++) {
			int j  = (su.length - 1) - i;
			if(i < (su.length/2)) {
				temp = su[j];
				su[j] = su[i];
				su[i] = temp;
			}
			System.out.println("su[" + i + "] : " + su[i]);
		}System.out.println("==============================");
		
		/*
		 * 
		1.
		for(int i=0, j = su.length -1; i<su.length/2; i++,j--) 
		
		2.
		for (int i = 0; i < (su.length/2) + 1; i++) {
			int j  = (su.length - 1) - i;
			temp = su[j];
			su[j] = su[i];
			su[i] = temp;
			System.out.println("su[" + i + "] : " + su[i]);
			}
		for (int i = (su.length/2)+1;  i < su.length; i++) {
			System.out.println("su[" + i + "] : " + su[i]);
		}System.out.println("==============================");
		* 
		*/
		
		
		System.out.println("<문제 6>");
		for(int i = 0; i<su.length; i++ ) {
			if(i%2==1) {
				System.out.println("su[" + i + "] : " + su[i]);
			}
		}System.out.println("==============================");
		
		
		System.out.println("<문제 7>");
		for(int i = 0; i<su.length; i++ ) {
			if(su[i]%2==1) {
				System.out.println("su[" + i + "] : " + su[i]);
			}
		}
		
	}
}
