package com.encore.j0430;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame {
	/*
		JFrame 'Center'에 javax.swing.JTable을 add시키시오.
		그리고 아래의 데이터를 JTable에 입력(표시)하시오.(API문서 참조)
		
		<데이터>
		
		이름		나이		직업
	  -----------------------
	       홍길동	13		학생
	       길라임	15		학생
	       김주원	17		학생
	       
	    Jtable, JtextArea, JList ===> 사이즈를 벗어나는 데이터를 표현하기 위해 JScrollPane 함꼐 사용
	 */
	
	//JTable(Object[][] rowData, Object[] columnNames)
	JTable table;
	JScrollPane scroll_table;
	
	public JTableTest() {
		String []columnNames = {"이름","나이","직업"};
		Object [][]data = {{"홍길동",new Integer(13),"학생"},{"길라임",new Integer(15),"학생"},{"김주원",new Integer(17),"학생"}};
		
//		DefaultTableModel(Object[][] data, Object[] columnNames)
		DefaultTableModel dtm = new DefaultTableModel(data,columnNames);
//		DefaultTableModel 클래스 사용 이유?
//		프로그램 실행 중 '행 단위 데이터'를 추가 또는 삭제 하기 위해
		
		//table = new JTable(data, columnNames) {
		table = new JTable(dtm) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scroll_table = new JScrollPane(table);
		
		add(scroll_table);
		
		setBounds(400,300,300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//문제 2) JTable내의 '길라임'을 찾아서 콘솔 화면에 출력하시오
		Object nameValue = table.getValueAt(1, 0);
		System.out.println("nameValue = " + nameValue);
		
		//문제3) JTable내의 '길라임' --> '차라임'으로 변경
		//table.setValueAt(Object aValue, int row, int column);	//aValue : 변경할 데이터
		table.setValueAt("차라임", 1, 0);
		
		//문제4) JTable내의 모든 사람의 이름을 (콘솔)화면에 출력하시오.
		System.out.println(table.getValueAt(0, 0));			
		System.out.println(table.getValueAt(1, 0));			
		System.out.println(table.getValueAt(2, 0));			
		//System.out.println(table.getValueAt(3, 0));		IndexOutOfBounds에러	
		System.out.println("==============");
		for (int i = 0; i < table.getRowCount(); i++) {
			System.out.println(table.getValueAt(i, 0));			
		}
		
		//문제5)행 추가 ---> ["김유신",13,"화랑"]
		//table.setValueAt("김유신", 3, 0); 에러
		Object [] newRow = {"김유신",13,"화랑"};
		
		dtm.addRow(newRow);
		
		Vector<Object> v = new Vector<>();
			v.add("강감찬");
			v.add(28);
			v.add("장군");
		dtm.addRow(v);
		
		//문제6)김주원 행을 삭제
		dtm.removeRow(2);
		
		
	}
	
	public static void main(String[] args) {
		new JTableTest();
	}
}
