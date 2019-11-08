package com.ssafy.step3.permutation.ad;

import java.util.Arrays;
import java.util.Scanner;

public class dice {
	static int N; // 던지는 횟수
	static int M;
	static int[] dice;
	static int[] selected;
	static boolean[] visited;
	static int totalCnt;
	// M = 1 : 주사위를 N번 던져서 나올 수 있는 모든 경우
	public static void allKind(int idx) {
		if(idx == N) {
			totalCnt++;
			for(int temp : selected) {
				System.out.print(temp+" ");
			}
			System.out.println();
			return;
		}
		for(int i = 0; i < 6; i++) {
			selected[idx] = dice[i];
			allKind(idx+1);
		}
	}
	
	// M = 2 : 주사위를 N번 던져서 중복이 되는 경우를 제외하고 나올 수 있는 모든 경우
	public static void reCombi(int idx, int start) {
		if(idx == N) {
			totalCnt++;
			for(int temp : selected) {
				System.out.print(temp+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < 6; i++) {
			selected[idx] = dice[i];
			reCombi(idx+1, i);
		}
	}
	
	// M = 3 : 주사위를 N번 던져서 모두 다른 수가 나올 수 있는 모든 경우
	public static void diffKind(int idx) {
		if(idx == N) {
			totalCnt++;
			for(int temp : selected) {
				System.out.print(temp+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < 6; i++) {
			if(visited[i]) continue;
			selected[idx] = dice[i];
			visited[i] = true;
			diffKind(idx+1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		selected = new int[N];
		visited = new boolean[6];
		dice = new int[] {1,2,3,4,5,6};
		totalCnt = 0;
		
		if(M == 1) {
			allKind(0);
		}else if(M == 2) {
			reCombi(0,0);
		}else if(M == 3) {
			diffKind(0);
		}
		System.out.println(totalCnt);
		
	}

}
