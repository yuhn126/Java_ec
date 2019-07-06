package com.encore.j0701;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest2 extends DefaultHandler { // i
	// SAX : 이벤트 기반의 파서
	// SAXParserException <== XML문서에 관련된 에러 (Well-formed하지 못한 문서)
	// (valid하지 못한 문서)
	//

	SAXParserFactory factory;
	SAXParser parser;
	
	//상태변수
	boolean titleState; //false
	boolean authorState; //false
	
	//임시변수
	String titleStr;
	String searchAuthor;
	
	
	public SAXTest2() {
		try {
			factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();

			searchAuthor = "김주원";	
			
			// parser.parse("SAX파싱하고자하는 XML문서 URL");
			// parser.parse(String uri, DefaultHandler dh);
			parser.parse("xml/0627/books.xml", this); //this : 핸들러 메소드(콜백메소드)의 위치
													  //SAX파싱! 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// 생성자
	
	@Override
	public void startDocument() throws SAXException {
		//XML문서를 읽었을때(파싱했을때) 단 한번 호출
		System.out.println("#도서목록 (저자:" + searchAuthor + ")");
	}
	
	
	/*
		미션 : books.xml을 SAX parsing하여 모든 책 제목을 화면에 출력하시오.
		
		결과화면)
			#도서목록
				JavaProgramming
				OracleSQL
				JavaScript
				XMLBible
				
		미션2 : books
	*/
	
	
	

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("title")) {	//<title>시작 태그를 만났을 때
			titleState = true;
		}
		if(qName.equals("author")) { //<author>시작 태그를 만났을 때
			authorState = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("title")) {	//<title>끝 태그를 만났을 때
			titleState = false;
		}
		if(qName.equals("author")) {	//<title>끝 태그를 만났을 때
			authorState = false;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String str = new String(ch,start,length);
		//if(Content의 내용이 title과 관련되었다면) {
		if(titleState) {
			titleStr = str;
		}
		
		if(authorState && str.equals(searchAuthor)) { //저자의 이름을 읽었을때
			//str == author
			System.out.println(titleStr);
		}
	}

	public static void main(String[] args) {
		new SAXTest2();
	}
}
