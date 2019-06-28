package com.encore.j0628;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMTest5 {
	DocumentBuilderFactory factory;// 공장
	DocumentBuilder builder;// 일꾼
	// ----------------- DOM표준, DOM프로그램 시작 --------------
	Document doc;// 문서(메모리)객체

	public DOMTest5() {
		try {  
			  factory = DocumentBuilderFactory.newInstance();
			  factory.setIgnoringElementContentWhitespace(true); //공백무시!
			  builder = factory.newDocumentBuilder();
			  //builder: DOM파서!!
			  
			  //재료(XML문서)전달
			  //doc = builder.parse(String uri);
			  doc = builder.parse("xml/0628/books3.xml");
			  //text XML분석  ---> 메모리 로딩
			  System.out.println("DOM파싱(메모리적재) 성공~!!^^*");
			  //----------DOM Programming시작------------------
			  
			  /*
			  	미션 : books.xml을 DOM parsing하여 모든 책 제목을 화면에 출력하시오.
			  	결과화면)
			  		#도서목록
			  			JavaProgramming
			  			OracleSQL
			  			JavaScript
			  			XMLBible
			  */
			  
			  System.out.println("#도서목록");
			  NodeList titleList = doc.getElementsByTagName("title");
			  //list [<title><title><title><title>]
			  
			  //xml문서의 <title>엘리먼트 갯수만큼 반복
			  for(int i = 0; i < titleList.getLength(); i++) {
				  /*
				  Node titleNode = titleList.item(i);
				  //titleNod ==> <title>XMLBible</title>
				  titleNode.getTextContent();
				  //			XMLBible
				  */
				  System.out.println("	" + titleList.item(i).getTextContent());
				  
			  }
			  
			  /*
			  	미션2) books.xml을 DOM Parsing하여 모든 책정보를 화면에 출력.
			  	결과화면)
			  		#전체 도서정보
			  			JavaProgramming(홍길동) : 28000원
			  			OracleSQL(길라임) : 32000원
			  			JavaScript
			  			XMLBible
			  */
			  
			  System.out.println("\n#전체 도서정보");
			  NodeList authorList = doc.getElementsByTagName("author");
			  NodeList priceList = doc.getElementsByTagName("price");
			 
			  for (int i = 0; i < titleList.getLength(); i++) {
				  System.out.println("	" + titleList.item(i).getTextContent() + "(" + authorList.item(i).getTextContent() + ") : "
						  			  + priceList.item(i).getTextContent() + "원");
			  }
			  
			  /*
			  	미션3) books.xml을 DOM Parsing하여 저자 '홍길동'의 책 정보를 화면에 출력.
			  	
			  	결과화면)
			  		#도서정보(저자:홍길동)
			  			JavaProgramming[28000원]
			  			XMLBible[33000원]
			  */
			  String searchAuthor = "홍길동";
			  System.out.println("\n#도서정보(저자:"+searchAuthor+")");
			  for (int i = 0; i < titleList.getLength(); i++) {
				if(authorList.item(i).getTextContent().equals(searchAuthor)) {
					System.out.println("	" + titleList.item(i).getTextContent() + "["
										+ priceList.item(i).getTextContent()+"원]");
				}
			}
			  
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new DOMTest5();
	}
}
