package bochung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Jungol1113ver2 {
	//상,하,좌,우
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	private static int M;
	private static int N;
	private static int m;
	private static int n;
	private static int[][] map;
	private static int[][] visited;	// 턴의 회수를 저장할 변수
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

		bfs();
		System.out.println(visited[m][n]);
	}
	
	public static class Local {
		int r, c, turn, dir;
		private Local(int r, int c, int turn, int dir) {
			this.r = r;
			this.c = c;
			this.turn = turn;
			this.dir = dir;
		}
	}
	
	public static void bfs() {
		// visited 배열의 턴의 회수의 초기값을 가장 큰값으로
		visited = new int[M][N];	// 턴의 회수를 저장할 변수
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		Queue<Local> q = new LinkedList<Local>();
		visited[0][0] = 0; // 턴의 회수
		q.add(new Local(0,0,0,DOWN));
		q.add(new Local(0,0,0,RIGHT));
		
		while(!q.isEmpty()) {
			Local lo = q.poll(); // 큐의 값을 꺼내
			int r = lo.r;
			int c = lo.c;
			if(r == m && c == n) continue;
			int dir = lo.dir;
			int turn = lo.turn;
			
			// 꺼낸 좌표의 상하좌우 인접칸을 큐에 넣기
			for(int d = 0; d < 4; d++) { // 상, 위쪽칸 길이 있는가? 위쪽칸에 저장된 턴의 개수보다 적을때만 진입
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
				int tempturn = (dir == d ? turn : turn+1);
				if(visited[nr][nc] < tempturn|| map[nr][nc] != 1) continue;
				visited[nr][nc] = tempturn;
				q.add(new Local(nr, nc, tempturn, d));
			}
			
		}
	}

}
