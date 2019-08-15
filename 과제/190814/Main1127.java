package Jungol;

import java.util.Arrays;
import java.util.Scanner;

public class Main1127 {
	static int N;
	static int[][] num;
	static int[] selected_num;
	static int min;
	
	public static void combi(int idx, int start, int limit) {
		if(idx == limit) {
			int tempS = 1;
			int tempB = 0;
			int tempMax = 0;
			
			for(int i = 0; i < limit; i++) {
				tempS *= num[selected_num[i]][0];
				tempB += num[selected_num[i]][1];
			}
			tempMax = Math.abs(tempS - tempB);
			min = min < tempMax ? min : tempMax;
			return;
		}
		for(int i = start; i < num.length; i++) {

			selected_num[idx] = i;
			combi(idx+1, i+1, limit);

		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num = new int[N][2];
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			num[i][0] = sc.nextInt();
			num[i][1] = sc.nextInt();
		}

		for(int i = 1; i <= N; i++) {
			selected_num = new int[i];
			combi(0,0, i);
		}
		System.out.println(min);

		
	}

}
