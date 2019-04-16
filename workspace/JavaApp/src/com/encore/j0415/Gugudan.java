package com.encore.j0415;

import java.io.IOException;

public class Gugudan {
	int inputDan() throws IOException {
		System.out.println("<<구구단>>");
		System.out.print("원하는 단 : ");

		int dan = System.in.read() -48;
		System.in.read();
		System.in.read();
		
		return dan;
	}
	
	void outputDan(int dan) {
		for(int i=1; i<10; i++) {
			System.out.println(dan + "*" + i + "=" + dan*i);
		}	
	}
	
	char continueDan() throws IOException {
		System.out.print("계속 할까요?(y/n) : ");
		int cd = System.in.read();
		System.in.read();
		System.in.read();
		return (char)cd;
	}
}
