package com.encore.j0517;

class EmptyIntStackException extends RuntimeException {
	public EmptyIntStackException() {
	}
}// 빈 예외클래스

class OverflowIntStackException extends RuntimeException {
}// 넘침 예외클래스

public class IntStack {// 정수를 저장하는 스택

	private int max; // 스택용량
	private int pointer; // 스택포인터
	private int[] stack; // 스택본체

	public IntStack(int capacity) {// capacity : 저장용량 (방 크기)
		// pointer = 0;
		try {
			max = capacity;
			stack = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}// 생성자

	public int push(int x) throws OverflowIntStackException {

		if (pointer >= max) {
			throw new OverflowIntStackException();
		}
		return stack[pointer++] = x; // 키포인트
//		stack[pointer] = x;
//		pointer++;
		/*
		 * 만약 'stack[++pointer] = x;' 정의했다면 풀어서 설명하면? pointer++; stack[pointer] = x;
		 * 
		 */
	}

	public int pop() {
		if (pointer <= 0) {// 데이터 없음
			throw new EmptyIntStackException(); // throw : 리턴 '에러메시지'
		}
		return stack[--pointer];
	}

	// 스택 정상에 있는 데이터를 들여다 보는 기능, 마지막 입력 push된 데이터 정보
	public int peek() {
		return stack[pointer - 1];
	}

	// ---------------------------------------------------------------------------------------

	// x데이터가 갖는 인덱스 리턴! x데이터가 존재하지 않는다면 리턴 -1
	public int indexOf(int x) {
		// for (int i = 0; i < pointer; i++) {
		for (int i = pointer - 1; i >= 0; i--) {
			if (stack[i] == x) {
				return i;
			}
		}
		return -1;
	}

	public int capacity() {
		return max;
	}

	public int size() {
		return pointer;
	}

	public boolean isEmpty() {// 스택의 빈 상태
		return pointer <= 0;
	}

	public boolean isFull() {// 스택이 꽉 찬 상태
		return pointer >= max;
	}

	public void dump() {//스택안의 모든 데이터를 bottom ---> top순서로 출력
		if (isEmpty()) {//스택에 데이터가 없다면 출력 할 필요x
			System.out.println("#스택이 비어있습니다.");
		}else{
			for (int i = 0; i < pointer; i++) {
				System.out.println(stack[i] + " ");
			}System.out.println();
		}
		
	}

}
