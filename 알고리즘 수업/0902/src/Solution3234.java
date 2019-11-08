import java.util.Arrays;
import java.util.Scanner;

// 준환이의 양팔저울

public class Solution3234 {
	static int N;
	static int[] num;
	static int[] selected;
	static boolean[] visited;
	static int cnt;
	
	static int[] sumList;
	static int c_sum;
	
	public static void combi(int idx, int start) {
		if(idx == N) {
			return;
		}
		
		for(int i = start; i < N; i++) {
			c_sum += num[selected[i]];
			if(sumList[i] - c_sum >= c_sum) {
				cnt++;
				combi(idx+1, start+1);
			}
			c_sum -= num[selected[i]];
		}
	}
	public static void permu(int idx) {
		if(idx == N) {
			sumList = new int[N];
			c_sum = 0;
			sumList[0] = num[selected[0]];
			for(int i = 1; i < N; i++) {
				sumList[i] = sumList[i-1] + num[selected[i]];
			}
			combi(1,1);
			cnt++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			selected[idx] = i;
			permu(idx+1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			num = new int[N];
			selected = new int[N];
			visited = new boolean[N];
			cnt = 0;
			for(int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}
			permu(0);
			
			System.out.printf("#%d %d\n", t, cnt);
		}
		
	}

}
