package com.encore.j0424;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

//컴포넌트(버튼)객체 생성  -------> 컨테이너(도화지) 붙이기
//자바GUI  ----->  AWT

public class FlowTest {
	//컴포넌트 선언, 컨테이너 선언	
	Button bt1, bt2, bt3; //기본값 null
	Frame f;
	
	public FlowTest() {
		//첫번쨰 : 컴포넌트, 컨테이너 객체 생성 (선언된 멤버변수 수 만큼)
//		bt = new Button();
		bt1 = new Button("Happy1");
		bt2 = new Button("Happy2");
		bt3 = new Button("Happy3");
//		f = new Frame(); 기본생성자
		f = new Frame("Flow테스트");
		
		//속성지정(컨테이너의 배치(layout)설정, 컴포넌트 붙이기 add)
//		FlowLayout fl = new FlowLayout();
//		f.setLayout(fl);
		f.setLayout(new FlowLayout()); //가운데정렬
			f   .add  (bt1);
			f   .add  (bt2);
			f   .add  (bt3);
		//프레임에 붙여라 무엇을
		
			
		//마무리 메소드 호출2 : 컨테이너 사이즈(가로, 세로길이) 설정, 컨테이너 보이기 설정
//		f.setSize(int width, int height);
		f.setSize(300, 300);
		f.setVisible(true);
		
	} //생성자 : 멤버 초기화
	
	public static void main(String[] args) { //최대한 간략화!
//		FlowTest ft = new FlowTest();
//		                 ------------
//						     생성자 호출
		new FlowTest();
		
	}
	
}
