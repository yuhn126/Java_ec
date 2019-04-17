package com.encore.j0417;

import java.util.Scanner;


	public class ScannerTest2 {

	   public static void main(String[] args) 
	   {
	      Scanner sc = new Scanner(System.in);
	      int t;
	      sc.hasNext();
	      long st1 = System.currentTimeMillis();
	      for ( int i = 0; i < 10000; i++ )
	      {
	         t = sc.nextInt();
	         System.out.println(i);
	      }
	      System.out.println( "소요시간" + (System.currentTimeMillis() - st1 ) + "ms" );
	      sc.close();
	   }

	}
