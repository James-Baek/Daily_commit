package Jungol;

import java.util.Arrays;
import java.util.Scanner;

public class jungol1169 {
	static int[] num;
	static int[] selected;
	static int cnt;
	static StringBuilder sb;
	// M = 1 모든 경우의 수
	public static void allKind(int idx) {
		if(idx == selected.length) {
			for(int temp : selected) {
				System.out.print(temp+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < num.length; i++) {
			selected[idx] = num[i];
			allKind(idx+1);
		}
		
	}
	// M = 2 중복되는 경우의 수 제외
	public static void reCombi(int idx, int start) {
		if(idx == selected.length) {
			for(int temp : selected) {
				System.out.print(temp+" ");
			}
			System.out.println();
			cnt++;
			return;
		}
		
		for(int i = start; i < num.length;i++) {
			selected[idx] = num[i];
			reCombi(idx+1, i);
		}
	}
	
	public static void reCombi2(int idx, int start) {
		if(idx == selected.length) {
			for(int temp : selected) {
				System.out.print(temp+" ");
			}
			System.out.println();
			cnt++;
			return;
		}
		
		for(int i = start; i < num.length;i++) {
			if(visited[i]) continue;
			selected[idx] = num[i];
			visited[i] = true;
			reCombi(idx+1, i+1);
			visited[i] = false;
		}
	}
	
	static boolean[] visited;
	// M = 3 모두 다른 경우의 수
	public static void alldiff(int idx) {
		if(idx == selected.length-1) {
			for(int k = 0; k < selected.length; k++) {
				
				if(k == 3) {
					sb.append("0 ");
					continue;
				}
				if(k < 3) {
					sb.append(selected[k]+" ");
				}else {
					sb.append(selected[k-1]+" ");
				}
//				System.out.print(temp+" ");
			}
			sb.append("\n");
//			System.out.println();
			cnt++;
			return;
		}
		
		for(int i = 0; i < num.length; i++) {
			if(visited[i]) continue;
			selected[idx] = num[i];
			visited[i] = true;
			alldiff(idx+1);
			visited[i] = false;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		num = new int[]{1,2,3,4};
		selected = new int[N+1];
		visited = new boolean[num.length];
		cnt = 0;
		
		if(M == 1) {
			allKind(0);
		}else if(M == 2) {
			reCombi(0, 0);
		}else if(M == 3) {
			alldiff(0);
		}else if(M == 4) {
			reCombi2(0,0);
		}
		
		System.out.print(sb);
		System.out.println("총 경우의 수 : "+cnt);
	}

}
