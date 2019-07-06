package com.encore.j0612.control;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Map;

import com.encore.j0612.model.dao.MembershipDAO2;
import com.encore.j0612.model.vo.MembershipVO;
import com.encore.j0612.view.JoinForm;
import com.encore.j0612.view.LoginForm;
import com.encore.j0612.view.ServiceForm;
import com.encore.j0612.view.UpdateForm;

public class Controller implements ActionListener {
	LoginForm loginForm;
	JoinForm joinForm;
	UpdateForm updateForm;
	ServiceForm serviceForm;

	public Controller() {
		loginForm = new LoginForm();
		joinForm = new JoinForm();
		updateForm = new UpdateForm();
		serviceForm = new ServiceForm();
		eventUp();
	}// 생성자

	private void eventUp() {
		//로그인폼
		loginForm.bt_login.addActionListener(this);
		loginForm.bt_join.addActionListener(this);
		loginForm.tf_pass.addActionListener(this);

		//회원가입 폼
		joinForm.bt_submit.addActionListener(this);
		joinForm.bt_reset.addActionListener(this);
		joinForm.tf_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				MembershipDAO2 dao = new MembershipDAO2();
				int i = dao.findExistId(joinForm.tf_id.getText());
				if (i == 0) {
					joinForm.la_checkid.setText("사용 가능 ID");
					joinForm.la_checkid.setForeground(Color.blue);
					joinForm.bt_submit.setEnabled(true);
				} else {
					joinForm.la_checkid.setText("사용 불가 ID");
					joinForm.la_checkid.setForeground(Color.red);
					joinForm.bt_submit.setEnabled(false);
				}
			}
		});
		
		joinForm.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				joinForm.setVisible(false);
				loginForm.setVisible(true);
			}
		});
		
		//서비스 폼
		serviceForm.bt_sel_all.addActionListener(this);
		serviceForm.bt_up.addActionListener(this);
		serviceForm.bt_del.addActionListener(this);
		serviceForm.bt_sel_name.addActionListener(this);
		serviceForm.bt_exit.addActionListener(this);
		serviceForm.item_confirm.addActionListener(this);
		serviceForm.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				serviceForm.setVisible(false);
				loginForm.setVisible(true);
			}
		});
		
		//회원수정 폼
		updateForm.bt_submit.addActionListener(this);
		updateForm.bt_reset.addActionListener(this);
		updateForm.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				updateForm.setVisible(false);
				serviceForm.setVisible(true);
			}
		});
	}// eventUp

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();// 이벤트 발생시킨 컴포넌트의 주소

		if (ob == loginForm.bt_login || ob == loginForm.tf_pass) {
			// 1. 로그인폼: 로그인버튼 클릭 ==> DB로그인조회 , 서비스폼으로 이동
			// 2. UI입력 데이터 얻기
			String id = loginForm.tf_id.getText();
			String pass = new String(loginForm.tf_pass.getPassword());
			// --------------------------------
			// char []
			/*
			 * str.toCharArray() str.getBytes() <--------------- ------------> char []ch
			 * String str="abc" byte []b {'a','b','c'} {97,98,99} ------------->
			 * <------------ String s1 =new String(ch); String s2 = new String(b); ---- ---
			 * "abc" "abc"
			 * 
			 */

			// 3. 모델호출
			MembershipDAO2 dao = new MembershipDAO2();
			if (dao.findLogin(id, pass)) {
				loginForm.showMsg("로그인 성공^O^*");
				loginForm.initText();
				serviceForm.loginID = id;
				System.out.println(serviceForm.loginID);
				serviceForm.displayTable(dao.findAll()); //테이블 바로 나옴!
				loginForm.setVisible(false);
				serviceForm.setVisible(true);
			} else {
				// loginForm.showMsg("로그인실패T.T*");
				loginForm.showMsg("아이디 또는 비밀번호가 일치하지 않습니다!!");
			}
			

//		     String result = dao.findLogin(id, pass);
//		     if(result.equals("success")) {
//		    	 loginForm.showMsg("로그인성공^O^*");
//		     }else if(result.equals("fail_id")) {
//		    	 loginForm.showMsg("아이디가 존재하지 않습니다!!");
//		    	 //confirm("회원가입하시겠습니까?");
//		     }else if(result.equals("fail_pass")) {
//		    	 loginForm.showMsg("비밀번호가 일치하지 않습니다!!");
//		     }

			// 4. 서비스폼 이동
			
		} else if (ob == joinForm.bt_submit) {
			// 컬럼 : id, pass, name, ssn1, ssn2, phone, addr, job
			String id = joinForm.tf_id.getText();
			String pass = new String(joinForm.tf_pass.getPassword());
			String name = joinForm.tf_name.getText();
			String ssn1 = joinForm.tf_ssn1.getText();
			String ssn2 = new String(joinForm.tf_ssn2.getPassword());
			String phone = joinForm.tf_phone1.getText() + "-" + joinForm.tf_phone2.getText() + "-" + joinForm.tf_phone3.getText();
			String addr = joinForm.tf_addr.getText();
			String job = joinForm.cb_job.getSelectedItem().toString();

			MembershipVO vo = new MembershipVO(id, pass, name, Integer.parseInt(ssn1), Integer.parseInt(ssn2), phone,
					addr, job);

			MembershipDAO2 dao = new MembershipDAO2();
			
			// ★
			if (dao.create(vo)) { // DB입력이 성공했다면(회원가입성공)
				joinForm.showMsg("회원가입성공!");
				joinForm.setVisible(false);
				loginForm.setVisible(true);
				joinForm.initText();
			} else {
				joinForm.showMsg("입력값을 확인하세요!");
			}
		} else if (ob == loginForm.bt_join) { //로그인폼 : 신규가입 버튼 클릭 시
			loginForm.setVisible(false);
			joinForm.setVisible(true);
		} else if (ob == serviceForm.bt_sel_all) {
			MembershipDAO2 dao = new MembershipDAO2();
			serviceForm.displayTable(dao.findAll());
		} else if (ob == serviceForm.bt_up) {
			String id;
			if (serviceForm.loginID.equals("admin") && serviceForm.authState) {
				id = serviceForm.showInput("수정할 아이디 : ");//관리자 인증 				
			} else if(serviceForm.loginID.equals("admin") && !serviceForm.authState) {
				serviceForm.showMsg("인증 후 사용 가능 합니다.");
				return;
			} else {
				id = serviceForm.loginID;
			}
			//----------------------------------------------
			MembershipDAO2 dao = new MembershipDAO2();
			MembershipVO vo = dao.findById(id);
			//----------------------------------------------
			if(vo == null) {
				serviceForm.showMsg("일치하는 아이디가 없습니다.");
				return;
			}
			//수정폼에 조회 결과(vo)를 출력!
			updateForm.initText(vo);
			
			//이동 : 서비스폼 ---> 회원정보 수정폼
			serviceForm.setVisible(false);
			updateForm.setVisible(true);
		} else if (ob == updateForm.bt_submit) {
			//수정할 정보(데이터) 수집
			String phone = updateForm.tf_phone1.getText() + "-" +  updateForm.tf_phone2.getText() + "-" + updateForm.tf_phone3.getText();
			
			//수집된 정보를 한 개의 변수명(vo)으로 정의
			MembershipVO vo = new MembershipVO();
			vo.setId(updateForm.tf_id.getText());
			vo.setPass(new String(updateForm.tf_pass.getPassword()));
			vo.setPhone(phone);
			vo.setAddr(updateForm.tf_addr.getText());
			vo.setJob(updateForm.cb_job.getSelectedItem().toString());
			//-------------------------------------------------------------
			MembershipDAO2 dao = new MembershipDAO2();
			if(dao.modify(vo)) {
				serviceForm.displayTable(dao.findAll());
				updateForm.setVisible(false);
				serviceForm.setVisible(true);
			} else {
				updateForm.showMsg("입력된 데이터를 확인하세요" );
			}
			//-------------------------------------------------------------
			//DAO실행 결과를 반영(뷰 이동, 뷰의 내용을 변경)
			
		} else if(ob == serviceForm.bt_del) { //서비스폼 : 삭제 버튼 클릭 시
			String id;
			if (serviceForm.loginID.equals("admin") && serviceForm.authState) {
				id = serviceForm.showInput("삭제할 아이디 : ");//관리자 인증 				
			} else if(serviceForm.loginID.equals("admin") && !serviceForm.authState) {
				serviceForm.showMsg("인증 후 사용 가능 합니다.");
				return;
			} else {
				id = serviceForm.loginID;
			}
			
			
			MembershipDAO2 dao = new MembershipDAO2();
			if(serviceForm.showConfirm("정말 삭제하시겠습니까?") == 0) {
				if(dao.remove(id)) {
					serviceForm.showMsg("삭제 성공");
					serviceForm.displayTable(dao.findAll());
				} else {
					serviceForm.showMsg("입력한 아이디를 확인하세요");
				}
			}
		} else if (ob == serviceForm.bt_sel_name) { //서비스폼 : 이름 검색 클릭 시
			//서비스폼: '이름검색' 버튼 클릭시   ----> '검색' 버튼 클릭시
			//String name = serviceForm.showInput("조회할 이름:");
			Map<String,String> map = serviceForm.showOption();
			//-----------------------------------------------
			MembershipDAO2 dao = new MembershipDAO2();
			// ArrayList<MembershipVO> list = dao.findByName(name);
			ArrayList<MembershipVO> list = dao.findSearch(map);
			//-----------------------------------------------
			//조회된 결과를 뷰(JTable)에 반영
			serviceForm.displayTable(list); 
		} else if (ob == serviceForm.bt_exit) {
			System.exit(0);
		} else if (ob == joinForm.bt_reset) {
			joinForm.initText();
		} else if(ob == updateForm.bt_reset) {
			MembershipDAO2 dao = new MembershipDAO2();
			MembershipVO vo = dao.findById(serviceForm.loginID);
			updateForm.initText(vo);
		} else if(ob == serviceForm.item_confirm) {
			MembershipDAO2 dao = new MembershipDAO2();
			System.out.println(serviceForm.loginID);
			if(serviceForm.loginID.equals("admin")) {
				serviceForm.showMsg("인증되었습니다.");
				serviceForm.authState = true;
			} else {
				serviceForm.authState = false;
				int i = serviceForm.showConfirm("관리자 로그인이 필요합니다\n" + "관리자로 로그인하시겠습니까?");
				if (i == 0) {
					serviceForm.setVisible(false);
					loginForm.setVisible(true);
				}
			}
		}

	}// actionPerformed

	public static void main(String[] args) {
		new Controller();
	}

}//49
