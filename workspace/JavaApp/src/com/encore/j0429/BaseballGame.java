package com.encore.j0429;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BaseballGame extends JFrame implements ActionListener {
	JTextArea ta;
	JTextField tf;
	JButton bt_new, bt_clear, bt_dap, bt_exit;
	JPanel taP, buP, tfP, tP;
	JLabel lb;
	JScrollPane sc;

	public BaseballGame() {
		ta = new JTextArea();

		tf = new JTextField(20);

		lb = new JLabel("입력 : ");

		bt_new = new JButton("새 게임");
		bt_clear = new JButton("지우기");
		bt_dap = new JButton("정답");
		bt_exit = new JButton("종료");

		taP = new JPanel();
		taP.setLayout(new BorderLayout(10, 10));
		taP.add("North", new JLabel());
		taP.add("West", new JLabel());
		taP.add("East", new JLabel());
		taP.add("South", new JLabel());
		taP.add("Center", ta);

		tfP = new JPanel();
		tfP.setLayout(new FlowLayout());
		tfP.add(lb);
		tfP.add(tf);

		tP = new JPanel();
		tP.setLayout(new BorderLayout(10, 10));
		tP.add("Center", taP);
		tP.add("South", tfP);

		buP = new JPanel();
		buP.setLayout(new GridLayout(6, 1, 10, 10));
		buP.add(new Label());
		buP.add(bt_new);
		buP.add(bt_clear);
		buP.add(bt_dap);
		buP.add(bt_exit);

		setLayout(new BorderLayout(10, 10));
		add("Center", tP);
		add("East", buP);

		setSize(550, 400);
		setBackground(Color.orange);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void eventup() {
		bt_new.addActionListener(this);
		bt_clear.addActionListener(this);
		bt_clear.addActionListener(this);
		bt_exit.addActionListener(this);
	}
	
	private void RandomGame() {
		int[] com = new int[3];
		Random r = new Random();
		for (int i = 0; i < com.length; i++) {
			com[i] = r.nextInt(10);
			for (int j = 0; j < i; j++) {
				if (com[i] == com[j]) {
					i--;
				}
			}
		}
		int user = Integer.parseInt(tf.getText());
		
		int [] userv = null; 
		for(int i = 0; i < 3; i++) {
			userv[i]=user/(10^(2-i));
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == bt_new) {
			RandomGame();
		}
		
	}
	
	public static void main(String[] args) {
		new BaseballGame();
	}

}
