package selfstudy;
import java.util.*;

public class Solution_D4_1210_Ladder1_백창현 {
	
	static int[] dr = {0,0};
	static int[] dc = {-1,1};
	
	static int[][] map;
	
	//탐색 메소드 2에 도착했으면 true 리턴 아니면 false 리턴
	static boolean go(int x) {
		//0 ~ 99번 row 까지 하나씩 증가시키면서 탐색
		if(map[0][x] == 0) {
			return false;
		}
		for(int i = 0; i < 100; i++) {
			//지금 포인트의 좌우에 1이 있으면 그쪽으로 이동
			if(map[i][x] == 2) {
				return true;
			}
			SEARCH:
			for(int j = 0; j < 2; j++) {
				if(x+dc[j] < 0 || x+dc[j] >= 100) {
					continue;
				}
				if(map[i][x+dc[j]] == 1) {
					while(true) {
						// 0이  나올때까지 이동
						x += dc[j];
						// 0이 나오면 한칸 뒤로 이동

						if(x == 100) {
							x--;
							break SEARCH;
						}
						if(x < 0) {
							x++;
							break SEARCH;
						}
						
						if(map[i][x] == 2) {
							return true;
						}
						
						if(map[i][x] == 0) {
							x -= dc[j];
							break SEARCH;
						}
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int testCase = 1; testCase <= 10; testCase++) {
			// 맵 초기화
			map = new int[100][100];
			int n = sc.nextInt(); // 테스트 케이스 n
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			// x좌표 0번 부터 99번 까지 탐색
			for(int i = 0; i < 100; i++) {
				if(go(i)) {
					System.out.printf("#%d %d\n", testCase, i);
					break;
				}
			}
		}
	}

}
