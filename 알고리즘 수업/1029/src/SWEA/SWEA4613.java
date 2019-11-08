package SWEA;

import java.util.Scanner;

public class SWEA4613 {
	static int N, M;
	static char[][] map;
	static int[][] WBR;
	static int[][] topDown;
	static int[][] bottomUp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			int ans = 0;
			
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N][M];
			sc.nextLine();
			
			WBR = new int[N][3];
			
			for(int i = 0; i < N; i++) {
				map[i] = sc.nextLine().toCharArray();
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 'W') WBR[i][0]++;
					else if(map[i][j] == 'B') WBR[i][1]++;
					else if(map[i][j] == 'R') WBR[i][2]++;
				}
			}
			topDown = new int[N][3];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < 3; j++) {
					topDown[i][j] = M-WBR[i][j];
				}
			}
			
			int top_r = 1;
			while(true) {
				if(top_r == N-2) break;
				if(topDown[top_r][0] > topDown[top_r][1]) break;
				ans += topDown[top_r][0];
				top_r++;
			}
			
			int bottom_r = N-2;
			while(true) {
				if(bottom_r == 1) break;
				if(topDown[bottom_r][2] > topDown[bottom_r][1]) break;
				ans += topDown[bottom_r][2];
				bottom_r--;
			}
			
			for(int i = top_r; i <= bottom_r; i++) {
				ans += topDown[i][1];
			}
			System.out.printf("#%d %d\n", t, ans+ topDown[0][0] + topDown[N-1][2]);
		}
	}

}
