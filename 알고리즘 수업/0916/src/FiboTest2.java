import java.util.Scanner;

public class FiboTest2 {
	static long[] call;
	static long callSum;
	static long[] result;
	public static long fibo(int n) {
		++call[n];
		++callSum;
		if(n <= 1) return n;
		if(result[n] != 0) return result[n];
		return result[n] = fibo(n - 2) + fibo(n - 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		call = new long[N+1];
		result = new long[N+1];
		
		System.out.println(fibo(N));
		for(int i = 0; i <= N; ++i) {
			System.out.println("fibo("+ i + ") : "+call[i]);
		}
		System.out.println(callSum);
	}
}
