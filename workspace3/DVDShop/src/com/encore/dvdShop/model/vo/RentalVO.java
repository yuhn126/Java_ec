package com.encore.dvdShop.model.vo;

import java.sql.Date;

public class RentalVO {
	private int rentalCode;
	private int movieCode;
	private int userCode;
	private Date rentalDate;
	private Date returnDate;
	
	public RentalVO() {
		// TODO Auto-generated constructor stub
	}
	
	public RentalVO(int rentalCode, int movieCode, int userCode, Date rentalDate, Date returnDate) {
		super();
		this.rentalCode = rentalCode;
		this.movieCode = movieCode;
		this.userCode = userCode;
		this.rentalDate = rentalDate;
		this.returnDate = returnDate;
	}

	public int getRentalCode() {
		return rentalCode;
	}

	public void setRentalCode(int rentalCode) {
		this.rentalCode = rentalCode;
	}

	public int getMovieCode() {
		return movieCode;
	}

	public void setMovieCode(int movieCode) {
		this.movieCode = movieCode;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	
	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	
	
}
