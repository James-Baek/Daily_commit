package com.ssafy.step1.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import com.ssafy.step1.mst.PrimTest2_최적화.Vertex;

public class djikstra2 {
	static class Vertex implements Comparable<Vertex>{
		int vertex;
		int weight;
		public Vertex(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
		@Override
		public int compareTo(Vertex o) {

			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int end = N - 1;
		int[][] adjMatrix = new int[N][N]; // 인접행렬
		boolean[] visited = new boolean[N]; // 정점방문여부
		int[] distance = new int[N]; // 시작정점에서 각정점까지 이르는 최소비용
		final int INF = Integer.MAX_VALUE;
		Arrays.fill(distance, INF);
		
		StringTokenizer st;
		for(int i = 0; i < visited.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}// i노드에서 j노드들까지 비용 저장.
		

		distance[0] = 0; // 출발정점 : 0-0까지의 최소비용 0으로 처리
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		queue.offer(new Vertex(0, distance[0]));
		
		while(!queue.isEmpty()) {
			// a단계 : 방문하지 않은 정점 중 최소가중치의 정점 선택
			Vertex current = queue.poll(); // 최소비용이 정점 선택
			if(visited[current.vertex]) continue;
			visited[current.vertex] = true;
			if(current.vertex == end) break;
			
			for(int j = 0; j < N; ++j) {
				if(!visited[j] // 방문하지 않은 j 정점
						&& current.weight + adjMatrix[current.vertex][j] < distance[j] // 시작-current-j 비용 < 시작 -j비용
								&& adjMatrix[current.vertex][j] !=0) { // currnet와 인접해 있는 j정점
					distance[j] = current.weight + adjMatrix[current.vertex][j];
					queue.offer(new Vertex(j, distance[j]));
				}
			}
		}
		
//		for(int i = 0; i < N; ++i) {
//			
//			min = INF;
//			for(int j = 0; j < N; ++j) {
//				if(!visited[j] && distance[j] < min) {
//					min = distance[j];
//					current = j;
//				}
//			}
//			visited[current] = true;
//			
//			if(current == end) break;
//			
//			//b단계 : current정점을 경유지로 하여 갈 수 있는 다른 방문하지 않은 정점들에 대한 고려
//			for(int j = 0; j < N; ++j) {
//				if(!visited[j] // 방문하지 않은 j 정점
//						&& min + adjMatrix[current][j] < distance[j] // 시작-current-j 비용 < 시작 -j비용
//								&& adjMatrix[current][j] !=0) { // currnet와 인접해 있는 j정점
//					distance[j] = min + adjMatrix[current][j];
//				}
//			}
//			
//		}
		System.out.println(distance[end]);
	}

}
