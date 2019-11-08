package HW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1082_화염에서탈출_백창현 {
	static char[][] map;
	static int R,C;
	static int hero_r, hero_c;
	static int house_r, house_c;
	
	static Queue<fire> Flist;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int min = Integer.MAX_VALUE;
	
	public static class fire{
		int r;
		int c;
		public fire(int r, int c) {
			this.r = r;
			this.c = c;
		}
		

		public void run() {
			for(int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if(map[nr][nc] == '.') {
					Flist.offer(new fire(nr,nc));
					map[nr][nc] = '*';
				}
			}
		}
	}
	public static void burn() {
		int size = Flist.size();
		
		for(int i = 0; i < size; i++) {
			Flist.poll().run();
		}
	}
	public static void bfs() {
		
		Queue<Integer> fath = new LinkedList<Integer>();
		fath.offer(100*hero_r + hero_c);
		boolean[][] visited = new boolean[R][C];
		visited[hero_r][hero_c] = true;
		int depth = 0;
		while(!fath.isEmpty()) {
			burn();
			int size = fath.size();
			for(int i = 0; i < size; i++) {
				int rc = fath.poll();
				int r = rc / 100;
				int c = rc % 100;
				if(map[r][c] == 'D' && depth < min ) {
					min = depth;
					return;
				}
				for(int dir = 0; dir < 4; dir++) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
					if(visited[nr][nc] || map[nr][nc] == 'X' || map[nr][nc] == '*') continue;
					fath.offer(nr * 100 + nc);
					visited[nr][nc] = true;
				}
			}
			depth++;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		Flist = new LinkedList<fire>();
		sc.nextLine();
		for(int i=0; i < R; i++) {
			char[] line = sc.nextLine().toCharArray();
			for(int j = 0; j < C; j++) {
				if(line[j] == '*') Flist.offer(new fire(i,j));
				else if(line[j] == 'D') {
					house_r = i;
					house_c = j;
				}
				else if(line[j] == 'S') {
					hero_r = i;
					hero_c = j;
				}
				map[i][j] = line[j];
			}
		}
		
		
		int dist = Math.abs(hero_r - house_r) + Math.abs(hero_c - house_c);

		bfs();

		if(min == Integer.MAX_VALUE) System.out.println("impossible");
		else System.out.println(min);
	}

}
