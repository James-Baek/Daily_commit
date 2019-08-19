package ssafy;

import java.util.Scanner;

public class SWEA2806 {
	static boolean[][] map;
	static int N;
	static int cnt;
	
	static int[] dr = {-1,1,0,0,-1,-1,1,1};
	static int[] dc = {0,0,-1,1,-1,1,-1,1};
	
	public static void dfs(int idx) {
		if(idx == N) {
			cnt++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			map[idx][i] = true;
			boolean isFale = false;
			
			OUTER:
			for(int j = 0; j < 8; j++) {
				int dist = 1;
				while(true) {
					int nr = idx + dr[j] * dist;
					int nc = i + dc[j] * dist;
					if(nr < 0 || nr >= N || nc < 0 | nc >= N) {
						break;
					}
					if(map[nr][nc] == true) {
						isFale = true;
						break OUTER;
					}
					dist++;
				}
			}
			if(isFale) {
				map[idx][i] = false;
				continue;
			}else {
				dfs(idx+1);
			}
			map[idx][i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			cnt = 0;
			N = sc.nextInt();
			map = new boolean[N][N];
			dfs(0);
			System.out.printf("#%d %d\n", t, cnt);
		}
	}
}
