package com.encore.j0502.person.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import com.encore.j0502.person.model.DataStore;
import com.encore.j0502.person.model.Model2;
import com.encore.j0502.person.model.Person;
import com.encore.j0502.person.view.InputForm;
import com.encore.j0502.person.view.MainView;
import com.encore.j0502.person.view.UpForm;

public class Controller2 implements ActionListener{
	//ActionListener상속한 이유? 뷰 내의 버튼의 눌림(액션)을 체크하기 위해서! 
	
	//전체 뷰 등록
	MainView mainView;
	InputForm inForm;
	UpForm upForm;
	
	DataStore store;
	
	public Controller2() {
		store = new DataStore();
		mainView = new MainView();
		inForm = new InputForm();
		upForm = new UpForm();
		
		eventUp();
	}//생성자
	
	private void eventUp() {//이벤트 소스 등록
		//MainView이벤트 소스
		mainView.bt_inp.addActionListener(this);
		mainView.bt_upd.addActionListener(this);
		mainView.bt_del.addActionListener(this);
		mainView.bt_ex.addActionListener(this);
		
		//InputForm이벤트 소스
		inForm.bt_submit.addActionListener(this);
		inForm.bt_cancel.addActionListener(this);
		inForm.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				inForm.setVisible(false);
				mainView.setVisible(true);				
			}
		});
		
		//UpForm이벤트 소스
		upForm.bt_submit.addActionListener(this);
		upForm.bt_cancel.addActionListener(this);
		upForm.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				upForm.setVisible(false);
				mainView.setVisible(true);
			}
		});
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//기능 정의 메소드 : 이벤트 핸들러
		Object ob = e.getSource();
		
		if(ob == mainView.bt_inp) {
			mainView.setVisible(false);
			inForm.setVisible(true);
			
		}else if(ob == inForm.bt_submit) {
			Person p = new Person(0,inForm.tf_name.getText(),
					Integer.parseInt(inForm.tf_age.getText()),inForm.tf_job.getText());
			Model2 m2 = new Model2(store);
			m2.insert(p);
			
			mainView.displayTable(m2.selectAll());
			inForm.init();
			
			inForm.setVisible(false);
			mainView.setVisible(true);
			
		}else if(ob == mainView.bt_upd) { //메인뷰 : 수정버튼
			int row = mainView.table.getSelectedRow();
			Object data = mainView.table.getValueAt(row, 0); 
			
			//Object data = new Integer(5);
			
			//Integer.parseInt("숫자로 구성된 문자열");
			int no = Integer.parseInt(data.toString());//수정할 번호 얻기
			//int no = (Integer)data;
			
			/*
				int su = 300;
				Integer su2 = new Integer(300);
				int su3 = new Integer(500);
				Integer su4 = 500;
			*/
			
			Model2 m2 = new Model2(store);
			Person p = m2.select(no);
			
			upForm.upNo = p.getNo();
			upForm.tf_name.setText(p.getName());
			upForm.tf_age.setText(p.getAge() + "");
			upForm.tf_job.setText(p.getJob());
			
			mainView.setVisible(false);
			upForm.setVisible(true);
			
		}else if(ob == upForm.bt_submit) {
			Person newp = new Person(upForm.upNo, null,
					Integer.parseInt(upForm.tf_age.getText()),
					upForm.tf_job.getText());
			
			Model2 m2 = new Model2(store);
			m2.update(newp);
			
			//벡터의 변경된 내용을 JTable에 반영
			mainView.displayTable(m2.selectAll());
			upForm.setVisible(false);
			mainView.setVisible(true);
			
		}else if(ob == mainView.bt_del) {//메인뷰 : 삭제 버튼
			String noStr = JOptionPane.showInputDialog(mainView,"삭제할 번호 : ");
			
			int state = JOptionPane.showConfirmDialog(mainView, "렬루?");
			//state = 0 : '예'클릭
			
			if(state == 0) {
				Model2 m2 = new Model2(store);
				m2.delete(Integer.parseInt(noStr));
				
				//벡터의 변경된 내용을 JTable에 반영
				mainView.displayTable(m2.selectAll());
			}
			
		}else if(ob == mainView.bt_ex) {//메인뷰 : 종료 버튼
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new Controller2();
	}
}
