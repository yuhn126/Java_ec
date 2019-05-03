package com.encore.j0503;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogTest extends JFrame {
	
	public DialogTest() {
		setTitle("대화상자 테스트");		
		setBounds(600,400,300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//1. 메세지 대화상자
		//JOptionPane.showMessageDialog(Component parentComponent, Object message);
		JOptionPane.showMessageDialog(this, "대화상자 안녕!");
		
		//2. 입력 대화상자 - Prompt창
		//JOptionPane.showInputDialog(Component parentComponent, Object message);
		String movie = JOptionPane.showInputDialog(this, "좋아하는 영화는?");
		System.out.println("영화 제목 : " + movie);
		//확인 : 입력된 문자열 또는 빈 문자열, 취소 : null, X버튼 : null
		
		//3. 확인 대화상자
		//int JOptionPane.showConfirmDialog(parentComponent, message)
		int c = JOptionPane.showConfirmDialog(this, "정말 삭제?");
		System.out.println(c);
		//예 : 0, 아니오 : 1, 취소 : 2, X버튼 : -1
	}
	public static void main(String[] args) {
		new DialogTest();
	}
}
