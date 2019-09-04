package Baekjoon;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 아기상어 {
	static int N;
	static int[][] map;
	static int[][] log;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int jr, jc, jsize, jcnt;
	static int ans;
	
	public static boolean isClear() {
		for(int i = 0; i < N;i++) {
			for(int j = 0; j < N;j++) {
				if(map[i][j] >= jsize) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		
//		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				// TODO Auto-generated method stub
//				int a = o1 % 100;
//				int b = o2 % 100;
//				return Integer.compare(a, b);
//			}
//		});
		int cnt = 0;
		
		boolean isAllup = true;
		while(isAllup) {
			int level = 0;
			queue.offer(jr*100+jc);
			visited = new boolean[N][N];
			isAllup = false;
			
			while(!queue.isEmpty()) {
				int size = queue.size();
				for(int i = 0; i < size; i++) {
					int xy = queue.poll();
					int r = xy / 100;
					int c = xy % 100;
					if(map[r][c] < jsize && map[r][c] != 0) {
						while(!queue.isEmpty()) {
							int same = queue.poll();
							int same_r = same / 100;
							int same_c = same % 100;
							if(map[same_r][same_c] < jsize && map[same_r][same_c] != 0) {
								if(r > same_r) {
									r = same_r;
									c = same_c;
								}else if(r == same_r) {
									if(c > same_c) {
										r = same_r;
										c = same_c;
									}
								}
							}
						}
						map[r][c] = 9;
						map[jr][jc] = 0;
						log[jr][jc] = cnt++;
						jr = r;
						jc = c;
						jcnt++;
						isAllup = true;
						if(jcnt == jsize) {
							jsize++;
							jcnt = 0;
						}
						ans += level;
						break;
					}
					
					for(int dir = 0; dir < 4; dir++) {
						int nr = r + dr[dir];
						int nc = c + dc[dir];
						if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || map[nr][nc] > jsize) continue;
						visited[nr][nc] = true;
						queue.offer(nr*100+nc);
					}
				}
				level++;
			}
		}

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		log = new int[N][N];
		
		ans = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 9) {
					jr = i;
					jc = j;
					jsize = 2;
				}
			}
		}
		
		bfs();
		
		System.out.println(ans);
	}

}
