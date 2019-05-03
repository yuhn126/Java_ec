package com.encore.j0502.person.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.encore.j0502.person.model.Model;
import com.encore.j0502.person.model.Person;
import com.encore.j0502.person.view.InputForm;
import com.encore.j0502.person.view.MainView;
import com.encore.j0502.person.view.UpForm;

public class Controller implements ActionListener{
	//ActionListener상속한 이유? 뷰 내의 버튼의 눌림(액션)을 체크하기 위해서!  
	
	//전체 뷰 등록
	MainView mainView;
	InputForm inForm;
	UpForm upForm;
	
	//모델 등록(Vector<Person> 등록)
	Model m;
	
	public Controller() {
		mainView = new MainView();
		inForm = new InputForm();
		upForm = new UpForm();
		
		m = new Model();
		
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
		if (ob == mainView.bt_inp) {
			mainView.setVisible(false);
			inForm.setVisible(true);
			inForm.tf_name.setText("");
			inForm.tf_age.setText("");
			inForm.tf_job.setText("");
		}else if (ob == mainView.bt_upd) {
//			Person p1 = new Person();
//			p1.setNo(mainView.table.getSelectedRow());
//			p1.setAge(Integer.parseInt(upForm.tf_age.getText()));
//			p1.setJob(upForm.tf_job.getText());
//			m.update(p1);
			
			//////////////////////////////////////////////////////////////
			
			int row = mainView.table.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(mainView, "수정할 데이터를 선택하세요");
				return;
			}
			int no = Integer.parseInt(mainView.table.getValueAt(row, 0).toString());
			//JTable에서 선택된 행의 번호 얻기
			
			Person oldp = m.select(no); //no를 조건으로 벡터에 일치하는 Person 얻어오기
			//oldp : 벡터에 이미 저장되어있는 Person
			// --> 수정폼(TextField)에 출력
			upForm.tf_name.setText(oldp.getName());
			upForm.tf_age.setText(oldp.getAge() + "");
			upForm.tf_job.setText(oldp.getJob());
			
			//나중에 수정을 위해 UpForm멤버 upNo에 번호 저장
			upForm.upNo = oldp.getNo();
			
			mainView.setVisible(false);
			upForm.setVisible(true);
		}else if (ob == mainView.bt_del) {
			int delNo = Integer.parseInt(JOptionPane.showInputDialog(mainView, "삭제할 번호 : "));
			m.delete(delNo);
			Vector<Person> personv = m.selectAll();
			mainView.displayTable(personv);
		}else if (ob == mainView.bt_ex) {
			System.exit(0);
		}else if (ob == inForm.bt_submit) {
			String name = inForm.tf_name.getText();
			String inAge = inForm.tf_age.getText();
			if(!inAge.matches("[\\d]+")) {
				JOptionPane.showMessageDialog(mainView, "나이에 숫자만 입력하세요!");
				return;
			}
			int age = Integer.parseInt(inAge);
			String job = inForm.tf_job.getText();
			
//			if(name == null || inAge == null || job == null) {
//				JOptionPane.showMessageDialog(inForm, "모든 정보를 입력하세요.");
//				return;
//			}
			
			Person p = new Person(0, name, age, job);
			
			m.insert(p);
			
			//추가된 내용을 JTable에 반영
			Vector<Person> personv = m.selectAll();
			mainView.displayTable(personv);
			
			//메인뷰로 이동
			inForm.setVisible(false);
			mainView.setVisible(true);
			
		}else if (ob == upForm.bt_submit){
			String upAge = upForm.tf_age.getText();
			if(!upAge.matches("[\\d]+")) {
				JOptionPane.showMessageDialog(upForm, "나이에 숫자만 입력하세요!");
				return;
			}
			int age = Integer.parseInt(upAge);
			String job = upForm.tf_job.getText();
			
			Person p = new Person();
			p.setAge(age);
			p.setJob(job);
			p.setNo(upForm.upNo);
			
			m.update(p);
			
			Vector<Person> personv = m.selectAll();
			mainView.displayTable(personv);
			
			upForm.setVisible(false);
			mainView.setVisible(true);
		}else if(ob == inForm.bt_cancel) {
			inForm.tf_name.setText("");
			inForm.tf_age.setText("");
			inForm.tf_job.setText("");
		}else if(ob == upForm.bt_cancel) {
//			upForm.tf_age.setText();
//			upForm.tf_job.setText();
		}
	}

	public static void main(String[] args) {
		new Controller();
	}
}
