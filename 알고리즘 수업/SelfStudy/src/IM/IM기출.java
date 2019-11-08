package IM;

import java.util.Scanner;

public class IM기출 {
	static int N;
	static boolean[] temp;
	static boolean[] base;
	static int cnt;
	
	public static boolean isSame() {
		for(int i = 0; i < N; i++) {
			if(temp[i] != base[i]) {
				change(i);
			}
		}
		return true;
	}
	public static void change(int num) {
		for(int i = 0; i < N; i++) {
			if((i+1) % (num+1) == 0) {
				temp[i] = !temp[i];
			}
		}
		cnt++;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; t++) {
			cnt = 0;
			N = sc.nextInt();
			base = new boolean[N];
			temp = new boolean[N];
			
			for(int i = 0; i < N; i++) {
				int a = sc.nextInt();
				if(a == 1) {
					base[i] = true;
				}
			}
			
			isSame();
			
			
			System.out.printf("#%d %d\n", t, cnt);
		}
	}

}
