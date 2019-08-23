package com.encore.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encore.domain.PersonVO;
import com.encore.persistence.EmpDAO;
import com.encore.s0823.Calculator;

@Controller
@RequestMapping("/0823")
public class WeController {
	
	@Autowired
	private EmpDAO dao;
	
	@RequestMapping("/hello")
	public String hello() {
		return "0823/hello";
	}
	
	
	
//	@RequestMapping("/form1")
//	public String input1() {
//		return "0823/input";
//	}
	@RequestMapping("/input")
	public void input() {} //--> 요청 URL과 응답페이지가 같은 경우 리턴을 void로 표시
	
	@RequestMapping("/result")
	public String input1(String name) {
		System.out.println("입력된 이름 : " + name);
		return "0823/input";
	}
	
	

//	@RequestMapping("/form2")
//	public String input2() {
//		return "0823/input2";
//	}
//	@RequestMapping("/result2")
//	public String input2(String name, int age, String job) {
//		System.out.println("입력된 이름 : " + name + ", 나이 : " + age + ", 직업 : " + job);
//		return "0823/input2";
//	}
	@RequestMapping("/result2")
	public String input2(PersonVO vo) {
		System.out.println("입력된 정보 : " + vo);
		return "0823/input2";
	}
	
	
	@RequestMapping("/remove")
	public @ResponseBody String remove() {
		//DB삭제요청시
		//DAO dao = new DAO();	dao.remove()
		//리턴 '삭제성공' '삭제실패'
		
		//@ResponseBody : 리턴 "문자열"이 JSP페이지가 아니라 (JSP페이지 사용 안함) 메시지 전달임! 주로 ajax요청 시 사용
		//return "success!"; //응답데이터
		return "성공!";
	}
	
	@RequestMapping("/doPerson")
	public @ResponseBody PersonVO doJSON() {
		PersonVO p = new PersonVO("나길동", 15, "직업");
		return p;
	}
	
	
	@RequestMapping(value = "good", method = RequestMethod.GET)
	public void good1() {
		System.out.println("good - GET요청");
	}
	
	@RequestMapping(value = "good", method = RequestMethod.POST)
	public void good2() {
		System.out.println("good - POST요청");
	}
	
	
///////////////////////////////////////////////////////////////////////
//	@RequestMapping("calcForm")
//	public String calcForm() {
//		return "0823/calc_form";
//	}
	
	@RequestMapping(value = "/calc", method = RequestMethod.GET)
	public String calc() {
		return "0823/calc_form";
	}
	
	@RequestMapping(value = "/calc", method = RequestMethod.POST)
	public String calc(int su1, int su2, String oper, Model m) {
		Calculator c = new Calculator(su1, su2, oper);
		m.addAttribute("c",c.getResultStr());
		return "0823/calc_form";
	}
	
	@RequestMapping("/selectEnames")
	public String selectEnames(Model m) {
		m.addAttribute("list",dao.selectEnames());
		return "/0823/emp"; //JSP페이지
	}
	
	
}
