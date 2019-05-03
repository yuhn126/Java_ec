package com.encore.j0503;

public class ASCIIOutputTest {
/*
 	<자료형 변환>
 	
 			   str.getByte()
 			<----------------------						---------------------->
 	byte []b						String str = "abc";							char[] ch
 	={97,98,99};																={'a','b','c'}
 			---------------------->						<----------------------
 		  String str2 = new String(b);				   String str3 = new String(ch);
 									
 */
	
	
	public static void main(String[] args) {
		
		
//		for (int i = 32; i < 127; i++) {
//			//System.out.write(int b); b : byte약자, byte는 문자코드
//			System.out.write(i);
//			if (i%8==7) System.out.write('\n');
//			else System.out.write('\t');
//		}
		
		String str = "hi java stream!!!";
		byte []b = str.getBytes();
		for (int i = 0; i < b.length; i++) {
			System.out.write(b[i]);
			if (i%3 == 2) {
				System.out.write('\n');
			}
			
//			System.out.flush();
			
			//출력 객체들은 flush()메소드 가짐	(참고 : 입력객체는 flush()메소드 없음)
			//		    -------
			//	버퍼(임시저장소)를 비우는 역할(버퍼의 내용을 push하는 역할)
		}

	}

}
