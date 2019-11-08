import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_D4_1258_행렬찾기_백창현 {
	
	static int N;
	static int cnt;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> ans;
	
	
	public static void find() {
		int start_r = 0;
		int start_c = 0;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(visited[r][c]) continue;
				if(map[r][c] != 0) {
					int ans_r = 0;
					int ans_c = 0;
					
					start_r = r;
					start_c = c;
					while(map[start_r][start_c] != 0 && !visited[start_r][start_c]) {
						while(map[start_r][start_c] != 0 && !visited[start_r][start_c]) {
							visited[start_r][start_c] = true;
							start_c++;
						}
						start_r++;
						ans_c = start_c - c;
						start_c = c;
					}
					ans_r = start_r - r;
					ans.add(ans_r * 1000 + ans_c);
					cnt++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc .nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			map = new int[N][N];
			visited = new boolean[N][N];
			ans = new ArrayList<Integer>();
			cnt = 0;
			
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			find();
			String output = "";
			Collections.sort(ans, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					int first = (o1 / 1000) * (o1 % 1000);
					int second = (o2 / 1000) * (o2 % 1000);
					
					if(first == second) {
						return Integer.compare(o1/1000, o2/1000);
					}
					return Integer.compare(first, second);
				}
			});
			for(int temp : ans) {
				output += temp / 1000 + " " + temp % 1000 + " ";
			}
			System.out.printf("#%d %d %s\n", t, cnt, output);
		}
		
	}
}
