package com.encore.j0701;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest3 extends DefaultHandler { // implements ErrorHandler
	// SAX : 이벤트 기반의 파서
	// SAXParserException <== XML문서에 관련된 에러 (Well-formed하지 못한 문서)
	// 										   (valid하지 못한 문서)

	SAXParserFactory factory;
	SAXParser parser;
	
	public SAXTest3() {
		try {
			factory = SAXParserFactory.newInstance();
			factory.setValidating(true);
			//valid(DTD와 문서 내용)체크를 하겠다!
			
			parser = factory.newSAXParser();
			parser.parse("xml/0628/books3.xml", this); //this : 핸들러 메소드(콜백메소드)의 위치
													  //SAX파싱! 
			System.out.println("SAX파싱 성공");
		} catch (Exception e) {
			//e.printStackTrace();
		}
	}// 생성자
	
	@Override
	public void error(SAXParseException e) throws SAXException {
		//DTD 또는 XML Schema 문서를 참조하는 XML문서가 Valid하지 못했을 때(유효하지 못한 XML문서 발견 시)호출 
		System.out.println("error --> 문서내용이 DTD 또는 XMLSchema와 일치하지 않음!");
		System.out.println(e.getMessage());
	}
	
	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		//XML Spec(XML문법)에 일치하지 않는 문서. well-formed하지 못한 XML문서 발견 시
		System.out.println("fatalError --> XML문법에 어긋남!");
		System.out.println(e.getMessage());
	}
	
	public static void main(String[] args) {
		new SAXTest3();
	}
}
