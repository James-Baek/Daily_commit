package com.ssafy.step2.subset;

import java.util.Scanner;

public class SubsetSumTest2 {
	static int[] numbers;
	static boolean[] selected;
	static int N;
	static int cnt = 0;
	static int target = 0;
	static int trycnt = 0;
	public static void makeSubset(int index, int sum, String result) {
		trycnt++;
		if(sum == target) {
			System.out.println(result);
			cnt++;
			return;
		}else if(sum > target) {
			return;
		}

		if(index == N) {
			return;
		}
		// 선택
		makeSubset(index+1, sum+numbers[index], result+numbers[index]+" ");
		// 비선택
		makeSubset(index+1, sum, result);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		target = sc.nextInt();
		for(int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		makeSubset(0,0, "");
		System.out.println("경우의 수 : "+cnt);;
		System.out.println(trycnt);
	}

}
