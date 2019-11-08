package Jungol;

import java.util.Scanner;

public class jungol1309 {
	static int N;
	static long sum;
	
	public static long factorial(int num) {
		if(num <= 1) {
			return num;
		}
		sum = num * factorial(num-1);

		return sum;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sum = 0;
		for(int i = N; i >= 1; --i) {
			if(i == 1) {
				System.out.printf("%d! = %d\n", i, i);
			}else {
				System.out.printf("%d! = %d * %d!\n", i, i, i-1);
			}
		}
		System.out.println(factorial(N));
	}
}
