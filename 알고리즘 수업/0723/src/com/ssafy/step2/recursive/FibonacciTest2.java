package com.ssafy.step2.recursive;

import java.util.Scanner;

public class FibonacciTest2 {
	static int[] memo;
	
	static int fibonacci(int n) {
		if(n > 2 || memo[n] == 0) {
			memo[n] = fibonacci(n-2) + fibonacci(n-1);
		}
		return memo[n];
	}
	


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memo = new int[n+1];
		memo[1] = 1;
		memo[2] = 1;
		
		System.out.println(fibonacci(n));
	}

}
