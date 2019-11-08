package com.ssafy.step1.bit;

public class BitOperatorTest {

	public static void main(String[] args) {
		int i = 0xFF, j=0xAA, k=0x99;
		// i : 11111111, j : 10101010, k : 10011001
		System.out.println("i : "+Integer.toBinaryString(i));
		System.out.println("j : "+Integer.toBinaryString(j));
		System.out.println("k : "+Integer.toBinaryString(k));
		
		System.out.println("i&j : "+Integer.toBinaryString(i&j));
		System.out.println("k&j : "+Integer.toBinaryString(k&j));
		
		System.out.println("i|j : "+Integer.toBinaryString(i|j));
		System.out.println("k|j : "+Integer.toBinaryString(k|j));
		
		System.out.println("i^j : "+Integer.toBinaryString(i^j));
		System.out.println("k^j : "+Integer.toBinaryString(k^j));
		
		System.out.println("~j : "+Integer.toBinaryString(~j));
		
		System.out.println("i<<2 : "+Integer.toBinaryString(i<<2));
		System.out.println("i>>2 : "+Integer.toBinaryString(i>>2));
		System.out.println("i>>>2 : "+Integer.toBinaryString(i>>>2));
		
		int m = -8;
		System.out.println("m : "+Integer.toBinaryString(m));		
		System.out.println("m>>2 : "+Integer.toBinaryString(m>>2));		
		System.out.println("m>>>2 : "+Integer.toBinaryString(m>>>2));		
	}

}
