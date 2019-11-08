package IM;

import java.util.ArrayList;
import java.util.Scanner;

public class Jungol1037 {
	static int[][] map;
	static int N;
	static ArrayList<Integer> check_r;
	static ArrayList<Integer> check_c;
	
	public static boolean isOK() {
		boolean isFine = false;
		
		// 가로 라인 쳌섬
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < N; j++) {
				sum += map[i][j];
			}
			if(sum % 2 != 0) {
				return false;
			}
		}
		
		// 세로 라인 쳌섬
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < N; j++) {
				sum += map[j][i];
			}
			if(sum % 2 != 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		check_r = new ArrayList<Integer>();
		check_c = new ArrayList<Integer>();
		
		boolean isFine = false;
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				sum += map[i][j];
			}
			if(sum % 2 != 0) {
				isFine = true;
				check_r.add(i);
			}
		}

		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < N; j++) {
				sum += map[j][i];
			}
			if(sum % 2 != 0) {
				isFine = true;
				check_c.add(i);
			}
		}
		
		if(isFine) {
			for(int r : check_r) {
				for(int c : check_c) {
					if(map[r][c] == 1) map[r][c] = 0;
					else				map[r][c] = 1;
					if(isOK()) {
						System.out.println("Change bit ("+(r+1)+","+(c+1)+")");
						return;
					}else {
						if(map[r][c] == 1) map[r][c] = 0;
						else				map[r][c] = 1;
					}
				}
			}
			System.out.println("Corrupt");
		}else {
			System.out.println("OK");
		}
		
	}

}
