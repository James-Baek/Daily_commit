package com.ssafy.step1.mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class djikstra {

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
		
		int min = 0, current = 0;
		distance[0] = 0; // 출발정점 : 0-0까지의 최소비용 0으로 처리
		for(int i = 0; i < N; ++i) {
			
			min = INF;
			for(int j = 0; j < N; ++j) {
				if(!visited[j] && distance[j] < min) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;
			
			if(current == end) break;
			
			//b단계 : current정점을 경유지로 하여 갈 수 있는 다른 방문하지 않은 정점들에 대한 고려
			for(int j = 0; j < N; ++j) {
				if(!visited[j] // 방문하지 않은 j 정점
						&& min + adjMatrix[current][j] < distance[j] // currnet와 인접해 있는 j정점
								&& adjMatrix[current][j] !=0) { // 시작-current-j 비용 < 시작 -j비용
					distance[j] = min + adjMatrix[current][j];
				}
			}
			
		}
		System.out.println(distance[end]);
	}

}
