package com.encore.j0514;

public class PlusTable {
	public static void main(String[] args) {
//		int sum;		
		for (int i = 4; i <= 12; i++) {
//			sum = i;
//			for(int j = 0; j <= 5; j++) {
//				sum += j;
			for(int j = 0, sum = i; j <= 5; j++, sum += j) {
				System.out.printf("%-4d", sum);
			}System.out.println();
		}
	}//main
}
//.....zZ