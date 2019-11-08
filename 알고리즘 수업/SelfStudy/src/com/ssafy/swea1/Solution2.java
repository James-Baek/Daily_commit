package com.ssafy.swea1;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution2
{
	static int T,N; // testcase, ������ ����
	static int[] S; // ����
	static int maxLength;
	public static void main(String args[]) throws Exception
	{

		System.setIn(new FileInputStream("res/input.txt"));
	
	/*
	ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
	*/
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt(); // ��� ����
			S = new int[N];
			int[] dp = new int[N];
			for(int i=0;i<N;i++)
				S[i] = sc.nextInt();
			int tmp, cnt;
			for(int i=0;i<N;i++) {
				tmp = S[i]; // ���� ���Ҹ� ����
				cnt = dp[i]; // count ����
				for(int j = i+1; j<N;j++) { 
					if(tmp > S[j]) continue; // ���Ұ��� ���� ������ ũ��
					if(cnt +1 <= dp[j]) continue; // count���� ���� count������ ������
					dp[j] = cnt + 1; // 
				}
				
				maxLength = Math.max(maxLength, dp[i]+1);
			}
			System.out.println("#"+test_case + " " + maxLength);
			
		}
			
	}	
}