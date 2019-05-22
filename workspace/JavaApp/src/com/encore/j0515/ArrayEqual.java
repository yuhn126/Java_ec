package com.encore.j0515;

import java.util.Scanner;

public class ArrayEqual {
	// 두 배열의 데이터 비교
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("배열a의 요소 갯수:");
		int size1 = scan.nextInt();

		int[] a = new int[size1];
		for (int i = 0; i < a.length; i++) {
			System.out.print("a[" + i + "]:");
			a[i] = scan.nextInt();
		}
		//////////////////////////////////////
		System.out.print("배열b의 요소 갯수:");
		int size2 = scan.nextInt();

		int[] b = new int[size2];
		for (int i = 0; i < b.length; i++) {
			System.out.print("b[" + i + "]:");
			b[i] = scan.nextInt();
		}
		//////////////////////////////////////
		ArrayEqual ae = new ArrayEqual();

		if (ae.equals(a, b)) {
			System.out.println("배열 a와 b는 같습니다.");
		} else {
			System.out.println("배열 a와 b는 다릅니다.");
		}

	}// main

	public boolean equals(int[] a, int[] b) {
		if (a.length != b.length)
			return false;

		for (int i = 0; i < a.length; i++) {// a와 b배열의 길이가 같았을때!! 배열의 인덱스
			if (a[i] != b[i])
				return false;
		}

		return true;// 두 배열의 길이가 같고, 내용 값이 같았을때
	}// equals

}
