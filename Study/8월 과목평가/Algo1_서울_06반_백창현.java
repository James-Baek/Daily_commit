import java.util.Scanner;

public class Algo1_서울_06반_백창현 {
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int ans = 0;
		
		for(int t = 1; t <= T; t++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			map = new int[R][C];
			visited = new boolean[R][C];
			
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					map[i][j] = sc.next().charAt(0)-'0';
					if(map[i][j] == 23 || map[i][j] == 39) {

					}
				}
			}
			// true는 못감.
			int max = 0;
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					int cnt = 0;
					if(map[i][j] == 23) {
						for(int dir = 0; dir < 4; dir++) {
							int nr = i;
							int nc = j;
							while(true) {
								nr = nr + dr[dir];
								nc = nc + dc[dir];
								if(nr < 0 || nr >=R || nc < 0 || nc >=C || map[nr][nc] == 23 || map[nr][nc] == 39) {
									break;
								}
								if(map[nr][nc] == 36 && !visited[nr][nc]) {
									visited[nr][nc] = true;
									cnt++;
									break;
								}
							}
						}
					}
					max += cnt;
				}
			}

			
			System.out.printf("#%d %d\n", t, max);
		}
	}

}


/*
2
5 7 
T 0 T 0 G 0 G 
0 W T W W W 0
T W G 0 T W T
0 0 0 T G W 0
0 0 T 0 0 W 0
2 10
T W 0 G 0 W 0 G 0 W
G 0 T W T 0 T W T 0

*/