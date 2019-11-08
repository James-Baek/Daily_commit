package HW;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3_Coin_백창현 {
	static int[] exchange;
	static int[] coin = {5,10,16};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		exchange = new int[N+1];
		for(int i = 1; i < N+1; i++) {
			exchange[i] = exchange[i-1] + 1;
			for(int j = 0; j < coin.length; j++) {
				if(i - coin[j] >= 0) {
					exchange[i] = Integer.min(exchange[i], exchange[i-coin[j]]+1);
				}
			}
		}
		System.out.println("최소 교환 동전 수 : "+exchange[N]);
	}

}
