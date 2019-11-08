package IM;

import java.util.Scanner;

public class Jungol1671 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] paper = new int[N][2];
		boolean[][] map = new boolean[101][101];
		int max_c = 0;
		int max_r = 0;
		int min_r = Integer.MAX_VALUE;
		int min_c = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			paper[i][0] = sc.nextInt();
			paper[i][1] = sc.nextInt();
			max_c = max_c > paper[i][0] ? max_c : paper[i][0];
			max_r = max_r > paper[i][1] ? max_r : paper[i][1];
			min_c = min_c < paper[i][0] ? min_c : paper[i][0];
			min_r = min_r < paper[i][1] ? min_r : paper[i][1];
		}
		

		for(int[] p : paper) {
			for(int i = p[1]; i < p[1]+10; i++) {
				for(int j = p[0]; j < p[0]+10; j++) {
					if(map[i][j]) continue;
					else {
						map[i][j] = true;
					}
				}
			}
		}
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		int cnt = 0;
		
		for(int i = min_r-1; i < max_r+11; i++ ) {
			for(int j = min_c-1; j < max_c+11; j++) {
				if(map[i][j] == false) {
					for(int dir = 0; dir < 4; dir++) {
						int nr = i + dr[dir];
						int nc = j + dc[dir];
						if(nr < 0 || nr >= 100 || nc < 0 || nc >=100) continue;
						if(map[nr][nc] == true) {
							cnt++;
						}
					}
				}
			}
		}
		
		System.out.println(cnt);
		
	}

}
