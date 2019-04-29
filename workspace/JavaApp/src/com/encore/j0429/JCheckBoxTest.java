package com.encore.j0429;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class JCheckBoxTest extends JFrame {
	JCheckBox cb1, cb2, cb3;
	JPanel panel;
	
	public JCheckBoxTest() {
		ImageIcon icon1 = new ImageIcon("image/left.gif");
		ImageIcon icon2 = new ImageIcon("image/leftrollover.gif");
		ImageIcon icon3 = new ImageIcon("image/leftdown.gif");
		
		ImageIcon icon4 = new ImageIcon("image/right.gif");
		ImageIcon icon5 = new ImageIcon("image/rightrollover.gif");
		ImageIcon icon6 = new ImageIcon("image/rightdown.gif");
		
		//JCheckBox(String text, Icon icon)
		cb1 = new JCheckBox("첫번째 체크박스", icon1);
		 cb1.setRolloverIcon(icon2);	//체크박스 위에 마우스가 올려졌을 때
		 cb1.setSelectedIcon(icon3);	//체크박스가 선택 되었을 때 
		cb2 = new JCheckBox("두번째 체크박스", icon4);
		 cb2.setRolloverIcon(icon5);
		 cb2.setSelectedIcon(icon6);
		cb3 = new JCheckBox("세번째 체크박스");
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		panel.add(cb1);
		panel.add(cb2);
		panel.add(cb3);
		
		//panel.setBorder(new TitledBorder("패널타이틀"));
		//panel.setBorder(new BevelBorder(BevelBorder.RAISED));	//양각
		//panel.setBorder(new BevelBorder(BevelBorder.LOWERED));	//양각
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED), "패널타이틀"));		
		
		setTitle("체크박스 테스트");
		add(panel);	//JFrame - BorderLayout기본레이아웃
					//		   "Center"기본위치
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//생성자
	
	public static void main(String[] args) {
		new JCheckBoxTest();
	}

}
