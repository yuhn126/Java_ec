package com.encore.j0425;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.Scrollbar;

public class ScrollChoiceListTest extends Frame{
	Scrollbar sb;
	Panel topp, smallp, bottomp;
	List list;
	Choice cho;
	Label la;
	
	public ScrollChoiceListTest() {
		setTitle("비주얼컴포넌트테스트");
		la = new Label("초록");
		
		//Scrollbar(int orientation, int value, int visible, int minimum, int maximum)
		//Orientation : 수평 0, 수직 1 스크롤바
		//value : 조절바의 시작 위치, visible : 조절바의 너비
		//minimum : 최솟값, maximum : 최댓값
		sb = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 10);
		
		cho = new Choice();
		cho.add("서울");
		cho.add("강릉");
		cho.add("대전");
		cho.add("대구");
		cho.add("부산");
		cho.add("광주");
		cho.add("제주");
		cho.setBackground(Color.orange);
		
//		List(int rows, boolean multipleMode)
		list = new List(2,false);
//		list.addItem("족구");  Deprecated메소드 (성능에 문제있음)
		list.setBackground(Color.magenta);
		list.add("야구");
		list.add("배구");
		list.add("축구");
		list.add("농구");
		list.add("야구");
		list.add("배구");
		list.add("축구");
		list.add("농구");
		
		smallp = new Panel();
		smallp.setLayout(new BorderLayout());
		smallp.add("West",la);
		smallp.add("Center",sb);
		
		topp = new Panel();
		//GridLayout(행,열,수평간격,수직간격);
		topp.setLayout(new GridLayout(3,1,0,45));
		topp.add(new Label());
		topp.add("Center", smallp);
//		topp.add(new Label()); 세번째 영역
		topp.setBackground(Color.green);
		
		bottomp = new Panel();
		bottomp.add(list);
		
		this.setLayout(new GridLayout(3,1));
		add(topp);
		add(cho);
		add(bottomp);
		
		setSize(300, 500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ScrollChoiceListTest();
	}
}
