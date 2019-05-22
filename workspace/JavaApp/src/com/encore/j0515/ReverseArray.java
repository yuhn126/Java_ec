package com.encore.j0515;

import java.util.Scanner;

class Test{
	
	int []arr = {11,22,33};
	public Test() {
//		arr = {11,22,33};
//		arr = new int[3]; //{0,0,0}
//		arr[0] = 11;
//		arr[1] = 22;
//		arr[2] = 33;
		
		arr = new int[] {11,22,33};
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("======================");
		for (int data : arr) {
			System.out.println(data);
		}
		
		/*
			for(자료형 변수명 : 배열){
				//각각 length,size()만큼 반복
				//단 인덱스 표현은 불가능 0,1,2,3,.......
			}
		 */
	}
	
}

public class ReverseArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("요소의 수 : ");
		int su = scan.nextInt();
		//int[]x = {10,73,2,-5,42};
		int[] x = new int[su]; //동적 메모리 할당

		for (int i = 0; i < su; i++) {
			System.out.print("x[" + i + "] : ");
			x[i] = scan.nextInt();
		}

		System.out.println("요소를 역순으로 정렬했습니다.");

		reverse(x);
		
//		ReverseArray rev = new ReverseArray();
//		rev.reverse(x);

		for (int i = 0; i < x.length; i++) {
			System.out.println("x[" + i + "] = " + x[i]);
		}

	}

	public static void swap(int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	public static void reverse(int[] a) {
		for (int i = 0; i < (a.length / 2); i++) {
			swap(a, i, (a.length - 1) - i);
		}
	}
}
