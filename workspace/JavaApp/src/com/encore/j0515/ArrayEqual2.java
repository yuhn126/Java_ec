package com.encore.j0515;

import java.util.Scanner;

public class ArrayEqual2 {
	public boolean equals(int[] a, int[] b) {
		if (a.length != b.length)
			return false;

		for (int i = 0; i < a.length; i++) {// a와 b배열의 길이가 같았을때!! 배열의 인덱스
			if (a[i] != b[i])
				return false;
		}

		return true;// 두 배열의 길이가 같고, 내용 값이 같았을때
	}// equals

	public int[] arrayGenerate(String arrName) {// 배열객체생성
		Scanner scan = new Scanner(System.in);

		System.out.print("배열" + arrName + "의 요소 갯수:");
		int size1 = scan.nextInt();

		int[] a = new int[size1];
		for (int i = 0; i < a.length; i++) {
			System.out.print(arrName + "[" + i + "]:");
			a[i] = scan.nextInt();
		}

		return a;
	}// arrayGenerate

	// 두 배열의 데이터 비교
	public static void main(String[] args) {

		ArrayEqual2 ae = new ArrayEqual2();
		int[] c = ae.arrayGenerate("c");
		int[] d = ae.arrayGenerate("d");

		if (ae.equals(c, d)) {
			System.out.println("배열 c와 d는 같습니다.");
		} else {
			System.out.println("배열 c와 d는 다릅니다.");
		}

	}// main

}
