package Baekjoon;
import java.util.*;

public class Baekjoon17281 {
	static int[][] map;
	static int[] selected;
	static int[] player;
	static boolean[] visited;
	static int N;
	static boolean[] ground;
	static int maxscore;
	static int casecnt;
	
	public static void playGame() {
		casecnt++;
		ground = new boolean[4];
		int rnd = 0;
		int outcnt = 0;
		int cnt = 0;
		int score = 0;
		
		while(rnd != N) {
			while(outcnt != 3) {
				int pivot = cnt % 9;
				int idx = player[pivot];
				int hit = map[rnd][idx];
				if(hit == 0) {
					outcnt++;
					cnt++;
					continue;
				}else if(hit == 4) {
					for(int i = 3; i >=1; --i) {
						if(ground[i]) score++;
						ground[i] = false;
					}
					score++;
				}else {
					for(int i = 3; i >= 1; --i) {
						if(ground[i] && i + hit > 3) {
							score++;
							ground[i] = false;
						}else if(ground[i]) {
							ground[i] = false;
							ground[i+hit] = true;
						}
					}
					ground[hit] = true;
				}
				cnt++;
			}
			rnd++;
			outcnt = 0;
		}
		
		maxscore = maxscore > score ? maxscore : score;
	}
	
	public static void dfs(int idx) {
		if(idx == 8) {
			for(int i = 0; i < 3; i++) {
				player[i] = selected[i];
			}
			player[3] = 0;
			for(int i = 4; i < 9; i++) {
				player[i] = selected[i-1];
			}
			
			playGame();
			return;
		}
		for(int i = 1; i < 9; i++) {
			if(visited[i-1] == true) continue;
			visited[i-1] = true;
			selected[idx] = i;
			dfs(idx+1);
			visited[i-1] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		selected = new int[8];
		map = new int[N][9];
		visited = new boolean[8];
		player = new int[9];
		maxscore = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 9; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(0);
		System.out.println(maxscore);
	}

}
