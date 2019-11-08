import java.util.Scanner;

public class stick {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] D = new int[N+1];
		D[0] = 1;
		D[1] = 2;
		for(int i = 2; i<= N; ++i) {
			D[i] = D[i-1]*2 + D[i-2];
		}
		System.out.println(D[N]);
	}

}
