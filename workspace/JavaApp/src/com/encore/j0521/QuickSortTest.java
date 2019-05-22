package com.encore.j0521;

/*
	<퀵정렬>
			pl--->			 x			<----pr
			[0]	[1]	[2]	[3]	[4]	[5]	[6]	[7]	[8]
	arr =  { 5,  7,  1,  4,  6,  2,  3,  9,  8 }
	
	pl(왼쪽 포인터)
	pr(오른쪽 포인터)
	x(피벗 기준!)
	
	작업1)arr[pl] >= x 조건성립되는 요소(데이터) 찾을때까지 pl을 오른쪽으로 스캔 pl++
	
	작업1)arr[pr] <= x 조건성립되는 요소(데이터) 찾을때까지 pr을 왼쪽으로 스캔 pr--
	
 */

public class QuickSortTest {
	
	public void swap(int[] arr, int idx1, int idx2) {// 스왑
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}
	
	public void quickSort(int[] arr, int left, int right){
		int pl = left;	//왼쪽포인터(인덱스)
		int pr = right;	//오른쪽포인터(인덱스)
		int x = arr[(pl + pr) / 2];
		
		do {
			while(arr[pl] < x)pl++;//피벗 기준 큰 값 찾기
			while(arr[pr] > x)pl--;//피벗 기준 작은 값 찾기
			
			//데이터 교환
			if(pl <= pr) {
				swap(arr, pl++, pr--);
			}
			
		} while (pl <= pr);
		
		if (left < pr) {
			quickSort(arr, left, pr);
		}
		if (pl < right) {
			quickSort(arr, pl, right);
		}
	}
	
	public static void main(String[] args) {
		QuickSortTest qst = new QuickSortTest();
		int[]su= {5, 6, 1, 4, 6, 2, 3, 9, 8};
		qst.quickSort(su, 0, su.length-1);
		
		System.out.println("#퀵정렬 후 su배열");
		
		for (int i = 0; i < su.length; i++) {
			System.out.print(su[i] + " ");
		}System.out.println();
		
	}
}
