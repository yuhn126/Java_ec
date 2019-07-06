package com.encore.j0701;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXTest extends DefaultHandler { // i
	// SAX : 이벤트 기반의 파서
	// SAXParserException <== XML문서에 관련된 에러 (Well-formed하지 못한 문서)
	// (valid하지 못한 문서)
	//

	SAXParserFactory factory;
	SAXParser parser;

	public SAXTest() {
		try {
			factory = SAXParserFactory.newInstance();
			parser = factory.newSAXParser();

			// parser.parse("SAX파싱하고자하는 XML문서 URL");
			// parser.parse(String uri, DefaultHandler dh);
			parser.parse("xml/0701/test.xml", this); // this : 핸들러 메소드(콜백메소드)의 위치
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// 생성자

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// System.out.println("startElement");
		// qName : 태그명
//		if(attributes.getValue(0) == null) {
//			System.out.print("<" + qName + ">");
//		} else {
//			System.out.print("<" + qName + " " + attributes.getQName(0) + "=" + attributes.getValue(0)+ " "  + attributes.getQName(1) + "=" + attributes.getValue(1) + ">");
//		}
		
		System.out.print("<" + qName);
		//속성출력
		
		//attributes.getLength() //시작태그 한 개의 속한 속성의 갯수
		for (int i = 0; i < attributes.getLength(); i++) {
			System.out.print(" " + attributes.getQName(i) + "='" + attributes.getValue(i) + "'");
		}
		
		System.out.print(">");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// System.out.println("endElement");
		System.out.print("</" + qName + ">");
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		/*
			byte []b	String  <------------------  char []ch
					new String(char []ch, int offset, int length) 
		*/
		// System.out.println("characters");
		String str = new String(ch, start, length);
		System.out.print(str);
	}

	public static void main(String[] args) {
		new SAXTest();
	}
}
