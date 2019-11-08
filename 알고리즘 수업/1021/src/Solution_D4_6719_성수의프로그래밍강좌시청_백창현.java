import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_6719_성수의프로그래밍강좌시청_백창현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			double ans = 0.0;
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] num = new int[N];
			
			for(int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}
			Arrays.sort(num);
			
			for(int i = N-K; i < N; i++) {
				ans += num[i];
				ans /= 2;
			}
			System.out.printf("#%d %f\n", t, ans);
		}
	}

}
