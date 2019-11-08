package SWEA;

import java.util.Scanner;

// SWEA 7206 숫자게임
public class Solution7206 {
	static int cnt;
	static int max;
	public static void dfs(int N) {
		if(N < 10) {
			if(max < cnt) max = cnt;
		}
		for()
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		cnt = 0;
		max = 0;
		dfs(N);
	}

}
