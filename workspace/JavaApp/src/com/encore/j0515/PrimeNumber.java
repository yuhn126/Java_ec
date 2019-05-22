package com.encore.j0515;

public class PrimeNumber {
	public static void main(String[] args) {
		for (int base = 2; base < 1000; base++) {//기준 수(소수인지 혹은 합성수인지 파악)
			int j;
			for (j = 2; j < base; j++) {//나눌수
				if(base % j == 0) {//1과 자신의 수를 제외하고 나뉘어진다면
					break;
				}
			}
			System.out.println(base + "  ");
		}
	}//main
}
 