package com.encore.dvdShop.model.vo;

import java.sql.Date;

public class UserVO {
	private int userCode;
	private String userId;
	private String password;
	private String username;
	private String birth;
	private String telNum;
	private int rentalNum;
	
	public UserVO() {
		
	}
	
	public UserVO(int userCode, String userId, String password, String username, String birth, String telNum,
			int rentalNum) {
		super();
		this.userCode = userCode;
		this.userId = userId;
		this.password = password;
		this.username = username;
		this.birth = birth;
		this.telNum = telNum;
		this.rentalNum = rentalNum;
	}
	
	public int getUserCode() {
		return userCode;
	}
	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	public int getRentalNum() {
		return rentalNum;
	}
	public void setRentalNum(int rentalNum) {
		this.rentalNum = rentalNum;
	}
	
	
}
