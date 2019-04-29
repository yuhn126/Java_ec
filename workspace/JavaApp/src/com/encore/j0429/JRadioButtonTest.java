package com.encore.j0429;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class JRadioButtonTest extends JFrame {
	JRadioButton radio1, radio2, radio3;
	JPanel panel;
	
	public JRadioButtonTest() {
		ImageIcon icon1 = new ImageIcon("image/left.gif");
		ImageIcon icon2 = new ImageIcon("image/leftrollover.gif");
		ImageIcon icon3 = new ImageIcon("image/leftdown.gif");
		
		radio1 = new JRadioButton("라디오1", icon1);
		  radio1.setRolloverIcon(icon2);
		  radio1.setPressedIcon(icon3);
		radio2 = new JRadioButton("라디오2");
		  radio2.setToolTipText("라디오2 영역에 진입~!");	//풍선 도움말
		  
		radio3 = new JRadioButton("라디오3");
		
		ButtonGroup group = new ButtonGroup();	//그룹 묶어주기
		group.add(radio1);
		group.add(radio2);
		group.add(radio3);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		  panel.add(radio1);
		  panel.add(radio2);
		  panel.add(radio3);
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED),"라디오그룹"));
		
		setTitle("라디오버튼테스트");
		add(panel);
		
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JRadioButtonTest();
	}

}
