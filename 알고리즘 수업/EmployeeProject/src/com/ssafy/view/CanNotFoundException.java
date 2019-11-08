package com.ssafy.view;

public class CanNotFoundException extends Exception {
	public CanNotFoundException() {
		super("등록되지 않은 사원 번호입니다.");
	}
	public CanNotFoundException(String msg) {
		super(msg);
	}
}
