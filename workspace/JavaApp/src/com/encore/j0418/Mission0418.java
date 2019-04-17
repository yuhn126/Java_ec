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
		int []su3 = new int[5];
		for (int i = 0; i < su.length; i++) {
			su3[i] = su[i];
			System.out.println("su3[" + i + "] : " + su3[i]);
		}System.out.println("==============================");
		
		System.out.println("<문제 5>");
		int temp = 0;
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
