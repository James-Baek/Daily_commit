import java.util.Scanner;

public class FiboTest {
	static long[] call;
	static long callSum;
	
	public static long fibo(int n) {
		++call[n];
		++callSum;
		if(n <= 1) return n;
		return fibo(n -2 ) + fibo(n -1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		call = new long[N+1];
		System.out.println(fibo(N));
		for(int i = 0; i <= N; ++i) {
			System.out.println("fibo("+ i + ") : "+call[i]);
		}
		System.out.println(callSum);
	}
}
