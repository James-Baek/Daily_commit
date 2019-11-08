package Jungol;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Jungol1841 {
	static int ans;
	static int sum;
	static int firstsum = 0;
	static int midsum = 0;
	static int lastsum = 0;
	static int[][] input;
	static int[][] map;
	static int[][] game;
	
	public static void dfs(int team, int cnt) {
		if(ans == 1) return;
		if(cnt == 30) {
			ans = 1;
			return;
		}
		
		for(int i = 0; i < 6; i++) {
			if(team == i) continue;
			if(game[team][i] == 0) {
				if(map[team][i] == 1)
			}
			game[team][i] = map[team][i];
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = new int[6][3];
		map = new int[6][6];
		game = new int[6][6];
		
		
		for(int t = 0; t < 4; t++) {
			boolean isFind = false;
			ans = 0;
			sum = 0;
			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 3; j++) {
					input[i][j] = sc.nextInt();
					sum += input[i][j];
					if(input[i][j] >= 6 || input[i][j] < 0) isFind = true;
					
				}
			}
			
			for(int i = 0; i < 6; i++) {
				firstsum += input[i][0];
				midsum += input[i][1];
				lastsum+= input[i][2];
			}
			
			// 불가능 가지치기
			if(sum != 30) {
				System.out.println(ans);
				continue;
			}else if(isFind) {
				System.out.println(ans);
				continue;
			}else if(midsum % 2 != 0) {
				System.out.println(ans);
				continue;
			}else if(firstsum != lastsum) {
				System.out.println(ans);
				continue;
			}

			
			Arrays.sort(input, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return o1[0] > o2[0] ? -1 : 1;
				};
			});
			
			dfs(0,0);
			
			System.out.println(ans);
		}

	}

}
