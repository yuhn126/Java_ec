<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>장바구니 결과 화면</title>
	</head>
	<body>
		<h3>선택된 상품 목록</h3>
		<hr>
		<%
			HashMap<String, Integer> map = new HashMap<>();
			map.put("사과", 100);
			map.put("수박", 200);
			map.put("딸기", 300);
			map.put("바나나", 400);
			map.put("복숭아", 500);
	
			ArrayList<String> cartList = (ArrayList<String>) session.getAttribute("fruitsName");
			//(ArrayList<String>) Object;		
			int sum = 0;
			for (int i = 0; i < cartList.size(); i++) {//장바구니에 담기 과일의 수만큼
				String fruitName = cartList.get(i);
				out.print(fruitName + "<br>");
	
				sum += map.get(fruitName);
			}
			/* 
			for (int i = 0; i < cartList.size(); i++) {
				out.print(cartList.get(i) + "<br>");
				if(cartList.get(i).equals("사과")){
					price += 100;
				}else if(cartList.get(i).equals("수박")){
					price += 200;
				}else if(cartList.get(i).equals("딸기")){
					price += 300;
				}else if(cartList.get(i).equals("바나나")){
					price += 400;
				}else if(cartList.get(i).equals("복숭아")){
					price += 500;
				} 
			}//사과 : 100원, 수박 : 200원, 딸기 : 300원, 바나나 : 400원, 복숭아 : 500원
			out.print("총 합계 : " + price + "원");
			*/
		%>
		
		
		<hr>
		총 합계 :
		<%=sum%>원
		<br>
		<!-- 미션) 아래의 버튼을 클릭했을 때 selProduct.jsp페이지로 이동해서 장바구니 비우기 -->
		<input type="button" value="장바구니 비우기(결제)"
			onclick="location.href='selProduct2.jsp?action=remove'">
	</body>
</html>


<%--
      방법1)
        int sum=0;
        if(만약 사과 cartList.get(i).equals("사과"))  sum += 100;
        else if(만약 수박)                          sum += 200;
        ......
      
      방법2)
        String []fruitsName = {"사과","수박","딸기",.....};
        int    []price      = {100,   200,  300, .....};
                                            인덱스            0      1     2           ===> 인덱스 매핑
                                            
        if(fruitsName[0]와 같다면)  sum += price[0];
           fruitsName.get(0)                                   
        else if(fruitsName[1]와 같다면)  sum += price[1];
        ......
      
      방법3)
        HashMap      ----> 신발장, 사물함 클래스
        HashMap<K,V> ----> K:Key(키,변수명)     V:Value(값데이터)
  
        HashMap<String,Integer> map = new HashMap<>();
                데이터저장 ----> 풋풋하게~!!
             map.put("사과",100);
             map.put("수박",200);
  
                데이터조회  ----> 열쇠로~!!
             int price = map.get("사과");  ----> 100
             int price = map.get("수박");  ----> 200
  
   --%>
