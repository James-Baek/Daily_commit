package com.ssafy.ws;
import java.util.*;

public class calc2 {

	public static int oper(String q) {
		
		int sum = 0;
		
		
		return sum;
	}
	
	public static void main(String[] args) {
		Stack<Character> operator = new Stack<Character>();
		Stack<Character> operend = new Stack<Character>();
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int len = 0;
		String cal;
		String q;
		
		for(int t = 1; t <= 10; t++) {
			len = sc.nextInt();
			sc.nextLine();
			cal = sc.nextLine();
			q = "";
			for(char temp : cal.toCharArray()) {
				if(temp == '+' || temp == '*') {
					if(operator.isEmpty()) operator.push(temp);
					else if(operator.peek() >= temp) {
						while(!operator.isEmpty()) {
							if(operator.peek() >= temp) {
							q += operator.pop(); //연산자 붙이기
							}else {
								operator.push(temp);
								break;
							}
						}
					}else {
						operator.push(temp); //연산자 넣기
					}
				}else {
					q += temp; //피연산자 붙이기
				}
			}
			System.out.println(q);
//			System.out.printf("#%d %d", t, sum);
		}

	}

}
