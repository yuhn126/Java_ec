package com.encore.j0520;

import java.util.Scanner;

public class BubbleSortTest {
	void swap(int[] a, int idx1, int idx2) {// 배열의 데이터 교환
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	void bubbleSort(int[] a, int n) {
		int cnt = 0;
		for (int i = 0; i < n - 1; i++) {
			// 비교할 왼쪽 데이터, 정렬된 데이터(아래 for문을 1회 반복할 때 마다 최소값을 저장)
			for (int j = n - 1; j > i; j--) {
				// 비교할 오른쪽 데이터 [끝번지:(끝번지 -1)], [(끝반지-1):(끝번지-2)]
				cnt++;
				if (a[j - 1] > a[j]) {// 오름차순의 경우
					swap(a, j - 1, j);
				}
			}
		}
		System.out.println("비교횟수 : " + cnt);
	}// bubbleSort

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("버블정렬");
		System.out.print("요소수 : ");
		int num = scan.nextInt();
		int[] array = new int[num];

		for (int i = 0; i < array.length; i++) {
			System.out.print("array[" + i + "] : ");
			array[i] = scan.nextInt();
		}
		BubbleSortTest bst = new BubbleSortTest();
		bst.bubbleSort(array, num);
		System.out.println();
		System.out.println("======= 버블정렬 후 결과 =======");
		for (int i = 0; i < array.length; i++) {
			System.out.println("array[" + i + "] : " + array[i]);
		}
	}
}
