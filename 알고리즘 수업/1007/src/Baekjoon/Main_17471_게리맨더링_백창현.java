package Baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_17471_게리맨더링_백창현 {
	static int N;
	static int[] human;
	static boolean[][] map;
	static ArrayList<Integer> Agroup;
	static ArrayList<Integer> Bgroup;
	static boolean[] AConnect;
	static boolean[] BConnect;
	static int min = Integer.MAX_VALUE;
	static boolean isGood = false;
	
	static public boolean bfs() {
		Queue<Integer> aq = new LinkedList<Integer>();
		Queue<Integer> bq = new LinkedList<Integer>();
		AConnect = new boolean[N];
		BConnect = new boolean[N];
		boolean[] Avisited = new boolean[N];
		boolean[] Bvisited = new boolean[N];
		
		aq.add(Agroup.get(0));
		while(!aq.isEmpty()) {
			int temp = aq.poll();
			for(int i = 1; i < N; i++) {
				if(map[temp][i] == true && !Bgroup.contains(temp) && !Avisited[i]) {
					aq.offer(i);
					Avisited[i] = true;
					AConnect[i] = true;
				}
			}
		}
		
		bq.add(Bgroup.get(0));
		while(!bq.isEmpty()) {
			int temp = bq.poll();
			for(int i = 1; i < N; i++) {
				if(map[temp][i] == true && !Agroup.contains(temp) && !Bvisited[i]) {
					bq.offer(i);
					Bvisited[i] = true;
					BConnect[i] = true;
				}
			}
		}
		
		for(int atom : Agroup) {
			if(!AConnect[atom]) return false;
		}
		
		for(int atom : Bgroup) {
			if(!BConnect[atom]) return false;
		}
		
		return true;
	}
	
	static public void makeSet() {
		int base = 0;
		
		for(int t = 1; t < Math.pow(2, N-1); t+=2) {
			Agroup = new ArrayList<Integer>();
			Bgroup = new ArrayList<Integer>();
			
			for(int i = 1; i < N; i++) {
				if((t & (1 << i)) != 0 ) {
					Agroup.add(i);
				}else {
					Bgroup.add(i);
				}
			}
			
			if(Agroup.size() == 0 || Bgroup.size() == 0) continue;
			int aSum = 0;
			int bSum = 0;
			

			if(bfs()) {
				for(int atom : Agroup) {
					aSum += human[atom];
				}
				for(int atom : Bgroup) {
					bSum += human[atom];
				}

				min = Math.min(min, Math.abs(aSum - bSum));
				isGood = true;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt() + 1;
		map = new boolean[N][N];
		human = new int[N];
		
		for(int i = 1; i < N; i++) {
			human[i] = sc.nextInt();
		}
		
		// 인접 행렬 셋팅
		for(int i = 1; i < N; i++) {
			int g = sc.nextInt();
			for(int n = 0; n < g; n++) {
				int temp = sc.nextInt();
				map[i][temp] = true;
				map[temp][i] = true;
			}
		}
		
		makeSet();
		if(isGood) {
			System.out.println(min);
		}else {
			System.out.println(-1);
		}
	}
}
