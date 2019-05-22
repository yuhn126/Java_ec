package com.encore.j0520;

import java.util.Scanner;

public class SelectionSortTest {
	void swap(int[] a, int idx1, int idx2) {// 배열의 데이터 교환
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	void selectionSort(int[] a, int n) {
		for (int i = 0; i < a.length; i++) {
			int min = i; // min인덱스 0, 1, 2, 3 (맨 앞 번지를 최소값이라고 간주)
			for (int j = i + 1; j < 5; j++) {// 최소값 구하기
				// [23, 12, 9, 8, 10]
				//   0   1  2  3   4
				if (a[j] < a[min]) {
					min = j;
				}
			}
			swap(a, i, min);
		}
	}

	public static void main(String[] args) {
		SelectionSortTest sst = new SelectionSortTest();
		Scanner scan = new Scanner(System.in);
		System.out.println("선택정렬");
		System.out.print("요소수 : ");
		int num = scan.nextInt();
		int[] array = new int[num];
		
		for (int i = 0; i < array.length; i++) {
			System.out.print("array[" + i + "] : ");
			array[i] = scan.nextInt();
		}
		sst.selectionSort(array, num);
		System.out.println();
		System.out.println("======= 선택정렬 후 결과 =======");
		for (int i = 0; i < array.length; i++) {
			System.out.println("array[" + i + "] : " + array[i]);
		}
	}
}
