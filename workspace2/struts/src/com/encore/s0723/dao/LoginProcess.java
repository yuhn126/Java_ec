package com.encore.s0723.dao;

import java.util.HashMap;

import com.encore.s0723.vo.UserInfo;

public class LoginProcess { //DAO
	//HashMap == DataBase(데이터 저장소)
	HashMap<String, String> userPasswords;
	HashMap<String, UserInfo> userInfos;
	
	public LoginProcess() {
		userPasswords = new HashMap<>();
		userInfos = new HashMap<>();
		
		userPasswords.put("gildong","1111");
		userPasswords.put("lime","2222");
		userPasswords.put("juwon","3333");
		
		userInfos.put("gildong",new UserInfo("나길동","gildong@naver.com","010-1234-5678"));
		userInfos.put("lime",new UserInfo("차라임","lime@daum.net","010-3333-5555"));
		userInfos.put("juwon",new UserInfo("강주원","juwon@encore.com","010-5555-8989"));
	} //생성자
	
	//로그인체크
	public UserInfo login(String id, String pass) {
		String dbPass = userPasswords.get(id);
		if(dbPass == null)//아이디가 존재하지 않는다면
			return null;
		
		if(!dbPass.equals(pass))//비밀번호가 일치하지 않는다면
			return null;
		
		UserInfo user = userInfos.get(id);
		return user;
	}
}
