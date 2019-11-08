package com.ssafy.step2.permutation.basic;
import java.util.*;

public class PermutationTest5 {
	private static int[] numbers;
	private static int N, R;
	private static int totalCount = 0;
	static StringBuilder sb;
	
	private static void permutation(int index, int flag) {
		
		if(index == R) {
			totalCount++;
			sb.append(Arrays.toString(numbers)+"\n");
			return;
		}
		//  가능한 선택지에 대해 반복(1~N까지 시도)
		for(int i = 1; i <= N; i++) {
			// 선택지를 사용할 수 있는지 기존수들과 중복체크
			if((flag & 1<<i) == 0) {
				numbers[index] = i;
				permutation(index+1, flag | 1 <<i); // flag에 | 연산을 한 값을 넘김으로써 다시 원복하는 수고를 줄일 수 있다.
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		permutation(0,0);
		System.out.print(sb);
		System.out.println("총 경우의 수 : "+totalCount);

	}

}
