package com.ssafy.step2.recursive;
import java.util.*;

public class DigitSumTest {
/*
 * 정수 입력 받고 각 자리수의 합을 구하기
 * 123 ===> 6
 * 
 */
	static long digitsum(long n) {
		if(n < 10) return n;
		
		long temp = n % 10;
		
		return temp + digitsum(n/10);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long num = sc.nextLong();
		System.out.println(digitsum(num));
	}

}
