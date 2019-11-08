package HW;

import java.util.Scanner;

public class Main_1681_해밀턴순환회로_백창현 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	public static void dfs(int idx, int from, int sum) {
		if(min < sum) return;
		if(idx == N-1) {
			if(map[from][0] == 0) return;
			if(min > sum + map[from][0]) min = sum + map[from][0];
		}
		
		for(int i = 1; i < N; i++) {
			if(visited[i]) continue;
			if(map[from][i] == 0) continue;
			visited[i] = true;
			dfs(idx+1, i, sum+map[from][i]);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		visited = new boolean[N];
		dfs(0, 0, 0);
		
		System.out.println(min);
	}

}
