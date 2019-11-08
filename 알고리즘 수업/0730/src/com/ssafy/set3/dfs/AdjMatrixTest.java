package com.ssafy.set3.dfs;

import java.util.Stack;

public class AdjMatrixTest {
	static int[][] matrix;
	static int totaLV;
	static boolean[] visited;
	
	public static void dfs1() {
		Stack<Integer> stack = new Stack<Integer>();
		visited = new boolean[totaLV];
		
		int current = 0;
		visited[current] = true;
		System.out.printf(" %c",current+65);
		
		do {			
			for(int i = 0; i < totaLV; i++) {
				if(matrix[current][i] == 1 && !visited[i]) {
					stack.push(current); // 메소드 콜
					current = i; // 매개변수 전달
					visited[current] = true;
					System.out.printf(" %c",current+65);
					i = -1; // 인접정점 방문 시작위해 0으로 만들어지도록 밑작업
				}
			}
		}while(!stack.isEmpty() && (current = stack.pop()) != -1);
	}
	
	public static void dfs2(int current) {
		visited[current] = true;
		System.out.printf(" %c", current+65);
		for(int i = 0; i < totaLV; i++) {
			if(matrix[current][i] == 1 && !visited[i]) { // 인접정점이며 미방문상태이면
				dfs2(i);
			}
		}
	}
	
	public static void main(String[] args) {
		totaLV = 7;
		matrix = new int [][]{
				  {0,1,1,0,0,0,0},
				  {1,0,0,1,1,0,0},
				  {1,0,0,0,1,0,0},
				  {0,1,0,0,0,1,0},
				  {0,1,1,0,0,1,0},
				  {0,0,0,1,1,0,1},
				  {0,0,0,0,0,1,0}};
		visited = new boolean[totaLV];
				  
		//dfs1();
		dfs2(0);
	}

}
