package IM;

import java.util.Scanner;

public class Solution1954ver2 {
	static int N;
	static int[][] arr;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			fill();
			System.out.printf("#%d\n", t);
			print();
		}

		
	}
//	private static void fill() {
//		int count = N, x=0, y=-1, value = 0, a=1, target = N*N;
//		// 열증가, 행증가, 열감소, 행감소 형태
//		// ==> 열 변화(+1), 행변화(+1), 열 변화(-1), 행 변화(-1)
//		while(value < target) {
//			//열변환
//			for(int k = 0; k < count; ++k) {
//				y +=a;
//				arr[x][y] = ++value;
//			}
//			--count;
//			for(int k=0; k < count; ++k) {
//				x += a;
//				arr[x][y] = ++value;
//			}
//			a *= -1;
//		}
//	}
	
	private static void fill() {
		int x=0, y=0, newX=0, newY=0, dir=0, value = 1, target = N*N;
		// 열증가, 행증가, 열감소, 행감소 형태
		// ==> 열 변화(+1), 행변화(+1), 열 변화(-1), 행 변화(-1)
		while(true) {
			arr[x][y] = value;
			newX = x + dr[dir];
			newY = y + dc[dir];
			if(newX<0 || newX >=N || newY < 0 || newY >=N
					|| arr[newX][newY] != 0) {
				if(value == target) return;
				dir = (dir+1) % 4;
			}else {
				x = newX;
				y = newY;
				value++;
			}
		}
	}
	
	private static void print() {
		for(int[] is : arr) {
			for(int i : is) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
