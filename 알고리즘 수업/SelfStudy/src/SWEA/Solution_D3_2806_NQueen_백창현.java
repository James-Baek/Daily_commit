package SWEA;

import java.util.Scanner;

public class Solution_D3_2806_NQueen_백창현 {
	static boolean[][] map;
	static boolean[] visited;
	static int N;
	static int cnt;
	
	static int[] dr = {-1,1,-1,-1,1,1};
	static int[] dc = {0,0,-1,1,-1,1};
	
	public static void dfs(int idx) {
		if(idx == N) {
			cnt++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i] == true) continue;
			map[idx][i] = true;
			visited[i] = true;
			boolean isFail = false;
			
			OUTER:
			for(int j = 0; j < 6; j++) {
				int dist = 1;
				while(true) {
					int nr = idx + dr[j] * dist;
					int nc = i + dc[j] * dist;
					if(nr < 0 || nr >= N || nc < 0 | nc >= N) {
						break;
					}
					if(map[nr][nc] == true) {
						isFail = true;
						break OUTER;
					}
					dist++;
				}
			}
			if(isFail) {
				map[idx][i] = false;
				visited[i] = false;
				continue;
			}else {
				dfs(idx+1);
			}
			map[idx][i] = false;
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			cnt = 0;
			N = sc.nextInt();
			map = new boolean[N][N];
			visited = new boolean[N];
			
			dfs(0);
			System.out.printf("#%d %d\n", t, cnt);
		}
	}
}
