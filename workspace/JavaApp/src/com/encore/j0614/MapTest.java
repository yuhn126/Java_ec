package com.encore.j0614;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.encore.j0418.Car;
import com.encore.j0502.person.model.Person;

public class MapTest {
	// Map - 지도(위도, 경도) ===> 저장 데이터(키 값, 데이터값)
	//			 x축,  y축
	/*
	
		Map<K, V>
		 - 사물함 클래스 (책 : 데이터, 열쇠 : 키)
		 - K : Key의 자료형, V : Value의 자료형
		 - Key는 보통 문자열 사용, Value(저장데이터)는 Object
		 - Key값은 중복X(유일한 값을 갖는다)
		 
		 
		★기억!!
		 - 저장 : map.put(키값, 저장 데이터);
		 - 조회 : 자료형 변수명 = map.get(키 값);
		 
	*/
	
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		//데이터 입력("홍길동", 13, "학생")
		//map.put(String key, Object value);
		map.put("name", "홍길동");
		map.put("age", 13);
		map.put("job", "학생");
		
		Map<String, String> map2 = new HashMap<>();
		//데이터 입력("홍길동","길라임","김주원","김유신","이순신")
		map2.put("k1", "홍길동");
		map2.put("k2", "길라임");
		map2.put("k3", "김주원");
		map2.put("k4", "김유신");
		map2.put("k3", "이순신"); //키 --> 중복되게 쓰면 덮어씀
		
		//전체 데이터 출력
		System.out.println("mp2.toString() : " + map2.toString());
		
		//특정 데이터 출력(k2키에 저장된 데이터를 출력!)★
		//map2.get(Object key);
		System.out.println("k2 : " + map2.get("k2"));
		
		//특정 데이터 삭제(특정 키 삭제 : k3)
		//map2.remove(Object key)
		map2.remove("k3");
		System.out.println("map2.toString() : " + map2.toString());
		
		//특정 키에 저장된 데이터 수정
		map2.replace("k4", "하유신");
		
		
		System.out.println();
		
		
		//전체 데이터 출력!!
		Collection<String> col = map2.values();
		Iterator<String> it = col.iterator();
		System.out.println("<<전체 map2데이터>>");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		System.out.println();
		
		
		//map2의 key값만 따로 얻어오기!!
		System.out.println("<<전체 map2의 키 출력>>");
		Set<String> set = map2.keySet();
		Iterator<String> keySet = set.iterator();
		while (keySet.hasNext()) {
			String key = keySet.next();
			System.out.println(key + "에 저장된 데이터 : " + map2.get(key));
		}
		
		
		System.out.println();
		
		
		//문제) Map m3;에 Person클래스(4, "길동", 13, "학생"),
		//				Car클래스 ("소나타", 4, 100)
		//				거리 데이터 (10km)를 저장하시오.
		Map<String, Object> map3 = new HashMap<>();
		map3.put("k1", new Person(4, "길동", 13, "학생"));
		map3.put("k2", new Car("소나타", 4, 100));
		map3.put("k3", "10km");
		
		Collection<Object> col3 = map3.values();
		Iterator<Object> it3 = col3.iterator();
		
		System.out.println("<<전체 map2데이터>>");
		while(it3.hasNext()) {
			System.out.println(it3.next());
		}
		
		//문제)person키에 저장된 이름과 나이를 출력
		//Object ob = m3.get("person");
		//System.out.println("이름 : " + ob.getName()); //부모 레퍼런스 ob를 통해 자식 메소드 호출 불가
		
		System.out.println();
		
		Person ob  = (Person) map3.get("k1");
	    System.out.println("이름: "+ ob.getName());
	    System.out.println("나이: "+ ob.getAge());
	} //main
}
