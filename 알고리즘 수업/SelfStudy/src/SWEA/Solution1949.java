package SWEA;
import java.util.*;

public class Solution1949 {
	static int[][] map;
	static boolean[][] visited;
	static int max;
	static int N;
	static int K;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int ans = 0;
		
		for(int t = 1; t < T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			sc.nextLine();
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				String[] row = sc.nextLine().split(" ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(row[j]);
				}
			}

			System.out.printf("#%d %d\n", t, ans);
		}
	}

}
