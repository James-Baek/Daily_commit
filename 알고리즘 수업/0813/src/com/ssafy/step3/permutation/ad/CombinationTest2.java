package com.ssafy.step3.permutation.ad;

import java.util.Scanner;

public class CombinationTest2 {
	static int N,R,numbers[],selected[];
	static int totalCount;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[] {1,2,3,4,5};
		selected = new int[] {0,0,1,1,1};
		
		Combination();
	}
	
	public static void Combination() {
		do {
			for(int i = 0; i < N; ++i) {
				if(selected[i]==1) System.out.print(numbers[i]+" ");
			}
			System.out.println();
		}while(nextPermu());
		System.out.println("총 경우의 수 : "+totalCount);
	}
	
	public static boolean nextPermu() {		
		totalCount++;
		// 1. 뒷쪽부터 탐색하며 감소하는 모습을 보이는 시작점(i, 꼭지) 찾기
		int i = N-1;
		while(i>0 && selected[i-1] >= selected[i]) --i;
		
		// 앞에서 볼때 모두 내림차순되어 있는 상황이어서 가장 큰 순열이므로 다음순열 없음
		if(i == 0) return false;
		
		// 2. i-1 위치에 다음에 올 큰 수를 뒤쪽부터 찾기
		int j = N-1;
		while(selected[i-1]>=selected[j]) --j;
		
		// 3. i-1위치와 j위치값 교환
		swap(i-1, j);
		
		// 4. i-1위치값이 변경되었으므로 뒷자리수(i~j) 재조정(뒷자리수 가장 작은 수열로 만듦 ==>오름차순)
		j = N-1;
		while(i<j) {
			swap(i++, j--);
		}
		return true;
	}
	
	public static void swap(int from, int to) {
		int temp = selected[from];
		selected[from] = selected[to];
		selected[to] = temp;
	}
}
