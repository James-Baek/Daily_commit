package HW;

import java.util.Scanner;

public class Main_1149_RGB거리_백창현 {
	static int N;
	static int[][] num;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num = new int[N][3];
		
		num[0][0] = sc.nextInt();
		num[0][1] = sc.nextInt();
		num[0][2] = sc.nextInt();
		
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < 3; j++) {
				int min = Integer.MAX_VALUE;
				for(int k = 0; k < 3; k++) {
					if(j == k) continue;
					if(min > num[i-1][k]) min = num[i-1][k];
				}
				int temp = sc.nextInt();
				num[i][j] = temp+min;
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for(int k = 0; k < 3; k++) {
			if(ans > num[N-1][k]) ans = num[N-1][k];
		}
		
		System.out.println(ans);
		
	}

}