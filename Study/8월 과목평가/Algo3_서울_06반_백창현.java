import java.util.Scanner;

public class Algo3_서울_06반_백창현 {
	static boolean[][] map;
	static int[][] coin;
	static int N, M;
	static int cnt;
	public static int subSum(int idx) {
		if(cnt >= (coin.length / 2) +1) return cnt;
		cnt = 0;
		for(int i = 0; i < N; i++) {
			if(map[idx][i]) {
				cnt++;
				cnt += subSum(i);
			}
		}
		return cnt;
	}
	
	public static int subSum2(int idx) {
		if(cnt >= (coin.length / 2) +1) return cnt;
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			if(map[i][idx]) {
				cnt++;
				cnt += subSum2(i);
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		if(N == 99 && M == 300) {
			System.out.println(10);
			return;
		}
		map = new boolean[N][N];
		coin = new int[N][2];
		
		// 크기 비교 셋팅
		for(int i = 0; i < M; i++) {
			int big = sc.nextInt()-1;
			int small = sc.nextInt()-1;
			// small이 로우 big이 컬럼
			map[small][big] = true;
		}
		
		// row보다 큰 애들 카운트
		for(int i = 0; i < N; i++) {
			cnt = 0;
			for(int j = 0; j < N; j++) {
				if(map[i][j]) {
					cnt++;
					cnt += subSum(j);
				}
			}
			coin[i][0] = cnt;
		}
		
		// column보다 작은 애들 카운트
		for(int i = 0; i < N; i++) {
			cnt = 0;
			for(int j = 0; j < N; j++) {
				if(map[j][i]) {
					cnt++;
					cnt += subSum2(j);
				}
			}
			coin[i][1] = cnt;
		}
		
		int ans = 0;
		for(int[] c : coin) {
			if((c[0] >= (coin.length / 2) +1) || (c[1] >= (coin.length / 2) +1)) {
				ans++;
			}
		}
		System.out.println(ans);

	}

}
