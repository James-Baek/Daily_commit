import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1733_오목_백창현 {
	static int[][] map;
	static final int LIMIT = 19;
						// 상하, 좌우, 좌상우하, 좌하우상
	static int[][] dr = {{-1,1}, {0,0}, {-1,1}, {1,-1}};
	static int[][] dc = {{0,0}, {-1,1},{-1,1},{-1,1}};
	static int ans_r;
	static int ans_c;
	public static boolean findFive(int r, int c) {
		for(int dir = 0; dir < 4; dir++) {
			int cnt = 1;
			int nr = r;
			int nc = c;
			int base = map[r][c];
			ans_r = nr;
			ans_c = nc;
			for(int dir2 = 0; dir2 < 2; dir2++) {
				nr = r;
				nc = c;
				for(int i = 0; i < 5; i++) {
					nr += dr[dir][dir2];
					nc += dc[dir][dir2];
					if(nr < 0 || nr >= LIMIT || nc < 0 || nc >= LIMIT || map[nr][nc] == 0) break;
					if(base == map[nr][nc]) {
						if(dir2 == 0) {
							ans_r = nr;
							ans_c = nc;
						}
						cnt++;
					}
					else break;
				}
			}
			if(cnt == 5) return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[LIMIT][LIMIT];
		
		for(int i = 0; i < LIMIT; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < LIMIT; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < LIMIT; i++) {
			for(int j = 0; j < LIMIT; j++) {
				if(map[i][j] == 0) continue;
				if(findFive(i, j)) {
					System.out.println(map[i][j]);
					System.out.println((ans_r+1)+" "+(ans_c+1));
					return;
				}
			}
		}
		System.out.println("0");
	}

}
