package com.ssafy.model.dto;

import java.io.Serializable;

public class Codemap implements Serializable{
	private String code;
	private String name;
	private Codemap() {}
	public Codemap(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Codemap [code=" + code + ", name=" + name + "]";
	}
	
}
