package com.encore.myapp;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.encore.domain.PersonVO;
import com.encore.domain.ProductVO;

@Controller //나 컨트롤러!! --> servlet-context.xml 등록
@RequestMapping("you") //http://localhost/Spring/you
					   //                        ---
public class YouController {
	
	@RequestMapping("0822/hello") //가상 경로! 단순 JSP포워딩 --> view resolver로 전달
	public void hello() { //return이 없는 경우(void) 가상 경로 == 호출페이지 
		
	}// http://localhost/Spring/0822/hello
	
	/*
		prefix ==> "/WEB-INF/views/"
	             		+ "0822/hello"
		suffix ==>    +  ".jsp" 
			="/WEB-INF/view/0822/hello.jsp
	*/
	
	@RequestMapping("hello") // ("gildong") --> 이미 등록되어있는 경로이기 때문에 충돌 에러 ---> 컨트롤러에 @RequestMapping달아서 해결
	public String hello2() {
		return "0822/hello";
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping("form") //요청URL : /Spring/you/name_input
	public String hello3() {
		return "0822/name_input"; //JSP찾기 --> WEB-INF/views/ + 리턴문자열 + .jsp
	}
	
	@RequestMapping("result") //요청URL : /Spring/you/result
	public void result(HttpServletRequest request) {
		System.out.println("입력된 이름 : " + request.getParameter("username"));
		request.getParameter("username");
	}//리턴 생략 시 : /WEB-INF/views/you/result.jsp
	
	@RequestMapping("result2") //요청URL : /Spring/you/result2
	public String result2(String username, HttpServletRequest req) {
		System.out.println("입력된 이름2 : " + username);
		req.setAttribute("un", username);
		return "0822/result";
	}//  /WEB-INF/views/0822/result.jsp
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping("/personForm") //URL매핑 : Spring/you/personForm
	public String person_form() {
		return "0822/person_input";//(forward)이동할 페이지에 설정
	}//WEB-INF/views/ 	[0822/person_input]		.jsp
	
	@RequestMapping("/result3") //URL매핑 : Spring/you/result3
	//public String result3(String name, int age, String job) {
	public String result3(PersonVO vo, Model model) {
		/*
			PersonVO vo = new PersonVO();
			vo.setName(req.getParameter("name"));
			vo.setName(req.getParameter("age"));
			vo.setName(req.getParameter("job"));
		*/
		System.out.println("vo >>>" + vo);
		
		//model.addAttribute(attributeName, attributeValue)
		model.addAttribute("person", vo);

		return "0822/result3";//(forward)이동할 페이지에 설정
	}//WEB-INF/views/	 [0822/person_input]	.jsp
	
	//////////////////////////////////////////////////////////////////////////////
	
	/*
		문제) 웹브라우저에서 /Spring/you/product URL요청시
		
			- YouController의 product메소드가 실행되고 메소드내에서 임의의 상품 등록
			- 이동 페이지는 /WEB-INF/views/0822/productDerail.jsp
			- JSP페이지에서 상품정보출력
		
	 */
	@RequestMapping("/product")
	public String product(Model m) {
		//ProductVO vo = new ProductVO("김밥", 25000);
		
		//model.addAttribute("product", vo);
		//만약 키값을 생략해서 데이터를 영역에 저장한다면 ==> 기본키값 : 클래스명이 설정(첫글자 소문자)
		
		//model.addAttribute(vo);
		//model.addAttribute("ProductVO", vo);
		
		m.addAttribute(new ProductVO("김밥", 30000));
		
		return "0822/productDetail";
	}
	
	@RequestMapping("/product2")
	public String product2(Model m, RedirectAttributes attr) { //URL요청 정의 /Spring/you/product2
		ProductVO vo = new ProductVO("꿀상품", 30000);
		//m.addAttribute("vo",vo);
		attr.addFlashAttribute("vo",vo);
		
		/*
		 	해결법1)
		 		String product2(HttpSession session)
		 			---> session.setAttribute("vo",vo);
		 			'
		 	해결법2)
		 		RedirectAttributes사용
		 			---> 리다이렉트 이동 시 request공유할 데이터(일회성 데이터)를 표현
		*/
		
		//return "redirect:/WEB-INF/views/0822/productDetail.jsp";
		return "redirect:/you/lime";
	}
	
	@RequestMapping("/lime") //URL요청 정의 --> /Spring/you/lime
	public String productDetail() {
		return "0822/productDetail";
	}
}




