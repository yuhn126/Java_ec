package com.encore.j0507;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SimpleNotePad extends JFrame implements ActionListener {
	JTextArea ta;
	JScrollPane scroll_ta;
	
	JMenuBar bar;
		JMenu menu_file;
			JMenuItem item_open;
			JMenuItem item_save;
			JMenuItem item_exit;
		JMenu menu_help;
		
		JFileChooser chooser;
	
	public SimpleNotePad() {
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
		menu_file.addSeparator();//구분선 추가
		menu_file.add(item_exit);
		
		bar.add(menu_file);
		bar.add(menu_help);
		
		setJMenuBar(bar);
		
		ta = new JTextArea();
		scroll_ta = new JScrollPane(ta);
		bar = new JMenuBar();
		
		add("Center", scroll_ta);
		
		setBounds(400,300,600,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		item_open.addActionListener(this);
		item_save.addActionListener(this);
		item_exit.addActionListener(this);
	}
	
	//FROM : 파일  ----> TO : TextArea  (fileReader)
	public void openFile() {
		chooser.showOpenDialog(this);
	}
	
	//FROM : TextArea ----> TO : 파일    (fileWriter)
	public void saveFile() {
		chooser.showSaveDialog(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if(ob == item_open) {
			openFile();
		}else if(ob == item_save) {
			saveFile();
		}else if(ob == item_exit) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new SimpleNotePad();
	}
}
