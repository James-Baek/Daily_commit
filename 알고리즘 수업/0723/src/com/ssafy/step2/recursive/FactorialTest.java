package com.ssafy.step2.recursive;

import java.util.Scanner;

public class FactorialTest {

	public static int factorial(int n) {
		if(n == 1) return 1;
		return n * factorial(n-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(factorial(sc.nextInt()));
	}

}
