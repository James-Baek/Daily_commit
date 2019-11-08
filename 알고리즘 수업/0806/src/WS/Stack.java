package WS;

import java.util.*;

import javax.xml.soap.Node;

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
	
	public Object pop() {
		if(isEmpty()) {
			throw new RuntimeException("스택이 공백상태입니다.");
		}
		Node popNode = top;
		top = popNode.link;
		popNode.link = null;
		return popNode.data;
	}
	

	public String peek() {
		if(isEmpty()) {
			throw new RuntimeException("스택이 공백상태입니다.");
		}
		return top.data;
	}
	
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public int size() {
		
		Node current = top;
		return top+1;
	}
}
