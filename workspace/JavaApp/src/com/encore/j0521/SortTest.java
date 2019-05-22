package com.encore.j0521;

public class SortTest {
	void swap(int[] arr, int idx1, int idx2) {// 스왑
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}// bubbleSort

	public void selectionSort(int[] arr) {
		// 기준 arr.length ==> 7 일때

		for (int i = 0; i < arr.length - 1; i++) {// 최소값 기준 인덱스 0~5
			int min = i;// 0
			// i=0 j=1,2,3,4,5,6
			// i=1 j=2,3,4,5,6
			// i=2 j=3,4,5,6
			// i=3 j=4,5,6
			// i=4 j=5,6
			// i=5 j=6

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					// min번지의 값보다 작은값을 갖는 번지를 찾았다면
					// 최소값을 찾았다면
					min = j; // 최소값 번지가 변경!!
				}
			}
			// 최소값 번지를 구할 수 있음!!
			// 좌측 번지(i) <===> 최소값번지(min)의 값
			// 교환
			swap(arr, i, min);
		}
	}// selectionSort

	void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
//			int home = i;
			int base = arr[i];
			for (int j = 0; j < i; j++) {// 이미 정렬된 값 확인
				if (arr[i] < arr[j]) {
//					?home = j;
				}
			}
		}
	}// insertionSort

	public static void main(String[] args) {
		SortTest st = new SortTest();

		System.out.println("--------버블정렬--------");
		int[] a = { 6, 3, 50, 1, 4, 72, 2009, 8, 22 };// void bubbleSort(int[] arr)
		st.bubbleSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

		
		System.out.println("--------선택정렬--------");
		int[] b = { 6, 4, 8, 3, 1, 9, 7 };// void selectionSort(int[] arr)

		
		System.out.println("--------삽입정렬--------");
		int[] c = { 1, 4, 6, 7, 3, 9, 8 };// void insertionSort(int[] arr)
		st.insertionSort(c);
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println();
	}
}
