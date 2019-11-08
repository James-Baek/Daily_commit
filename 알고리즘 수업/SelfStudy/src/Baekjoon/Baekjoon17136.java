package Baekjoon;

import java.util.Scanner;

// 17136 색종이 붙이
public class Baekjoon17136 {
	static int[][] map;
	static int[] papers = {0,5,5,5,5,5};
	static int[] dr = {-1,1,0,0,-1};
	static int[] dc = {};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				boolean isFind = false;
				for(int k = i; k < 5; k++) {
					for(int w = j; j < 5; j++) {
						if(k < 0 || k >= 10 || w < 0 || w >= 10 ) {
							isFind = false;
							break;
						}else {
							if(map[k][w] == 1) {
								isFind = true;
							}else {
								isFind = false;
								break;
							}
						}
					}
					if(!isFind) break;
				}
				if(isFind) {
					for(int k = i; k < 5; k++) {
						for(int w = j; j < 5; j++) {
							map[k][w] = 0;
						}
					}
				}
			}
		}
		
	}

}
