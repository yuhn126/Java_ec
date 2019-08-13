package com.encore.dvdShop.model.vo;

import java.sql.Date;

public class MovieVO {
	private int movieCode;
	private String movieTitle;
	private String director;
	private String actors;
	private String ganre;
	private int filmRate;
	private Date openingDate;
	private int runningTime;
	private int stock;
	private String image;
	
	public MovieVO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getMovieCode() {
		return movieCode;
	}
	public void setMovieCode(int movieCode) {
		this.movieCode = movieCode;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getGanre() {
		return ganre;
	}
	public void setGanre(String ganre) {
		this.ganre = ganre;
	}
	public int getFilmRate() {
		return filmRate;
	}
	public void setFilmRate(int filmRate) {
		this.filmRate = filmRate;
	}
	public Date getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	public int getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public MovieVO(int movieCode, String movieTitle, String director, String actors, String ganre, int filmRate,
			Date openingDate, int runningTime, int stock, String image) {
		super();
		this.movieCode = movieCode;
		this.movieTitle = movieTitle;
		this.director = director;
		this.actors = actors;
		this.ganre = ganre;
		this.filmRate = filmRate;
		this.openingDate = openingDate;
		this.runningTime = runningTime;
		this.stock = stock;
		this.image = image;
	}
	
	
	
}
