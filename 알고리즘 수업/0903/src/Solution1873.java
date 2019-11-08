import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1873 {
	static int H;
	static int W;
	static int N;
	static char[][] map;
	static char[] command;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int location = 0;
	static int dir = 0;
	
	public static void findtank() {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				switch(map[i][j]) {
				case '^':
					location = i*100+j;
					dir = 0;
					return;
				case 'v':
					location = i*100+j;
					dir = 1;
					return;
				case '<':
					location = i*100+j;
					dir = 2;
					return;
				case '>':
					location = i*100+j;
					dir = 3;
					return;
				}
			}
		}
	}
	
	public static void fire() {
		int nr = location / 100; 
		int nc = location % 100;
		
		while(true) {
			nr += dr[dir];
			nc += dc[dir];
			if(nr < 0 || nr >= H || nc < 0 || nc >= W) return;
			if(map[nr][nc] == '*') {
				map[nr][nc] = '.';
				return;
			}else if(map[nr][nc] == '#') {
				return;
			}
		}
	}
	
	public static void run() {
		// 1. 전차 위치 찾기
		// 2. 커맨드 실행
		// 2-1. 만약 S면 전차 방향으로 발사 if 돌벽이면 박살 후 평지, 철벽이면 break, 밖으로 나가면 끝
		// 2-2. 만약 U면 위쪽으로 방향 전환 후 평지면 이동
		// 2-3. 만약 D면 아래쪽으로 방향 전환 후 평지면 이동
		// 2-4. 만약 L이면 왼쪽으로 바꾸고 평지면 이동
		// 2-5. 만약 R이면 오른쪽으로 바꾸구 평지면 이동
		
		findtank();
		for(char cm : command) {
			int r = location / 100; 
			int c = location % 100;
			
			if(cm == 'S') {
				fire();
			}else if(cm == 'U') {
				dir = 0;
				map[r][c] = '^';
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				if(nr < 0 || nr >= H || nc < 0 || nc >= W) {

				}else {
					if(map[nr][nc] == '.') {
						location = nr * 100 + nc;
						map[nr][nc] = '^';
						map[r][c] = '.';
					}
				}
			}else if(cm == 'D') {
				dir = 1;
				map[r][c] = 'v';
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				if(nr < 0 || nr >= H || nc < 0 || nc >= W) {

				}else {
					if(map[nr][nc] == '.') {
						location = nr * 100 + nc;
						map[nr][nc] = 'v';
						map[r][c] = '.';
					}
				}
			}else if(cm == 'L') {
				dir = 2;
				map[r][c] = '<';
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				if(nr < 0 || nr >= H || nc < 0 || nc >= W) {

				}else {
					if(map[nr][nc] == '.') {
						location = nr * 100 + nc;
						map[nr][nc] = '<';
						map[r][c] = '.';
					}
				}
			}else if(cm == 'R') {
				dir = 3;
				map[r][c] = '>';
				int nr = r+dr[dir];
				int nc = c+dc[dir];
				if(nr < 0 || nr >= H || nc < 0 || nc >= W) {

				}else {
					if(map[nr][nc] == '.') {
						location = nr * 100 + nc;
						map[nr][nc] = '>';
						map[r][c] = '.';
					}
				}
			}
		}

		
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int T = Integer.parseInt(st.nextToken());

		
		int ans = 0;
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			
			for(int i = 0; i < H; i++) {
				char[] input = br.readLine().toCharArray();
				for(int j = 0; j < W; j++) {
					map[i][j] = input[j];
				}
			}
			N = Integer.parseInt(br.readLine());
			command = new char[N];
			command = br.readLine().toCharArray();
			
			run();
			System.out.printf("#%d ", t);
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.printf("%c",map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
