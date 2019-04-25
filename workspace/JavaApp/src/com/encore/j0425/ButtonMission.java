package com.encore.j0425;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
	<이벤트처리> ---> 컴포넌트에 기능을 정의하자!!
	
	1. 이벤트소스(컴포넌트)에 적용할 이벤트 분석
		   Button bt  ----> ActionEvent
	2_1. ActionListener(인터페이스) ---> implements ActionListener
	2_2. public void actionPerformed(ActionEvent e){} ===> 오버라이딩
	
	3. 연결자메소드 등록		[이벤트 소스] <------------연결-------------> [이벤트 처리부]
		이벤트 소스명.add인터페이스명(이벤트 처리부의 위치);
			bt.addActionListener(this);
			
	<이벤트처리 방법>
	1. 기능을 적용할 컴포넌트 찾기(이벤트 소스 찾기) : bt1, bt2( sb, list, cb)
										   --------
										   자료형 Button
										         
	2.Button(이벤트소스)클래스의 메소드 중 add~Listener()메소드 찾기!	==>	 addActionListener()!
	
	3. 인터페이스(add제거) ===> ActionListener : implements 하기!! ==> 메소드 오버라이딩
	
	4. 연결자 등록!! (2번의 add~Listener()메소드)
	
 */

public class ButtonMission extends Frame implements ActionListener{
	Button bt1, bt2;	//[이벤트 소스]
	
	public ButtonMission() {
		setTitle("미션");
		bt1 = new Button("안녕");
		bt2 = new Button("잘가");
		
		setLayout(new FlowLayout());
		add(bt1);
		add(bt2);
		
		setSize(300,300);
		setVisible(true);
		
		//소스 <------연결------> 핸들러
		//이벤트소스명.add~Listener(핸들러위치);
		  bt1.addActionListener(this);
		  bt2.addActionListener(this);
		
		/*
		   public class Button{
		   
		       public void addActionListener(ActionListener l){
		       
		           while(true){
		           
		               if(버튼이 눌렸다면){
		                   1. actionPerformed(이벤트소스정보);
		               }
		               
		           }
		           
		       }
		       
		   }
		 */
		
	}//생성자
	

	@Override
	public void actionPerformed(ActionEvent e) {	//[이벤트 핸들러(처리부)]
		//사건발생시 실행할 기능 정의
		
//		if(e.getActionCommand().equals("안녕")) {
//			System.out.println("안녕~~!!");
//		}else{
//			System.out.println("잘가~~!!");
//		}
		
		Object ob = e.getSource(); 	//이벤트 소스를 얻어옴
		//==> 이벤트를 발생시킨 컴포넌트의 주소를 리턴하는 메소드
		//'안녕'버튼 클릭 시 Object ob = 203호; Object ob = bt1;
		//'잘가'버튼 클릭 시 Object ob = 303호; Object ob = bt2;
		
		if(ob == bt1) {
			System.out.println("안녕~~!!");
		}else if( ob == bt2){
			System.out.println("잘가~~!!");
		}
		
		
	}

	public static void main(String[] args) {
		new ButtonMission();
	}
}
