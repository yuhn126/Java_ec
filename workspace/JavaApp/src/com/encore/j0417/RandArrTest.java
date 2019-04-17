package com.encore.j0417;

import java.util.Random;

public class RandArrTest {
	int []su;
	Random r;
	int temp;
	
	public RandArrTest() {				//생성자 : 초기화 메소드 리턴타입xx 클래스와 이름이 같음
		su = new int[5];
		r = new Random();
	}
	
	public void inputArray() {
		// 랜덤(임의의 난수)수를 발생해서 배열 안에 입력
		// 임의의 수 발생 ==> java.lang.Math : random(), java.util.Random
		
		
		for (int i = 0; i < su.length; i++) {
			//su[i] = (int) (Math.random()*100);	// 0.0 ~ 0.99999999
			su[i] = r.nextInt(1000);	// 0 ~ 999 + 1 : 1 ~ 1000
		}
	}
	public void printArray() {
		for(int i = 0; i < su.length; i++) {	// 배열 인덱스 표현
			System.out.println("su[" + i + "] = " + su[i]);
		}
	}
	public void sortArray() {
//		int [] su = { 109, 87, 55, 79, 90 };
		for(int i = 0; i < su.length; i++) {
			for(int j = i+1; j < su.length; j++) {	// i와 j는 배열의 번지수를 표현
				if(su[i] > su[j]) {
					temp = su[i];
					su[i] = su[j];
					su[j] = temp;									
				}
			}
		}
//		for (int i = 0; i < su.length; i++) {
//			System.out.println("정렬/su[" + i + "] : " + su[i]);
//		}
	}
	
	public static void main(String[] args) {
		RandArrTest rat = new RandArrTest();
		rat.inputArray();
		rat.sortArray();
		rat.printArray();
	}
}
