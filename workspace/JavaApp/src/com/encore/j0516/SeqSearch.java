package com.encore.j0516;

import java.util.Scanner;

public class SeqSearch {
	int seqSearch(int[] a, int n, int key) {
//		for (int i = 0; i < a.length; i++) {
//			if (a[i] == key) {
//				return i;
//			}
//		}
//		return -1;
		int i = 0;
		while (true) {
			if (i == n)// 데이터를 끝까지 조회했는지 체크 2.
				return -1;
			if (a[i] == key)
				return i;
			i++;
		}
	}

	public static void main(String[] args) {
		SeqSearch ss = new SeqSearch();
		Scanner scan = new Scanner(System.in);
		System.out.print("요소 개수 : ");
		int su = scan.nextInt();
		int[] a = new int[su];
		for (int i = 0; i < su; i++) {
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
