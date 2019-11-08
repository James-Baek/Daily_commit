package bochung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol1113 {
	//상,하,좌,우
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static int M;
	private static int N;
	private static int m;
	private static int n;
	private static int[][] map;
	private static boolean[][] visited;
	private static int min;
	private static final int UP = 0;
	private static final int DOWN = 1;
	private static final int LEFT = 2;
	private static final int RIGHT = 3;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());	// 행 지도의 크기 1 <= M <= 100
		N = Integer.parseInt(st.nextToken());	// 열
		
		st = new StringTokenizer(br.readLine()," ");
		m = Integer.parseInt(st.nextToken());	// 목표점
		n = Integer.parseInt(st.nextToken());
		map = new int[M][N]; // 도로 맵 
		for(int i =0; i < M; i++) {
			String str = br.readLine(); // 쪼개지 않고 읽어오기
			for(int j = 0, index = 0; j < map.length; j++, index += 2) {
				map[i][j] = str.charAt(index) - '0'; // 숫자글자를 숫자로 변환
			}
		}
		visited = new boolean[M][N];
		min = Integer.MAX_VALUE;
		visited[0][0] = true;
		dfs(0,0,-1, -1); // 턴
		System.out.println(min);
	}
	public static void dfs(int r, int c, int turn, int dir) {
		if(min <= turn) return; // 가지치기
		if(r == m && c == n) { // 도착지점에 도착시 종료
			if(min > turn) {
				min = turn; // 최소값이면 업데이트
			}
			return;
		}
		// 상하좌우 재귀호출, 길이 있는 경우, 방문하지 않은 경우
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
			if(visited[nr][nc] || map[nr][nc] != 1) continue;
			visited[nr][nc] = true;
			dfs(nr, nc, (dir==d ? turn : turn+1), d);
			visited[nr][nc] = false;
		}
	}

}
