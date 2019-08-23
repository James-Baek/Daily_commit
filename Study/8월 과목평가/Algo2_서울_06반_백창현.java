import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo2_서울_06반_백창현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		int[][] map = new int[R+(R+1)][C+(C+1)];
		boolean[][] visited = new boolean[R+(R+1)][C+(C+1)];
		
		// 가로 채우기
		for(int i = 0; i < C+(C+1); i++) {
			map[0][i] = -1;
		}
		
		for(int i = 0; i < C+(C+1); i++) {
			map[R+R][i] = -1;
		}
		
		// 세로 채우기
		for(int i = 0; i < R+(R+1); i++) {
			map[i][0] = -1;
		}
		
		for(int i = 0; i < R+(R+1); i++) {
			map[i][C+C] = -1;
		}
		
		for(int i = 1; i < R+(R+1); i+=2) {
			for(int j = 1; j < C+(C+1); j+=2) {
				map[i][j] = 1;
			}
		}
		
		int N = sc.nextInt();
		for(int n = 0 ; n < N; n++) {
			int type = sc.nextInt();
			int location = sc.nextInt()*2;
			
			// 0 가로, 1 세로
			switch(type) {
			case 0:
				for(int i = 0; i < C+(C+1); i++) {
					map[location][i] = 2;
				}
				break;
			case 1:
				for(int i = 0; i < R+(R+1); i++) {
					map[i][location] = 2;
				}
				break;
			}
		}
		
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		int max = 0;
		for(int i = 1; i < R+R; i++) {
			for(int j = 1; j < C+C; j++) {
				if(visited[i][j]) continue;
				int r = i;
				int c = j;
				int cnt = 0;

				Queue<Integer> queue = new LinkedList<Integer>();
				queue.offer(r*100 + c);
				while(!queue.isEmpty()) {
					int temp = queue.poll();
					int nowr = temp / 100;
					int nowc = temp % 100;
					if(visited[nowr][nowc] || map[nowr][nowc] == 2) continue;
					cnt += map[nowr][nowc];
					visited[nowr][nowc] = true;
					
					for(int dir = 0; dir < 4; dir++) {
						int nr = nowr + dr[dir];
						int nc = nowc + dc[dir];
						if(nr < 1 || nr >=R+R || nc < 1 || nc >=C+C || visited[nr][nc] || map[nr][nc] == 2) {
							continue;
						}
						queue.offer(nr * 100 + nc);
					}
				}
				max = max > cnt ? max : cnt;
			}
		}

		System.out.println(max);
	}

}
