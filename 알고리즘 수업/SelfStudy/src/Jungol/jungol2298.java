package Jungol;

import java.util.Scanner;

public class jungol2298 {
	static int N;
	static int[][] map;
	static boolean[][] waterMap;
	static int maxArea;
	static int wHeight;
	static int maxHeight;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void findArea() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(waterMap[i][j] == false) {
					waterMap[i][j] = true;
					if(map[i][j] > wHeight) {
						
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		wHeight = 0;
		maxArea = 0;
		
		// 맵초기화
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		while(wHeight != maxHeight) {
			// 공간 찾기
			findArea();
			
			// 물 붓기
			wHeight++;
			
		}
		
		System.out.println(maxArea);
		
	}

}
