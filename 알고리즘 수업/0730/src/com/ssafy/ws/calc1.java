package com.ssafy.ws;
import java.util.*;

public class calc1 {

	public static int oper(String q) {
		
		int sum = 0;
		
		
		return sum;
	}
	
	public static void main(String[] args) {
		Stack<Character> operator;
		
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
			operator = new Stack<Character>();
			
			for(char temp : cal.toCharArray()) {
				if(temp == '+' || temp == '*') {
					if(operator.isEmpty()) {
						operator.push(temp);
					}else if(operator.peek() > temp){ //43 +    42 *
						operator.push(temp);
					}else {
						while(!operator.isEmpty() && operator.peek() >= '*') {
							if(operator.peek() == '+') {
								operator.push(temp);
								break;
							}
							q += operator.pop();
						}

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
