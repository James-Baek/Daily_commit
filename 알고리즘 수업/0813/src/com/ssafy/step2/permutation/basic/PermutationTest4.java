package com.ssafy.step2.permutation.basic;
import java.util.*;

public class PermutationTest4 {
	private static int[] numbers;
	private static boolean[] selected;
	private static int N, R;
	private static int totalCount = 0;
	
	private static void permutation(int index) {
		
		if(index == R) {
			totalCount++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(!selected[i]) {
				selected[i] = true;
				numbers[index] = i;
				permutation(index+1);
				selected[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		selected = new boolean[N+1];
		permutation(0);
		System.out.println("총 경우의 수 : "+totalCount);
	}

}
