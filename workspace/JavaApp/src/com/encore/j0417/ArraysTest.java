package com.encore.j0417;

import java.util.Arrays;

public class ArraysTest {
	public static void main(String[] args) {
		int []su = { 273, 151, 973, 269, 50, 489 };
		
		Arrays.sort(su);
		
		for (int i = 0; i < su.length; i++) {
			System.out.println("su[" + i + "] : " + su[i]);
		}
		System.out.println("----------------");
		for (int i = su.length - 1; i >= 0; i--) {
			System.out.println("su[" + i + "] : " + su[i]);
		}
		
		System.out.println("================");
		
		char []ch = {'j','a','v','a','l','i','k','e'};
		Arrays.sort(ch);
		for (int i = 0; i < ch.length; i++) {
			System.out.println("ch[" + i + "] : " + ch[i]);
		}
		
		System.out.println("================");
		
		String []names = { "홍길동", "길라임", "김주원", "이순신", "김주원", "박길동" };
		Arrays.sort(names);
		for (int i = 0; i < names.length; i++) {
			System.out.println("names[" + i + "] : " + names[i]);
		}
		
		
		
		
		
	}// main
}
