import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_D4_1494_사랑의카운슬러_백창현 {
	static int N;
	static long ans_x;
	static long ans_y;
	static long ans;
	static int[][] worms;
	static int[][] vector;
	static boolean[] done;
	
	public static void dfs() {
		int cnt = 0;
		int G = N - 1;
		if(N >= 4) {
			G = N - 2;
		}
		for(int i = 0 ; i < G; i++) {
			if(done[i]) continue;
			done[i] = true;
			int base_x = worms[i][0];
			int base_y = worms[i][1];
			int min_vx = base_x - worms[i+1][0];
			int min_vy = base_y - worms[i+1][1];
			int y = 0;
			
			for(int j = i+1; j < N; j++) {
				if(done[j]) continue;
				int target_x = worms[j][0];
				int target_y = worms[j][1];
				int temp_vx = base_x - target_x;
				int temp_vy = base_y - target_y;
				if((temp_vx * temp_vx * temp_vy * temp_vy) < (min_vx * min_vx * min_vy * min_vy)){
					min_vx = temp_vx;
					min_vy = temp_vy;
					y = j;
				}
			}
			done[y] = true;
			vector[cnt][0] = min_vx;
			vector[cnt][1] = min_vy;
			cnt++;
		}
		
		Arrays.sort(vector, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[0], o2[0]);
			}
		});
		
		ans_x = vector[0][0];
		ans_y = vector[0][1];
		
		for(int a = 1; a < vector.length; a++) {
			ans_x += Math.abs(vector[a][0]);
			ans_y += Math.abs(vector[a][1]);
		}
		ans = (ans_x * ans_x) + (ans_y * ans_y);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			worms = new int[N][2];
			done = new boolean[N];
			vector = new int[N/2][2];
			int min = 0;
			
			for(int i = 0; i < N; i++) {
				worms[i][0] = sc.nextInt();
				worms[i][1] = sc.nextInt();
				min = min > worms[i][0] ? worms[i][0] : min;
				min = min > worms[i][1] ? worms[i][1] : min;
			}
			
			min = Math.abs(min);
			for(int i = 0; i < N; i++) {
				worms[i][0] += min;
				worms[i][1] += min;
			}
			
			Arrays.sort(worms, new Comparator<int[]>() {
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[0], o2[0]);
				}
			});
			
			dfs();
			System.out.printf("#%d %d\n", t, ans);
		}
	}

}
