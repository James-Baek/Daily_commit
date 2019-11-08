package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11657 {
	static final int INF = Integer.MAX_VALUE;
	static int count, edgeCount;
	static int[] distance;
	static Edge[] edges;
	
	static class Edge{
		int from,to, time;
		public Edge(int from, int to, int time) {
			this.from = from;
			this.to = to;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		count = Integer.parseInt(st.nextToken());
		edgeCount = Integer.parseInt(st.nextToken());
		distance = new int[count]; // 1번 도시에서 각도시로 오는 최소시간
		edges = new Edge[edgeCount];
		Arrays.fill(distance, INF);
		for(int i = 0; i < edgeCount; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			edges[i] = new Edge(Integer.parseInt(st.nextToken())-1,
								Integer.parseInt(st.nextToken())-1,
								Integer.parseInt(st.nextToken()));	
		}
		distance[0] = 0;
		if(goNegativeCycle()) {
			System.out.println(-1);
		}else{
			for(int d = 1; d < count; ++d) {
				System.out.println(distance[d] == INF ? -1 : distance[d]);
			}
		}
		
		
	}
	private static boolean goNegativeCycle() {
		for(int i = 1; i <= count; i++) {
			for(Edge e : edges) { // from -> to
				if(distance[e.from] == INF) continue;
				if(distance[e.from] + e.time < distance[e.to] ) {
					distance[e.to] = distance[e.from] + e.time;
					if(i==count) return true; // 최소시간 업데이트 된 경우의 라운드가 정점카운트와 동일하다면 음수싸이클 존재한다는 의미
				}
			}
		}
		return false;
	}

}
