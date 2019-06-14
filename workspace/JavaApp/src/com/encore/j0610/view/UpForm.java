package com.encore.j0610.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpForm extends JFrame {
	public JTextField tf_name, tf_age, tf_job;
	public JButton bt_submit, bt_cancel;
	JLabel lb_name, lb_age, lb_job;
	JPanel namep, agep, jobp, btp;
	
	public int upNo;

	public UpForm() {
		setTitle("수정폼");
		tf_name = new JTextField(10);
		tf_name.setEditable(false);
		tf_age = new JTextField(10);
		tf_job = new JTextField(10);

		lb_name = new JLabel("이름");
		lb_age = new JLabel("나이");
		lb_job = new JLabel("직업");
		
		namep = new JPanel();
		  namep.setLayout(new FlowLayout());
		  namep.add(lb_name);
		  namep.add(tf_name);
		agep = new JPanel();
		  agep.setLayout(new FlowLayout());
		  agep.add(lb_age);
		  agep.add(tf_age);
		jobp = new JPanel();
		  jobp.setLayout(new FlowLayout());
		  jobp.add(lb_job);
		  jobp.add(tf_job);

		bt_submit = new JButton("수정");
		bt_cancel = new JButton("취소");
		btp = new JPanel();
		  btp.setLayout(new FlowLayout());
		  btp.add(bt_submit);
		  btp.add(bt_cancel);

		setLayout(new GridLayout(6,1,10,10));
		setSize(250,300);
		add(new JLabel());
		add(namep);
		add(agep);
		add(jobp);
		add(btp);
		//setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
