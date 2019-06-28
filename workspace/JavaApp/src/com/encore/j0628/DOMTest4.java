package com.encore.j0628;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DOMTest4 {
	DocumentBuilderFactory factory;// 공장
	DocumentBuilder builder;// 일꾼
	// ----------------- DOM표준, DOM프로그램 시작 --------------
	Document doc;// 문서(메모리)객체

	public DOMTest4() {
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
				  미션) books3.xml을 DOM Parsing하여 첫번째 book의 title을 화면에 출력하시오.
				       ===> 결과화면: JavaProgramming
				       ===> 단, 부모          자식        형제 관계를 통해 문제를 해결하시오.
				               parent  child   sibling
				               
				 doc ---> books ---> book ---> title ---> TextNode("JavaProgramming")            
			  */ 
			  
			  
			  Element root = doc.getDocumentElement(); //루트엘리먼트 얻기
			  //System.out.println(root);
			  Node firstBook = root.getFirstChild(); //루트의 첫번째 자식노드(book)
			  Node firstTitle = firstBook.getFirstChild(); //첫번째book의 첫째자식노드(title)
			  Node textNode = firstTitle.getFirstChild(); //첫번째title의 첫째자식노드(TextNode)
			  String titleName = textNode.getNodeValue(); //textNode가 갖는 내용값 얻기
			  
			  
			  /*
				  String titleName = doc.getDocumentElement()
						  				.getFirstChild()	//공백
						  				.getNextSibling()	//<book>
						  				.getFirstChild()	//공백
						  				.getNextSibling()	//<title>
						  				.getFirstChild()	//TextValue
						  				.getNodeValue();
				  
			   */
				  System.out.println("책 제목 : " + titleName);
			  
			  
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new DOMTest4();
	}
}
