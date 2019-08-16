package Baekjoon;

import java.util.Scanner;

public class Baekjoon16926 {
	static int[][] map;
	static int baseNum;
	static int basexy;
	
	public static void blink(int fromxy, int toxy) {
		int from_x = fromxy/1000;
		int from_y = fromxy%1000;
		int to_x = toxy/1000;
		int to_y = toxy%1000;
		
		if(toxy == basexy) {
			map[to_x][to_y] = baseNum;
			return;
		}
		map[to_x][to_y] = map[from_x][from_y];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int R = sc.nextInt();
		map = new int[N][M];
		int[][] map2 = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int[] dr = {1,0,-1,0};
		int[] dc = {0,1,0,-1};
		int dir = 0;
		
		for(int k = 0; k < R; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					
				}
			}
		}
	}

}
