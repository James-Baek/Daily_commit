package WS;

import java.util.Scanner;

public class Solution_D5_1247_최적경로_백창현 {
	static int T;
	static int[] customer;
	static int[] selected;
	static boolean[] visited;
	static int home;
	static int company;
	static int now;
	static int N;
	static int min;
	
	public static void pathFind(int idx) {
		if(idx == N) {
			int dist = 0;
			int temp_dist = 0;
			now = company;
			for(int i = 0; i < N; i++) {
				int now_x = now / 1000;
				int now_y = now % 1000;
				int cust_x = customer[selected[i]] / 1000;
				int cust_y = customer[selected[i]] % 1000;
				
				temp_dist = Math.abs(now_x - cust_x) + Math.abs(now_y - cust_y);
				now = customer[selected[i]];
				dist += temp_dist;
				if(dist >= min) return;
//				dist += (temp_dist / (int)1000) + (temp_dist % (int)1000);
			}
			int now_x = now / 1000;
			int now_y = now % 1000;
			int home_x = home / 1000;
			int home_y = home % 1000;
			
			temp_dist = Math.abs(now_x - home_x) + Math.abs(now_y - home_y);
			dist += temp_dist;
			min = min < dist ? min : dist;
			return;
		}
		
		for(int i = 0; i < customer.length; i++) {
			if(visited[i] == true) continue;
			visited[i] = true;
			selected[idx] = i;
			pathFind(idx+1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			min = Integer.MAX_VALUE;
			N = sc.nextInt();
			visited = new boolean[N];
			customer = new int[N];
			selected = new int[N];
			
			company = sc.nextInt() * 1000 + sc.nextInt();
			home = sc.nextInt() * 1000 + sc.nextInt();
			
			for(int i = 0 ; i < N; i++) {
				customer[i] = sc.nextInt() * 1000 + sc.nextInt();
			}
			
			pathFind(0);
			System.out.printf("#%d %d\n", t, min);
		}
	}
}
