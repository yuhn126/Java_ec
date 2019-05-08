package com.encore.j0508;

import java.net.InetAddress;

public class InetAddressTest {
	
	public static void main(String[] args)throws Exception {
		String host = "playdata.io";//"naver.com";
		//호스트 : 서비스를 제공하는 단말(pc)
		//naver.com : 도메인(ip주소에 적용하는 문자)
		
		InetAddress ia = InetAddress.getByName(host);
		
		String name = ia.getHostName();		//도메인명
		String addr = ia.getHostAddress();	//ip주소

		System.out.println("호스트명 : " + name);
		System.out.println("호스트주소 : " + addr);
		
		System.out.println("===========================");
		//한 도메인에 매핑된 모든 서버 ip 얻어오기
		InetAddress []ias = InetAddress.getAllByName(host);
		System.out.println("# [" + host + "]의 서버 ip");
		for (int i = 0; i < ias.length; i++) {
			System.out.println(" " + ias[i].getHostAddress());
		}
	}
}
