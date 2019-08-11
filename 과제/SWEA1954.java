package ssafy;
import java.util.*;

public class SWEA1954 {
	static int N;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			int[][] map = new int[N][N];
			int cnt = 1;
			int r = 0;
			int c = 0;
			int idx = 0;
			int nr = 0;
			int nc = 0;
			
			while(true) {
				
				map[r][c] = cnt;
				nr = r + dr[idx%4];
				nc = c + dc[idx%4];
				cnt++;
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
					nr = nr - dr[idx%4];
					nc = nc - dc[idx%4];
					
				}else {
					if(cnt > N*N) {
						break;
					}

				}
				
				//다음이 0이 아니면 
				if(map[nr][nc] != 0) {
					// 현위치에서 방향전환
					idx++;
					r = r + dr[idx%4];
					c = c + dc[idx%4];
				}else {
					r = nr;
					c = nc;
				}

			}
			
			// 출력
			System.out.printf("#%d\n", t);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}
	}

}
