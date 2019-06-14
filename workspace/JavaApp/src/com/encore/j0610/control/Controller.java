package com.encore.j0610.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.encore.j0510.MainChat;
import com.encore.j0610.model.dao.PersonDAO;
import com.encore.j0610.model.dto.Person;
import com.encore.j0610.view.InputForm;
import com.encore.j0610.view.MainView;
import com.encore.j0610.view.UpForm;

public class Controller implements ActionListener {
	/*
		<컨트롤러의 역할>★ - 전체 프로그램에 대한 흐름 제어!
		1. 사용자 요청 분석(예 : 어떤 버튼을 눌렀는지)
		2. 사용자 입력 데이터 얻어오기 (예 : 입력폼 또는 수정폼을 통해 입력된 데이터)
		3.  ★모델 객체 생성 (예 : PersonDAO)
				- 메소드호출
				- 결과값(리턴값)얻기, 저장, 판단
		4. 페이지(뷰) 이동 (예 : 메인(JTable) ---> 입력폼)
	 */
	
	//뷰등록
	MainView mainView;
	InputForm form;
	UpForm upForm;
	
	public Controller() {
		mainView = new MainView();
		form = new InputForm();
		upForm = new UpForm();
		mainView.displayTable(new PersonDAO().selectAll());
		eventUp();
	}
	
	private void eventUp() {
		//메인뷰
		mainView.bt_inp.addActionListener(this);
		mainView.bt_upd.addActionListener(this);
		mainView.bt_del.addActionListener(this);
		mainView.bt_ex.addActionListener(this);
		
		//입력폼
		form.bt_submit.addActionListener(this);
		form.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				form.setVisible(false);
				mainView.setVisible(true);
			}
		});
		
		//수정폼
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
	public static void main(String[] args) {
		new Controller();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource(); //action이벤트를 발생시킨 이벤트 소스의 주소 얻기
		
		if (ob == mainView.bt_inp) {
			mainView.setVisible(false);
			form.setVisible(true);
			form.init();
		} else if(ob == form.bt_submit) { //1.입력폼 : 입력버튼 --> 분석 : DB입력 요청!
			//2. 입력 데이터 얻기
			String name = form.tf_name.getText();
			String age = form.tf_age.getText();
			String job = form.tf_job.getText();
			
			if(name.equals("") || age.equals("") || job.equals("")) {
				mainView.showMsg("빈 칸에 값을 입력하세용");
				return;
			} else if(!age.matches("[0-9]+")) {
				mainView.showMsg("나이에 숫자만 입력하세용");
				return;
			}
			
			//세 개의 변수를 p변수로 정의하기(한 개의 변수명으로 정의하기)
			Person p = new Person(0, name, Integer.parseInt(age), job);
			
			//3. 모델 객체 생성
			PersonDAO dao = new PersonDAO();
			if(dao.insert(p)) {
				ArrayList<Person> list = dao.selectAll();
				mainView.displayTable(list);
				form.setVisible(false);
				mainView.setVisible(true);
			}
		} else if(ob == mainView.bt_upd) {
			int row = mainView.table.getSelectedRow();
			if(row == -1) {
				mainView.showMsg("수정할 행을 선택!");
				return;
			}
			int no = (int) mainView.table.getValueAt(row, 0);
			PersonDAO dao = new PersonDAO();
			Person p = dao.select(no);
			upForm.upNo = no; //수정폼 멤버에 '번호'저장
			upForm.tf_name.setText(p.getName());
			upForm.tf_age.setText(p.getAge()+"");
			upForm.tf_job.setText(p.getJob());
			
			mainView.setVisible(false);
			upForm.setVisible(true);
		} else if (ob == upForm.bt_submit) {
			String upAge = upForm.tf_age.getText();
			String upJob = upForm.tf_job.getText();
			
			if(upAge.equals("") || upJob.equals("")) {
				mainView.showMsg("빈 칸에 값을 입력하세용");
				return;
			} else if(!upAge.matches("[0-9]+")) {
				mainView.showMsg("나이에 숫자만 입력하세용");
				return;
			}
			
			Person upP = new Person();
			PersonDAO dao = new PersonDAO();
			upP.setNo(upForm.upNo);
			upP.setAge(Integer.parseInt(upAge));
			upP.setJob(upJob);
			
			if(dao.update(upP)) {
				ArrayList<Person> list = dao.selectAll();
				mainView.displayTable(list);
				upForm.setVisible(false);		
				mainView.setVisible(true);
			}
			
		} else if (ob == mainView.bt_del) {
//			int delNo = Integer.parseInt(JOptionPane.showInputDialog(mainView, "삭제할 번호를 입력하세요"));
//			PersonDAO dao = new PersonDAO();
//		
//			if(dao.delete(delNo)) {
////				ArrayList<Person> list = dao.selectAll();
////				mainView.displayTable(list);
//				mainView.displayTable(dao.selectAll());
//			} else {
//				mainView.showMsg("없는 번호입니다 :(");
//			}
			
			PersonDAO dao = new PersonDAO();
			boolean b = true;
			String delNoString;
			do {
				delNoString = JOptionPane.showInputDialog(mainView, "삭제할 번호를 입력하세요");
				
				if(!delNoString.matches("[0-9]+")) {
					mainView.showMsg("숫자만 입력하세요");
				}else {
					int delNo = Integer.parseInt(delNoString);
					b = dao.delete(delNo);
					if(b) {
						ArrayList<Person> list = dao.selectAll();
						mainView.displayTable(list);
					} else {
						mainView.showMsg("없는 번호입니다 :(");
					}
				}
			}while(b);
			
		} else if (ob == mainView.bt_ex) {
			System.exit(0);
		}
		// 하나님 안녕?
		// 누가더 편지 길게쓰나 해볼까
		// 반가워
		// 오랜만이야
		// 안뇽
		// 콧큐명
		// 쿵쿵
		// 윤아언니 이해 빠르다
		// 근데 하나도 대따 똑똑함
		// 나 선생님한테 괜한 고민거리를 준것같아
		// 포커스얘길 괜히해서
		//..... 지금 찾으시는거 아니겠지
		// ㄷㄷㄷㄷ....
		// 죄송합니다..
		// 선물은 못드릴망정,,,
		// 근데 내일 뭐한다구?
		// 로그인?
		// 회원가입인데 비번이 없다고 하지 않았옹?
		// 
	}
}
