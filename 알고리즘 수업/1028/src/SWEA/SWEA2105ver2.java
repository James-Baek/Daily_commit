package SWEA;

import java.util.Scanner;
import java.util.Stack;

public class SWEA2105ver2 {
	static int max;
	static int N;
	static int[][] map;
	static Stack<Integer> cafe;
	static int base_r;
	static int base_c;
						//우하, 좌하, 좌상, 우상
	static int[] dr = {1,1,-1,-1};
	static int[] dc = {1,-1,-1,1};
	
	static boolean[][] visited;
	static int cnt;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			max = -1;
			N = sc.nextInt();
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			

			System.out.printf("#%d %d\n", t, max);
		}
	}

}
