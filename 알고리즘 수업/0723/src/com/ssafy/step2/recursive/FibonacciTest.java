package com.ssafy.step2.recursive;

import java.util.Scanner;

public class FibonacciTest {
	static long[] fibo;
	
	static int fibonacci(int n) {
		if(n <=1) return n;

		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	// 내가 한거
	static long fibonacci2(int n) {
		if(fibo[n] != 0) return fibo[n];
		if(fibo[n-1] !=0 && fibo[n-2] != 0) {
			fibo[n] = fibo[n-1] + fibo[n-2];
			return fibo[n];
		}
		return fibonacci2(n-1) + fibonacci2(n-2);
	}
	
	//교수님 코드
	public static long fibonacci3(int count, long before, long current) {
		if(count == 1) return current;
		return fibonacci3(--count, current, before+current);
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		fibo = new long[n+2];
		fibo[1] = 1;
		fibo[2] = 1;
		
		System.out.println(fibonacci2(n));
		System.out.println(fibonacci3(n,0,1));
		
	}

}
