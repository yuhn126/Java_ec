package com.encore.j0516;

import java.util.Scanner;

public class SeqSearchSentinel {
	int seqSearch(int[] arr, int n, int key) {
//		for (int i = 0; i < a.length; i++) {
//			if (a[i] == key) {
//				return i;
//			}
//		}
//		return -1;

//		arr[마지막번지] = 검색할 데이터(보초데이터)
		arr[n] = key;

		int i = 0;// 배열 인덱스(번지)표현
		while (true) {
			if (arr[i] == key) {// 데이터 존재 체크
				break;
			}
			i++;
		}
		return (i == n) ? -1 : i;
	}

	public static void main(String[] args) {
		SeqSearchSentinel ss = new SeqSearchSentinel();
		Scanner scan = new Scanner(System.in);
		System.out.print("요소 개수 : ");
		int su = scan.nextInt();
		int[] a = new int[su + 1];
		for (int i = 0; i < su; i++) {// x.length ---> num변경 : 사용자 입력
			System.out.print("x[" + i + "] : ");
			a[i] = scan.nextInt();
		}
		System.out.print("찾을 요소 : ");
		int key = scan.nextInt();

		int idx = ss.seqSearch(a, su, key);

		if (idx == -1) {
			System.out.println("x배열에 " + su + "은(는) 없음.");
		} else {
			System.out.println(key + "은(는) x[" + idx + "]에 있음");
		}
	}

}
