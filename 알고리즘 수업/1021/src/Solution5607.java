import java.util.Scanner;

public class Solution5607 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			long ans = 0;
			int N = sc.nextInt();
			int R = sc.nextInt();
			long top = 1;
			for(int i = N; i > N-R; i--) {
				top *= i;
				top %= 1234567891;
			}
			
			long bottom = 1;
			for(int i = 1; i <= R; i++) {
				bottom *= i;	
				bottom %= 1234567891;
			}
			
			ans = (top / bottom) % 1234567891;
			
			System.out.printf("#%d %d\n", t, ans);
		}
	}

}
