package com.encore.j0612.view;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.encore.j0612.model.vo.MembershipVO;

public class ServiceForm extends JFrame {

	DefaultTableModel dtm;
	public JTable table;
	// public 명시이유? 다른 패키지에 있는 클래스(컨트롤러)에서 사용하기 때문.
	JScrollPane scroll_table;

	public JButton bt_sel_all, bt_del, bt_up, bt_sel_name, bt_exit;

	JPanel southp;
	public String loginID;
	public boolean authState = false;
	
	public JMenuItem item_confirm;
	JMenu menu_admin;
	JMenuBar bar;
	
	public ServiceForm() {
		setTitle("Display Data");
		
		item_confirm = new JMenuItem("인증");
		menu_admin = new JMenu("관리자");
		menu_admin.add(item_confirm);
		bar = new JMenuBar();
		bar.add(menu_admin);
		setJMenuBar(bar);

		Object[][] rowData = new Object[0][7];
		String[] columTitle = { "ID", "이름", "나이", "성별", "전화번호", "주소", "직업" };
		dtm = new DefaultTableModel(rowData, columTitle);

		table = new JTable(dtm);
		scroll_table = new JScrollPane(table);

		bt_sel_all = new JButton("전체보기");
		bt_up = new JButton("수정");
		bt_del = new JButton("삭제");
		bt_sel_name = new JButton("이름검색");
		bt_exit = new JButton("종료");

		southp = new JPanel();
		southp.add(bt_sel_all);
		southp.add(bt_up);
		southp.add(bt_del);
		southp.add(bt_sel_name);
		southp.add(bt_exit);

		add("Center", scroll_table);
		add("South", southp);

		setBounds(300, 200, 450, 300);
		//setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);

	}// 생성자

	public void showMsg(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}// showMsg

	public String showInput(String msg) {
		return JOptionPane.showInputDialog(this, msg);
	}// showInput

	public int showConfirm(String msg) {
		return JOptionPane.showConfirmDialog(this, msg);
	}// showConfirm

	// ArrayList안에 저장된 MembershipVO정보를 JTable에 출력하는 기능.
	// {"ID","이름","나이","성별","전화번호","주소","직업"};
	public void displayTable(ArrayList<MembershipVO> list) {

		dtm.setRowCount(0);

		for (int i = 0; i < list.size(); i++) {
			MembershipVO vo = list.get(i);
			int ssn1 = vo.getSsn1(); //950203, 070603
			int ssn2 = vo.getSsn2(); //1012345, 401234
			
			//나이구하기 ==> 현재연도 - 출생연도 + 1 --> 2019 - (1900 + 95) + 1
			int year = Calendar.getInstance().get(Calendar.YEAR);
			int mille = ssn2/1000000;
			int age;
			if(mille < 3 || mille == 5 || mille == 6) //1,2,5,6
				age = year - (1900 + ssn1/10000) + 1;
			else //3,4,7,8
				age = year - (2000 + ssn1/10000) + 1;
			
			//삼상연산자  ==> (조건식) ? A : B
			String gender = (ssn2/1000000 % 2 ==0) ? "여자" : "남자";
			
			Object[] rowData = { vo.getId(), vo.getName(),age, gender, vo.getPhone(), vo.getAddr(), vo.getJob() };
			dtm.addRow(rowData);
		}
	}// displayTable

}// ServiceForm
