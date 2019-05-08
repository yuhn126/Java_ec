package com.encore.j0508;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MoveThreadTest extends JFrame implements ActionListener, Runnable {
	JButton bt, bt_stop;
	ImageIcon icon;
	JLabel lb;

	int x, y;
	
	Thread t1;
	
	boolean start = false;

	public MoveThreadTest() {
		bt = new JButton("시작");
		bt_stop = new JButton("정지");
		bt.setBounds(10, 400, 60, 40);
		bt_stop.setBounds(80,400,60,40);

		icon = new ImageIcon("image/right.gif");
		lb = new JLabel(icon);
		lb.setBounds(x, 0, 56, 56);

		
//		Thread t = new Thread() {
//			@Override
//			public void run() {
//				
//			}
//		}
		
		
		
		setLayout(null);
		add(bt);
		add(bt_stop);
		add(lb);

		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		bt.addActionListener(this);
		bt_stop.addActionListener(this);

	}

	@Override
	public void run() {
		// 화살표 라벨을 우측으로 이동(x값 증가) 또는 아래로 이동(y값 증가)
		try {
			while(true) {
				
				if(!start) break;
				
				Thread.sleep(5);
				if(x <= 425)x += 1;
				else if(y <= 395) y += 1;
				lb.setLocation(x, y);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// 스레드 호출
		Object ob = e.getSource();
		
		if(ob == bt) {
			start = true;
			t1 = new Thread(this);
			t1.start();
		}else if(ob == bt_stop) {
			start = false; //run()메소드의 while문 벗어나기
//			t1.stop();
		}
	}

	public static void main(String[] args) {
		new MoveThreadTest();
	}

}
