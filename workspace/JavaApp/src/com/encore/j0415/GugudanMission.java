package com.encore.j0415;

import java.io.IOException;

public class GugudanMission {

	public static void main(String[] args) throws IOException {
		Gugudan g = new Gugudan();
		do {
			int i = g.inputDan();
			g.outputDan(i);
		}while( g.continueDan() == 'y');
		System.out.println("프로그램을 종료합니다.");
		
	}

}
