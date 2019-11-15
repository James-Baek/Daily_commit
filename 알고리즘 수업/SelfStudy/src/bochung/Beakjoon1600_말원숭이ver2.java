package bochung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon1600_말원숭이ver2 {

	private static int W;
	private static int H;
	private static int K;
	private static int[][] m;
	private static int minMoveCnt;
	private static int[] dr = {-1,-2,-2,-1,1,2, 2, 1,-1,1, 0,0};
	private static int[] dc = {-2,-1, 1, 2,2,1,-1,-2, 0,0,-1,1};
	private static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());	 // 말처럼 이동할 수 있는 회수, 0 <= K <=30
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());	// 가로의 길이 W, 1 <= W, H <= 200
		H = Integer.parseInt(st.nextToken());   // 세로의 길이 H, 1 <= W, H <= 200
		m = new int[W][H];
		for(int i = 0; i < H; i++) {
			String str = br.readLine(); // 0:평지, 1:장애물
			for(int j = 0, index = 0; j < m.length; j++, index +=2) {
				m[i][j] = str.charAt(index) - '0';
			}
		}
		minMoveCnt = Integer.MAX_VALUE; //이동회수의 최소값
		dfs(0,0,K,0);
		System.out.println(minMoveCnt == Integer.MAX_VALUE ? -1 : minMoveCnt);
	}
	
	/** r,c좌표, K : 말처럼 이동할 수 있는 남은 회수, moveCnt : 현재까지 이동회수*/
	public static void dfs(int r, int c, int K, int moveCnt) {
		if(r == H-1 && c == W-1) { // 종료파트
			if(minMoveCnt > moveCnt) minMoveCnt = moveCnt;
			return;
		}
		
		if(minMoveCnt <= moveCnt) return; //가지치기
		
		// 재귀파트
			// 말처럼 이동
		if(K > 0) {
			for(int i = 0; i < 8; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
			if(nr < 0 || nr >= H || nc < 0 || nc >=W) continue; // 배열을 벗어나지 않았는지, 방문했는지 체크
			if(visited[nr][nc] == 1 || m[nr][nc] == 1) continue;
			visited[nr][nc] = 1;
			dfs(nr, nc, K-1, moveCnt+1);
			visited[nr][nc] = 0;
			}
		}
			// 상하좌우 인접한칸으로 이동
		
		for(int i = 0; i < dc.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr < 0 || nr >= H || nc < 0 || nc >=W) continue; // 배열을 벗어나지 않았는지, 방문했는지 체크
			if(visited[nr][nc] == 1 || m[nr][nc] == 1) continue;
			visited[nr][nc] = 1;
			dfs(nr, nc, K-1, moveCnt+1);
			visited[nr][nc] = 0;
		}
	}
} // end of class
