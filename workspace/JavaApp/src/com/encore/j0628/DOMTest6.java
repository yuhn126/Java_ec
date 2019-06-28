package com.encore.j0628;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class DOMTest6 {
	DocumentBuilderFactory factory;// 공장
	DocumentBuilder builder;// 일꾼
	FileWriter out;
	// ----------------- DOM표준, DOM프로그램 시작 --------------
	Document doc;// 문서(메모리)객체

	public DOMTest6() {
		try {
			out = new FileWriter("xml/0628/root.xml");
			// FileWriter와 FileOutputStream공통점 : 명시된 파일을 생성!

			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
			// builder: DOM파서!!

			doc = builder.newDocument();
			// text XML분석 ---> 메모리 로딩
			System.out.println("DOM파싱(메모리적재) 성공~!!^^*");
			// ------------------DOM Programming시작------------------

			// doc : Document객체 ---> 생성관련 메소드 (엘리먼트, 텍스트, 주석)

			Element root = doc.createElement("ROOT"); // <ROOT></ROOT>
			Element a = doc.createElement("A"); // <A></A>
			Element b = doc.createElement("B"); // <B></B>
			Element c = doc.createElement("C"); // <C></C>
			Element d = doc.createElement("D"); // <D></D>
			Element e = doc.createElement("E"); // <E></E>

			// doc.createTextNode(String data);
			Text t1 = doc.createTextNode("Hello");
			Text t2 = doc.createTextNode("GoodBye");
			Text t3 = doc.createTextNode("GoodDay");

			//1. 추가 : 부모노드.appendChild(자식노드);
			doc.appendChild(root);
			
			a.appendChild(c);//<A><C></C></A>
			c.appendChild(t1);//<A><C>Hello</C></A>
			b.appendChild(t2);//<B>GoodBye</B>
			d.appendChild(t3);//<D>GoodDay</D>
			
			root.appendChild(a);
			root.appendChild(b);
			
			//2. 추가(끼워넣기) : 부모노드.insertBefore(새로운노드, 참조노드)
			root.insertBefore(d, b);
			
			//3. 삭제: 부모노드.removeChild(삭제할 노드);
			//root.removeChild(b);
				//만약, b태그를 삭제하고 싶은데 부모를 모를 경우(부모가 바뀌는 경우)?
				b.getParentNode().removeChild(b);
			
			//4. 수정(대체) : 부모노드.replaceChild(새노드, 기존노드);
			//d태그 ----> e태그 대체!
			root.replaceChild(e, d);
			
			//5. 복제 : 복제 할 노드.cloneNode(깊이deep상태);
			//Node aClone = a.cloneNode(true); //a엘리먼트의 자식까지 복제
			Node aClone = a.cloneNode(false); //a엘리먼트만 복사
			
			root.appendChild(aClone);
			
			//6. 기타
			String data = "나&데이터3<4";
			Text newTxt = doc.createTextNode(data);
			CDATASection cdata = doc.createCDATASection(data);
			Comment comm = doc.createComment("나주석");

			//e엘리먼트에 text추가
			//e.appendChild(newTxt);
			e.appendChild(cdata);
			e.appendChild(comm);
			
			documentTravel(doc);
			System.out.println("DOM트리(메모리)를 파일로 옮기기 성공 ");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(out != null)out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void documentTravel(Node n) throws IOException {
		// 매개변수 Node n : Element, Test, Comment, Document, ...

		// 노드 구분 (1 ~ 12) 1 : Element 3 : Text 8 : Comment

		switch (n.getNodeType()) {// 노드 ---> 너 누구니? 1 ~ 12
		case Node.ELEMENT_NODE: { // 1 :
			NodeList list = n.getChildNodes();// 자식노드구하기(Element)
			// NodeList : 속성을 제외한 XML문서 구성요소들을 저장
			// ---> getLength(), item(index) 여행하기!

			String tagName = n.getNodeName(); // 태그명
			out.write("<" + tagName);

			// 엘리먼트(태그)가 갖는 속성을 구해서 출력.
			NamedNodeMap attrs = n.getAttributes();
			for (int i = 0; i < attrs.getLength(); i++) {
				Node attr = attrs.item(i);
				String attrName = attr.getNodeName();
				String attrVal = attr.getNodeValue();
				out.write(" " + attrName + "='" + attrVal + "'");
			}

			out.write(">");

			// for문 ==> 자식요소 표현
			for (int i = 0; i < list.getLength(); i++) {
				// NodeList의 인덱스 표현
				documentTravel(list.item(i));
			}
			out.write("</" + tagName + ">");
			break;
		}

		case Node.TEXT_NODE: { // 3 :
			out.write(n.getNodeValue());
			// 텍스트 내용
			break;
		}

		case Node.COMMENT_NODE: { // 8 :
			out.write("<!-- " + n.getNodeValue() + " -->");
			break;
		}
		
		case Node.CDATA_SECTION_NODE: { // 4 : 
			out.write("<![CDATA[" + n.getNodeValue() + "]]>");
			break;
		}

		case Node.DOCUMENT_NODE: {

			// n: Document
			NodeList list = n.getChildNodes();// 자식노드구하기 (Element)
			// list [books, <!--너주석--> ]
			out.write("<?xml version='1.0' encoding='utf-8'?>\r\n");

			// for문 ==> 자식요소 호출
			for (int i = 0; i < list.getLength(); i++) {
				// NodeList의 인덱스 표현
				documentTravel(list.item(i));
			}
		}

		}// switch
	}

	public static void main(String[] args) {
		new DOMTest6();
	}
}
