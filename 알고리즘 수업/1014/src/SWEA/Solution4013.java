package SWEA;

import java.util.Scanner;

// 4013. [모의 SW 역량테스트] 특이한 자석
public class Solution4013 {
	static int N;
	static int cnt;
	static magnetic[] ml;
	static int sum;
	
	public static class magnetic{
		int[] NS;
		int l_Point;
		int r_Point;
		public magnetic() {
			this.NS = new int[8];
			this.l_Point = 6;
			this.r_Point = 2;
		}
		
		public void r_rotation() {
			l_Point = Math.abs((7+(l_Point)))%8;
			r_Point = Math.abs((7+(r_Point)))%8;
		}
		
		public void l_rotation() {
			l_Point = (l_Point+1)%8;
			r_Point = (r_Point+1)%8;
		}
		
	}
	
	public static void rotation(int idx, int dir) {
		boolean[] isRotate = new boolean[4];
		int[] lr = new int[4];
		
//		for(int i = 0; i < 3; i++) {
//			if(ml[i].NS[ml[i].r_Point] != ml[i+1].NS[ml[i+1].l_Point]) {
//				isRotate[i] = true;
//				isRotate[i+1] = true;
//			}else{
//				isRotate[i+1] = false;
//			};
//		}
//		
		// 오른쪽
		lr[idx] = dir;
		int r_idx = idx;
		while(r_idx != 3) {
			if(ml[r_idx].NS[ml[r_idx].r_Point] != ml[r_idx+1].NS[ml[r_idx+1].l_Point]) {
				isRotate[r_idx] = true;
				isRotate[r_idx+1] = true;
				lr[r_idx+1] = lr[r_idx] * -1;
			}else{
				isRotate[r_idx+1] = false;
				break;
			};

			r_idx++;
		}
		
		int l_idx = idx;
		while(l_idx < 0) {
			if(ml[l_idx].NS[ml[l_idx].l_Point] != ml[l_idx-1].NS[ml[l_idx-1].r_Point]) {
				isRotate[l_idx] = true;
				isRotate[l_idx-1] = true;
				lr[l_idx-1] = lr[l_idx] * -1;
			}else{
				isRotate[l_idx-1] = false;
				break;
			};
			
			l_idx--;
		}
		
		for(int i = 0; i < 4; i++) {
			if(isRotate[i]) {
				if(lr[i] == 1) {
					ml[i].r_rotation();
				}else if(lr[i] == -1) {
					ml[i].l_rotation();
				}
			}
		}
	}
	
	public static void getSum() {
		for(int i = 0; i < 4; i++) {
			if(ml[i].NS[(ml[i].l_Point+2) % 8] == 1) {
				sum += Math.pow(2, i);
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for(int t = 1; t <= T; t++) {
			cnt = 0;
			ml = new magnetic[4];
			N = sc.nextInt();
			sum = 0;
			for(int i = 0; i < 4; i++) {
				magnetic m = new magnetic();
				for(int j = 0; j < 8; j++) {
					m.NS[j] = sc.nextInt();
				}
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
