package com.ssafy.step1.array2;
// N*N 연못
// 처음 3칸 , 2번째 2칸, 3번째 1칸
// 여러 마리의 소금쟁이
// 연못의 밖으로 나가거나, 앞에서 뛰었던 위치를 또 뛸 수 있다.
// N 5~20
//////////////////입력/////////////////////
// 첫 줄 Tc								//
// 배열의 크기 N	, 소금쟁이 수					//
// 시작위치(행,열),방향(하:1, 우:2)			//
//////////////////////////////////////////

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2_D2_소금쟁이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input2.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 연못의 크기
			int S = Integer.parseInt(st.nextToken()); // 소금쟁이 수
			int s=0;
			int[] x = new int[S];
			int[] y = new int[S];
			int[] dir = new int[S];				
			int[][] map = new int[N][N];
			
			for (int i = 0; i < S; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				x[i] = Integer.parseInt(st2.nextToken());
				y[i] = Integer.parseInt(st2.nextToken());
				dir[i] = Integer.parseInt(st2.nextToken());
			}
			A:
				for (int i = 0; i < S; i++) {
					
					if(dir[i] == 1) {
						for (int j = 3; j > 0; j--) {
							if(x[i]+j < N) {
								if(map[x[i]+j][y[i]] == 1) {
									s = i+1;
									break A;
								}else {
									map[x[i]+j][y[i]] =1;
									x[i]= x[i]+j;
								}
							}
							else break;
						}// end for j
						
					}					
					else {
						for (int j = 3; j > 0; j--) {
							if(y[i]+j < N) {
								if(map[x[i]][y[i]+j] == 1) {
									s = i+1;
									break A;
								}else {
									map[x[i]][y[i]+j] =1;
									y[i] = y[i]+j;
								}
							}
							else break;
						}// end for j
					}
				}// end for i
			
			System.out.println("#"+tc+" "+s);
		} // end tc
		
	}//end main

}
