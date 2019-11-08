package baekjoon;

import java.util.Scanner;

public class Main_5014_스타트링크_백창현 {
	static int F,S,G,U,D;
	
	public static int isGood() {
		int minus = G - S;
		if(minus > 0 && U == 0) return -1;
		if(minus < 0 && D == 0) return -1;
		// 목표층이 위에 있는 것
		// 위로 올라갔다가 아래로 내려오는 경우
		int cnt = 0;
		int current;
		if(U == 0) cnt = -1;
		while(true) {
			cnt++;
			current = S + (U * cnt);
			if(current > F) break;
			if(current == G) {
				return cnt;
			}else if(current > G) {
				int gap = current - G;
				if(gap % D == 0) return cnt + (gap/D);
			}
		}
		
		// 아래로 내려갔다가 위로 올라가는 경우
		cnt = 0;
		if(D == 0) cnt = -1;
		while(true) {
			cnt++;
			current = S - (D * cnt);
			int gap = G - current;
			if(current == 0) {
				if(G % U == 0) return cnt + (G/U);
			}
			if(current < 0) return -1;
			if(current == G) {
				return cnt;
			}else if(current < G) {
				if(gap % U == 0 && gap > 0) return cnt + (gap/U);
			}
		}
	}
	
	public static void main(String[] args) {
		// 첫째 줄에 F:전체, S:현재, G:목표, U:위, D:아래
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		
		
		// S랑 G랑 같으면 0
		// S보다 G가 작은데 D가 0이면 use the stairs
		// S보다 G가 큰데 U가 0이면 use the stairs
		// S보다 G가 작으면 차이값을 D로 나눠서 나온 몫이 0이면 아래로 내려가는게 불가능  100 98 1 98 user the stairs
		// S보다 G가 작으면 차이값을 D로 나눠서 나온 몫이 0보다 크면 아래로 내려가는게 불가능  100 47 1 25 이면 몫이 2인데
		// 몫에 + 1 해서 한번 더 내려간다고 할때 up을 몇번 눌러야 하는지 판단.
		
		if(S == G) {
			System.out.println(0);
		}else {
			int ans = isGood();
			if(ans == -1) {
				System.out.println("use the stairs");
			}else {
				System.out.println(ans);
			}
		}
	}

}
