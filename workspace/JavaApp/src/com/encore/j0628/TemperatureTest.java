package com.encore.j0628;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class TemperatureTest {
	/*
		미션) 화면에 아래와 같이 출력하시오.
		
		내일 서초구 서초1동 : 15시 기온은 24.0도 입니다.
		===> 내일 최고기온 28.0도, 최저기온 22.0도 입니다.
		
		http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1165051000
		
		<hour>15</hour>			==> 시간정보(3시간 단위: 12시 15시 18시)
		<day>1</day>			==> 날짜 : 0(오늘) 1(내일) 2(모레)
		<temp>26.0</temp>		==> 특정시간의 온도
		<tmx>27.0</tmx>			==> 그 날의 최고온도
		<tmn>21.0</tmn>			==> 그 날의 최저온도
		
	*/
	
	DocumentBuilderFactory factory;
	DocumentBuilder builder;
	Document doc;
	
	public TemperatureTest() {
		try {
			factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true); //공백무시!
			builder = factory.newDocumentBuilder();
			
			//doc = builder.parse(String uri);
			doc = builder.parse("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1165051000");
			System.out.println("DOM파싱(메모리적재) 성공~!!^^*");
			
			//----------------------DOM 프로그래밍 시작(메모리의 데이터에 대한)----------------------
			NodeList catList = doc.getElementsByTagName("category");
			NodeList dayList = doc.getElementsByTagName("day");
			NodeList hourList = doc.getElementsByTagName("hour");
			NodeList tempList = doc.getElementsByTagName("temp");
			NodeList tmxList = doc.getElementsByTagName("tmx");
			NodeList tmnList = doc.getElementsByTagName("tmn");
			
			
			/*
			 * System.out.println("내일 " + catList.item(0).getTextContent()+" : " +
			 * hourList.item(7).getTextContent() + "시 기온은 " +
			 * tempList.item(7).getTextContent() + "도 입니다.\n" + "===> 내일 최고기온 " +
			 * tmxList.item(7).getTextContent()+"도, 최저기온 " +
			 * tmnList.item(7).getTextContent() + "도 입니다.");
			 */
			String searchHour = "15";
			
			for(int i = 0; i < dayList.getLength(); i++) {
				String dayStr = dayList.item(i).getTextContent();	//"0" "1" "2"
				String hourStr = hourList.item(i).getTextContent();
				if (dayStr.equals("1") &&  hourStr.equals(searchHour)) {
					System.out.println("내일 서초구 서초1동 : "+searchHour+"시 기온은 "+tempList.item(i).getTextContent()+"도 입니다.");
					System.out.println("===> 내일 최고기온 "+tmxList.item(i).getTextContent()+", 최저기온 " + tmnList.item(i).getTextContent() + "입니다.");
				}
			}
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new TemperatureTest();
	}
	
}
