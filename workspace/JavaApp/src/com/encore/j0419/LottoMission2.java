package com.encore.j0419;

import java.util.Arrays;
import java.util.Random;

public class LottoMission2 {
	int []lotto;		// 선언, 기본값 : null
	Random r;			// 기본값 : null
	
	public LottoMission2() {	// 생성자 : 초기화 메소드, 선행작업
		lotto = new int[6];
		r = new Random();
	} // 생성자
	
	// 번호출력 기능
	public void printNum(){
		for (int i = 0; i < lotto.length; i++) {
			if(i < lotto.length - 1) {
				System.out.print(lotto[i] + ", ");				
			}else{
				System.out.print(lotto[i]);	
			}
		}
	} //printNum
	
	// 로또 번호 생성 기능
	public void generateNum(){
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = r.nextInt(45) + 1;
			if(duplicateNum(i))
				i--;
		} //for
		Arrays.sort(lotto);
	} //generateNum
	
	// 중복 숫자 체크 기능
	public boolean duplicateNum(int idx) { // 중복 숫자 발견 시 true 리턴
		for(int i = idx - 1; i > -1; i-- ) {
			if (lotto[idx] == lotto[i]) {
				return true;
			} //if
		} //for
		return false;	// 발견 못하면 false
	} //duplicateNum
	
	public static void main(String[] args) {
		LottoMission2 lotto = new LottoMission2();
		System.out.println("★★금주 행운의 로또 번호★★");
		for (int i = 1; i < 6; i++) {
			System.out.print(i + "회 : ");
			lotto.generateNum();
			lotto.printNum();
			System.out.println();
		} //for
	} //main
}
