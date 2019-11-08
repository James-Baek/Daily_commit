package com.ssafy.step1.hello;
import java.util.Scanner;

class Solution
{
	static int T,N; // Testcase, 수열의 길이
	static int[] S; // 수열
	static int maxLength;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            maxLength = 0;
			N = sc.nextInt(); // 재료 개수
			S = new int[N];
			int[] dp = new int[N];
			for(int i=0;i<N;i++) S[i] = sc.nextInt(); // 수열 받아오고

			for(int i=0;i<N;i++) {
				for(int j = i+1; j<N;j++)
					if(S[i] <= S[j] && dp[i] >= dp[j]) dp[j] = dp[i] +1;
				maxLength = Math.max(maxLength, dp[i]);
			}			
			System.out.println("#"+test_case + " " + ++maxLength);			
		}
	}	
}