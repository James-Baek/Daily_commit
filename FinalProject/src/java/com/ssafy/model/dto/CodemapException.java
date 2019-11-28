package com.ssafy.model.dto;

public class CodemapException extends RuntimeException {
	public CodemapException() {
		super("코드가 없습니다.");
	}
	public CodemapException(String msg) {
		super(msg);
	}
}
