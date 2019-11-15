package bochung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Beakjoon1600_말원숭이BFS {

	private static int W;
	private static int H;
	private static int K;
	private static int[][] m;
	private static int minMoveCnt;
	private static int[] dr = {-1,-2,-2,-1,1,2, 2, 1,-1,1, 0,0};
	private static int[] dc = {-2,-1, 1, 2,2,1,-1,-2, 0,0,-1,1};
	
	private static boolean[][][] visited;

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
		visited = new boolean[H][W][K+1];
		visited[0][0][K] = true;
		
		Queue<int[]> q = new LinkedList<int[]>(); // {r, c, K, moveCnt}
		q.add(new int[] {0,0,K,0});	// K : 말처럼 이동할 수 있는 남은 회수, moveCnt : 현재까지 이동한 회수
		while(!q.isEmpty()) {
			// 큐에서 하나 꺼냄
			int[] arr = q.poll();
			int r = arr[0];
			int c = arr[1];
			int kk = arr[2];
			int moveCnt = arr[3];
			
			// 목적지에 도착하면 최소값 업데이트
			if(r == H-1 && c == W-1) { // 목적지 : 우측하단
				if(minMoveCnt > moveCnt) {
					minMoveCnt = moveCnt;
				}
				break; // 가장 적은 이동회수로 도착
			}
			if(minMoveCnt <= moveCnt) continue; // 가지치기
			// 이동경로들을 큐에 넣기(방문체크)
			// 상하좌우
			for(int i = 8; i < dc.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr < 0 || nr >= H || nc < 0 || nc >= W || visited[nr][nc][kk] || m[nr][nc] == 1) continue;
				visited[nr][nc][kk] = true;
				q.offer(new int[] {nr, nc, kk, moveCnt+1});
			}
			// 말처럼 이동할 수 있는 회수가 있는 경우만 진행
			if(kk == 0) continue; // 다음턴
			for(int i = 0; i < 8; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(nr < 0 || nr >= H || nc < 0 || nc >= W || visited[nr][nc][kk-1] || m[nr][nc] == 1) continue;
				visited[nr][nc][kk-1] = true;
				q.offer(new int[] {nr, nc, kk-1, moveCnt+1});
			}
			
		}

		System.out.println(minMoveCnt == Integer.MAX_VALUE ? -1 : minMoveCnt);
	}
	
} // end of class
