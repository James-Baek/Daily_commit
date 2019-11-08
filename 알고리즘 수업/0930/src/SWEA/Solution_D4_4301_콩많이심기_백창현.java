package SWEA;

import java.util.Scanner;

public class Solution_D4_4301_콩많이심기_백창현 {
	static boolean[][] map;
	static int N;
	static int M;
	static int cnt;
	static int[] dr = {-2,0,2,0};
	static int[] dc = {0,-2,0,2};
	
	public static void fill(int x, int y) {
		cnt = 0;
		
		for(int i= 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				boolean isGood = true;
				for(int dir = 0; dir < 4; dir++) {
					int nr = i + dr[dir];
					int nc = j + dc[dir];
					if(nr < 0 || nr >= x || nc < 0 || nc >= y) {
						continue;
					}else {
						if(map[nr][nc]) {
							isGood = false;
							break;
						}
					}
				}
				if(isGood) {
					map[i][j] = true;
					cnt++;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new boolean[M][N];
			fill(M, N);
			System.out.printf("#%d %d\n", t, cnt);
		}

	}

}
