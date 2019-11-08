package com.ssafy.step2.recursive;
import java.io.*;
import java.util.*;

public class Main11729_하노이탑이동순서_백창현 {
	static int cnt = 0;
	static StringBuilder sb;
	
	// 원판수, 출발점, 도착점, 임시점, 원판이 한 개 남으면 최종 to 로 이동 시키고 끝.
    static void tower(int n, int from, int to, int temp) 
    { 
    	cnt++;
        if (n == 1) 
        { 
        	sb.append(from + " " + to + "\n");
            return; 
        } 
        tower(n-1, from, temp, to); 
        sb.append(from + " " + to + "\n");
        tower(n-1, temp, to, from); 
    } 
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		int N = sc.nextInt();		

		tower(N, 1,3,2);
		System.out.println(cnt);
		System.out.println(sb);
	}

}
