package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main17780 {
	static int N, K;
	static int[][] map;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	static Queue<dron> Dlist;
	
	static class dron{
		int r;
		int c;
		int dir;
		dron up;
		dron down;
		dron root;
		
		public dron(int r, int c, int dir) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.up = null;
			this.down = null;
			this.root = this;
		}
		
		public void reverse() {
			dron top = findTop(this);
			
			for(dron rev : Dlist) {
				if(rev.root == this) {
					rev.root = top;
					dron temp = rev.up;
					rev.up = rev.down;
					rev.down = temp;
				}
			}
		}
		
		public dron findTop(dron base) {
			dron top = this;
			while(top.up != null) {
				top = top.up;
			}
			return top;
		}
		public void changeDir() {
			if(dir == 0) dir = 1;
			else if(dir == 1) dir = 0;
			else if(dir == 2) dir = 3;
			else if(dir == 3) dir = 2;
		}
		
		public void move(int dir) {
			this.root = this;
			this.down = null;
			
			this.r += dr[dir];
			this.c += dc[dir];
			
			dron upDron = this.up;
			while(upDron != null) {
				upDron.r += dr[dir];
				upDron.c += dc[dir];
				upDron = upDron.up;
			}
		}
	}
	
	public static void rootConnect(dron target, int r, int c) {
		for(dron temp : Dlist) {
			if(temp == target) continue;
			if(temp.r == r && temp.c == c && temp.root == temp) {
				while(temp.up != null) {
					temp = temp.up;
				}
				
				target.down = temp;
				temp.up = target;
				target.root = temp.root;
				target.up = null;
				
				return;
			}
		}
		return;
	}
	
	public static boolean isFour(dron target) {
		int cnt = 1;
		dron upside = target.up;
		
		while(upside != null) {
			cnt++;
			upside = upside.up;
		}
		
		if(cnt >= 4) return true;
		return false;
	}
	
	public static void turn(dron d) {
		dron current = d;
		int next_r = current.r + dr[current.dir];
		int next_c = current.c + dc[current.dir];
		
		if(next_r < 0 || next_r >= N || next_c < 0  || next_c >= N) {
			// 밖으로 나갔을 때
			current.changeDir();
		}else if(map[next_r][next_c] == 0) {
			// 흰색
			rootConnect(current, next_r, next_c);
			current.move(current.dir);
			
		}else if(map[next_r][next_c] == 1) {
			// 빨간색
			current.move(current.dir);
			current.reverse();
			
			rootConnect(current.root, next_r, next_c);
			
		}else if(map[next_r][next_c] == 2) {
			// 파란색
			current.changeDir();
			next_r = current.r + dr[current.dir];
			next_c = current.c + dr[current.dir];
			if(next_r < 0 || next_r >= N || next_c < 0  || next_c >= N) return;
			if(map[next_r][next_c] == 2) return;
			if(map[next_r][next_c] == 1) {
				current.move(current.dir);
				current.reverse();
				rootConnect(current.root, next_r, next_c);
				return;
			}
			if(map[next_r][next_c] == 0) {
				rootConnect(current, next_r, next_c);
				current.move(current.dir);
				return;
			}
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][N];
		Dlist = new LinkedList<dron>();
		
		
		for(int i = 0; i < N;i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < K; i++) {
			Dlist.offer(new dron(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt()-1));
		}
		
		for(int i = 1; i <= 1001; i++) {
			for(dron d : Dlist) {
				turn(d);
				if(isFour(d)) {
					System.out.println(i);
					return;
				}
			}
		}
		System.out.println(-1);
	}

}
