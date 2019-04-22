package com.encore.j0422;

public class StringTest3 {
	public static void main(String[] args) {
		/*
		 				str.getBytes()								str.toCharArray()
		 		<--------------------------					  ----------------------------->
		 byte[]b							String str = "abc"								char []ch
		   ={97,98,99};																			={'a','b','c'};	
		   		-------------------------->					  <-----------------------------
					   new String(b);								  new String(ch);
		 */
		
		String str = "abc";
		System.out.println("STR = " + str);
		
		byte []b = str.getBytes();		//byte로 변환
		for (int i = 0; i < b.length; i++) {
			System.out.println("b[" + i + "] = " + b[i]);
			
		}
		String str2 = new String(b);
		System.out.println("STR2 = " + str2);
		
		System.out.println("=========byte배열을 문자열로 변환=========");
		
	}
}
