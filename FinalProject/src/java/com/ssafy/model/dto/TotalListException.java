package com.ssafy.model.dto;

public class TotalListException extends RuntimeException {
	public TotalListException() {
		super("없는 리스트 입니다.");
	}
	public TotalListException(String msg) {
		super(msg);
	}
}
