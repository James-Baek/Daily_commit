package com.ssafy.model.dto;

import java.io.Serializable;

public class TotalList implements Serializable {
	private int no;
	private String code;
	private String id;
	private String date;
	private String list;
	private int count;
	private String name;
	private String image;
	public TotalList() {}
	public TotalList(int no, String code, String id, String date, String list, int count) {
		super();
		this.no = no;
		this.code = code;
		this.id = id;
		this.date = date;
		this.list = list;
		this.count = count;
	}
	public TotalList(String code, String id, String date, String list, int count) {
		super();
		this.code = code;
		this.id = id;
		this.date = date;
		this.list = list;
		this.count = count;
	}
	
	public TotalList(int no,String code, String id, String date, String list, int count, String name,String image) {
		super();
		this.no = no;
		this.code = code;
		this.id = id;
		this.date = date;
		this.list = list;
		this.count = count;
		this.name = name;
		this.image = image;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "TotalList [no=" + no + ", code=" + code + ", id=" + id + ", date=" + date + ", list=" + list + "]";
	}	
}
