package com.ssafy.step1.mst;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PrimTest {

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
		
		int index=0, min=0, result=0;
		
		//임의의 정점(0)을 첫 정점으로 연결
		visited[0] = true;
		list.add(0);
		result = 0;
		
		for(int c = 0; c < N-1; c++) { // 위에서 한개의 정점을 택했으므로 n-1개 정점만큼 반복
			// 기존에 방문한 모든 정점들을 기준으로 최소비용으로 방문가능한 정점 찾기
			min = Integer.MAX_VALUE;
			index = 0;
			for(Integer i : list) { // 방문했던 노드 하나씩 꺼내어 처리
				for(int j = 0; j <N; j++) {
					if(!visited[j] && adjMatrix[i][j] != 0 && adjMatrix[i][j] < min) {
						min = adjMatrix[i][j];
						index = j; // 최소비용으로 연결할 수 있는 정점 기억
					}
				}
			}
			visited[index] = true; // 정점 방문처리
			list.add(index); // 방문리스트에 추가
			result += min; // 신장트리 비용 누적	
		}
		System.out.println(result);
	}

}
