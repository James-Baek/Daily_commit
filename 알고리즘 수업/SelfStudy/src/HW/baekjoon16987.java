package HW;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class baekjoon16987 {
	static int N;
	static int[] selected;
	static boolean[] visited;
	static int max = 0;
	static int[][] eggs;
	
	public static void dfs(int idx, int cnt, int zerocnt) {
		if(zerocnt >= N-1 || idx == N) {
			if(cnt > max) max = cnt;
			return;
		}
		if(eggs[idx][0] <= 0) return;
		for(int i = 1; i < N; i++) {
			if(eggs[i][0] <= 0) continue;
			
			eggs[i][0] -= eggs[idx][1];
			eggs[idx][0] -= eggs[i][1];
			
			if(eggs[i][0] <= 0) {
				cnt++;
				zerocnt++;
			}
			if(eggs[idx][0] <= 0) {
				cnt++;
				zerocnt++;
			}
			
			dfs(idx+1, cnt, zerocnt);
			
			if(eggs[i][0] <= 0) {
				cnt--;
				zerocnt--;
			}
			if(eggs[idx][0] <= 0) {
				cnt--;
				zerocnt--;
			}
			eggs[i][0] += eggs[idx][1];
			eggs[idx][0] += eggs[i][1];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		eggs = new int[N][2];
		int cnt = 0;
		
		int[] base_egg = new int[2];

		for(int i = 0; i < N; i++) {
			eggs[i][0] = sc.nextInt();
			eggs[i][1] = sc.nextInt();
		}
		
		dfs(0, 0, 0);
				
		System.out.println(max);
	}
}
