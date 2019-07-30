import java.util.*;

public class Solution_17281 {

	static int[][] map;
	static int cnt = 0;
	static int max_score = 0;
	static int N;

	//0번 타자 4번 위치로 이동
	public static int[] fixlist(int[] players) {
		int[] temp = new int[9];
		
		for(int i = 0; i < 3; i++) {
			temp[i] = players[i];
		}
		temp[3] = 0;
		for(int i = 4; i < 9; i++) {
			temp[i] = players[i-1];
		}
		
		return players;
	}
	
	//점수 내기 시작
	public static int playGame(int[] players) {
		int score = 0;
		players = fixlist(players);
		int outcnt = 0;
		int playcnt = 0;
		int nowIdx = 0;
		int nowRound = 0;
		int[] roo = new int[4];
		
		while(true) {
			nowIdx = playcnt % 9;
			int hit = map[nowRound][players[nowIdx]];
			if(hit == 0) {
				outcnt++;
			}else {
				for(int i = 3; i <= 1; i++){
					if(roo[i] == 1 && i + hit >= 4){
						score++;
						roo[i] = 0;
					}else if(roo[i] == 1){
						roo[i] = 0;
						roo[i+hit] = 1;
					}else{
						roo[hit] = 1;
					}
				}
			}
			
			if(outcnt == 3) {
				if(nowRound == N-1) {
					return score;
				}
				nowRound++;
			}
		}

	}
	
	//스왑
	public static int[] swap(int[] players, int i, int j) {
		
		int temp = players[i];
		players[i] = players[j];
		players[j] = temp;
		
		return players;
	}
	
	//모든 경기 탐방
	public static void makepermu(int[] players, int start, int end) {
		
		if(start == end) {
			System.out.println(Arrays.toString(players));
			playGame(players);
			cnt++;
		}else {
			for(int i = start; i <= end; i++) {
				players = swap(players, start, i);
				makepermu(players, start + 1, end);
				players = swap(players, i, start);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] players = {1,2,3,4,5,6,7,8};
		
		N = sc.nextInt();
		
		map = new int[N][9];
		
		// 맵 초기화
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < 9; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		makepermu(players, 0, players.length - 1);
		System.out.println(cnt);
		
		
	
	}

}
