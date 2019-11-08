package Baekjoon;

import java.util.Scanner;

public class Main_1987_알파벳_백창현 {
	static int R;
	static int C;
	static int[][] map;
	static int max;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	
	public static void dfs(int r, int c, int cnt, int list) {
		if(max == 26) {
			return;
		}
		if(cnt > max) {
			max = cnt;
		}
		
		for(int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
			if((list & (1 << map[nr][nc])) == 0) {
				dfs(nr, nc, cnt+1, list | (1 << map[nr][nc]));
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		sc.nextLine();
		max = 0;
		
		for(int i = 0; i < R; i++) {
			char[] row = sc.nextLine().toCharArray();
			for(int j = 0; j < C; j++) {
				map[i][j] = row[j] - 'A';
			}
		}
		
		dfs(0,0,1,1 << map[0][0]);
		
		System.out.println(max);

	}

}
