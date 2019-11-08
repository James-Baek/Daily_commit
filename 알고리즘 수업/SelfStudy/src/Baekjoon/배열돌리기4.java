package Baekjoon;

import java.util.Scanner;

public class 배열돌리기4 {
	static int N;
	static int[][] map;
	static int[][] testCase;
	
	public static void rotation(int start_r, int start_c, int cnt) {
		int count = N, x=0, y=-1, value = 0, a=1, target = N*N;
		// 열증가, 행증가, 열감소, 행감소 형태
		// ==> 열 변화(+1), 행변화(+1), 열 변화(-1), 행 변화(-1)
		
		int temp = map[start_r][start_c];
		
		while(value < target) {
			
			//열변환
			for(int k = 0; k < count; ++k) {
				y +=a;
				map[x][y] = ++value;
			}
			--count;
			for(int k=0; k < count; ++k) {
				x += a;
				map[x][y] = ++value;
			}
			a *= -1;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		map = new int[N][M];
		testCase = new int[K][3];
		
		
		
	}

}
