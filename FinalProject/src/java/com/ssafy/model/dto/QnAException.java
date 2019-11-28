package com.ssafy.model.dto;

public class QnAException extends RuntimeException {
	public QnAException() {
		super("QnA 정보 처리 중 오류 발생");
	}
	public QnAException(String msg) {
		super(msg);
	}
}
