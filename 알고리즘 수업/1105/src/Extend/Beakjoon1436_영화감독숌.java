package Extend;

import java.util.Scanner;

// 문자열 이용 400ms 짜리
public class Beakjoon1436_영화감독숌 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 1 <= N <= 10000 자연수
		
		int cnt = 0; // 666의 개수
		int num = 666;
		while(cnt < N) {
			String str = num + ""; // 문자열로 변환
			if(str.contains("666")) {
				cnt++;
			}
			num++;
		}
		System.out.println(num-1);
		
	}

}
