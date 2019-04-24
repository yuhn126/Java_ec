package com.encore.j0424;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class GridTest extends Frame {
	//프로그램에 필요한 객체(컴포넌트, 컨테이너)선언
	Button bt1,bt2,bt3,bt4,bt5;
	
	public GridTest() {
		setTitle("Grid테스트");
		
		//객체 생성을 먼저! (왜? NullPointerException 예방)
		bt1 = new Button("1");
		bt2 = new Button("2");
		bt3 = new Button("3");
		bt4 = new Button("4");
		bt5 = new Button("5");
		
		//레이아웃 설정, 붙이기
//		setLayout(new GridLayout()); //행열정렬 (기본: 1행)
//		setLayout(new GridLayout(int row, int cols)); row : 행  cols : column 열
//		new GridLayout(int rows, int cols, int hgap, int vgap)
//		setLayout(new GridLayout(2,3)); // 2 * 3 = 6 --> 컨테이너에 최대 6개의 컴포넌트를 붙이기
		
		setLayout(new GridLayout(2,3,10,0));
		add(bt1);
		add(bt2);
		add(bt3);
		add(bt4);
		add(bt5);
		
		//마무리(사이즈, 보이기 설정)
		setSize(500,300); //(가로,세로)
		setVisible(true);
	} //생성자 : 초기화(값할당) 작업
	
	public static void main(String[] args) {
		new GridTest();
	}
}
