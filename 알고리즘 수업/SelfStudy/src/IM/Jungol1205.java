package IM;

import java.util.Arrays;
import java.util.Scanner;

public class Jungol1205 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] list = new int[N];
		
		int zero = 0;
		
		for(int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
			if(list[i] == 0) zero++;
		}
		
		Arrays.sort(list);
		
		for(int temp : list) {
			
		}
		
	}

}
