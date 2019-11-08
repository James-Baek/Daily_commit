package baekjoon;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_16235_나무재테크_백창현 {
	static int N, M, K;
	static int[][] map;
	static int[][] plus;
	static int[] dr = {-1,-1,-1,0,0,1,1,1};
	static int[] dc = {-1,0,1,-1,1,-1,0,1};
	static PriorityQueue<tree> list;
	static Queue<tree> death;
	static Queue<tree> alive;
	
	static class tree implements Comparable<tree>{
		int age;
		int x,y;
		public tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
		@Override
		public int compareTo(tree o) {
			// TODO Auto-generated method stub
			return Integer.compare(age, o.age);
		}
				
	}
	
	public static void year() {
		int size = list.size();
		
		// 봄 양분 섭취, 죽음
		while(!list.isEmpty()) {
			tree t = list.poll();
			if(map[t.x][t.y] >= t.age) {
				map[t.x][t.y] -= t.age;
				t.age++;
				alive.offer(t);
			}else {
				death.offer(t);
			}
		}
		
		// 여름 양분 추가
		while(!death.isEmpty()) {
			tree t = death.poll();
			map[t.x][t.y] += t.age/2;
		}
		
		// 가을 번식
		while(!alive.isEmpty()) {
			tree t = alive.poll();
			if(t.age % 5 == 0) {
				for(int dir = 0; dir < 8; dir++) {
					int nr = t.x + dr[dir];
					int nc = t.y + dc[dir];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
					list.offer(new tree(nr, nc, 1));
					
				}
			}
			list.offer(t);
		}
		
		// 겨울 기계 양분 추가
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] += plus[i][j];
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N][N];
		plus = new int[N][N];
		
		list = new PriorityQueue<tree>();
		death = new LinkedList<tree>();
		alive = new LinkedList<tree>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				plus[i][j] = sc.nextInt();
				map[i][j] = 5;
			}
		}
		
		for(int i = 0; i < M; i++) {
			list.offer(new tree(sc.nextInt()-1, sc.nextInt()-1, sc.nextInt()));
		}
		
		for(int i = 0; i < K; i++) {
			year();
		}
		
		System.out.println(list.size());
	}

}
