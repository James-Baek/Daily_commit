package com.ssafy.step1.permutation;

public class BitOperatorTest {

	public static void main(String[] args) {
		int i = 1, j = 6; // j   :110		j	: 110
						  // i<<0:001		i<<0: 001
						  // i<<1:010		i<<1: 010
						  // i<<2:100		i<<2: 110
		System.out.println("i:"+Integer.toBinaryString(i));
		System.out.println("j:"+Integer.toBinaryString(j));
		System.out.println("1<<2:"+ Integer.toBinaryString(1<<2));
		System.out.println("j&(1<<2):"+ Integer.toBinaryString(j&(1<<2)));
		System.out.println("j&(1<<1):"+ Integer.toBinaryString(j&(1<<1)));
		System.out.println("j&(1<<0):"+ Integer.toBinaryString(j&(1<<0)));
		System.out.println("j|(1<<0):"+ Integer.toBinaryString(j&(1<<2))); //110
		System.out.println("j|(1<<0):"+ Integer.toBinaryString(j&(1<<1))); //110
		System.out.println("j|(1<<0):"+ Integer.toBinaryString(j&(1<<0))); //111
	}

}
