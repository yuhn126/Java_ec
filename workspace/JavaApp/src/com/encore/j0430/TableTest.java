package com.encore.j0430;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TableTest extends JFrame {
	JTable table;
	JScrollPane scroll_table;
	JButton bt;

	public TableTest() {
		String[] columnNames = { "이름", "나이", "사는곳", "전화번호" };
		Object[][] data = { 
				{ "길라임", 13, "일산", "010-1234-5678" }, 
				{ "김주원", 15, "서울", "010-1234-2345" },
				{ "홍길동", 17, "인천", "010-4894-1894" }
		};
		DefaultTableModel dtm = new DefaultTableModel(data,columnNames);
		table = new JTable(dtm) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scroll_table = new JScrollPane(table);
		
		System.out.println(scroll_table.getColumnHeader());
		
		add(scroll_table);
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

	}

	public static void main(String[] args) {
		new TableTest();
	}

}
