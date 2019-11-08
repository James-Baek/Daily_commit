/*package com.ssafy.step1.pretest;
//import java.util.Scanner;
//import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution
{
//	static int T;
	public static void main(String args[]) throws NumberFormatException, IOException
	{
//		System.setIn(new FileInputStream("res/input.txt"));
    		
    	
    	int T=Integer.parseInt(br.readLine());
    
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int cnt = 0; 
			char[] CH = br.readLine().toCharArray();
			char pivot = '0'; 
			for(char ch:CH) {
				if(ch != pivot) { 
					cnt++;
					pivot = ch;
				}
			}
			
			
			System.out.println("#" + test_case + " " + cnt);
			
		}
			
	}
}*/