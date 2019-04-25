package com.encore.j0424;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class EmailTest2 extends Frame {
	TextArea ta;
	TextField tf1, tf2, tf3;
	Button b1, b2;
	Label lb1, lb2;

	Panel NoP, SoP, CeP, NoUp, NoDw;

	public EmailTest2() {
		setTitle("이메일 보내기");

		ta = new TextArea("내용");
		tf1 = new TextField(25);
		tf2 = new TextField(25);
		tf3 = new TextField("제목");
		b1 = new Button("전송");
		b2 = new Button("파일 첨부");
		lb1 = new Label("보낸 사람 :");
		lb2 = new Label("받는 사람 :");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "전송 완료", "알림메세지", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		// bt2를 클릭시 파일 첨부 창열리기
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg) {

				JFileChooser chooser = new JFileChooser(); // 객체 생성
				int ret = chooser.showOpenDialog(null); // 열기창 정의

				if (ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "경로를 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
					return;
				}

				String filePath = chooser.getSelectedFile().getPath(); // 파일경로를 가져옴
				System.out.println(filePath); // 출력

				JOptionPane.showMessageDialog(null, "파일이 정상첨부되었어요!", "알림메세지", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		NoUp = new Panel();
		NoUp.add(lb1);
		NoUp.add(tf1);

		NoDw = new Panel();
		NoDw.add(lb2);
		NoDw.add(tf2);

		NoP = new Panel();
		NoP.setLayout(new BorderLayout());
		NoP.add("North", NoUp);
		NoP.add("South", NoDw);
		
		CeP = new Panel();
		CeP.setLayout(new BorderLayout());
		CeP.add("North", tf3);
		CeP.add("Center", ta);
		

		SoP = new Panel();
		SoP.add(b1);
		SoP.add(b2);

		this.setLayout(new BorderLayout());
		add("North", NoP);
		add("Center", CeP);
		add("South", SoP);

		setSize(300, 400);
		setVisible(true);

	}

	public static void main(String[] args) {

		new EmailTest2();
	}

}
