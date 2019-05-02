package com.encore.j0502.calc.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.encore.j0502.calc.model.Calculator;
import com.encore.j0502.calc.view.CalcView;

/*
	★★<컨트롤러의 역할> - 전체 프로그램에 대한 흐름제어!★★
	  1. (뷰를 통해 전달된)사용자의 요청을 분석 : if(ob == bt_new)
	  2. (사용자가)입력한 데이터 얻어오기 : tf.getText();
	  3. 모델클래스 객체 생성 : Calculator c= new Calculator();
	  	 - 메소드 호출                                    c.plus(2,3);
	  	 - 리턴된 데이터를 (변수에)저장          int result = c.plus(2,3);
	  	 
	  4. 페이지 이동(화면 한 개), 이동할 페이지(프레임) 선택 :  f1.setVisible(false);
	  												f2.setVisible(true);
	 -----------------------------------선택사항!-----------------------------------
	  5. 유효성 검사(Valid Check)	===>	뷰에서 검사하기도 함!
 */

public class CalcController implements ActionListener {
	//모든 뷰 등록
	CalcView view;
	
	public CalcController() {
		view = new CalcView();
		view.bt_calc.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == view.bt_calc) {//1. 계산요청!
			String su1Str = view.tf_su1.getText();//2. 계산에 필요한 데이터 얻기
			String su2Str = view.tf_su2.getText();
			String oper = (String) view.cb_oper.getSelectedItem();
			// = String oper = view.cb_oper.getSelectedItem().toString();
			
			//5. 유효성 검사
			if(!su1Str.matches("[0-9]+") || !su1Str.matches("[\\d]+")) {
				view.la_result.setText("숫자만 입력하세요 :)");
				return;
			}else if(oper.equals("/") && su2Str.contentEquals("0")) {
				view.la_result.setText("0으로 나눌 수 없습니다 :)");
				return;
			}
			
			Calculator calc = new Calculator(Integer.parseInt(su1Str),Integer.parseInt(su2Str),oper);//3. 모델객체생성
			
			//3-1 메소드 호출
			String result = calc.getResultStr();
			//3-2 변수에 저장      //3-1 메소드 호출
			
			view.la_result.setText(result);
		}//if
		
	}
	
	public static void main(String[] args) {
		new CalcController();
	}
}
