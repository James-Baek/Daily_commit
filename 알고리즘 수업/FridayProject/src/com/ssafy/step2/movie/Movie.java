package com.ssafy.step2.movie;

public class Movie {
	private String title;
	private String director;
	private int grade;
	private String genre;
	private String summary;
	
	public Movie() {}
	public Movie(String title, String director, int grade, String genre) {
		this.title = title;
		this.director = director;
		this.grade = grade;
		this.genre = genre;
	}
	public Movie(String title, String director, int grade, String genre, String summary) {
		this.title = title;
		this.director = director;
		this.grade = grade;
		this.genre = genre;
		this.summary = summary;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	public String toString() {
		if(this.summary != null) {
			return "제목 : "+title+" \t감독 : "+director+" \t평점 : "+grade+" \t장르 : "+genre+" \t줄거리 : "+summary;
		}else {
			return "제목 : "+title+" \t감독 : "+director+" \t평점 : "+grade+" \t장르 : "+genre;
		}
	}
}
