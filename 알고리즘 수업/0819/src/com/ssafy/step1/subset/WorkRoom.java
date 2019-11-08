package com.ssafy.step1.subset;

import java.util.Arrays;
import java.util.Scanner;

public class WorkRoom {
	static int[] selected;
	static int[][] maxCase;
	static int caseCnt;
	static boolean[] visited;
	static int T;
	static int[][] time;
	static int max;
	
	public static void dfs(int idx) {
		if(idx == T) {
			System.out.println(Arrays.toString(selected));
			return;
		}
		// 모든 경우 검색
		for(int i = 0; i < T; i++) {
			if(visited[i]) continue;
			if(idx != 0) {
				if(time[selected[idx-1]][1] > time[i][0]) continue;
			}
			visited[i] = true;
			selected[idx] = i;
			dfs(idx+1);
			visited[i] = false;
			selected[idx] = -1;
		}
		
		int cnt =0;
		for(int i = 0; i < T; i++) {
			if(selected[i] >= 0) cnt++;
		}
		
		// 순서 출력 및 최대 회의 개수 파악
		if(cnt > max) {
			max = cnt;
			maxCase[0] = selected.clone();
			caseCnt = 1;
		}else if(cnt == max) {
			maxCase[caseCnt] = selected.clone();
			caseCnt++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		time = new int[T][2];
		selected = new int[T];
		visited = new boolean[T];
		maxCase = new int[T][];
		caseCnt = 0;
		max = 0;
		
		for(int i = 0; i < T; i++) {
			time[i][0] = sc.nextInt();
			time[i][1] = sc.nextInt();
			selected[i] = -1;
		}

		dfs(0);
		System.out.println(max);
		for(int[] temp : maxCase) {
			for(int room : temp) {
				if(room >= 0) {
					System.out.print((room+1)+"번 회의 ");
				}
			}
			System.out.println();
		}
	}

}
