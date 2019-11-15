package bochung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Beakjoon4485_젤다 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] m = new int[125][125];
	static int[][] memo = new int[125][125]; // (0,0) ~(r,c) 까지의 최소비용을 저장할 배열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int testCase = 1; ; testCase++) {
			int N = Integer.parseInt(br.readLine()); // 동굴의 크기 N (2 <= N <= 125)
			if( N == 0) break; // 프로그램 종료
			
			
			for(int i =0 ; i < N ;i++) {
				String line = br.readLine();
				for(int j = 0, index = 0; j < N; j++, index += 2) {
					m[i][j] = line.charAt(index) - '0';
					memo[i][j] = Integer.MAX_VALUE;
				}
			}

//			Queue<int[]> q = new LinkedList<int[]>(); // [0]:r, [1]:c, [2]:(0,0) ~(r,c) 까지의 최소비용
			
			// 우선순위큐, 비용이 최소인 정점 부터 꺼내자.
			PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});
			
			memo[0][0] = m[0][0];
			q.add(new int[] {0,0,memo[0][0]});
			while(!q.isEmpty()) {
				// 큐에서 값을 꺼내기
				int[] data = q.poll();
				int r = data[0];
				int c = data[1];
				int cost = data[2]; // (0,0) ~ (r,c) 까지의 최소비용
			
				if(memo[r][c] < cost) continue; // 가지치기
				// 꺼낸 정점에 인접한 정점들을 방문
				for(int i = 0; i < dr.length; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if(nr < 0 || nr >= N || nc < 0 || nc >=N) continue;
					if(memo[nr][nc] <= memo[r][c] + m[nr][nc]) continue;
					memo[nr][nc] = memo[r][c] + m[nr][nc]; // 최소비용 업데이트
					q.offer(new int[] {nr, nc, memo[nr][nc]}); // 큐에 추가
				}
			}
			System.out.println("Problem "+testCase+": "+memo[N-1][N-1]);
			
		}
		
	}

}
