package com.ssafy.step3.permutation.ad;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest1 {
	static int N,R,numbers[];
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		cnt = 0;
		combination(0,0);
		System.out.println(cnt);
	}
	
	private static void combination(int before, int index) {
		if(index == R) {
			cnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i = before+1; i <= N; ++i) {
			numbers[index] = i;
			combination(i, index+1);
		}
	}
}
