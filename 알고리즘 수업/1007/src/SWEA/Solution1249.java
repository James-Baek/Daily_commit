package SWEA;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1249 {
	static int N;
	static int min;
	static int cnt;
	static int[][] map;
	static int[] dr = {-1,0};
	static int[] dc = {0,-1};
	static boolean[][] visited;
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {

			int r = i;
			int c = i;
			for(int j = i; j < N; j++) {
				c = j;
				if(r == 0 && c == 0) continue;
				int temp_min = Integer.MAX_VALUE;
				for(int dir = 0; dir < 2; dir++) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[r][c]) continue;
					if(map[nr][nc] < temp_min) temp_min = map[nr][nc];
				}
//				if(temp_min == Integer.MAX_VALUE) continue;
				map[r][c] += temp_min;
				visited[r][c] = true;
			}
			
			c = i;
			for(int j = i; j < N; j++) {
				r = j;
				if(r == i && c == i) continue;
				int temp_min = Integer.MAX_VALUE;
				for(int dir = 0; dir < 2; dir++) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[r][c]) continue;
					if(map[nr][nc] < temp_min) temp_min = map[nr][nc];
				}
//				if(temp_min == Integer.MAX_VALUE) continue;
				map[r][c] += temp_min;
				visited[r][c] = true;
			}
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			min = Integer.MAX_VALUE;
			sc.nextLine();
			for(int i = 0; i < N; i++) {
				char[] line = sc.nextLine().toCharArray();
				for(int j = 0; j < N; j++) {
					map[i][j] = line[j] - 48;
				}
			}

			bfs();
			System.out.printf("#%d %d\n", t, map[N-1][N-1]);
		}
		
		
	}

}
