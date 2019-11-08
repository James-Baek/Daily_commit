package SWEA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution3074 {
	static int N, M;
	static long min;
	static long time;
	static Long[] line;
	static boolean[] isWorking;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for(int t = 1; t <= T; t++) {
			min = 0;
			time = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			
			PriorityQueue<Long[]> q = new PriorityQueue<Long[]>(new Comparator<Long[]>() {
				@Override
				public int compare(Long[] o1, Long[] o2) {
					if(Long.compare(o1[0]+o1[1], o2[0]+o2[1]) == 0) {
						return Long.compare(o1[0], o2[0]);
					}
					return Long.compare(o1[0]+o1[1], o2[0]+o2[1]);
				}
			});
			
			
			for(int i = 0; i < N; i++) {
				line = new Long[2];
				line[0] = sc.nextLong();
				line[1] = (long) 0;
				q.offer(line);
			}
			isWorking = new boolean[N];

			while(M != 0) {
				Long[] temp = q.poll();
				temp[1] += temp[0];
				min = min > temp[1] ? min : temp[1];
				q.offer(temp);
				M--;
			}

			System.out.printf("#%d %d\n", t, min);
		}
	}
}
