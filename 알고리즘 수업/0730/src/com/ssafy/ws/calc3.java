package com.ssafy.ws;
import java.util.*;

public class calc3 {

	public static int oper(String q) {
		Stack<Integer> st = new Stack<Integer>();
		int sum = 0;
		int a, b;
		for(char temp : q.toCharArray()) {
			if(temp == '+' || temp == '*') {
				a = st.pop();
				b = st.pop();
				if(temp == '+') {
					st.push(a+b);
				}else {
					st.push(a*b);
				}
			}else {
				st.push(temp-'0');
			}
		}
		if(st.size() == 2) {
			sum = st.pop() + st.pop();
		}else {
			sum = st.pop();
		}
		
		return sum;
	}
	// icp가 높으면 true
	public static boolean comp(char icp, char isp) {
		int s1 = 0;
		int s2 = 0;
		if(icp == '*' || icp == '/') {
			s1 = 2;
		}else if(icp == '+' || icp == '-') {
			s1 = 1;
		}else if(icp == '(') {
			s1 = 0;
		}
		
		
		if(isp == '*' || isp == '/') {
			s1 = 2;
		}else if(isp == '+' || isp == '-') {
			s1 = 1;
		}else if(isp == '(') {
			s1 = 3;
		}
		
		return icp > isp ? true : false;
	}
	public static void main(String[] args) {
		Stack<Character> st;
		Scanner sc = new Scanner(System.in);
		int len;
		String cal;
		String q;
		
		for(int t = 1; t <= 10; t++) {
			len = sc.nextInt();
			sc.nextLine();
			cal = sc.nextLine();
			q = "";
			st = new Stack<Character>();
			
			for(char temp : cal.toCharArray()) {
				if(temp == '+' || temp =='*' || temp == ')' || temp == '(') {
					if(temp == ')') {
						while(!st.isEmpty() && !(st.peek() == '(')) {
							q += st.pop();
						}
						st.pop();
						continue;
					}
					if(st.isEmpty() || temp == '(') {
						st.push(temp);
						continue;
					}
					if(comp(st.peek(), temp)) {
						st.push(temp);
						continue;
					}else {
						while(!st.isEmpty() && !comp(st.peek(), temp)) {
							q += st.pop();
						}
						st.push(temp);
					}
					continue;
				}
				q += temp;
			}
			q += st.pop();

			System.out.printf("#%d %d\n", t, oper(q));
		}

	}

}
