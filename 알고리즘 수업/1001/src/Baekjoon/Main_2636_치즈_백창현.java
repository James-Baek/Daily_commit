package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2636_치즈_백창현 {
	static int N;
	static int M;
	static int[][] map;
	static int before;
	static int now;
	static boolean[][] visited;
	static boolean[][] selected;
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	
	public static void find_line() {
		before = now;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		visited = new boolean[N][M];
		selected = new boolean[N][M];
		
		queue.offer(0);
		visited[0][0] = true;
		
		while(!queue.isEmpty()) {
			int rc = queue.poll();
			int r = rc / 1000;
			int c = rc % 1000;
			visited[r][c] = true;
			for(int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
				if(map[nr][nc] == 1) {
					selected[nr][nc] = true;
					continue;
				}
				visited[nr][nc] = true;
				queue.offer(nr*1000+nc);
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(selected[i][j]) {
					map[i][j] = 0;
					now--;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		before = 0;
		now = 0;
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				now += map[i][j];
			}
		}
		
		while(now != 0) {
			find_line();
			cnt++;
		}

		System.out.println(cnt);
		System.out.println(before);
	}

}
