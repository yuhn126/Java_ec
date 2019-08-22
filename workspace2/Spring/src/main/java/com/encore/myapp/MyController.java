package com.encore.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // ---> extends HttpServlet, extends Action 대신
public class MyController {
	
	@RequestMapping("/doA") //---> 가상의 경로 설정(/Spring/doA요청이 들어왔다면!)
	public void doA() {
		System.out.println("doA 요청.........");
	}
	
	@RequestMapping("/gildong") //---> 1. 가상 경로(/Spring/gildong URL요청)
	public String gildong() {
		//2. getParameter
		//3. Model m = new Model();
		//4. setAttribute
		
		return "0821/hello"; //5. 페이지이동
	}
	/*
	 	[return "hello"]
	 	- servlet-context.xml
	 		<beans:property name="prefix" value="/WEB-INF/views/" />
	 		<beans:property name="suffix" value=".jsp/" />
	 		
	 	접두사 : "/WEB-INF/views/"
	 	+ "0821/hello" +
	 	접미사 : ".jsp"
	 	
	 	==>/WEB-INF/views/0821/hello.jsp --> p124 
	 	
	 		
	*/
}
