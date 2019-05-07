package com.encore.j0507;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SimpleNotePad2 extends JFrame implements ActionListener {
	JTextArea ta;
	JScrollPane scroll_ta;

	JMenuBar bar;
	JMenu menu_file;
	JMenuItem item_open;
	JMenuItem item_save;
	JMenuItem item_exit;
	JMenu menu_help;

	JFileChooser chooser;

	public SimpleNotePad2() {
		setTitle("자바 메모장");

		chooser = new JFileChooser();

		bar = new JMenuBar();
		menu_file = new JMenu("File");
		item_open = new JMenuItem("열기");
		item_save = new JMenuItem("저장");
		item_exit = new JMenuItem("종료");

		menu_help = new JMenu("Help");

		menu_file.add(item_open);
		menu_file.add(item_save);
		menu_file.addSeparator();// 구분선 추가
		menu_file.add(item_exit);

		bar.add(menu_file);
		bar.add(menu_help);

		setJMenuBar(bar);

		ta = new JTextArea();
		scroll_ta = new JScrollPane(ta);
		bar = new JMenuBar();

		add("Center", scroll_ta);

		setBounds(400, 300, 600, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		item_open.addActionListener(this);
		item_save.addActionListener(this);
		item_exit.addActionListener(this);
	}// 생성자

	// FROM(읽기 객체) : 파일		 ----> 		TO : TextArea (fileReader)
	// FileInputStream, FileReader 				ta.setText("문자열");
	// ---------------------------
	// 특징 : 읽고자 하는 파일 없을 시 에러
	
	// fis.read(); int c = fr.read();

	public void openFile() {
		int i = chooser.showOpenDialog(this);
		//if (i == 0) {
		try {
			if(i == JFileChooser.APPROVE_OPTION) {
				File f = chooser.getSelectedFile();
				
				//1.(파일에)읽기
				FileReader fr = new FileReader(chooser.getSelectedFile());
				BufferedReader br = new BufferedReader(fr);
				//BufferedReader클래스 왜 이용? ta.setText()메소드가 원하는 문자열을 얻기위해
				//br.readLine()특징  ----> 더 이상 읽을 라인이 없다면 null 리턴!
				//※read()메소드 특징   ----> 더 이상 읽을 바이트 또는 문자가 없다면 -1 리턴!
				
				//2.(GUI에)쓰기
				String fileName = f.getName();
				setTitle("자바 메모장 - [" + fileName + "]");
				ta.append("");//초기화
				String str;
				while((str = br.readLine()) != null) {//읽을 라인이 있다면
					ta.append(str + "\r\n");//한 줄 읽고 엔터(줄바꿈)
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
//			FileReader fr;
//			try {
//				fr = new FileReader(chooser.getSelectedFile());
//				int ind;
//				String str;
//				while ((ind = fr.read()) != -1) {
//					char ch = (char) ind;
//					str = Character.toString(ch);
//					ta.append(str);
////				System.out.print((char)i); //화면출력
////				fw.write(openI);//파일 복사
//				}
//				fr.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//				System.out.println("오류");
//			}
//		}
	}

	// FROM : TextArea ta ----> TO : 파일 (fileWriter)
	// FileOutputStream, FileWritwe fw
	// ㄴ>특징 : 파일 새롭게 생성!
	// String str = ta.getText() fw.write(데이터)

	public void saveFile() {
		int i = chooser.showSaveDialog(this);
		try {
			if (i == 0) {
				// if(i == JFileChooser.APPROVE_OPTION){
				// 1.데이터 얻기!
				String str = ta.getText();
				File f = chooser.getSelectedFile();// 저장 대화상자에 선택된 경로와 파일명 얻기
				System.out.println("파일경로 : " + f.getAbsolutePath());
				// FileWriter fw = new FileWriter("a.txt");
				FileWriter fw = new FileWriter(f);

				// 2. 데이터 쓰기!
				// fw .write (String str);
				// 파일에 쓰시오 무엇을
				fw.write(str);
				fw.close();

//			FileWriter fw;
//			try {
//				fw = new FileWriter(chooser.getSelectedFile());
//				fw.write(ta.getText());
//				fw.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();

		if (ob == item_open) {
			openFile();
		} else if (ob == item_save) {
			saveFile();
		} else if (ob == item_exit) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new SimpleNotePad2();
	}
}
