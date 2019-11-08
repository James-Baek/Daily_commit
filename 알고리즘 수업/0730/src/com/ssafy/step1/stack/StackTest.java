package com.ssafy.step1.stack;

public class StackTest {

	public static void main(String[] args) {
		Stack stack = new Stack(10);
		System.out.println(stack.peek());
		stack.push("월요일");
		stack.push("화요일");
		stack.push("수요일");
		stack.push("목요일");
		stack.push("금요일");
		System.out.println(stack.size());
//		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
	}

}
