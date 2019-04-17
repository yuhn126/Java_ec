package com.encore.j0415;

import java.io.IOException;

public class GugudanMission {

	public static void main(String[] args) throws IOException {
		System.out.println("<<구구단>>");
		
//		while(flag) {
//			반복문을 벗어날 코드 ==> flag = false;
//		}
		
		Gugudan g = new Gugudan();
		
//		do {
//			int i = g.inputDan();
//			g.outputDan(i);
//		}while( g.continueDan() == 'y');
		
		
		while(true) {
			int i = g.inputDan();
			g.outputDan(i);
			
			char cd = g.continueDan();
			if(cd == 'n') break;
		}
		System.out.println("프로그램을 종료합니다.");
	}
}