package com.encore.j0429;

import java.util.Random;

public class GameTest {
	public static void main(String[] args) {
		
		int user = 642;
		int[] userv = new int[3];
		int su = user;
		
		
//		System.out.println((int)(user/Math.pow( 10, 2)));
		
		for(int i = 0; i < userv.length; i++) {
			su = ((int)(user/Math.pow( 10, i)));
			userv[userv.length-(i+1)] = su;
			user = user - su;
		}
		
		for(int i = 0; i < userv.length; i++) {
			System.out.println(userv[i]);
		}
		
//		for(int i = 0; i < 3; i++) {
//			System.out.println("userv[" + i +"]="+ userv[i]);
//		}
		
		
	}
}
