package com.encore.j0520;

public class RecursiveTest {
	int count = 1;

	void gildong() {
		System.out.println("동에번쩍 서에번쩍!");
		if (count >= 10)
			return;

		count++;

		gildong(); // 재귀호출 : 끝나는 조건이 없다면 StackOverflowError발생한다.

	}

	public static void main(String[] args) {
		RecursiveTest rt = new RecursiveTest();
		rt.gildong();
	}
}
