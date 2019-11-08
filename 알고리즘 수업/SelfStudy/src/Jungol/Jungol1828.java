package Jungol;

import java.util.Scanner;

public class Jungol1828 {
	static int ans;
	static int[] cnt;
	public static void findMax() {
		int max = 0;
		int idx = 0;
		for(int j = 0; j < cnt.length; j++) {
			if(cnt[j] > max) {
				max = cnt[j];
				idx = j;
			}
		}
		
		for(int j = idx; j < cnt.length; j++) {
			cnt[j] = 0;
		}
		ans++;
		
		for(int j = 0; j < cnt.length; j++) {
			if(cnt[j] != 0) {
				findMax();
				break;
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		cnt = new int[10272];
		ans = 0;
		int base = 271;
		
		for(int i = 0; i < N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			// 이제 0은 271번이 0 이다.
			
			if(start < 0) {
				for(int k = base + start; k < base + end; k++) cnt[k]++;
			}else {
				for(int k = base + start; k < base + end; k++) cnt[k]++;
			}
		}
		findMax();
		System.out.println(ans);
	}

}
