package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2630 {
	static int N;
	static int[][] map;
	static Queue<square> q;
	static Queue<square> end;
	
	static class square{
		int from_r;
		int from_c;
		int to_r;
		int to_c;
		int size;
		private square(int from_r, int from_c, int to_r, int to_c, int size) {
			super();
			this.from_r = from_r;
			this.from_c = from_c;
			this.to_r = to_r;
			this.to_c = to_c;
			this.size = size;
		}
	}
	
	public static void devide(square s) {
		int from_r = s.from_r;
		int from_c = s.from_c;
		int to_r = s.to_r;
		int to_c = s.to_c;
		
		int size = (to_r - from_r + 1) * (to_c - from_c + 1);
		if(from_r == to_r && from_c == to_c) {
			end.offer(s);
			return;
		}
		
 		if(isSame(from_r, from_c, to_r/2, to_c/2)) {
			end.offer(new square(from_r, from_c, to_r/2, to_c/2, size));
		}else {
			q.offer(new square(from_r, from_c, to_r/2, to_c/2, size));
		}
		
		if(isSame(from_r, (to_c/2)+1, to_r/2, to_c)) {
			end.offer(new square(from_r, (to_c/2)+1, to_r/2, to_c, size));
		}else {
			q.offer(new square(from_r, (to_c/2)+1, to_r/2, to_c, size));
		}
		
		if(isSame((to_r/2)+1, from_c, to_r, to_c/2)) {
			end.offer(new square((to_r/2)+1, from_c, to_r, to_c/2, size));
		}else {
			q.offer(new square((to_r/2)+1, from_c, to_r, to_c/2, size));
		}
		
		if(isSame((to_r/2)+1, (to_c/2)+1, to_r, to_c)) {
			end.offer(new square((to_r/2)+1, (to_c/2)+1, to_r, to_c, size));
		}else {
			q.offer(new square((to_r/2)+1, (to_c/2)+1, to_r, to_c, size));
		}
		
	}
	
	public static boolean isSame(int from_r, int from_c, int to_r, int to_c) {
		int base = map[from_r][from_c];
		for(int i = from_r; i <= to_r ; i++) {
			for(int j = from_c; j <= to_c; j++) {
				if(map[i][j] != base) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt()+1;
		map = new int[N][N];
		
		for(int i = 1; i < N; i++) {
			for(int j = 1; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		q = new LinkedList<square>();
		end = new LinkedList<square>();
		
		q.offer(new square(1,1, N-1, N-1, (N-1)*(N-1)));
		while(!q.isEmpty()) {
			devide(q.poll());
		}
		System.out.println(end.size());		
	}

}
