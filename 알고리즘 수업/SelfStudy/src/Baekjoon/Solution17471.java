package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 *
 *6
5 2 3 4 1 2
2 2 4
4 1 3 6 5
2 4 2
2 1 3
1 2
1 2
 */
public class Solution17471 {
	static int N;
	static int[] human;
	static boolean[][] map;
	static int[][] map2;
	static Queue<Integer> A_group;
	static Queue<Integer> B_group;
	static boolean[] A_connect;
	static boolean[] B_connect;
	static int ans = -1;
	
	public static int bfs() {
		
		boolean[] A_A = new boolean[N];
		boolean[] B_B = new boolean[N];
		
		for(int v : A_group) {
			for(int i = 0; i < N; i++) {
				if(B_group.contains(i)) {
					continue;
				}
				if(map[v][i] == true) {
					A_A[i] = true;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			if(A_connect[i] != A_A[i]) return -1;
		}
		for(int v : B_group) {
			for(int i = 0; i < N; i++) {
				if(A_group.contains(i)) {
					continue;
				}
				if(map[v][i] == true) {
					B_B[i] = true;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			if(B_connect[i] != B_B[i]) return -1;
		}
		
		int A_sum = 0;
		int B_sum = 0;
		
		for(int i : A_group) {
			A_sum += human[i];
		}
		
		for(int i : B_group) {
			B_sum += human[i];
		}
		
		return Math.abs(A_sum - B_sum);
	}
	
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st =  new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 human = new int[N];
		 map = new boolean[N][N];
		 map2 = new int[N][N];
		 st = new StringTokenizer(br.readLine());
		 for(int i = 0; i < N; i++) {
			 human[i] = Integer.parseInt(st.nextToken());
		 }
		 
		 for(int i = 0; i < N; i++) {
			 map[i][i] = true;
		 }
		 
		 for(int i = 0; i < N; i++) {
			 st = new StringTokenizer(br.readLine());
			 int edge = Integer.parseInt(st.nextToken());
			 for(int j = 0; j < edge; j++) {
				 int v = Integer.parseInt(st.nextToken())-1;
				 map[i][v] = true;
				 map[v][i] = true;
				 map2[i][v] = 1;
				 map2[v][i] = 1;
			 }
		 }
		 
		 for(int i = 1; i < (1 << N)-1; i++) {
			 A_group = new LinkedList<Integer>();
			 B_group = new LinkedList<Integer>();
			 A_connect = new boolean[N];
			 B_connect = new boolean[N];
			 
			 for(int j = 0; j < N; j++) {
				 if((i & 1 << j) != 0) {
					 A_group.offer(j);
					 A_connect[j] = true;
				 }else {
					 B_group.offer(j);
					 B_connect[j] = true;
				 }
			 }
			 int temp_sum = bfs();
			 if(temp_sum == -1) {
				 
			 }else {
				 if(ans == -1) ans = temp_sum;
				 else		   ans = ans < temp_sum ? ans : temp_sum;
			 }
		 }
		 
		 System.out.println(ans);
	}

}
