package com.ssafy.step1.mst;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class PrimTest2_최적화 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int[N][N]; // 인접행렬
		boolean[] visited = new boolean[N]; // 정점방문여부
		ArrayList<Integer> list = new ArrayList<Integer>(); // 방문한 정점번호 리스트
		StringTokenizer st;
		for(int i = 0; i < visited.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}// i노드에서 j노드들까지 비용 저장.
		
		int count=0, result=0;
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		//임의의 정점(0)을 첫 정점으로 연결
		queue.offer(new Vertex(0, 0));
		
		
		while(!queue.isEmpty()) {
			Vertex current = queue.poll(); // 최소비용이 정점 선택
			
			if(visited[current.vertex]) continue;
			result += current.weight;
			visited[current.vertex] = true;
			if(++count == N) break;
			
			for(int i = 0; i < N; i++) {
				if(!visited[i] && adjMatrix[current.vertex][i] != 0) {
					queue.offer(new Vertex(i, adjMatrix[current.vertex][i]));
				}
			}
		}
		System.out.println(result);
	}
	
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

}
