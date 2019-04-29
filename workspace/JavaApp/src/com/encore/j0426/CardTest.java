package com.encore.j0426;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//CardLayout테스트(컴포넌트를 같은 위치에 부착)
public class CardTest implements ActionListener {
	Frame f;
	Panel card1, card2, card3; //카드
	Panel redp, bluep, yellowp; //색깔패널
	Button bt1, bt2, bt3;
	CardLayout card;
	
	public CardTest() {
		f = new Frame("카드레이아웃");
		
		redp = new Panel();
		redp.setBackground(Color.red);
		bluep = new Panel();
		bluep.setBackground(Color.blue);
		yellowp = new Panel();
		yellowp.setBackground(Color.yellow);
		
		bt1 = new Button("다음");
		bt2 = new Button("다음");
		bt3 = new Button("다음");
		
		card1 = new Panel();
		  card1.setLayout(new BorderLayout(0,10));
		  card1.add("Center",redp);
		  card1.add("South",bt1);
		 
		card2 = new Panel();
		  card2.setLayout(new BorderLayout(0,10));
		  card2.add("Center",bluep);
		  card2.add("South",bt2);
		 
		card3 = new Panel();
		  card3.setLayout(new BorderLayout(0,10));
		  card3.add("Center",yellowp);
		  card3.add("South",bt3);
		 
		card = new CardLayout();
		 f.setLayout(card);
		   f.add(card1,"first");	//처음에 보이는 카드
		   f.add(card2,"second");
		   f.add(card3,"third");
		 //f.add(붙일컴포넌트,별명);	alias별명		  
		 
		 //card.show(Container parent, String name);
		 // 를     보여라	    어디에			   무엇을
		 card.show(f, "a3");
		 
		 f.setSize(250,300);
		 f.setVisible(true);
		 
		 bt1.addActionListener(this);
		 bt2.addActionListener(this);
		 bt3.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { //이벤트 핸들러
		Object ob = e.getSource(); //이벤트 소스의 주소(bt1 또는 bt2 또는 bt3의 주소)
		
		if(ob == bt1) {
			//첫번째 버튼 눌렀을 때 - 두번째 카드 보이기
			card.show(f,"second");
		}else if(ob == bt2){
			//두번째 버튼 눌렀을 때 - 세번째 카드 보이기
			card.show(f,"third");
		}else if(ob == bt3){
			card.show(f,"first");
			//세번째 버튼 눌렀을 때 - 첫번째 카드 보이기
		}
	}
	
	public static void main(String[] args) {
		new CardTest();
	}

}
