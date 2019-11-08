package SWEA;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

import SWEA.Solution4013.magnetic;

public class Solution4013ver2 {
	static int N;
	static int sum;
	static magnetic[] ml;
	public static class magnetic{
		Deque<Integer> list = new LinkedList<Integer>();
		int l;
		int r;
		
		public magnetic() {}
		
		public void r_rotation() {
			list.offerFirst(list.pollLast());
			setLR();
		}
		
		public void l_rotation() {
			list.offerLast(list.pollFirst());
			setLR();
		}
		
		public void setLR() {
			for(int i = 0; i < 8; i++) {
				int temp = list.pollFirst();
				if(i == 6) {
					l = temp;
				}else if(i == 2) {
					r = temp;
				}
				list.offerLast(temp);
			}
		}

	}
	
	public static void getSum() {
		for(int i = 0; i < 4; i++) {
			if(ml[i].list.peekFirst() == 1) {
				sum += Math.pow(2, i);
			}
		}
	}
	
	public static void rotation(int idx, int dir) {
		//오른쪽 로테이션
		int[] rota = new int[4];
		
		int r_idx = idx;
		int r_dir = dir;
		while(r_idx != 3) {
			if(ml[r_idx].r != ml[r_idx+1].l) {
				rota[r_idx] = r_dir;
				r_dir *= -1;
				rota[r_idx+1] = r_dir;
			}else {
				break;
			}
			r_idx++;
		}
		
		//왼쪽 로테이션
		int l_idx = idx;
		int l_dir = dir;
		while(l_idx > 0) {
			if(ml[l_idx].l != ml[l_idx-1].r) {
				rota[l_idx] = l_dir;
				l_dir *= -1;
				rota[l_idx-1] = l_dir;
			}else {
				break;
			}
			l_idx--;
		}
		
		rota[idx] = dir;
		for(int i = 0; i < 4; i++) {
			if(rota[i] == 1) {
				ml[i].r_rotation();
			}else if(rota[i] == -1) {
				ml[i].l_rotation();
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			sum = 0;
			ml = new magnetic[4];
			for(int i = 0; i < 4; i++) {
				magnetic m = new magnetic();
				for(int j = 0; j < 8; j++) {
					m.list.offer(sc.nextInt());
				}
				m.setLR();
				ml[i] = m;
			}
			for(int i = 0; i < N; i++) {
				rotation(sc.nextInt()-1, sc.nextInt());
			}
			getSum();
			
			System.out.printf("#%d %d\n", t, sum);
		}
	}

}
