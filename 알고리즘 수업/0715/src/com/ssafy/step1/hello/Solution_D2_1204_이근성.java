package com.ssafy.step1.hello;
import java.util.Scanner;
import java.io.*;

//실행 시간 : 0.19391s
class Solution_D2_1204_이근성
{    
    public static void main(String args[]) throws Exception
    {
    	int T,t; // testcase,#testcase
        final int student = 1000; //학생 수
        final int N = 101; // 점수(0 ~ 100) 수
        int Maxfreq; // 가장 많이 나온 점수의 빈도
        int MaxNum=0; // 가장 많이 나온 점수
    	
        Scanner sc = new Scanner(System.in);
        
        T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            Maxfreq = 0;
            t = sc.nextInt(); // #testcase
            int[] count = new int[N]; // 각 점수의 빈도
             
            for(int i = 0 ; i<student;i++) {
                int score = sc.nextInt();
                count[score]++;    
            }
            for(int i=0;i<N;i++) Maxfreq = Math.max(Maxfreq,count[i]);
            
            for(int i=0;i<N;i++) { 
            	if(count[i] == Maxfreq) {
            	MaxNum = i;
            	break;
            	}
            }
             
            System.out.println("#"+ test_case + " " + MaxNum);          
        }
             
    }   
}
