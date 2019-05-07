package com.encore.j0507;

import java.io.Serializable;

public class Person implements Serializable{//객체 직렬화를 하겠음~!
	String name = "나길동";
	int age = 13;
	transient String job = "학생";
	//transient : 직렬화 대상에서 제외 ---> 데이터값을 전달하지x(기본값이 넘어감)
}

//Person객체를 파일에 쓸 수 있습니까? ===> ObjectOutputStream 사용!