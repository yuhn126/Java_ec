package com.encore.j0424;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

//BorderLayout : "Center"(주된 데이터,컴포넌트를 표현)를 기준으로 동서남북 위치를 설정
public class BorderTest extends Frame{
	//필요한 객체(컴포넌트, 컨테이너) 선언
	Button b1,b2,b3,b4,b5;
	
	public BorderTest(String title) {
		//상위클래스 생성자 호출
		//super(title);		맨 첫 줄에만 있어야됨
		setTitle("새로운 타이틀");	//중간에 있어도 됨
		
		//멤버 객체 생성
		b1 = new Button("1");
		b2 = new Button("2");
		b3 = new Button("3");
		b4 = new Button("4");
		b5 = new Button("5");
		
		//속성 설정(프레임에 대한 레이아웃, 붙이기)
		this.setLayout(new BorderLayout());
		//this.add(b1);
		//BorderLayout(방위정렬)의 경우 컴포넌트를 붙일 위치(동서남북중앙)를 함께 설정.
		//주의) 위치 문자열을 표현 할 때 첫글자 대문자 사용, 철자가 틀리면 에러!
		add("North",b1);
		add("East",b2);
		add("South",b3);
		add("West",b4);
		add("Center",b5);
		
		//마무리 2개(프레임 사이즈, 프레임 보이기)
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderTest("Border테스트");	//Frame객체생성
	}
}
