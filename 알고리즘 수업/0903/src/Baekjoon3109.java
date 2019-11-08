import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon3109 {
	static int[] dr = {-1,0,1};
	static int[] dc = {1,1,1};
	static int N;
	
	public static void dfs() {
		
		for(int i = 0; i < N; i++) {
			
		}
	}
	
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		boolean[][] map = new boolean[R][C];
		for(int i = 0; i < R; i++) {
			char[] input = sc.next().toCharArray();
			boolean isclear = false;
			for(int j = 0; j < C; j++) {
				if(input[j] == 'x') {
					map[i][j] = true;
				}
			}
		}
		int max = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i = 0; i < R; i++) {
				int cnt = 0;
				queue.offer(i*100000);
				while(!queue.isEmpty()) {
					int xy = queue.poll();
					int x = xy/100000;
					int y = xy%100000;
					if(y == C-1) {
						max++;
						
						break;
					}
					for(int dir = 0; dir < 3; dir++) {
						int nr = x + dr[dir];
						int nc = y + dc[dir];
						if(nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc]) continue;
						else {
							map[nr][nc] = true;
							queue.offer(nr*100000+nc);
						}
					}
				}
			
		}
		System.out.println(max);
	}
}
