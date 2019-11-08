package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
	// 길이 N인 정사각형
	// B : 빌딩
	// G : 공원 조성 단지
	// G에 인접한 B 2층높이로 세울수 있다.
	// B에 인접한 G가 없으면 현위치+가로+세로에 위치한 B만큼 높이
	// 인접 : 8방
	// 입력 
	// T
	// N
	// 각 배열의 값
	// 출력 : 가장 높은 빌딩의 높이
public class Solution13 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
			System.setIn(new FileInputStream("res/Solution13.txt"));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int T = Integer.parseInt(br.readLine());
			
			for (int tc = 1; tc <= T; tc++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(st.nextToken()); // map의 크기
				
				int s=0;				
				char[][] map = new char[N][N];
				
				for (int i = 0; i < N; i++) {
					StringTokenizer st2 = new StringTokenizer(br.readLine());
					for (int j = 0; j < N; j++) {
						map[i][j] = st2.nextToken().charAt(0); 
					}
				}
				int[] dirX = {-1,1,0,0,-1,1,-1,1};
				int[] dirY = {0,0,-1,1,-1,-1,1,1};
				int nx,ny; // new x, new y;
				boolean isB,isG;
				int maxHeight = 0,h = 0;
				int[][] BHeight = new int[N][N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						isB = true;
						isG = true;
						if(map[i][j] == 'B') {
							BHeight[i][j]++;
							for (int k = 0; k < dirY.length; k++) {
								nx = i + dirX[k];
								ny = j + dirY[k];
								if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
								
								if(map[nx][ny] == 'G') {
								//	isG = true;
									isB = false;
									break;
								}									
								else if(map[nx][ny] == 'B') {
									//isB = true;
									isG = false;
								}
							}// end for k
							if(isG) {
								BHeight[i][j] = 2;
							}else if(isB) {
								for (int k = 0; k < 4; k++) {
									nx = i;
									ny = j;
									while(true) {
										nx += + dirX[k];	
										ny += + dirY[k];
										if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;
										
										if(map[nx][ny] == 'B')
											BHeight[i][j]++;
									}
								}
							}else {
								BHeight[i][j] =1;
							}
						}
					}// end for j
					
				}//end for i
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						maxHeight = Math.max(maxHeight, BHeight[i][j]);
					}
				}
				System.out.println("#"+tc+" "+maxHeight);
			}//end tc

		}// end main
}