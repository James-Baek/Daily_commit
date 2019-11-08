package baekjoon;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_16236_아기상어_백창현 {
	static int N;
	static int[][] map;
	static int br, bc, bsize, bcnt;
	static int time;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static boolean[][] visited;
	static int min;
	
	static class fish implements Comparable<fish> {
		int r, c, size, dist;
		public fish(int r, int c, int size, int dist) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.dist = dist;
			
		}

		@Override
		public int compareTo(fish o) {
			if(Integer.compare(dist, o.dist) == 0) {
				if(Integer.compare(r, o.r) == 0) {
					return Integer.compare(c, o.c);
				}
				return Integer.compare(r, o.r);
			}
			return Integer.compare(dist, o.dist);
		}
		
	}

	
	public static void find() {
		Queue<Integer> path = new LinkedList<Integer>();
		PriorityQueue<fish> fishs = new PriorityQueue<fish>();
		visited = new boolean[N][N];
		
		int depth = 1;
		path.offer(br * 100 + bc);
		
		while(!path.isEmpty()) {
			int size = path.size();
			for(int i = 0; i < size; i++) {
				int rc = path.poll();
				int r = rc / 100;
				int c = rc % 100;
				visited[r][c] = true;
				if(map[r][c] < bsize && map[r][c] != 0) {
					fishs.offer(new fish(r,c,map[r][c], depth-1));
				}
				for(int dir = 0; dir < 4; dir++) {
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					if(nr < 0 || nr >= N || nc < 0 || nc >=N) continue;
					if(visited[nr][nc] || map[nr][nc] > bsize || map[nr][nc] == 9) continue;
					path.offer(nr * 100 + nc);
					visited[nr][nc] = true;
				}
				
			}
			if(fishs.size() >= 1) {
				fish temp = fishs.poll();
				map[temp.r][temp.c] = 9;
				map[br][bc] = 0;
				br = temp.r;
				bc = temp.c;
				bcnt++;
				if(bsize == bcnt) {
					bsize++;
					bcnt = 0;
				}
				time += temp.dist;
				path = new LinkedList<Integer>();
				path.offer(br * 100 + bc);
				depth = 1;
				visited = new boolean[N][N];
				fishs = new PriorityQueue<fish>();
				continue;
			}
			depth++;
		}
		
	}
	
	public static void main(String[] args) {
		// 아기 상어 크기 2, 1초에 상하좌우 1칸씩 이동.
		// •더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
		// •먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
		// •먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다. ◦거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
		// ◦거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		
		// 맵 초기화 및 아기 상어 위치 파악
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int f = sc.nextInt();
				if(f == 9) {
					br = i;
					bc = j;
					bsize = 2;
					bcnt = 0;
				}
				map[i][j] = f;
			}
		}
		
		find();
		
		
		System.out.println(time);

	}

}
