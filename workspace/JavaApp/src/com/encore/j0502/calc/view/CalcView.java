package com.encore.j0502.calc.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CalcView extends JFrame {
	
	public JTextField tf_su1, tf_su2;
	public JComboBox<String> cb_oper;
	public JButton bt_calc;
	public JLabel la_result;
	
	public CalcView() {
		tf_su1 = new JTextField(5);	//너비 지정
		tf_su2 = new JTextField(5);
		
		cb_oper = new JComboBox<>();
		cb_oper.addItem("+");
		cb_oper.addItem("-");
		cb_oper.addItem("*");
		cb_oper.addItem("/");
		
		bt_calc = new JButton("계산");
		la_result = new JLabel(); 
		
		setLayout(new FlowLayout());
		setTitle("MVC계산기");
		add(tf_su1);
		add(cb_oper);
		add(tf_su2);
		add(bt_calc);
		add(la_result);
		
		setBounds(300,200,300,110);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new CalcView();
	}
	
}
