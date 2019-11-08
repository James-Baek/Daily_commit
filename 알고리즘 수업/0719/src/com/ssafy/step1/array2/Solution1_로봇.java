package com.ssafy.step1.array2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution1_로봇 {
	static int[][][] dir = {
			{{0,1}},
			{{0,-1},{0,1}},
			{{-1,0},{1,0},{0,-1},{0,1}},
			};
			
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/input1.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[][] map = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.next().charAt(0); 									
				}				
			}
			int ans = 0;
			int newI=0,newJ=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int robot = map[i][j] - 'A';
					if(robot > 2) continue; // !A~C 
					for (int k = 0; k < dir[robot].length; k++) {
						newI = i;
						newJ = j;
						while(true) {
							newI += dir[robot][k][0];
							newJ += dir[robot][k][1];
							if(newI <0 || newI >=N || newJ <0 || newJ >= N) break;
							if(map[newI][newJ] == 'S') ans++;
							else break;
						}//end while
					}//end dir
				}// end for j
			}// end for i
			System.out.println("#"+tc+" "+ans);
		}// end tc
	}// end main
}
