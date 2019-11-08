package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baekjoon1717 {
	static int N, M;
	static int[] root;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		root = new int[N+1];
		Arrays.fill(root, -1);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			if(type == 0) {
				disjoint(from, to);
			}else if(type == 1){
				int a = findSet(from);
				int b = findSet(to);
				if(a != b) {
					System.out.println("NO");
				}else {
					System.out.println("YES");
				}
			}
		}
	}
	
	public static int findSet(int a) {
		if(root[a] < 0) return a;
		
		return root[a] = findSet(root[a]);
	}
	
	public static boolean disjoint(int from, int to) {
		int a = findSet(from);
		int b = findSet(to);
		
		if(a != b) {
			root[b] = a;
			return true;
		}
		return false;
	}
	
}
