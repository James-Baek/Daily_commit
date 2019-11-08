package com.ssafy.step1.divide;

public class PowerTest {
	public static int power(int base, int exp) {
		if(exp == 1)return base;
		int halfExp = exp/2;
		int result = power(base, halfExp);
		result *= power(base,halfExp);
		if(halfExp % 2 == 1) {
			result *= base;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(power(2,4));
	}

}
