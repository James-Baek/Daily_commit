package SWEA;

import java.util.Scanner;
import java.util.Stack;

public class SWEA2105 {
	static int max;
	static int N;
	static int[][] map;
	static Stack<Integer> cafe;
	static int base_r;
	static int base_c;
						//우하, 좌하, 좌상, 우상
	static int[] dr = {1,1,-1,-1};
	static int[] dc = {1,-1,-1,1};
	
	static boolean[][] visited;
	static int cnt;
	
	public static void dfs(int r, int c) {
		if(r == base_r && c == base_c && cafe.size() >= 4) {
			if(max < cafe.size()) {
				max = cafe.size();
			}
			return;
		}
		
		for(int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr == base_r && nc == base_c && cafe.size() >= 4) {
				dfs(nr, nc);
			}
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || cafe.contains(map[nr][nc])) continue;
			visited[nr][nc] = true;
			cafe.push(map[nr][nc]);
			dfs(nr, nc);
			cafe.pop();
			visited[nr][nc] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			max = -1;
			N = sc.nextInt();
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 1; i < N-1; i++) {
				for(int j = 1; j < N-1; j++) {
					visited = new boolean[N][N];
					cafe = new Stack<Integer>();
					base_r = i;
					base_c = j;
					visited[i][j] = true;
					cafe.push(map[i][j]);
					dfs(i, j);
				}
			}
			
			System.out.printf("#%d %d\n", t, max);
		}
	}

}
