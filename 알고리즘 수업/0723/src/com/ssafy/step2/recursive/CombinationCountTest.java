package com.ssafy.step2.recursive;
import java.util.*;

public class CombinationCountTest {

	/*
	 * nCk
	 * n개 수 중 k개를 조합할 수 있는 경우의 수
	 * 
	 */
	
	static int combi(int N, int K) {
		if(N == K || K == 0) return 1;
		return combi(N-1, K-1) + combi(N-1, K);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		System.out.println(combi(N, K));
		
	}

}
