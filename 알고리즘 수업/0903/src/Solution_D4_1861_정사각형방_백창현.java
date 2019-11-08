import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D4_1861_정사각형방_백창현 {
	static int N;
	static int cnt;
	static int max;
	static int ans;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		int cnt = 0;
		max = 1;
		ans = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				queue.offer(i*10000+j);
				cnt = 0;

				while(!queue.isEmpty()) {
					if(cnt > max) {
						max = cnt;
						ans = map[i][j];
					}else if(cnt == max) {
						if(ans > map[i][j]) {
							ans = map[i][j];
						}
					}
					if(max == N*N) {
						return;
					}
					int base = queue.poll();
					cnt++;
					int base_r = base/10000;
					int base_c = base%10000;

					for(int dir = 0; dir < 4; dir++) {
						int nr = base_r + dr[dir];
						int nc = base_c + dc[dir];
						if(nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc]-1 != map[base_r][base_c]) continue;
						queue.offer(nr*10000+nc);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			bfs();
			
			System.out.printf("#%d %d %d\n", t, ans, max+1);
		}
		
	}

}
