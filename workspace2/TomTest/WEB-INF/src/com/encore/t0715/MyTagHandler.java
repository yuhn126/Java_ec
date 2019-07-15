package com.encore.t0715;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagHandler extends TagSupport{
	//태그를 만났을때 실행할 (로직적인)코드를 기술
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();//브라우저 출력 객체
		
		try {
			for (int i = 0; i < 10; i++) {
				if (i%2==0) {
					out.print("<font color=blue>안녕, 커스텀태그~!!</font>");
				} else {
					out.print("<font color=red>안녕, 커스텀태그~!!</font>");
				}
				out.print("<br>");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
}
