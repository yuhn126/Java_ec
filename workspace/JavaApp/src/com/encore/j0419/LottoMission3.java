package com.encore.j0419;

import java.util.Random;

public class LottoMission3 {
	public static void main(String[] args) {
		
		int[] lotto = new int[45];			//인덱스 : 0~44
		
		//첫번째 방 ~ 마지막 방 숫자 입력 : 1 ~ 45
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i+1;
		}
		
		Random r = new Random();
		//숫자를 섞어주기
		int temp;
		for(int i = 0; i < 1000; i++){ 		//번호 숫자를 섞어주는 횟수
			int randomIdx = r.nextInt(44) + 1;
			
			temp = lotto[0];
			lotto[0] = lotto[randomIdx];	//1~44번지 중 한개
			lotto[randomIdx] = temp;
		}//for
		
		for(int i = 0; i < 6; i++) {		//배열 맨 앞의 6개 숫자를 출력
			System.out.println("lotto[" + (i+1) + "] = " + lotto[i]);
		}
	}
}
