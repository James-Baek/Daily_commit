package com.ssafy.step1.subset;

import java.util.Arrays;
import java.util.Scanner;

public class Babygin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] cnt = new int[10];
		int[] number = new int[6];
		String temp = sc.next();
		char[] temp_num = temp.toCharArray();
		int ans = 0;
		
		for(int i = 0; i < 6; i++) {
			cnt[Integer.parseInt((temp_num[i]+""))]++;
		}
		System.out.println(Arrays.toString(cnt));
		
		for(int i = 0; i < 10; i++) {
			if(cnt[i] >= 3) {
				ans++;
				cnt[i] -= 3;
			}else if(cnt[i] >= 1) {
				boolean isRun = true;
				for(int j = i; j < i+3; j++) {
					if(j >= 10) {
						isRun = false;
						break;
					}else if(cnt[j] < 1) {
						isRun = false;
						break;
					}
				}
				if(isRun) {
					for(int j = i; j < i+3; j++) {
						cnt[j]--;
					}
					ans++;
					i--;
				}
			}
		}
		if(ans == 2) {
			System.out.println("베이비진 입니다.");
		}else {
			System.out.println("베이비진이 아닙니다.");
		}
	}

}
