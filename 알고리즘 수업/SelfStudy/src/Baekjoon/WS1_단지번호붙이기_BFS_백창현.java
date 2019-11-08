package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WS1_단지번호붙이기_BFS_백창현 {
	
	static int N;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[][] visited;
	static int[][] map;
	static ArrayList<Integer> ans;
	static int max;
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int cnt = 0;
				if(visited[i][j] || map[i][j] == 0) continue;
				queue.offer(i * 100 + j);
				while(!queue.isEmpty()) {
					int rc = queue.poll();
					int r = rc / 100;
					int c = rc % 100;
					if(map[r][c] == 1) cnt++;
					visited[r][c] = true;
					
					for(int dir = 0; dir < 4; dir++) {
						int nr = r + dr[dir];
						int nc = c + dc[dir];
						if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] == 0) {
							continue;
						}
						visited[nr][nc] = true;
						queue.offer(nr * 100 + nc);
					}
				}
				if(cnt >= 1) ans.add(cnt);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		ans = new ArrayList<Integer>();
		
		for(int i = 0; i < N; i++) {
			String line = sc.nextLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(line.charAt(j)+"");
			}
		}
		
		bfs();
		
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int temp : ans) {
			System.out.println(temp);
		}

	}

}
