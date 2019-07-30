package ssafy;
import java.util.*;

public class dice {
	static int N;
	static int M;
	static int sum = 0;
	static int[] num;
	public static void dfs(int n) {
		if(sum > M) return;
		if(n == N) {
			if(sum == M) {
				for(int i = 0; i < N; i++) {
					System.out.print(num[i]+" ");
				}
				System.out.println();
			}
			return;
		}
		for(int i = 1; i <= 6; i++) {
			sum += i;
			num[n] = i;
			dfs(n+1);
			sum -= i;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> st = new Stack<Integer>();
		
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[N];
		
		dfs(0);
	}

}
