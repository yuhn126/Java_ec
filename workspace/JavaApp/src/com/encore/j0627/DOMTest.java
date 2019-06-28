package com.encore.j0627;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class DOMTest {
	DocumentBuilderFactory factory; //공장
	DocumentBuilder bulider;
	
	//----------------------- DOM표준, DOM프로그램 시작 -----------------------
	Document doc; //문서(메모리)객체
	//DOM (Document Object Model)
	//	   -------- -------------
	//		text ----> 메모리 데이터로 변환해서 프로그래밍!
	//			DOM파서
	
	public DOMTest() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			bulider = factory.newDocumentBuilder();
			//bulider : DOM파서 (일꾼객체)
			
			//재료(XML문사)전달
			//doc = bulider.parse(String uri);
			doc = bulider.parse("xml/0627/test.xml");
			//text XML분석 ---> 메모리 로딩
			System.out.println("DOM파싱 성공");
			
			//----------------DOM Programming시작----------------
			
			//문서상의 루트엘리먼트 얻어오기
			//Document doc: 1.위치(rootElement바로위)   2.생성(create~)
			Element root = doc.getDocumentElement(); //문서를 대표하는 엘리먼트: 루트엘리먼트
			System.out.println("루트 엘리먼트명: "+ root.getTagName());
			
			
			Node n = root.getFirstChild(); //root: <person>
			
			//누구? 어떤요소?  (1~12)
			System.out.println("노드타입(1~12)=" + n.getNodeType());
			System.out.println("엘리먼트 매핑 숫자="+Node.ELEMENT_NODE);
			System.out.println("텍스트 매핑 숫자="+Node.TEXT_NODE);
			System.out.println("주석 매핑 숫자="+Node.COMMENT_NODE);
			
			System.out.println("노드이름="+ n.getNodeName());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	public static void main(String[] args) {
		new DOMTest();

	}

}
