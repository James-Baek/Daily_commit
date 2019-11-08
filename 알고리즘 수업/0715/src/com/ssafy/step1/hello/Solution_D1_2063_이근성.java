package com.ssafy.step1.hello;

import java.util.Scanner;
import java.util.Arrays;
// 실행 시간 : 0.15721s
class Solution_D1_2063_이근성
{
	static int N; // 원소 개수
	static int[] Num;  // 점수 배열
	static int median; // 중간값
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);		
		N = sc.nextInt();
		Num = new int[N];
		for(int i=0;i<N;i++) Num[i] = sc.nextInt();		
		Arrays.sort(Num); //sort
		median = Num[(N-1)/2];	
//		Arrays.fill
			
		System.out.println(median);			
	}
}