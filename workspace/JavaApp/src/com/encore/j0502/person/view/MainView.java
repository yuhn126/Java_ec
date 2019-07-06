package com.encore.j0502.person.view;

import java.awt.BorderLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.encore.j0502.person.model.Person;

public class MainView extends JFrame implements Runnable {
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
		
		//displayTime();
		Thread t = new Thread(this);
		t.start();//스케줄러 호출
		
		setLayout(new BorderLayout());
		add("North", cur_time);
		add("Center",scroll);
		add("South",bt_pn);
		
		setTitle("MainView");
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}//생성자
	
	
	//public void displayTime() {
	public void run() {	
		//동시 실행 할 문장들!
		try {
			while(true){
				//Thread.sleep(long millis);
				Thread.sleep(1000);//1초
				//System.out.println("시간구하기");
				Calendar cal = Calendar.getInstance();	//cal변수에는 현재 날짜관련된 모든 정보가 저장
					//cal.get(int field);
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH);//API문서 ---> 1월 ~ 12월 : 0 ~ 11
				int date = cal.get(Calendar.DATE);
				int hour = cal.get(Calendar.HOUR);
				int minute = cal.get(Calendar.MINUTE);
				int second = cal.get(Calendar.SECOND);
				time.setText(year + "년 " + (month+1) + "월 " + date + "일 " + hour + "시 " + minute + "분 " + second + "초");
			}
		}catch(Exception e) {
			System.out.println("오류");
		}
		
	}
	
	
	
	//MainView - JTable이 원하는 타입 1 : object []rowData = {1,"나길동",13,"학생"};
	
	//Controller를 통해 전달받은 데이터 타입
	//  - Vector<Person> personv = new Vector<>();
	// personv.get(0) ---> p1 (Person p1 = new Person(1, "홍길동", 13, "학생");)
	// personv.get(1) ---> p2 (Person p1 = new Person(2, "길라임", 15, "학생");)

	
	
	//벡터 안에 저장된 Peryson정보를 JTable에 출력하는 기능.
	public void displayTable(Vector<Person> personv) {	
		dtm.setRowCount(0);//새로 addRow되는 행 데이터를 0 인덱스부터 출력하겠음.
						   //이전에 JTable에 출력된 내용을 clear하는 역할!
		for(int i = 0; i < personv.size(); i++) {//벡터의 인덱스 수 == 사람의 수
			Person p = personv.get(i);
			Object []data = {p.getNo(), p.getName(), p.getAge(), p.getJob()};
			dtm.addRow(data);
		}
	}
	
}
