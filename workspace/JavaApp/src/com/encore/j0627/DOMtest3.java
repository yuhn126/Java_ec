package com.encore.j0627;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMtest3 {
	//Java프로그램에서 DOM파싱을 위해 DocumentBulider, DocumentBuliderFactory지원
	DocumentBuilderFactory factory;
	DocumentBuilder bulider; //DOM파서
	
	//--------------- DOM표준, DOM프로그램 시작 ---------------
	Document doc;
	
	//미션) DOMTest2 (XML문서를 읽어서 화면 출력!)
	//---> DOMTest3 (XML문서를 읽어서 파일 출력!) ---> 파일명 : books2.xml
	//				 ------       -------
	//				books.xml    books2.xml
	//---> XML파일 복사!
	//---> 추가되는 클래스 : FileWriter클래스
	//---> 1. 파일출력객체 생성  2. 콘솔화면출력을 파일출력으로 변환 
	FileWriter out;
	
	public DOMtest3() {
		try{
			out = new FileWriter("xml/0627/books2.xml");
			
			factory = DocumentBuilderFactory.newInstance();
			
			bulider = factory.newDocumentBuilder();
			
			doc = bulider.parse("xml/0627/books.xml"); //파싱기능 메소드 : text ---> 구성요소를 메모리 적재
			//doc : 메모리 doc / 메모리상의 문서구조를 의미!
			
			//-----------DOM programming시작(메모리 사용, 메모리 읽기, 메모리 조작)-----------
			
			//미션 : 전체 문서(books.xml) 여행하기  ==> 재귀호출사용
			Element root = doc.getDocumentElement(); //루트 엘리먼트 구하기
			documentTravel(root);
			
			System.out.println("메모리 XML을 파일복사 성공!");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(out != null)out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}//생성자
	
	public void documentTravel(Node n) throws IOException {
		//매개변수 Node n : Element, Test, Comment, Document, ...
		
		//노드 구분 (1 ~ 12)	1 : Element		3 : Text	8 : Comment
		
		switch(n.getNodeType()) {//노드 ---> 너 누구니? 1 ~ 12
			case Node.ELEMENT_NODE : { //1 :
				NodeList list = n.getChildNodes();//자식노드구하기(Element)
				//NodeList : 속성을 제외한 XML문서 구성요소들을 저장
				// ---> getLength(), item(index) 여행하기!
				
				String tagName = n.getNodeName(); //태그명
				out.write("<"+tagName);
				
				//엘리먼트(태그)가 갖는 속성을 구해서 출력.
				NamedNodeMap attrs = n.getAttributes();
				for(int i = 0; i < attrs.getLength(); i++) {
					Node attr = attrs.item(i);
					String attrName = attr.getNodeName();
					String attrVal = attr.getNodeValue();
					out.write(" " + attrName + "='" + attrVal + "'");
				}
				
				out.write(">");
				
				//for문 ==> 자식요소 표현
				for(int i = 0; i < list.getLength(); i++) {
					//NodeList의 인덱스 표현
					documentTravel(list.item(i));
				}
				out.write("</"+tagName+">");
				break;
			}
			
			case Node.TEXT_NODE : { //3 :
				out.write(n.getNodeValue());
										//텍스트 내용
				break;
			}
			
			case Node.COMMENT_NODE : { //8 :
				out.write("<!-- " + n.getNodeValue() + " -->");
				break;
			}
			
			case Node.DOCUMENT_NODE:{
				
				//n: Document
				NodeList list= n.getChildNodes();//자식노드구하기 (Element)
				//list [books, <!--너주석--> ] 
				out.write("<?xml version='1.0' encoding='utf-8'?>\r\n" );
			    	
				//for문 ==> 자식요소 호출
				for(int i=0; i<list.getLength(); i++) {
					//NodeList의 인덱스 표현		 
					documentTravel(list.item(i));
				}
			}
			
		}//switch
		
		
		/*
			1. n = <books>
				자식들 list [book, book, book, book]
				
				1-0. n = <book>
					 자식들 list [title, author, price]
					 
					 1-0-0. n = <title>
					 		자식들 list ['JavaProgramming']
					 		
					 		1-0-0-0. n = #text
					 				자식들 X
					 				
					 1-0-1. n = <author>
					 		자식들 list ['홍길동']
					 		
					 		1-0-1-0. n = #text
					 				자식들 X
					 
					 1-0-2. n = <price>
					 		자식들 list ['28000']
					 		
					 		1-0-1-0. n = #text
					 				자식들 X
					 				
					 				
				1-1. n = <book>
					 자식들 list [title, author, price]
					 
					 1-1-0. n = <title>
					 		자식들 list ['OracleSQL']
					 		
					 		1-1-0-0. n = #text
					 				자식들 X
					 				
					 1-1-1. n = <author>
					 		자식들 list ['길라임']
					 		
					 		1-1-1-0. n = #text
					 				자식들 X
					 
					 1-1-2. n = <price>
					 		자식들 list ['32000']
					 		
					 		1-1-2-0. n = #text
					 				자식들 X
		*/
	
	}//documentTravel
	
	public static void main(String[] args) {
		new DOMtest3();
	}

}
