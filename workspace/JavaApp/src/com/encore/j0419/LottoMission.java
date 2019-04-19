package com.encore.j0419;

import java.util.Arrays;
import java.util.Random;

public class LottoMission {
	public static void main(String[] args) {
		int []lotto = new int[6];
		Random r = new Random();
		System.out.println("★★ 금주 행운의 로또 번호 ★★");
		for(int k = 1; k < 6; k++) {
			System.out.print(k + "회 : ");
			for(int i = 0; i < lotto.length; i++) {
				lotto[i] = r.nextInt(45) + 1;		//특정 범위 설정 (0~44) + 1 = 1~45
				for(int j = 0; j < i; j++) {
					if(lotto[i] == lotto[j]) {
						i--;
					}
				}
			}
			
			Arrays.sort(lotto);
			
			for(int i = 0; i<lotto.length; i++) {
				if(i<lotto.length -1) {
					System.out.print(lotto[i] + ", ");
				}else{
					System.out.println(lotto[i]);
				}
			}
		}
		
		
		
		
	}
}
