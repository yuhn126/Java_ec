package com.encore.j0610.view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.encore.j0610.model.dto.Person;


public class MainView extends JFrame {
	public JButton bt_inp, bt_upd, bt_del, bt_ex;
	public JTable table;
	JPanel bt_pn, cur_time;
	JLabel time;
	JScrollPane scroll;
	DefaultTableModel dtm;
	
	public MainView() {
		bt_inp = new JButton("입력");
		bt_upd = new JButton("수정");
		bt_del = new JButton("삭제");
		bt_ex = new JButton("종료");
		
		time = new JLabel();
		
		bt_pn = new JPanel();
		  bt_pn.add(bt_inp);
		  bt_pn.add(bt_upd);
		  bt_pn.add(bt_del);
		  bt_pn.add(bt_ex);
		
		String []columnNames = {"번호","이름","나이","직업"};
		Object [][]data = new Object[0][4];
		//행 크기 0인 이유? 시작을(앞으로 JTable에 추가될 행을)0인덱스(첫 행)부터 하기 위해
		table = new JTable();
		dtm = new DefaultTableModel(data,columnNames);
		//dtm 생성 이유? dtm내의 addRow(), removeRow()사용하기 위해!
		table = new JTable(dtm) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scroll = new JScrollPane(table);
		//scroll 생성 이유? 1.테이블을 벗어나는 데이터를 보기 위해서(스크롤바 필요)!
		//               2.테이블의 컬럼명을 보여줄 수 있음.
		
		cur_time = new JPanel();
		cur_time.add(time);
			//자바에서 날짜 관련 클래스 : Date, Calendar
			//Calendar cal = new GregorianCalendar();
		
		
		setLayout(new BorderLayout());
		add("North", cur_time);
		add("Center",scroll);
		add("South",bt_pn);
		
		setTitle("MainView");
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}//생성자
	
	
	public void showMsg(String msg) {
	   JOptionPane.showMessageDialog(this, msg);
	}//showMsg
	
	
	
	//MainView - JTable이 원하는 타입 1 : object []rowData = {1,"나길동",13,"학생"};
	
	//Controller를 통해 전달받은 데이터 타입
	//  - Vector<Person> personv = new Vector<>();
	// personv.get(0) ---> p1 (Person p1 = new Person(1, "홍길동", 13, "학생");)
	// personv.get(1) ---> p2 (Person p1 = new Person(2, "길라임", 15, "학생");)

	
	
	//벡터 안에 저장된 Person정보를 JTable에 출력하는 기능.
	public void displayTable(ArrayList<Person> list) {	
		dtm.setRowCount(0);//새로 addRow되는 행 데이터를 0 인덱스부터 출력하겠음.
						   //이전에 JTable에 출력된 내용을 clear하는 역할!
		for(int i = 0; i < list.size(); i++) {//벡터의 인덱스 수 == 사람의 수
			Person p = list.get(i);
			Object []rowData = {p.getNo(), p.getName(), p.getAge(), p.getJob()};
			dtm.addRow(rowData);
		}
	}
	
}
