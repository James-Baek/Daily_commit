package com.ssafy.step3.graph;

import java.util.Scanner;

public class Friend {
	static boolean[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		map = new boolean[V][V];
		
		for(int i = 0; i < E ; i++) {
			char tempA = sc.next().charAt(0);
			char tempB = sc.next().charAt(0);
			int r = tempA - 'A';
			int c = tempB - 'A';
			map[r][c] = true;
			map[c][r] = true;
		}
		int max = 0;
		int idx = 0;
		for(int i = 0; i < V; i++) {
			int cnt = 0;
			if(map[0][i]) {
				for(int j = 0; j < V; j++) {
					if(map[i][j]) cnt++;
				}
			}
			if(max < cnt) {
				max = cnt;
				idx = i;
			}
		}
		System.out.println((char)('A'+idx)+" "+max+"명");
	}

}
