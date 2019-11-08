package com.ssafy.step1.pretest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
////////////////////////////////////
// 메모리 : 21,788kb, 실행시간 : 126ms //
////////////////////////////////////
public class Solution_D3_1208_이근성{
	static int max_idx,min_idx;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int diff_height;
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			diff_height = 0;
			int dump = Integer.parseInt(br.readLine());
			int[] height = new int[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i =0;st.hasMoreElements();i++) {
				height[i] = Integer.parseInt(st.nextToken());
			} 
			diff_height = dump(height,max(height),min(height),dump);
			
			System.out.println("#"+ test_case + " " + diff_height);			
		}
	}

	private static int dump(int[] height,int max, int min, int cnt) {
		if(max == min) return 0;
		if(cnt == 0) return max - min;
		for(int i = 0; i< 100; i++) {
			if(max == height[i]) max_idx = i;
			if(min == height[i]) min_idx = i;
		}		
		height[max_idx] = height[max_idx] - 1;
		height[min_idx] = height[min_idx] + 1;
		cnt--;

		return dump(height,max(height),min(height),cnt);
	}
	
	private static int max(int[] H) {		
		int max_height = 0;
		for(int h:H) max_height = Math.max(max_height, h);
				
		return max_height;
	}
	private static int min(int[] H) {
		int min_height = 100;
		for(int h:H) min_height = Math.min(min_height, h);
		
		return min_height;
	}
	

}
