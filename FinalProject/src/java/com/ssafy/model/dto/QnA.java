package com.ssafy.model.dto;

import java.io.Serializable;

public class QnA implements Serializable {
	private int no;
	private String title;
	private String name;
	private String write_date;
	private String content;
	private String comment;
	private char done;
	public QnA() {}
	
	public QnA(int no, String title, String name, String write_date, String content, String comment, char done) {
		super();
		this.no = no;
		this.title = title;
		this.name = name;
		this.write_date = write_date;
		this.content = content;
		this.comment = comment;
		this.done = done;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public char getDone() {
		return done;
	}

	public void setDone(char done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "QnA [no=" + no + ", title=" + title + ", name=" + name + ", write_date=" + write_date + ", content="
				+ content + ", comment=" + comment + ", done=" + done + "]";
	}

}
