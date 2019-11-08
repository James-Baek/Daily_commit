package com.ssafy.ws;
import java.util.*;

class IStack extends Stack<Character> {

	// ArrayStack.java 파일 내의 
	// Stack 클래스 상속하여 기본적인 Stack 기능 대체
	
	// 연산자의 우선순위를 반환한다
	int prec(char op) {
		switch(op) {
			case '(': case ')': return 0;
			case '+': case '-': return 1;
			case '*': case '/': return 2;
		}
		return -1;
	}
	
	// 중위 표기 수식 -> 후위 표기 수식
	void infix_to_postfix(String exp) {
		char[] ch_exp = exp.toCharArray();
		char ch, top_op;
		
		for (int i = 0; i < ch_exp.length; i++) {
			ch = ch_exp[i];
			switch(ch) {
				case '+': case '-': case '*': case '/': // 연산자
					// 스택에 있는 연산자의 우선순위가 더 크거나 같으면 출력
					while(!isEmpty() && prec(ch) <= prec(peek())) 
						System.out.print(pop());
					push(ch);
					break;
				case '(': // 왼쪽 괄호
					push(ch);
					break;
				case ')': // 오른쪽 괄호
					top_op = pop();
					// 왼쪽 괄호를 만날 때까지 출력
					while(top_op != '(') {
						System.out.print(top_op);
						top_op = pop();
					}
					break;
				default: // 피연산자
					System.out.print(ch);
					break;
			}
		}
		while(!isEmpty()) // 스택에 저장된 연산자들 출력
			System.out.print(pop());
	}
	
}

public class test2 {
	
	public static void main(String[] args) {
		IStack s = new IStack();
		s.infix_to_postfix("9+5*2+1+3*3*7*6*9*1*7+1+8*6+6*1*1*5*2*4*7+4*3*8*2*6+7*8*4*5+3+7+2+6+5+1+7+6+7*3*6+2+6+6*2+4+2*2+4*9*3");
	}
	
}