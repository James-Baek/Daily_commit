package Baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main17472 {
	static int N;
	static int M;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	static boolean[][] visited;
	static Islandobj[] island;
	static int cnt;
	static int[][] distance;
	
	static class Islandobj{
		Queue<Integer> rc;
		public Islandobj() {
			rc = new LinkedList<Integer>();
		}
	}
	
	public static void makePath() {
		for(int i = 1; i < cnt; i++) {
			int rc = island[i].rc.poll();
			int r = rc / 1000;
			int c = rc % 1000;
			
			int nr = r;
			int nc = c;
					
			for(int dir = 0; dir < 4; dir++) {
				int target = 0;
				int dist = 0;
				nr += dr[dir];
				nc += dc[dir];
				
				while(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					if(map[nr][nc] == 0) {
						dist++;
						nr += dr[dir];
						nc += dc[dir];
					}else {
						target = map[nr][nc];
						break;
					}
				}


				if(target != 0) {
					if(distance[i][target] == 0) {
						distance[i][target] = dist;
					}else {
						distance[i][target] = Math.min(distance[i][target], dist);
					}
				}
			}
		}

	}
	
	public static void findIsland() {
		Queue<Integer> q = new LinkedList<Integer>();
		visited = new boolean[N][M];
		island = new Islandobj[7];
		
		for(int i = 1; i < 7; i++) {
			island[i] = new Islandobj();
		}
		
		cnt = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < M; j++) {
				if(visited[i][j]) continue;
				if(map[i][j] == 0) {
					visited[i][j] = true;
					continue;
				}
				visited[i][j] = true;
				q.offer(i * 1000 + j);
				while(!q.isEmpty()) {
					int rc = q.poll();
					int r = rc / 1000;
					int c = rc % 1000;
					if(map[r][c] == 1) {
						map[r][c] = cnt;
						island[cnt].rc.offer(rc);
					}
					
					for(int dir = 0; dir < 4; dir++) {
						int nr = r + dr[dir];
						int nc = c + dc[dir];
						if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] || map[nr][nc] != 1) continue;
						q.offer(nr * 1000 + nc);
						visited[nr][nc] = true;
					}
				}
				cnt++;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		distance = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		findIsland();
		makePath();
		
		System.out.println();
		
	}

}
