package com.ssafy.step1.pretest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gravity {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		int maxHeight = 0;
		int[][] diff = new int[N][N];
		int[] height = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i = 0;st.hasMoreElements();i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}		
		
		for(int i =0; i < N; i++) 
			for(int j =0; j< data[i]; j++) 
				diff[i][j] = 1;
		
		for(int i =0; i < N; i++) {
			for(int j =0; j< N; j++) {
				if(diff[i][j] == 0) continue; 
				height[j]++;										
			}
		}
		for(int i =0; i<N; i++) 
			maxHeight = Math.max(maxHeight, N-height[i]);
		
		System.out.println(maxHeight);
	}
}