package com.ssafy.view;

public class DuplicateException extends Exception {
	public DuplicateException() {
		super("이미 등록된 사원 번호입니다.");
	}
	public DuplicateException(String msg) {
		super(msg);
	}
}
