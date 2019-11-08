package SWEA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SWEA5658 {
	static int N, K;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		int ans = 0;
		for(int t=1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			sc.nextLine();
			
			ArrayList<Integer> password = new ArrayList<Integer>();
			ArrayList<String> fix = new ArrayList<String>();
			
			int mod = N / 4;
			
			String pw = sc.nextLine();
			for(int k = 0; k < N; k++) {
				for(int i = 0; i < pw.length(); i=i+mod) {
					String sub = pw.substring(i, i+mod);
					if(fix.contains(sub)) continue;
					fix.add(sub);
				}
				String temp = pw.charAt(0)+"";
				pw = pw.substring(1);
				pw += temp;
			}
			
			for(String pwd : fix) {
				password.add(Integer.parseInt(pwd, 16));
			}
			password.sort(Collections.reverseOrder());
			
			System.out.println("#"+t+" "+password.get(K-1));
		}
		
	}
}
