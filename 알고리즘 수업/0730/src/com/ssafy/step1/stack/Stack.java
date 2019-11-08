package com.ssafy.step1.stack;

import java.util.*;

public class Stack {
	private String stack[];
	private int top = -1;
	private final int MAX_STACK_SIZE;
	public Stack() {
		this(5);
	}
	public Stack(int maxSize) {
		MAX_STACK_SIZE = maxSize;
		stack = new String[maxSize];
	}
	public void push(String element) {
	
		if(top == MAX_STACK_SIZE-1) {
			System.out.println("스택이 포화상태입니다.");
			return;
		}
		stack[++top] = element;
	}
	
	public String pop() {
		String result = peek();
		
		if(result != null) {
			stack[top--] = null;
		}
		return result;
	}
	
	public String pop2() {
		String result = peek2();
		if(result != null) {
			stack[top--] = null;
		}
		return result;
	}

	public String peek() {
		if(isEmpty()) {
			throw new RuntimeException("스택이 공백상태입니다.");
		}
		return stack[top];
	}
	
	public String peek2() {
		if(isEmpty()) {
			System.out.println("스택이 공백상태입니다.");
			return null;
		}
		return stack[top];
	}
	
	public boolean isEmpty() {
		return top == -1 ? true : false;
	}
	
	public int size() {
		return top+1;
	}
}
