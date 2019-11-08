package Baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WS1_단지번호붙이기_DFS_백창현 {
	
	static int N;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean[][] visited;
	static int[][] map;
	static ArrayList<Integer> ans;
	static int max;
	
	public static void dfs(int r, int c) {
		if(visited[r][c])
			return;
		max++;
		visited[r][c] = true;
		for(int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 0 || visited[nr][nc]) {
				continue;
			}
			dfs(nr, nc);
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

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				max = 0;
				if(map[i][j] == 1) {
					dfs(i, j);
				}
				if(max >= 1) ans.add(max);
			}
		}
		
		
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int temp : ans) {
			System.out.println(temp);
		}
	}

}
