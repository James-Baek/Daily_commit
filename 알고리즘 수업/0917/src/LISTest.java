import java.util.Arrays;
import java.util.Scanner;

public class LISTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		int[] D = new int[N+1];
		
		for(int i = 1; i <= N; ++i) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 1; i <= N; ++i) {
			D[i] = 1;
			for(int j = 1; j < i; ++j) {
				if(arr[j] < arr[i] && D[j]+1>D[i]) {
					D[i] = D[j] + 1;
				}
			}
		}
		Arrays.sort(D);	
		System.out.println(D[N]);
	}
}
