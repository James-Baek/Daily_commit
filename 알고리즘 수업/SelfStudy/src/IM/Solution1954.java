package IM;

import java.util.Scanner;

public class Solution1954 {
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int cnt = 1;
		for(int t = 1; t <= T; t++){
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int nr = 0;
			int nc = 0;
			int r = 0;
			int c = 0;
			int dir = 0;
			
			System.out.printf("#%d\n",t);
			while(cnt <= N*N) {
				nr += dr[dir%4];
				nc += dc[dir%4];
				
				if(nr >= N || nr < 0|| nc >= N || nc < 0 || map[nr][nc] != 0) {
					nr -= dr[dir%4];
					nc -= dc[dir%4];
					dir++;
					nr += dr[dir%4];
					nc += dc[dir%4];
				}
				
				if(map[r][c] == 0) {
					map[r][c] = cnt;
					cnt++;
				}
				
				r = nr;
				c = nc;
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
			cnt = 1;
		}
	}

}
